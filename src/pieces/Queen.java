package pieces;

import Game.Player;
import Game.Types;

public class Queen extends Piece{
	Types type;
	public Queen(int x, int y, Player player) {
		super(x,y,player);
		type = Types.queen;
	}
	
	public Types getType(){return type.queen;}
	@Override
	public boolean isvalidmove(int finalX, int finalY) {
		 int x_diff = Math.abs(finalX - this.x);
	        int y_diff = Math.abs(finalY - this.y);

	        if((x_diff == y_diff) || (finalX == this.x) || (finalY == this.y))
	            return true;

	        return false;
	}
	public int [][] drawpath(int startX, int startY, int finalX, int finalY)
    {
        int pairs;
        int x_dir = 0, y_dir = 0;

        if(finalY == startY) //if queen is travelling horizontally
        {
            pairs = Math.abs(finalX - startX);
            if(finalX - startX < 0)
                x_dir = -1;
            else
                x_dir = 1;
        }

        else if(finalX == startX) //if queen is travelling vertically
        {
            pairs = Math.abs(finalY - startY);
            if(finalY - startY < 0)
                y_dir = -1;
            else
                y_dir = 1;
        }

        else //if queen is travelling diagonally
        {
            pairs = Math.abs(finalX - startX);
            if(finalX - startX < 0)
                x_dir = -1;
            else
                x_dir = 1;
            if(finalY - startY < 0)
                y_dir = -1;
            else
                y_dir = 1;
        }

        int [][] path = new int[2][pairs];

        if(pairs - 1 > 0)
        {
            for(int i = 0; i < pairs - 1; i++)
            {
                path[0][i] = startX + x_dir*1;
                path[1][i] = startY + y_dir*1;
            }
        }


        return path;
    }
}
