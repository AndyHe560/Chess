package Game;

import java.util.Random;

public class Game {

    public Board gameBoard;
    public Player player1, player2; //for now, player 1 is white, player 2 is black
    public int turn;
    final static int Height = 8, Width = 8;
    public boolean invalid = false, capture = false;

    /**
     * Default constructor for a game.
     */
    public Game()
    {
        setStandardGame();
    }

    /**
     * Sets up a standard game with two players and an 8 x 8 board.
     */
    public void setStandardGame()
    {
        gameBoard = new Board(Height,Width, this);
        setPlayers();
        gameBoard.setPieces();
        turn = 1;
    }

    /**
     * Initializes both players for a game.
     */
    public void setPlayers()
    {
        player1 = new Player(Color.White, true);
        player2 = new Player(Color.Black, true);
        isFirst();

        player1.myGame = this;
        player2.myGame = this;
    }

    /**
     * Randomly determines which player goes first.
     */
    public void isFirst()
    {
        Random rand = new Random();
        int randomNum1 = rand.nextInt(2) + 1;
        int randomNum2 = rand.nextInt(2) + 1;

        if(randomNum1 >= randomNum2)
            player1.goesFirst = false;
        else
            player2.goesFirst = false;
    }

}