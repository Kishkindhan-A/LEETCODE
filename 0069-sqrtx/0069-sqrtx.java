class Solution {
    public int mySqrt(int x) {
        int n=0;
        for (int i=0;i<=x;i++){
            if((long)i*i==x){
                n=i;
                break;
            }
            if((long)i*i>x){
                n=i-1;
                break;
            }
        }
        return n;
    }
}