package pieces;
import Game.*;
import java.util.Vector;

public class King extends Piece{
	public boolean check = false;
	Types type;
	
	public King(int x, int y, Player player) {
		super(x,y,player);
		type = Types.king;
	}

	public Types getType() {return type.king;}
	
	public boolean isvalidmove(int finalx, int finaly) {
		   if(isValidPathHelper(finalx,finaly) /*&& !kingInCheck
	                && !isInCheck(finalX, finalY)*/)
	        {
	            return true;
	        }

	        return false;
		
	}

	public int[][] drawpath(int startX, int startY, int finalX, int finalY){
		
		 int pairs = 0; //kings will never have a path
	        int [][] path = new int[2][pairs];

	        return path;
		
	}

	public boolean checkmate()
	{
        Vector<Piece> enemies = this.player.getEnemyPieces(this.player.playercolor);
        Vector<Piece> attackingEnemies = new Vector<Piece>(1);

        for(int i = 0; i < enemies.size(); i++)
        {
            if(enemies.elementAt(i).getType() != Types.king && cankillking(enemies.elementAt(i), this.x, this.y))
            {
                check = true;
                /*
                 * if there's more than one enemy that can kill the king in a given space,
                 * an ally cannot defend against both, and it cannot defend against knights.
                 */
                if(attackingEnemies.size() < 2 && enemies.elementAt(i).getType() != Types.knight)
                {
                    //keep a list of attacking enemies to potentially require an ally to defend against
                    attackingEnemies.add(enemies.elementAt(i));
                }
            }
        }

        if(!kingCanMove(this.x, this.y)
                && !kingCanMove(this.x + 1, this.y)
                && !kingCanMove(this.x + 1, this.y + 1)
                && !kingCanMove(this.x + 1, this.y - 1)
                && !kingCanMove(this.x - 1, this.y)
                && !kingCanMove(this.x - 1, this.y + 1)
                && !kingCanMove(this.x - 1, this.y - 1)
                && !kingCanMove(this.x + 1, this.y + 1))
        {
            //if(allyCanDefend(attackingEnemies))
                //return false;


        return true;

        }
        return false;
    }
	
	protected boolean cankillking(Piece enemy, int x, int y)
	 {
        Board board = enemy.player.myGame.gameBoard;

        //pawns can only kill king if there is a piece to capture, so must consider it while king is in place
        if(enemy.getType() == Types.pawn && (board.isValidMove(enemy, x, y) && enemy.isvalidmove(x, y)))
        {
            return true;
        }

        //must delete the king in its current state temporarily to see if the enemy's path to the king's
        //final position is possible. there are some cases in which leaving the king in its original position
        //will "block" the enemy piece that could capture the king if the king was in its final location
        Player player = this.player;
        int kingX = this.x;
        int kingY = this.y;
        board.boardArray[kingX][kingY] = null;

        if(board.isValidMove(enemy, x, y)
                && enemy.isvalidmove(x, y))
        {
            King new_king = new King(kingX, kingY, player);
            return true;
        }

        else
        {
            King new_king = new King(kingX, kingY, player);
            return false;
        }
    }
	   public boolean isValidPathHelper(int finalX, int finalY)
	    {
	        int x_diff = Math.abs(finalX - this.x);
	        int y_diff = Math.abs(finalY - this.y);

	        if((x_diff < 2) && (y_diff < 2))
	            return true;

	        else
	            return false;
	    }
	   protected boolean kingCanMove(int finalX, int finalY)
	    {
	        Board board = this.player.myGame.gameBoard;

	        if(board.isValidMove(this, finalX, finalY)
	                && isValidPathHelper(finalX, finalY)
	                && !ischecked(finalX, finalY))
	        {
	            return true;
	        }
	        return false;
	    }
	   protected boolean ischecked(int x, int y) {
		   Vector<Piece> enemies = this.player.getEnemyPieces(this.player.playercolor);

	        for(int i = 0; i < enemies.size(); i++)
	        {
	            if(cankillking(enemies.elementAt(i), x, y))
	            {
	                return true;
	            }
	        }

	        return false;
	   }
	  
}

      