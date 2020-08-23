// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


/*https://leetcode.com/problems/candy/
 */
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int[] res = new int[ratings.length];
        
        //since each child gets min 1 candy
        Arrays.fill(res, 1);
        
        //forward pass
        /* in this pass compare current rating with previous 
        if larger, increase candies for current student by adding one more than prev child
        */
        for(int i=1; i< ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                res[i] = res[i-1] + 1;
            }
        }
        
        //backward pass
        /*in this pass, compare the current rating with next child,
        if larger, see if we need to increase candies for current child (since we may have increased those
        already in prev pass), either increase those or keep current one (whichever is max)
        */
        for(int i=ratings.length-2 ; i>= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                res[i] = Math.max(res[i], res[i+1] + 1);
            }
        }
        
        int sum = 0;
        for(int num: res) {
            sum+=num;
        }
        
        return sum;
    }
}