package pieces;
import Game.*;
public class Knight extends Piece {
	
	Types type;
	public Knight(int x, int y, Player player) {
		super(x,y,player);
		type = Types.knight;
	}
	public Types getType() {return type.knight;}
	@Override
	public boolean isvalidmove(int finalX, int finalY) {
		 int x_diff = Math.abs(finalX - this.x);
	        int y_diff = Math.abs(finalY - this.y);

	        if((x_diff == 1 && y_diff == 2) || (x_diff == 2 && y_diff == 1))
	            return true;

	        return false;
	}

	@Override
	public int[][] drawpath(int startX, int startY, int finalX, int finalY) {
		 int pairs = 0; //knights can jump over pieces, so a path is not necessary
	        int [][] path = new int[2][pairs];

	        return path;
	}

}
