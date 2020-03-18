/**
 * 1352. Product of the Last K Numbers
 * 
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 * 
 */

class ProductOfNumbers {
    
    List<Integer> ans;
    public ProductOfNumbers() {
        ans = new LinkedList<>();
    }
    
    public void add(int num) {
        if(num == 0) {
            ans = new LinkedList<>();
            return;
        }
        
        int lastProductResult = 1;
        if(ans.size() > 0) {
            lastProductResult = ans.get(ans.size() - 1);
        }
        
        ans.add(lastProductResult * num);
    }
    
    public int getProduct(int k) {
        if(k > ans.size()) {
            return 0;
        }
        
        if(k == ans.size()) {
            return ans.get(ans.size() - 1);
        }
        
        //if k < size
        return ans.get(ans.size() - 1) / ans.get(ans.size() - k - 1);
    }
}