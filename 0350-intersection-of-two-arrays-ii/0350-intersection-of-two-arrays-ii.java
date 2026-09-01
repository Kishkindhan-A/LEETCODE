class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        
        for(int elem : nums2){
            if(map.getOrDefault(elem, 0) > 0){
                list.add(elem);
                map.put(elem, map.get(elem) - 1);
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        
        for(int val : list){
            result[i++] = val;
        }

        return result;
    }
}