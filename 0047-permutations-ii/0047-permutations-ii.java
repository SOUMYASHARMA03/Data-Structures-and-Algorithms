import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to easily identify and skip duplicates
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used in the current path
            if (used[i]) {
                continue;
            }

            // Skip duplicates: if the current number is the same as the previous one,
            // and the previous one was not used in this path, it means we already explored
            // all unique permutations starting with this value.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Make choices
            used[i] = true;
            current.add(nums[i]);

            // Recurse
            backtrack(nums, used, current, result);

            // Undo choices (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
