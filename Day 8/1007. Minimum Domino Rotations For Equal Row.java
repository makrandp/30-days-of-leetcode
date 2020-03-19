/**
 * Leetcode problem #1007. Minimum Domino Rotations For Equal Row
 * 
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int rotations = -1;
        //pick any element - picking 0th element here
        //try both A[0] and B[0] one by one. and see if we can make row equal
        int target = A[0];
        rotations = findDominoRotations(target, A, B);
        
        if(rotations == -1) {
            if(A[0] == B[0]) {
                //no need to check B[0]
                return -1;
            } else {
                //try B[0] now
                target = B[0];
                rotations = findDominoRotations(target, A, B);
                return rotations;
            }
        }
        
        return rotations;
    }
    
    private int findDominoRotations(int target, int[] A, int[] B)
    {
        int rotateA = 0, rotateB = 0;
        
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != target && B[i] != target) {
                return -1;
            } else if(A[i] != target) {
                // A[i] != target and B[i] == target
                //so rotate A
                rotateA++;
            } else if(B[i] != target) {
                // A[i] == target and B[i] != target
                //so rotate B
                rotateB++;
            }
        }
        
        return Math.min(rotateA, rotateB);
    }
}