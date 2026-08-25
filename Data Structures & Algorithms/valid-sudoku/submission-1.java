class Solution {
    public boolean isValidSudoku(char[][] board) {
    int[][] big_row = new int[9][9];

    int[][] big_col = new int[9][9];

    int[][] boxes = new int[9][9];
    
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if(board[i][j] == '.') continue;

        int digit = board[i][j] - '1';
        int boxIndex = (i / 3) * 3 + (j / 3);

        if(big_row[i][digit] == 1) return false;
        if(big_col[j][digit] == 1) return false;

        if(boxes[boxIndex][digit] == 1) return false;

        boxes[boxIndex][digit] = 1;
        big_col[j][digit] = 1;
        big_row[i][digit] = 1;
      }
    }

    return true;
    }
}
