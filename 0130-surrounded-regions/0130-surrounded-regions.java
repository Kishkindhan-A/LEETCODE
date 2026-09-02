class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        
        Queue<Pair> q=new LinkedList<>();
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<col;i++){
            if(board[0][i]=='O' && !visited[0][i]){
                q.offer(new Pair(0,i));
                visited[0][i]=true;
            }

            if(board[row-1][i]=='O' && !visited[row-1][i]){
                q.offer(new Pair(row-1,i));
                visited[row-1][i]=true;
            }
        }

        for(int i=0;i<row;i++){
            if(board[i][0]=='O' && !visited[i][0]){
                q.offer(new Pair(i,0));
                visited[i][0]=true;
            }

            if(board[i][col-1]=='O' && !visited[i][col-1]){
                q.offer(new Pair(i,col-1));
                visited[i][col-1]=true;
            }
        }
        int[] drow={-1,1,0,0};
        int[] dcol={0,0,1,-1};

        while(!q.isEmpty()){
            Pair current=q.poll();
            int nrow=current.row;
            int ncol=current.col;

            for(int i=0;i<4;i++){
                int ro=nrow+drow[i];
                int co=ncol+dcol[i];

                if(ro>=0&&co>=0&&ro<row&&co<col&&board[ro][co]=='O'&&!visited[ro][co]){
                    visited[ro][co]=true;
                    q.offer(new Pair(ro,co));
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j]='X';
                }
            }
        }
    }
}