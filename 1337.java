class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] sumRows = new int[mat.length];
        int[] returnArr = new int[k];
    
        for(int i = 0; i < mat.length; i++) {
            int sum = 0;
            for(int j = 0; j < mat[i].length; j++){
                sum+=mat[i][j];
                if(mat[i][j] == 0 ) {
                    break;
                }
            }
            sumRows[i] = sum;
        }


        for(int i = 0; i < k; i++) {
            int index = 0;
            int min = sumRows[0];
            for(int j = 0; j < sumRows.length; j++) {
                if(sumRows[j] < min) {
                    index = j;
                    min = sumRows[j];
                }
            }
            returnArr[i] = index;
            sumRows[index] = mat[0].length+1;
        }

        return returnArr;
    }
}
