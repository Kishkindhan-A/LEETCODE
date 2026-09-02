class Solution { 
    public List<List<Integer>> fourSum(int[] nums, int target) { 
         
        // Store all valid quadruplets
        List<List<Integer>> ans = new ArrayList<>(); 
        int n = nums.length; 
 
        // Sort the array for Two Pointer approach
        Arrays.sort(nums); 
 
        // Fix the first element
        for(int i=0;i<n;i++){ 
            
            // Fix the second element
            for(int j=i+1;j<n;j++){ 
             
             // Remaining target needed from left and right
             // long is used to avoid integer overflow
             long target2 = (long)target - (long)nums[i]-nums[j]; 
             
             // Two pointers for the remaining two elements
             int left= j+1; 
             int right= n-1; 
 
             while(left<right){ 
                
                // Sum of the two pointer elements
                int s= nums[left]+nums[right]; 
                
                if(s<target2){ 
                    // Sum is too small, increase left
                    left++; 
                    
                }else if(s>target2){ 
                    // Sum is too large, decrease right
                    right--;
                    
                }else{ 
                    // Found a valid quadruplet
                    List<Integer> list = Arrays.asList(nums[i],nums[j],nums[left],nums[right]); 
                    ans.add(list); 
 
                    // Remove duplicate values from left and right
                    while(left<right && nums[left]==list.get(2)){ 
                        left++; 
                    } 
                    while(left<right && nums[right]==list.get(3)){ 
                        right--; 
                    } 
                } 
             } 
             
            // Skip duplicate values for second element
            while(j+1<n && nums[j]==nums[j+1]){ 
                j++; 
            } 
            } 
         
        // Skip duplicate values for first element
        while(i+1<n && nums[i]==nums[i+1]){ 
            i++; 
        } 
        } 
        
        // Return all unique quadruplets
        return ans; 
    } 
}