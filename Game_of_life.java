package Game_of_life;

public class Game_of_life_2 {
    // The final value representing a dead
    public final static int DEAD    = 0; //dead represent '.'

    // The final value representing a live
    public final static int LIVE    = 1; //live represent '*'
    public static void main(String[] args) {
        // the starting  life and dead cells
        // int[][] board;  The game board is a 2D array.
        int M=10,N=10;
        int[][] board = {
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, LIVE, LIVE, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, LIVE, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, LIVE, LIVE, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, LIVE, LIVE, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD,LIVE, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, LIVE, DEAD,DEAD, DEAD, DEAD, DEAD, DEAD},
                {DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD}
        };

        // Displaying the grid
        System.out.println("Original Generation");
        System.out.println("..... is dead");
        System.out.println("** is live");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (board[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(board, M, N);
    }

    // Function to print next generation
    static void nextGeneration(int grid[][], int M, int N)
    {
        int[][] future = new int[M][N];

        // Loop through every cell call
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];

                // The cell needs to be subtracted from
                aliveNeighbours -= grid[l][m];

                // Check condition
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // Cell dies due to over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // A new cell is born
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                    // Remains the same
                else
                    future[l][m] = grid[l][m];
            }
        }
//print next generation after changes
        System.out.println("Next Generation");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
