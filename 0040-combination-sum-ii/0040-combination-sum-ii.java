class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates,
                                               int target) {

        // Stores final answer
        List<List<Integer>> ans = new ArrayList<>();

        // Sorting helps in pruning and duplicate handling
        Arrays.sort(candidates);

        // Start backtracking
        backtrack(candidates,
                  ans,
                  target,
                  0,
                  new ArrayList<>());

        return ans;
    }

    public void backtrack(int[] arr,
                          List<List<Integer>> ans,
                          int target,
                          int start,
                          List<Integer> ds) {

        // Valid combination found
        if (target == 0) {

            ans.add(new ArrayList<>(ds));
            return;
        }

        // Try every possible element
        for (int i = start; i < arr.length; i++) {

            /*
             * Skip duplicates
             * at same recursion level
             */

            if (i > start &&
                arr[i] == arr[i - 1]) {

                continue;
            }

            // Pruning optimization
            if (arr[i] > target) {

                break;
            }

            // Choose current element
            ds.add(arr[i]);

            /*
             * Move to next index
             * because reuse is NOT allowed
             */

            backtrack(arr,
                      ans,
                      target - arr[i],
                      i + 1,
                      ds);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }
}