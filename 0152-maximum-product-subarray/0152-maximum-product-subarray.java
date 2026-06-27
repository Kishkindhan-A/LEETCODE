class Solution {
    public int maxProduct(int[] nums) {
        int l=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int pro=1;
            for(int j=i;j<nums.length;j++){
                pro*=nums[j];
            if(pro>l){
                    l=pro;
                }
            }
        }
        return l;
    }
}