import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort the array to handle duplicates and optimize pruning
        Arrays.sort(candidates);
        // 2. Start the recursive backtracking process
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // Base case: if remaining target is 0, we found a valid combination
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early Pruning: If the current number exceeds the remaining target, 
            // all subsequent numbers will too because the array is sorted.
            if (candidates[i] > remain) {
                break;
            }

            // Skip Duplicates: Avoid selecting the identical element at the same depth
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Choose: Include the current element
            tempList.add(candidates[i]);

            // Explore: Move to the next element (i + 1) since each element can only be used once
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1);

            // Backtrack: Remove the last element to try other paths
            tempList.remove(tempList.size() - 1);
        }
    }
}
