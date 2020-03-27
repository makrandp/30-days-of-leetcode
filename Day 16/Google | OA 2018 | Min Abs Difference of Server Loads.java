/**
 * Google | OA 2018 | Min Abs Difference of Server Loads
 * 
 * https://leetcode.com/discuss/interview-question/356433/
 */

public class Solution{
  
    static int minDiff(int[] loads){
        if(loads.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for(int load : loads) {
            sum += load;
        }
        
        
        boolean[][] dp = new boolean[loads.length + 1][sum/2 + 1];
        
        dp[0][0] = true;
        //first row
        for(int i = 1; i < dp[0].length; i++) {
            dp[0][i] = false;
        }
        
        //first column
        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = true;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                boolean s1 = false, s2 = false;
                
                s1 = dp[i-1][j];
                if(loads[i-1] <= j) {
                    s2 = dp[i-1][j - loads[i-1]];
                }
                
                dp[i][j] = s1 || s2;
            }
        }
        
        int sum1 = 0;
        for(int i = sum/2; i >= 0; i--) {
            if(dp[loads.length][i]) {
                sum1 = i;
                break;
            }
        }
        
        int sum2 = sum - sum1;
        return Math.abs(sum2-sum1);
    }
    
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 9};
        int expected = 3;
        int actual = minDiff(data);
        String confirm = expected == actual ? "Correct" : "Incorrect";
        System.out.println(confirm);
        System.out.print("Expected Output: ");
        System.out.println(expected);
        System.out.print("Code Output: ");
        System.out.print(actual);
    }
}