public class Maze {
    int rows;
    int cols;
    int [][] matrix;
    Location start;
    Location end;

    Maze(int rows, int cols, Location start, Location end){
        this.rows = rows;
        this.cols = cols;
        this.start = start;
        this.end = end;
        this.matrix = this.createMatrix();
    }

    private int[][] createMatrix(){
        int[][] matrix = new int[this.rows][this.cols];
        for(int i =0; i < this.rows; i++){
            for(int j =0; j < this.rows; j++){
                if((this.start.row == i && this.start.col == j)
                || (this.end.row == i && this.end.col == j)){
                    matrix[i][j] = 0;
                }else{
                    if(Math.random() < 0.2){
                        matrix[i][j] = 1;
                    }else{
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return matrix;
    }
}
