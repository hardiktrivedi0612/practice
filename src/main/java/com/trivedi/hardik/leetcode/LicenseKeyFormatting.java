package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 12, 2018
 * @since 2.5
 */
public class LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
		StringBuilder sb = new StringBuilder();
		for (int i = S.length() - 1; i >= 0; i--)
			if (S.charAt(i) != '-')
				sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
		return sb.reverse().toString().toUpperCase();
	}
}
