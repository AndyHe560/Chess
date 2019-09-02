package Game;
import java.util.Vector;

import pieces.Piece;
public class Player {
		
	public Color playercolor;
	 public boolean goesFirst;
	  public boolean isLoser = false;
	    public Game myGame; //Players can access the board, the turn number, and the opponent's pieces.
	    public boolean isTurn = false;
	    public int score = 0;
	    
	    
	    public Player(Color color,boolean goesFirst) {
	    	this.playercolor = color;
	    	this.goesFirst = goesFirst;
	    }	            
	    
	    public Vector<Piece> getEnemyPieces(Color playerColor)
	    {
	        Vector<Piece> enemyPieces;

	        if(playerColor == Color.White)
	            enemyPieces = myGame.gameBoard.blackPieces;

	        else
	            enemyPieces = myGame.gameBoard.whitePieces;

	        return enemyPieces;

	    }
	    public Vector<Piece> getAllyPieces(Color playerColor)
	    {
	    	 Vector<Piece> allyPieces;

	         if(playerColor == Color.White)
	             allyPieces = myGame.gameBoard.whitePieces;

	         else
	             allyPieces = myGame.gameBoard.blackPieces;

	         return allyPieces;
	    }
}
