import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] board1 = Moves.board1();
        char[][] board2 = Moves.board2();

        Scanner in = new Scanner(System.in);
        int u;
        System.out.println("Enter 1 to board1");
        System.out.println("Enter 2 to board2");
        System.out.println("Enter 3 to enter board");

        u = in.nextInt();

        if (u == 1) {
            Moves.gorithms1();
        }
        else if (u == 2) {
            Moves.gorithms2();
        }
        else if (u == 3) {
            Moves.gorithms3();
        }




    }


}
