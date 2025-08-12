import java.util.*;

class Main
{
    static char[][] board;

    public Main()
    {
        board = new char[3][3];
        initBoard();
    }

    void initBoard()
    {
        for(int i = 0; i < board.length; i++) 
        {
            for(int j = 0; j < board[i].length; j++) 
            {
                board[i][j] = ' ';
            }
        }
    }

    static void DispBoard()
    {
        System.out.println("-------------");
        for(int i = 0; i < board.length; i++) 
        {
            System.out.print("| ");
            for(int j = 0; j < board[i].length; j++) 
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static void PlaceMark(int row, int col, char mark)
    {
        if(row>=0 && row<=2 && col>=0 && col<=2)
        {
            board[row][col]=mark;
        }
    }

    static boolean checkRowWin()
    {
        for(int i=0;i<=2;i++)
        {
            if(board[i][0]!=' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
            {
                return true;
            }
        }
        return false;
    }

    static boolean checkColWin()
    {
        for(int j=0;j<=2;j++)
        {
            if(board[0][j]!=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
            {
                return true;
            }
        }
        return false;
    }

    static boolean checkDiagWin()
    {
        if(board[0][0]!=' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] == board[1][1] && board[1][1] == board[2][0] )
        {
            return true;
        }
        return false;
    }
}


class HumanPlayer
{
    String name;
    char mark;
    int row, col;
    public HumanPlayer(String name, char mark)
    {
        this.name = name;
        this.mark = mark;
    }
    void makeMove()
        {
            Scanner scan = new Scanner(System.in);
            
            do
            {
                System.out.print("Enter the Row & Column for Input Position: ");
                row = scan.nextInt();
                col = scan.nextInt();
            } while(!isValidMove());
            Main.PlaceMark(row, col, mark);
        }

        boolean isValidMove()
        {
            if(row>=0 && row<=2 && col>=0 && col<=2)
            {
                if(Main.board[row][col] == ' ')
                {
                    return true;
                }
            }
            return false;
        }
}
public class TicTacToe
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();
        System.out.println("Welcome to TIC TAC TOE Game");
        System.out.println();
        System.out.println("1st player is - X ");
        System.out.println("2nd player is - O ");
        System.out.println();
        System.out.print("Enter the Name of 1st Player: ");
        String play1 = sc.nextLine();
        System.out.println();
        System.out.print("Enter the Name of 2nd Player: ");
        String play2 = sc.nextLine();
        HumanPlayer p1 = new HumanPlayer(play1, 'X');
        HumanPlayer p2 = new HumanPlayer(play2, 'O');
        HumanPlayer cp;
        cp = p1;

        while (true) 
        {
            System.out.println(cp.name + "'s Turn");
            System.out.println();
            cp.makeMove();
            Main.DispBoard();
            if (Main.checkRowWin() || Main.checkColWin() || Main.checkDiagWin()) 
            {
                System.out.println(cp.name + " has Won the Game");
                break;
            }
            else
            {
                if (cp == p1)
                {
                    cp = p2;
                }
                else
                {
                    cp = p1;
                }
            }
        }
        System.out.println();
        System.out.println("Game Over! Thank for Playing...");
    }
}

