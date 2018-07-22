package com.trivedi.hardik.interviewcake;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Meetings question
 * 
 * @author hatrivedi
 * @date Apr 17, 2018
 * @since 2.5
 */
public class Arrays1 {

	/**
	 * @author hatrivedi
	 * @date Apr 17, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Meeting[] testInput = { new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12),
				new Meeting(9, 10) };
		List<Meeting> response = myFunction(Arrays.asList(testInput));
		for (int i = 0; i < response.size(); i++)
			System.out.println("(" + response.get(i).getStartTime() + ", " + response.get(i).getEndTime() + ")");
	}

	public static List<Meeting> myFunction(List<Meeting> meetings) {

		// Sort the meetings input by start times
		List<Meeting> sortedMeetings = new ArrayList<>();
		for (Meeting meeting : meetings) {
			Meeting meetingCopy = new Meeting(meeting.getStartTime(), meeting.getEndTime());
			sortedMeetings.add(meetingCopy);
		}

		Collections.sort(sortedMeetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				return o1.getStartTime() - o2.getStartTime();
			}
		});

		List<Meeting> mergedMeetings = new ArrayList<Meeting>();
		mergedMeetings.add(sortedMeetings.get(0));

		for (Meeting currentMeeting : sortedMeetings) {
			Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);
			if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
				lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));
			} else {
				mergedMeetings.add(currentMeeting);
			}
		}

		return mergedMeetings;
	}

}

class Meeting {

	private int startTime;
	private int endTime;

	public Meeting(int startTime, int endTime) {
		// number of 30 min blocks past 9:00 am
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
}
