import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to optimize and avoid processing larger numbers prematurely
        Arrays.sort(candidates); 
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // Base case: target met
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: if the current element is greater than the remaining target, 
            // all subsequent elements will also be greater since the array is sorted.
            if (candidates[i] > remain) {
                break;
            }

            tempList.add(candidates[i]); // Choose
            // Explore: 'start' remains 'i' because we can reuse the same element
            backtrack(result, tempList, candidates, remain - candidates[i], i); 
            tempList.remove(tempList.size() - 1); // Unchoose (backtrack)
        }
    }
}
