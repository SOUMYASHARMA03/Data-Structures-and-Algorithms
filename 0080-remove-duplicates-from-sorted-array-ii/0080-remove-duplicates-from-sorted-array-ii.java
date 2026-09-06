class Solution {
    public int removeDuplicates(int[] nums) {
        // If the array has 2 or fewer elements, it already meets the condition
        if (nums.length <= 2) {
            return nums.length;
        }
        
        // 'index' tracks where the next valid element should be placed
        int index = 2; 
        
        // Start iterating from the third element
        for (int i = 2; i < nums.length; i++) {
            // Compare the current element with the element two positions behind the write index
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
}
