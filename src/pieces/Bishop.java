package pieces;
import Game.*;
public class Bishop extends Piece {
	Types type;
	public Bishop(int x, int y, Player player) {
		super(x,y,player);
		type = Types.bishop;
	}
	public Types getType(){return type.bishop;}
	@Override
	public boolean isvalidmove(int finalX, int finalY) {
		 int x_diff = Math.abs(finalX - this.x);
	        int y_diff = Math.abs(finalY - this.y);

	        return x_diff == y_diff;
	}

	@Override
	public int[][] drawpath(int startX, int startY, int finalX, int finalY) {
		  int pairs = Math.abs(finalX - startX); //length of path

	        int x_dir = 1, y_dir = 1; //determining direction
	        if(finalX - startX < 0)
	            x_dir = -1;
	        if(finalY - startY < 0)
	            y_dir = -1;

	        int [][] path = new int[2][pairs - 1]; //populating array of pairs

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
