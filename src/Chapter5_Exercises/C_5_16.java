package Chapter5_Exercises;

import java.util.*;
import static java.lang.System.out;
import net.datastructures.LinkedStack;

public class C_5_16 {
	
	static class Move {
        char from, to;
        Move(char from, char to) {
            this.from = from;
            this.to = to;
        }
    }
	
    List<Move> solve(int n) {
        moves = new ArrayList<Move>();
        move(n, 'A', 'B', 'C');
        return moves;
    }

    private List<Move> moves;
	
    private void move(int n, char a, char b, char c) {
        if(n == 1) {
            moves.add(new Move(a, c));
        } else {
            move(n - 1, a, c, b); 
            move(1, a, b, c); 
            move(n - 1, b, a, c);
        } 
    }
    
    public static void main(String args[]) {
        out.print("請輸入盤數：");
        C_5_16 hanoi = new C_5_16();
        int n = new Scanner(System.in).nextInt();
        for(Move move : hanoi.solve(n)) {
            out.printf("盤由 %c 移至 %c%n", move.from, move.to);
        }
        System.out.println(hanoi.solve(n).size());
    }
}
