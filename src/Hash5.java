import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Path;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * You left your computer unlocked and your friend decided to troll you by
 * copying a lot of your files to random spots all over your file system.
 * 
 * Even worse, she saved the duplicate files with random, embarrassing names
 * ("this_is_like_a_digital_wedgie.txt" was clever, I'll give her that).
 * 
 * Write a method that returns a list of all the duplicate files. We'll check
 * them by hand before actually deleting them, since programmatically deleting
 * files is really scary. To help us confirm that two files are actually
 * duplicates, return a list of FilePaths objects with variables for the
 * original and duplicate paths:
 * 
 * import java.nio.file.Path;
 * 
 * public class FilePaths {
 * 
 * private Path duplicatePath; private Path originalPath;
 * 
 * public FilePaths(Path duplicatePath, Path originalPath) { this.duplicatePath
 * = duplicatePath; this.originalPath = originalPath; }
 * 
 * public Path getDuplicatePath() { return duplicatePath; }
 * 
 * public Path getOriginalPath() { return originalPath; }
 * 
 * @Override public String toString() { return String.format("(duplicate: %s,
 *           original: %s)", duplicatePath, originalPath); } }
 * 
 *           Java
 * 
 *           For example:
 * 
 *           [(duplicate: /tmp/parker_is_dumb.mpg, original:
 *           /home/parker/secret_puppy_dance.mpg), (duplicate:
 *           /home/trololol.mov, original: /etc/apache2/httpd.conf)]
 * 
 *           You can assume each file was only duplicated once.
 * 
 * @author hatrivedi
 * @date Jun 27, 2018
 * @since 2.5
 */
public class Hash5 {

	/**
	 * @author hatrivedi
	 * @date Jun 27, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class FilePaths {

		private Path duplicatePath;
		private Path originalPath;

		public FilePaths(Path duplicatePath, Path originalPath) {
			this.duplicatePath = duplicatePath;
			this.originalPath = originalPath;
		}

		public Path getDuplicatePath() {
			return duplicatePath;
		}

		public Path getOriginalPath() {
			return originalPath;
		}

		@Override
		public String toString() {
			return String.format("(duplicate: %s, original: %s)", duplicatePath, originalPath);
		}
	}

	private static class FileInfo {

		long timeLastEdited;
		Path path;

		FileInfo(long timeLastEdited, Path path) {
			this.timeLastEdited = timeLastEdited;
			this.path = path;
		}
	}

	public static List<FilePaths> findDuplicateFiles(Path startingDirectory) {
		Map<String, FileInfo> filesSeenAlready = new HashMap<>();
		Stack<Path> stack = new Stack<>();
		stack.push(startingDirectory);

		List<FilePaths> duplicates = new ArrayList<>();

		while (!stack.isEmpty()) {
			Path currentPath = stack.pop();
			File currentFile = new File(currentPath.toString());

			if (currentFile.isDirectory()) {
				for (File file : currentFile.listFiles()) {
					stack.push(file.toPath());
				}
			} else {
				String fileHash;
				try {
					fileHash = sampleHashFile(currentPath);
				} catch (IOException | NoSuchAlgorithmException e) {

					// show error and skip this file
					e.printStackTrace();
					continue;
				}
				// get its last edited time
				long currentLastEditedTime = currentFile.lastModified();

				// if we've seen it before
				if (filesSeenAlready.containsKey(fileHash)) {

					FileInfo fileInfo = filesSeenAlready.get(fileHash);
					long existingLastEditedTime = fileInfo.timeLastEdited;
					Path existingPath = fileInfo.path;

					if (currentLastEditedTime > existingLastEditedTime) {

						// current file is the dupe!
						duplicates.add(new FilePaths(currentPath, existingPath));

					} else {

						// old file is the dupe!
						duplicates.add(new FilePaths(existingPath, currentPath));

						// but also update filesSeenAlready to have the new
						// file's info
						filesSeenAlready.put(fileHash, new FileInfo(currentLastEditedTime, currentPath));
					}

					// if it's a new file, throw it in filesSeenAlready
					// and record its path and last edited time,
					// so we can tell later if it's a dupe
				} else {
					filesSeenAlready.put(fileHash, new FileInfo(currentLastEditedTime, currentPath));
				}
			}
		}
		return duplicates;
	}

	private static final int SAMPLE_SIZE = 4000;

	private static String sampleHashFile(Path path) throws IOException, NoSuchAlgorithmException {
		final long totalBytes = new File(path.toString()).length();
		try (InputStream inputStream = new FileInputStream(path.toString())) {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			DigestInputStream digestInputStream = new DigestInputStream(inputStream, digest);
			if (totalBytes < SAMPLE_SIZE * 3) {
				byte[] bytes = new byte[(int) totalBytes];
				digestInputStream.read(bytes);
			} else {
				byte[] bytes = new byte[SAMPLE_SIZE];
				long numBytesBetweenSamples = (totalBytes - SAMPLE_SIZE * 3) / 2;
				// read first, middle and last bytes
				for (int n = 0; n < 3; n++) {
					digestInputStream.read(bytes, n * SAMPLE_SIZE, SAMPLE_SIZE);
					digestInputStream.skip(numBytesBetweenSamples);
				}
			}
			return new BigInteger(1, digest.digest()).toString(16);
		}
	}

}
