/**
 * Leetcode problem #929. Unique Email Addresses
 * 
 * https://leetcode.com/problems/unique-email-addresses/
 */

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        
        for(String email : emails) {
            set.add(clean(email));
        }
        
        return set.size();
    }
    
    private String clean(String email)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            //cant use "" to compare with ch -> so single '' is used
            if(ch == '.') {
                continue;
            } else if(ch == '+') {
                while(email.charAt(i) != '@') {
                    i++;
                }
                sb.append(email.substring(i));
                break;
            } else if(ch == '@') {
                sb.append(email.substring(i));
                break;
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}