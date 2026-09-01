class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
      
        int totalSum=0;
        for(int i=0;i<distance.length;i++){
            totalSum=totalSum+distance[i];
        }
        int rightSum=0;
        int leftSum=0;
        for(int i=start;i<distance.length;i++){

           if (i==destination){
                break;
            } 
          rightSum=rightSum+distance[i];
           
          if(i==distance.length-1){
                i=-1;
            }
             
        }

    
        leftSum=totalSum-rightSum;

        if(leftSum<rightSum){
           return leftSum;
    }else{
        return rightSum;
    }
    }
}