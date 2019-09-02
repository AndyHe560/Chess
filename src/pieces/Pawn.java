package pieces;
import Game.*;
public class Pawn extends Piece {

	Types type;
	
	public Pawn(int x, int y, Player player) {
		super(x,y,player);
		type = Types.pawn;
		
	}
	public Types getType(){return type.pawn;}
	@Override
	
	public boolean isvalidmove(int finalX, int finalY) {
		 if(pawnmovetwo(finalX, finalY))
	            return true;

	            //checks if pawn is moving on a diagonal, if it is moving only one space, and if there is an enemy in that space
	        if(pawncapture(finalX, finalY))
	            return true;

	            //checks if pawn is moving one space forward, does not let it move forward unless space is empty
	        if(pawnCanMoveForward(finalX, finalY))
	            return true;

	        else
	        {
	            return false;
	        }
	}

	@Override
	public int[][] drawpath(int startX, int startY, int finalX, int finalY) {
		   int pairs = 0;
	        int[][] path = new int[2][pairs];

	        return path;
	
	}
	
        

        
	protected boolean pawncapture(int finalX, int finalY) {
		 int abs_X_diff = Math.abs(finalX - this.x);
	        int abs_Y_diff = Math.abs(finalY - this.y);
	        int Y_diff = (finalY - this.y);
	        Piece[][] board = this.player.myGame.gameBoard.boardArray;

	        if((abs_X_diff == abs_Y_diff) && (abs_Y_diff == 1))
	        {
	            if(this.player.playercolor == Color.White && ((board[finalX][finalY] != null
	                    && board[finalX][finalY].player.playercolor == Color.Black)) && Y_diff < 0)
	                return true;

	            if(this.player.playercolor == Color.Black && ((board[finalX][finalY] != null&& board[finalX][finalY].player.playercolor == Color.White)) && Y_diff > 0)
	                return true;
	        }

	        return false;
	}
	
	
	protected boolean pawnmovetwo(int finalX, int finalY){  
		 int abs_Y_diff = Math.abs(finalY - this.y);
	        Piece[][] board = this.player.myGame.gameBoard.boardArray;

	        if((abs_Y_diff == 2)&&(this.player.myGame.turn == 1 || this.player.myGame.turn == 2)&&(board[finalX][finalY] == null)&&((this.player.playercolor == Color.White && board[this.x][this.y - 1] == null)||(this.player.playercolor == Color.Black && board[this.x][this.y + 1] == null)))
	        {
	            return true;
	        }

	        else
	            return false;
	}
	  protected boolean pawnCanMoveForward(int finalX, int finalY)
	    {
	        int abs_Y_diff = Math.abs(finalY - this.y);
	        int Y_diff = finalY - this.y;
	        Piece[][] board = this.player.myGame.gameBoard.boardArray;

	        if(((this.player.playercolor == Color.White && Y_diff < 0 && abs_Y_diff == 1 ) ||
	                (this.player.playercolor == Color.Black && Y_diff > 0 && abs_Y_diff == 1)) &&
	                board[finalX][finalY] == null && this.x == finalX)
	        {
	            return true;
	        }

	        return false;
	    }
   
	
}
