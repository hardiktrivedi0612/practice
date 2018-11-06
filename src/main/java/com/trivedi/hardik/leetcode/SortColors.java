package com.trivedi.hardik.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author hatrivedi
 * @date Oct 27, 2018
 * @since 2.5
 */
public class SortColors {
	
	//My Solution
	public void sortColors(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : nums) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for(int j = 0; j < entry.getValue(); j++) {
                nums[i++] = entry.getKey();
            }
        }
    }
	
	
	//Optimized solution
	
}
