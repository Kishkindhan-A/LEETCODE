class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> a=new ArrayList<>();
        char[][] queen=new char[n][n];  
        for(int i=0;i<queen.length;i++)
            Arrays.fill(queen[i],'.');
        solveUntil(queen,a,0);
        return a;      
    }
    public boolean isValid(char[][] queen,int row,int col){
        for(int i=row-1;i>=0;i--){
            if(queen[i][col]=='Q')
                return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(queen[i][j]=='Q')
                return false;
        }
        for(int i=row-1,j=col+1;j<queen.length&&i>=0;j++,i--){
            if(queen[i][j]=='Q')
                return false;
        }
        return true;
    }
    public void solveUntil(char[][] queen,ArrayList<List<String>>a,int index){
        if(index==queen.length){
            ArrayList<String>temp=new ArrayList<>();
            for(int i=0;i<queen.length;i++){
                StringBuilder b=new StringBuilder();
                for(int j=0;j<queen.length;j++)
                    b.append(queen[i][j]);
                temp.add(b.toString());
            }
            a.add(temp);
            return;
        }
        for(int i=0;i<queen.length;i++){
            if(isValid(queen,index,i)){
                queen[index][i]='Q';
                solveUntil(queen,a,index+1);
                queen[index][i]='.';
            }
        }
    }
}