class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(b[1], a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int n = envelopes.length;

        int[] tails = new int[n];
        int size = 0;

        for(int[] e : envelopes){
            int h = e[1];

            int left = 0;
            int right = size;

            // Lower Bound: first position where tails[pos] >= h
            while(left < right){
                int mid = left + (right - left) / 2;

                if(tails[mid] < h){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = h;

            if(left == size){
                size++;
            }
        }

        return size;
    }
}