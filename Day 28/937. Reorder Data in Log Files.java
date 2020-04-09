/**
 * 937. Reorder Data in Log Files
 * 
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0) {
            return logs;
        }
        
        Arrays.sort(logs, (log1, log2) -> {
            //split a log into two parts
            String[] splits1 = log1.split(" ", 2); 
            String[] splits2 = log2.split(" ", 2);
            
            boolean isDigit1 = Character.isDigit(splits1[1].charAt(0)) ? true : false;
            boolean isDigit2 = Character.isDigit(splits2[1].charAt(0)) ? true : false;
            
            if(isDigit1 && isDigit2) {
                return 0;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else if (!isDigit1 && isDigit2) {
                return -1;
            } else {
                //both are letter logs
                int result = splits1[1].compareTo(splits2[1]);
                if(result == 0) {
                    return splits1[0].compareTo(splits2[0]);
                }
                return result;
            }
        });
        
        return logs;
    }
}