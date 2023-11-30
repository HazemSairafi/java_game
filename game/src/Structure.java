import java.util.ArrayList;
import java.util.List;

class Structure {
    public Structure parent;
    public int cost;
    char board[][];

    Structure(char[][] board, Structure parent, int cost) {
        char[][] newBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                newBoard[i][j] = board[i][j];
        this.parent = parent;
        this.board = newBoard;
        this.cost= cost;
    }

    void print() {
        System.out.println("-----------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("  " + board[i][j]);
            }
            System.out.println("");

        }

        System.out.println("Coast : "+this.cost);
        System.out.println("-----------------------------");
    }


    boolean upcheckmove() {
        for (int i = 1; i < this.board.length; i++)
            for (int j = 0; j < this.board[0].length; j++)
                if (board[i][j] == 'k') {
                    if (board[i - 1][j] == ' ') return true;
                    if (board[i - 1][j] == 'l') return true;
                }
        return false;
    }

    boolean downcheckmove() {
        for (int i = this.board.length - 1; i >= 0; i--)
            for (int j = 0; j < this.board[0].length; j++)
                if (board[i][j] == 'k') {
                    if (board[i + 1][j] == ' ') return true;
                    if (board[i + 1][j] == 'l') return true;
                }
        return false;
    }

    boolean leftcheckmove() {
        for (int i = 0; i < this.board.length; i++)
            for (int j = 1; j < this.board[0].length; j++)
                if (board[i][j] == 'k') {
                    if (board[i][j - 1] == ' ') return true;
                    if (board[i][j - 1] == 'l') return true;
                }
        return false;
    }

    boolean rightcheckmove() {
        for (int i = 0; i < this.board.length; i++)
            for (int j = this.board[0].length - 1; j >= 0; j--)
                if (board[i][j] == 'k') {
                    if (board[i][j + 1] == ' ') return true;
                    if (board[i][j + 1] == 'l') return true;
                }
        return false;
    }

    Structure upmove() {
        Structure x = new Structure(this.board, this, this.cost+1);
//        for (int i = 1; i < x.board.length; i++) {
//            for (int j = 0; j < x.board[0].length; j++) {
        for (int i = 1; i < this.board.length; i++){
            for (int j = 0; j < this.board[0].length; j++){
                if (x.board[i][j] == 'k') {
                    if (x.board[i - 1][j] != '#' && x.board[i - 1][j] != 'k') {
                        x.board[i][j] = ' ';
                        if (x.board[i - 1][j] == 'l') {
                            x.board[i - 1][j] = ' ';

                        } else x.board[i - 1][j] = 'k';
                    }
                }
            }
        }

        return x;
    }

    Structure downmove() {
        Structure x = new Structure(this.board, this, this.cost+2);
//        for (int i = x.board.length - 1; i >= 0 ; i--) {
//            for (int j = 0; j < x.board[0].length; j++) {
        for (int i = this.board.length - 1; i >= 0; i--){
            for (int j = 0; j < this.board[0].length; j++){
                if (x.board[i][j] == 'k') {
                    if (x.board[i + 1][j] != '#' && x.board[i + 1][j] != 'k') {
                        x.board[i][j] = ' ';
                        if (x.board[i + 1][j] == 'l') {
                            x.board[i + 1][j] = ' ';
                        } else x.board[i + 1][j] = 'k';
                    }

}}
        }

        return x;
    }

    Structure leftmove() {
        Structure x = new Structure(this.board, this, this.cost+2);
//        for (int i = x.board.length - 1; i >= 0 ; i--) {
//            for (int j = 0; j < x.board[0].length; j++) {
        for (int i = 0; i < this.board.length; i++){
            for (int j = 1; j < this.board[0].length; j++){
                if (x.board[i][j] == 'k') {
                    if (x.board[i][j-1] != '#'&& x.board[i ][j-1] != 'k') {
                        x.board[i][j] = ' ';
                        if (x.board[i][j-1] == 'l') {
                            x.board[i][j-1] = ' ';
                        } else x.board[i][j-1] = 'k';
                    }

}}
                }

        return x;
    }

    Structure rightmove() {
        Structure x = new Structure(this.board, this, this.cost+1);
//        for (int i = 0; i < x.board.length; i++) {
//            for (int j = x.board[0].length - 1; j >= 0 ; j--) {
        for (int i = 0; i < this.board.length; i++){
            for (int j = this.board[0].length - 1; j >= 0; j--){
                if (x.board[i][j] == 'k') {
                    if (x.board[i][j + 1] != '#' && x.board[i ][j+1] != 'k') {
                        x.board[i][j] = ' ';
                        if (x.board[i][j + 1] == 'l') {
                            x.board[i][j + 1] = ' ';

                        } else x.board[i][j + 1] = 'k';
                    }
}}
        }
        return x;
    }

    Structure deepcopy() {
        char[][] newBoard = new char[this.board.length][this.board[0].length];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                newBoard[i][j] = this.board[i][j];
        Structure s = new Structure(newBoard, this, this.cost);
        return s;
    }


    boolean win() {
        for (int i = 0; i < this.board.length; i++)
            for (int j = 0; j < this.board[0].length; j++)
                if (board[i][j] == 'k' || board[i][j] == 'l')
                    return false;

        return true;
    }


    public String getHash() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.board.length; i++)
            for (int j = 0; j < this.board[0].length; j++) {
                s.append(board[i][j]);
            }

        return s.toString();
    }

    public List<Structure> possibleMoves() {
        List<Structure> list = new ArrayList<>();
        if (upcheckmove()) {
            list.add(upmove());
        }
        if (downcheckmove()) {
            list.add(downmove());
        }
        if (rightcheckmove()) {
            list.add(rightmove());
        }
        if (leftcheckmove()) {
            list.add(leftmove());
        }


        return list;
    }


    public int HeuristicCost(){
        int total_distance = 0;
        for(int i = 0 ; i < this.board.length; i++){
            for(int j = 0 ; j<this.board[0].length;j++){
                if(this.board[i][j]=='k'){
                    int nearest_lock = this.board.length + this.board[0].length;
                    for(int a =0 ; a<this.board.length;a++){
                        for(int b=0 ; b<this.board[0].length;b++){
                            if(this.board[a][b]=='l'){
                                int distance = Math.abs(j-b) + Math.abs(i-a);
                                if(distance<nearest_lock)
                                    nearest_lock=distance;
                            }
                        }
                    }
                    total_distance=nearest_lock;
                }
            }
        }
        return total_distance;
    }

    public int gets() {

        return this.cost+this.HeuristicCost();
    }
}