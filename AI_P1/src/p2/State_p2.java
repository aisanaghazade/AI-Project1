package p2;

import java.util.Vector;

public class State_p2 {

//	Vector<Integer[][]> made_matrixes;
	Integer [][] matrix;
	Vector<String> directions;
	int EmptyRoomRow;
	int EmptyRoomCol;
	public State_p2(int[][] first_matrix, Vector<String> directions) {
		this.matrix = new Integer[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				this.matrix[i][j] = first_matrix[i][j];
				if(first_matrix[i][j] == 0){
					EmptyRoomCol = j;
					EmptyRoomRow = i;
				}
			}
		}
		this.directions = new Vector<String>();
		for(int i = 0; i < directions.size(); i++){
			this.directions.addElement(directions.elementAt(i));
		}
	}
}
