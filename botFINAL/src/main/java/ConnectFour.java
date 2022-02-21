public class ConnectFour {
    private int[][] board;
    private boolean red;
    private boolean done;

    public ConnectFour(boolean red) {
        this.red = red;
        board = new int[6][7];
        done = false;
    }

    public String toString() {
        String ret = "";
        for (int[] row : board) {
            ret += "|";
            for (int peice : row) {
                if (peice == 0)
                    ret += " :black_circle: |";
                else if (peice == 1)
                    ret += " :red_circle: |";
                else
                    ret += " :blue_circle: |";

            }
            ret += "\n";
        }
        return ret;
    }

    public boolean isRed() {
        return red;
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isDone() {
        return done;
    }

    public void play(int col) {
        if (col > 8 || col < 1 || board[0][col - 1] != 0) {
            throw new IllegalArgumentException("please enter 1-7, and enter an unfilled column");
        }
        if (done) {
            return;
        }
        for (int i = board.length - 1; i > -1; i--) {
            if (board[i][col - 1] == 0) {
                if (red) {
                    board[i][col - 1] = 1;
                } else {
                    board[i][col - 1] = 2;
                }
                red = !red;
                if (win(i, col - 1) || full()) {
                    done = true;
                    red = !red;
                }
                break;
            }
        }
    }

    public boolean full() {
        for (int i : board[0]) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean win(int r, int c) {
        int numAt = board[r][c];
        boolean lBlocked = false;
        boolean lDBlocked = false;
        boolean lUBlocked = false;
        boolean rBlocked = false;
        boolean rDBlocked = false;
        boolean rUBlocked = false;
        boolean dBlocked = false;
        int diagD = 0, diagU = 0, rl = 0, d = 0;
        for (int i = 0; i < Math.max(board[0].length, board.length); i++) {
            if (!dBlocked && exists(r + i, c) && board[r + i][c] == numAt) {
                d++;
            } else {
                dBlocked = true;
            }
            if (!lBlocked && exists(r, c - i) && board[r][c - i] == numAt) {
                rl++;
            } else {
                lBlocked = true;
            }
            if (!lDBlocked && exists(r + i, c - i) && board[r + i][c - i] == numAt) {
                diagU++;
            } else {
                lDBlocked = true;
            }
            if (!lUBlocked && exists(r - i, c + i) && board[r - i][c + i] == numAt) {
                diagU++;
            } else {
                lUBlocked = true;
            }
            if (!rBlocked && exists(r, c + i) && board[r][c + i] == numAt) {
                rl++;
            } else {
                rBlocked = true;
            }
            if (!rUBlocked && exists(r + i, c + i) && board[r + i][c + i] == numAt) {
                diagD++;
            } else {
                rUBlocked = true;
            }
            if (!rDBlocked && exists(r - i, c - i) && board[r - i][c - i] == numAt) {
                diagD++;
            } else {
                rDBlocked = true;
            }
            if (rl > 4 || diagD > 4 || diagU > 4 || d > 3) {
                return true;
            }
        }
        return false;
    }

    private boolean exists(int r, int c) {
        return r > -1 && r < board.length && c > -1 && c < board[0].length;
    }
}
