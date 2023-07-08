class validsudoku {
    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int i = 0; i < 9; i++) {
            boolean[] filled = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (filled[num]) {
                        return false; // Duplicate number in row
                    }
                    filled[num] = true;
                }
            }
        }

        // Check each column
        for (int j = 0; j < 9; j++) {
            boolean[] filled = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (filled[num]) {
                        return false; // Duplicate number in column
                    }
                    filled[num] = true;
                }
            }
        }

        // Check each 3x3 sub-box
        for (int box = 0; box < 9; box++) {
            boolean[] filled = new boolean[9];
            int rowOffset = (box / 3) * 3;
            int colOffset = (box % 3) * 3;
            for (int i = rowOffset; i < rowOffset + 3; i++) {
                for (int j = colOffset; j < colOffset + 3; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        if (filled[num]) {
                            return false; // Duplicate number in sub-box
                        }
                        filled[num] = true;
                    }
                }
            }
        }

        return true; // Valid Sudoku board
    }
}

