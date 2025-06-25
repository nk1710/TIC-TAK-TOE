import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        Scanner sc = new Scanner(System.in);
        char p = 'X';

        while (true) {
            for (char[] row : board) 
                System.out.println(Arrays.toString(row));

            System.out.print("Player " + p + " (row & col): ");
            int r = sc.nextInt(), c = sc.nextInt();

            if (board[r][c] != ' ') {
                System.out.println("Invalid!");
                continue;
            }

            board[r][c] = p;

            if (check(board, p)) {
                for (char[] row : board) 
                    System.out.println(Arrays.toString(row));
                System.out.println("Player " + p + " wins!");
                break;
            }

            if (draw(board)) {
                System.out.println("Draw!");
                break;
            }

            p = (p == 'X') ? 'O' : 'X';
        }
    }

    static boolean check(char[][] b, char p) {
        for (int i = 0; i < 3; i++)
            if ((b[i][0]==p && b[i][1]==p && b[i][2]==p) || 
                (b[0][i]==p && b[1][i]==p && b[2][i]==p)) return true;

        return (b[0][0]==p && b[1][1]==p && b[2][2]==p) || 
               (b[0][2]==p && b[1][1]==p && b[2][0]==p);
    }

    static boolean draw(char[][] b) {
        for (char[] row : b)
            for (char cell : row)
                if (cell == ' ') return false;
        return true;
    }
}
