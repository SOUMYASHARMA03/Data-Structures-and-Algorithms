import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums) {
        // Base case: if the current permutation is complete
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Since all elements are unique, we skip if it's already in the path
            if (currentList.contains(nums[i])) {
                continue; 
            }
            
            // Choose the element
            currentList.add(nums[i]);
            
            // Explore further paths recursively
            backtrack(result, currentList, nums);
            
            // Unchoose the element (backtrack)
            currentList.remove(currentList.size() - 1);
        }
    }
}
