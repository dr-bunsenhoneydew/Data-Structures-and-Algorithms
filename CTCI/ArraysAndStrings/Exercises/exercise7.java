package ArraysAndStrings.Exercises;

public class exercise7 {
    
// Given an image represented by an N x N matrix, where each pixel in the image is represented by an integer, write a method to rotate the image by 90 degrees. Can you do this in place?


//The approach here would be to go layer by layer, and store the top into a temp variable, replace it with left, replace left with bottom, replace bottom with right, and replace right with top. Given we have to touch all N^2 pixels, the best time complexity will be O(N^2). However, by doing this in place, we maintain a space complexity of O(N) - given we create a new temp variable of length N.

    public static int[][] rotate(int[][] matrix) {
        //first check if it is an actual N x N matrix
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            System.out.println("Incompatible matrix");
            return matrix;
        }

        int n = matrix.length;

        //loop through the layer
        for (int layer  = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            //for each layer
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; //save top 

                //replace top with left (left -> top)
                matrix[first][i] = matrix[last-offset][first];

                //replace left with bottom (bottom -> left)
                matrix[last-offset][first] = matrix[last][last-offset];

                //replace bottom with right (right -> bottom)
                matrix[last][last-offset] = matrix[i][last];

                //replace right with top (top -> right)
                matrix[i][last] = top;
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        int[][] myMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < myMatrix.length; i++) {
            for (int j = 0; j < myMatrix.length; j++) {
                System.out.print(myMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Rotated to: ");
        
        int[][] newMatrix = rotate(myMatrix);
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
