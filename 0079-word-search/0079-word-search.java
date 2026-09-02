class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length()==1) for(int i=0;i<board.length;i++) for(int j=0;j<board[0].length;j++) if(board[i][j]==word.charAt(0)) return true;
        for(int i=0;i<board.length;i++) for(int j=0;j<board[0].length;j++) if(board[i][j]==word.charAt(0)) if(search(word,board,i,j,0)) return true;
        return false;
    }

    boolean search(String word,char[][] board, int i, int j,int idx){
        if(idx==word.length()) return true;
        if(board[i][j]==word.charAt(idx)){
            board[i][j]='@';
            boolean a=false,b=false,c=false,d=false;
            if(j+1<board[0].length) a=search(word,board,i,j+1,idx+1);
            if(i+1<board.length) b=search(word,board,i+1,j,idx+1);
            if(j-1>=0) c=search(word,board,i,j-1,idx+1);
            if(i-1>=0) d=search(word,board,i-1,j,idx+1);
            if(a||b||c||d) return true;
            board[i][j]=word.charAt(idx);
        }
        return false;
    }
}