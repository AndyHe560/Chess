package pieces;
import Game.*;


public class Rook extends Piece {
	Types type;
	
	public Rook(int x, int y, Player player){
		        super(x, y, player);
		        type = Types.rook;
		   
	}
	public Types getType(){return type.rook;} 
	@Override
	public boolean isvalidmove(int finalX, int finalY) {
		
		if(finalX == this.x||finalY == this.y) {
			
			return true;
		}
		return false;
	}

	@Override
	public int[][] drawpath(int startX, int startY, int finalX, int finalY) {
		int pairs = Math.abs(finalX - startX); //length of path

        int x_direction = 1;
        int y_direction = 1; //determining direction
        if(finalX - startX < 0)
        	x_direction = -1;
        if(finalY - startY < 0)
        	y_direction = -1;

        int [][] path = new int[2][pairs - 1]; //populating array of pairs

        if(pairs - 1 > 0)
        {
            for(int i = 0; i < pairs - 1; i++)
            {
                path[0][i] = startX + x_direction*1;
                path[1][i] = startY + y_direction*1;
            }
        }

        return path;
	}

}
