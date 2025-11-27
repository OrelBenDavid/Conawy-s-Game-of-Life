public class GOLMatrix {
    private boolean[][] world;
    public int generations;

    public GOLMatrix(int n){
        if (n<3)
            n =3;
        this.world = new boolean[n][n];
        this.generations = 0;
    }
    public void flipCell(int row, int col) {
        this.world[row][col] = !this.world[row][col];
    }
    public boolean[][] getWorld() {
        return world;
    }
    public int getGenerations() {
        return generations;
    }
    public void clearWorld() {
        this.world = new boolean[world.length][world.length];
        this.generations = 0;

    }
    public int getNeighbors(int row, int col){
        int neighbors = 0;
        for (int i = row-1 ; i<= row+1 ; i++)
            for(int j = col-1 ; j<=col+1 ; j++)
               if(j>=0 && j< world.length && i>=0 && i< world.length && world[i][j] && (i != row || j != col ))
                   neighbors++;


        return neighbors;

    }
    public void nextGeneration() {
        int neighbors;
        boolean[][] a = new boolean[world.length][world.length];
        for (int i = 0; i< world.length; i++)
            for (int j = 0; j< world.length; j++)
                a[i][j] = world[i][j];
        for (int i = 0; i< world.length; i++)
            for (int j = 0; j< world.length; j++) {
                neighbors = getNeighbors(i, j);

                if ((world[i][j] && (neighbors < 2 || neighbors > 3))
                        || (!world[i][j] && neighbors == 3))
                    a[i][j] = !a[i][j];
            }
        this.world = a;



    }
}
