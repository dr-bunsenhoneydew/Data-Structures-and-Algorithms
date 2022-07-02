package ArraysAndStrings.Exercises;

public class exercise8 {
    
// Write an algorithm such that if an element in an M X N matrix is 0, its entire row and column are set to 0;

// First thoughts:
// In order to not break this algorithm, we will need to create an array that flags rows and columns with 0 in them throughout the first pass. Once we know what rows and columns need to be edited, we can iterate through that boolean flag array and zero out all necessary rows/columns.

// Time complexity will be O(N^2) given we must iterate through a 2D matrix, with O(N) space complexity. 



    public static int[][] zeroMatrix(int[][] matrix) {
    
    boolean[] row = new boolean[matrix.length];
    boolean[] column = new boolean[matrix[0].length];

    //Iterate through the matrix and flag which rows and columns are required
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                row[i] = true;
                column[j] = true;
            }
        }
    }

    //Now to clear out all rows that have been flagged
    for (int i = 0; i < matrix.length; i++) {
        if (row[i]) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    //And to clear out all columns that have been flagged
    for (int j = 0; j < matrix[0].length; j++) {
        if (column[j]) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    return matrix;

    }

    public static void main(String[] args) {
        int[][] myMatrix = {{1,2,3},{4,5,6},{7,8,0}};
        for (int i = 0; i < myMatrix.length; i++) {
            for (int j = 0; j < myMatrix.length; j++) {
                System.out.print(myMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Zeroed to: ");

        int[][] newMatrix = zeroMatrix(myMatrix);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }


}
