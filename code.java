public class soduku {
    public static void main(String[] args) {
        int soduku[][]={ { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
        { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
        { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
        { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
        { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
        { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
        { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
        { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
        { 7, 4, 5, 0, 8, 6, 3, 1, 0 } };

        if(sodukuSolver(soduku,0,0)){
            System.out.println("solution exists");
            printSOL(soduku);
        }
        else{
            System.out.println(" not exist");
        }
    }

    public static void printSOL(int soduku[][]) {
        for(int i=0;i<9;i++){
             for(int j=0;j<9;j++){
               System.out.print(soduku[i][j]);
             }
             System.out.println();
        }
    }

    public static boolean isSafe(int soduku[][],int row,int col, int digit) {
        //coloumn
        for(int i=0;i<9;i++){
            if(soduku[i][col]==digit){
                return false;
            }
        }

         //row
         for(int i=0;i<9;i++){
            if(soduku[row][i]==digit){
                return false;
            }
        }

        //grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(soduku[sr][sc]==digit){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sodukuSolver(int soduku[][], int row , int col) {
        //base case
        if(row==9){
            return true;
        }

        //recursion
        int nextRow=row, nextCol=col+1;
        if(col+1==9){
            nextCol=0;
            nextRow=row+1;
        }
        if(soduku[row][col]!=0){
            //means it contain some value then dont change nd move to next col
            return sodukuSolver(soduku, nextRow, nextCol);
        }

        //digit seter
        for(int digit=1; digit<=9; digit++){
            if(isSafe(soduku,row,col,digit)){
                soduku[row][col]=digit;
                if(sodukuSolver(soduku, nextRow, nextCol)){
                    return true;
                }
                soduku[row][col]=0;
            }
        }
       return false; 
    }

}


