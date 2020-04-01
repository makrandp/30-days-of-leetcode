/**
 * Leetcode problem #811. Subdomain Visit Count
 * 
 * https://leetcode.com/problems/subdomain-visit-count/
 */


class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> ans = new ArrayList<String>();
        
        for(String cpdomain : cpdomains) {
            String splits[] = cpdomain.split(" ");
            int count = Integer.parseInt(splits[0]);
            String[] domains = splits[1].split("\\.");
            
            String temp = "";
            for(int i = domains.length - 1; i >= 0; i--) {
                temp = domains[i] + (i < domains.length - 1 ? "." : "") + temp;
                map.put(temp, map.getOrDefault(temp, 0) + count);
            }
        }
        
        for(String key : map.keySet()) {
            ans.add("" + map.get(key) + " " + key);
        }
        
        return ans;
    }
}