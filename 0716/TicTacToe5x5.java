import java.util.Scanner;

public class TicTacToe5x5 {
    static final int SIZE = 5;
    static char[][] board = new char[SIZE][SIZE];
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();

        while (true) {
            int row, col;

            
            while (true) {
                System.out.print("玩家 " + currentPlayer + " 請輸入 row 和 col (0-4): ");
                row = scanner.nextInt();
                col = scanner.nextInt();

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.println("錯誤：座標超出範圍，請重新輸入！");
                } else if (board[row][col] != '.') {
                    System.out.println("錯誤：該位置已有棋子，請重新輸入！");
                } else {
                    break;
                }
            }

           
            board[row][col] = currentPlayer;
            System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
            printBoard();

           
            if (checkWin(row, col)) {
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                break;
            }

           
            if (isBoardFull()) {
                System.out.println("平手！");
                break;
            }

           
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    
    public static void initializeBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '.';
    }

    public static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(int row, int col) {
        char symbol = board[row][col];
        return (checkLine(row, 0, 0, 1, symbol) ||   
                checkLine(0, col, 1, 0, symbol) ||   
                checkLine(0, 0, 1, 1, symbol) ||     
                checkLine(0, SIZE - 1, 1, -1, symbol)); 
    }

    
    public static boolean checkLine(int startRow, int startCol, int dr, int dc, char symbol) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            int r = startRow + i * dr;
            int c = startCol + i * dc;
            if (r < 0 || r >= SIZE || c < 0 || c >= SIZE) continue;
            if (board[r][c] == symbol) {
                count++;
                if (count == 5) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    
    public static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
    }
}
