package com.trivedi.hardik.leetcode;

/**
 * @author hatrivedi
 * @date Nov 15, 2018
 * @since 2.5
 */
public class RLEIterator {
	
	int[] A;
    int index;
    
    public RLEIterator(int[] A) {
        this.A = A;
        this.index = 0;
    }
    
    public int next(int n) {
        while(index < A.length && n > A[index]) {
            n -= A[index];
            index += 2;
        }
        
        if(index >= A.length) {
            return -1;
        }
        
        A[index] -= n;
        return A[index + 1];
    }
}
