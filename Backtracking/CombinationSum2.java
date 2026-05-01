import java.util.*;

class Solution {
    public void helper(int[] arr, int target, int idx,
                       List<List<Integer>> res, List<Integer> list) {

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {

            // 🔥 skip duplicates
            if (i > idx && arr[i] == arr[i - 1]) continue;

            // pruning
            if (arr[i] > target) break;

            list.add(arr[i]);

            helper(arr, target - arr[i], i + 1, res, list);

            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr); // 🔥 VERY IMPORTANT
        List<List<Integer>> res = new ArrayList<>();
        helper(arr, target, 0, res, new ArrayList<>());
        return res;
    }
}
