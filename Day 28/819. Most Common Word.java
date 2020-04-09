/**
 * 819. Most Common Word
 * 
 * https://leetcode.com/problems/most-common-word/
 */

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        
        Set<String> bannedWordsSet = new HashSet<>(Arrays.asList(banned));
        
        String[] words = paragraph.split("\\W+");
        for(String word : words) {
            word = word.toLowerCase();
            if(!bannedWordsSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        String ans = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }
        
        return ans;
    }
}