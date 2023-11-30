import java.util.List;
import java.util.Scanner;

public class Moves {
    static Scanner i = new Scanner(System.in);

    static void play(Structure o) {
        Structure current = o;
        int m;
        while (true) {
            if (current.win()) {
                System.out.println("Win");
                break;
            }
            System.out.println("write number (5 up , 2 down, 3 right, 1 left) : ");
            m = i.nextInt();
            if (m==5 && current.upcheckmove()){
                current = current.upmove();
            }
            if (m==2 && current.downcheckmove()){
                current = current.downmove();
            }
            if (m==1 && current.leftcheckmove()){
                current = current.leftmove();
            }
            if (m==3 && current.rightcheckmove()){
                current = current.rightmove();
            }
                current.print();
            }
        }

    static char[][] pp(){
            int width,hight,colKey,rowKey,colG,rowG,colB,rowB;
            System.out.println("Enter width : ");
            width = i.nextInt();
            System.out.println("Enter hight : ");
            hight = i.nextInt();
            System.out.println("Enter key index in row : ");
            rowKey = i.nextInt();
            System.out.println("Enter key index in col : ");
            colKey = i.nextInt();
            System.out.println("Enter G index in row : ");
            rowG = i.nextInt();
            System.out.println("Enter G index in col : ");
            colG = i.nextInt();
            System.out.println("Enter block index in row : ");
            rowB = i.nextInt();
            System.out.println("Enter block index in col : ");
            colB = i.nextInt();

            char[][] board = new char[width][hight];

            for (int i=0;i<width;i++){
                for (int j=0;j<hight;j++){

                    if (i==0 || i==width-1 || j==0 || j==hight-1) {
                        board[i][j]='#';
                    } else board[i][j]= ' ';

                    if (rowKey<width-1 && rowKey>0 && colKey>0 && colKey<hight-1) {
                        board[rowKey][colKey] = 'k';
                    }
                    if(rowG<width-1 && rowG>0 && colG>0 && colG<hight-1)
                        if (rowKey != rowG || colG !=rowG) {
                        board[rowG][colG] = 'l';
                    }
                    if(rowB<width-1 && rowB>0 && colB>0 && colB<hight-1)
                        if (rowB != rowG || colB !=colG || colB !=colKey  || rowB !=rowKey) {
                            board[rowB][colB] = '#';
                        }
                }
            }
            System.out.println("-----------------------------");
            for (int i = 0; i < width; i++) {
            for (int j = 0; j < hight; j++) {
                System.out.print("  " + board[i][j]);
            }
            System.out.println("");
        }
            System.out.println("-----------------------------");
        return board;
    }



    static char[][] board1(){
        char[][] board = new char[][]{
                {'#', '#', '#', '#','#', '#'},
                {'#', 'k', '#', 'l',' ', '#'},
                {'#', ' ', ' ', ' ',' ', '#'},
                {'#', '#', '#', ' ','l', '#'},
                {'#', ' ', 'k', ' ',' ', '#'},
                {'#', ' ', ' ', ' ',' ', '#'},
                {'#', '#', '#', '#','#', '#'},
        };
        return board;
    }
    static char[][] board2(){
        char[][] board = new char[][]{
                {'#', '#', '#', '#','#','#','#','#', '#'},
                {'#', ' ', 'k', ' ','k',' ','l',' ', '#'},
                {'#', ' ', ' ', ' ',' ',' ','#','k', '#'},
                {'#', 'l', ' ', '#',' ',' ',' ',' ', '#'},
                {'#', ' ', ' ', ' ',' ','k','#',' ', '#'},
                {'#', ' ', ' ', 'l',' ','#','l',' ', '#'},
                {'#', ' ', ' ', '#',' ',' ',' ',' ', '#'},
                {'#', '#', '#', '#','#','#','#','#', '#'},
        };
        return board;
    }


    static void gorithms1(){
        char[][] board1 = Moves.board1();
        Scanner in = new Scanner(System.in);
        int m;
        System.out.println("write 1 to player");
        System.out.println("write 2 to BFS");
        System.out.println("write 3 to DFS");
        System.out.println("write 4 to UCS");
        System.out.println("write 5 to A*");
        System.out.println("write 6 to HillClimbing");
        Structure s = new Structure(board1,null,0);
        s.print();
        m = in.nextInt();

        if (m==1) {
            Moves.play(s);
//            Moves.pp();
        }
        if (m==2){
            List<Structure> path = SearchAlgorithms.BFS(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            System.out.println("WIN");
        }
        if (m==3){
            List<Structure> path = SearchAlgorithms.DFS(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            System.out.println("WIN");

        }
        if (m==4){
            List<Structure> path = SearchAlgorithms.UCS(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            int cost = s.cost;
            System.out.println("WIN");
        }
        if (m==5){
            List<Structure> path = SearchAlgorithms.AStar(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            int cost = s.cost;
            System.out.println("WIN");
        }
        if (m==6){
            List<Structure> path = SearchAlgorithms.HillClimbing(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            int cost = s.cost;
            System.out.println("WIN");
        }
    }

    static void gorithms2(){
        char[][] board2 = Moves.board2();
        Scanner in = new Scanner(System.in);
        int m;
        System.out.println("write 1 to player");
        System.out.println("write 2 to BFS");
        System.out.println("write 3 to DFS");
        System.out.println("write 4 to UCS");
        System.out.println("write 5 to A*");
        System.out.println("write 6 to HillClimbing");


        Structure s = new Structure(board2,null,0);
        s.print();
        m = in.nextInt();

        if (m==1) {
            Moves.play(s);
//            Moves.pp();
        }
        if (m==2){
            List<Structure> path = SearchAlgorithms.BFS(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            System.out.println("WIN");
        }
        if (m==3){
            List<Structure> path = SearchAlgorithms.DFS(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            System.out.println("WIN");

        }
        if (m==4){
            List<Structure> path = SearchAlgorithms.UCS(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            int cost = s.cost;
            System.out.println("WIN");
        }
        if (m==5){
            List<Structure> path = SearchAlgorithms.AStar(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            int cost = s.cost;
            System.out.println("WIN");
        }
        if (m==6){
            List<Structure> path = SearchAlgorithms.HillClimbing(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            int cost = s.cost;
            System.out.println("WIN");
        }
    }


    static void gorithms3(){
        char[][] board3 = Moves.pp();
        Scanner in = new Scanner(System.in);
        int m;
        System.out.println("write 1 to player");
        System.out.println("write 2 to BFS");
        System.out.println("write 3 to DFS");
        System.out.println("write 4 to UCS");
        System.out.println("write 5 to A*");
        System.out.println("write 6 to HillClimbing");
        Structure s = new Structure(board3,null,0);
        s.print();
        m = in.nextInt();

        if (m==1) {
            Moves.play(s);
        }
        if (m==2){
            List<Structure> path = SearchAlgorithms.BFS(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
        }
        if (m==3){
            List<Structure> path = SearchAlgorithms.DFS(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }

        }
        if (m==4){
            List<Structure> path = SearchAlgorithms.UCS(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            int cost = s.cost;
        }
        if (m==5){
            List<Structure> path = SearchAlgorithms.AStar(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            int cost = s.cost;
        }
        if (m==6){
            List<Structure> path = SearchAlgorithms.HillClimbing(s);

            if (path != null) {
                for (Structure step : path) {
                    step.print();
                }
            } else {
                System.out.println("No solution for this level!");
            }
            int cost = s.cost;
        }
    }
}



