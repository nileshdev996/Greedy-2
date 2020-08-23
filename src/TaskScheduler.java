// Time Complexity : O(n)
// Space Complexity : O(1) - since tasks are characters -  hashmap will max have 26 entries
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/task-scheduler/
 * 
 * calculate max freq and number of tasks having max freq
 * based on the max freq, calculate partitions
 * based on partitions, calculate empty spots - here consider all tasks having maxFreq count scheduled together
 * now calculate pending tasks, array length - schedule task count (we scheduled all tasks which had count equal to max frq)
 * calculate ideal spots - empty - pending, this can be negative, so if negative, its value = 0
 * number of time slots needed will be array length plus ideal spots
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        
        Map<Character, Integer> taskCountMap = new HashMap<>();
        
        //max fequency 
        int maxFreq = 0;
        
        //count of tasks which has max freq
        int maxCount = 0;
        for(char task: tasks) {
            int cnt = taskCountMap.getOrDefault(task, 0);
            maxFreq = Math.max(maxFreq, cnt+1);
            taskCountMap.put(task, cnt+1);
        }
        
        for(HashMap.Entry<Character, Integer> entry: taskCountMap.entrySet()) {
            if(entry.getValue() == maxFreq){
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int emptySpots = (n - (maxCount -1)) * partitions;
        int pendingTasks = tasks.length - maxFreq * maxCount;
        int idealSpots = Math.max(0, emptySpots - pendingTasks);
        
        return idealSpots + tasks.length;
    }
}