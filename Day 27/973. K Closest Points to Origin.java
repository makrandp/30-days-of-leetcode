/**
 * 973. K Closest Points to Origin
 * 
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        findKthSmallest(points, K, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private void findKthSmallest(int[][] points, int k, int start, int end) {
        //get pivot
        int pivot = partition(points, start, end);
        
        if(pivot == k) {
            // points[pivot];
            return;
        }
        
        if(pivot > k) {
            //search left side
            findKthSmallest(points, k, start, pivot-1);
        } else {
            //else
            //search right side
            findKthSmallest(points, k, pivot+1, end);
        }
        
    }
    
    private int partition(int[][] points, int low, int high) {
        if(low >= high) {
            return low;
        }
        
        Random random = new Random();
        int pivotIndex = low + random.nextInt(high - low);
        
        swap(points, pivotIndex, high);
        
        int[] pivot = points[high];
        int pivotDistance = distance(pivot);
        
        for(int i = low; i < high; i++) {
            if(distance(points[i]) < pivotDistance) {
                swap(points, i, low);
                low++;
            }
        }
        
        swap(points, low, high);
        
        return low;
    }
    
    //calculate distance from origin
    private int distance(int[] point) {
        return point[0]*point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}