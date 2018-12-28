package p2;

import java.util.Vector;

public class Node {

	State_p2 state;
	String id;
	int pathCost;
	int h;
	int f;
	Vector<Node> next_nodes;
	Vector<Node> parent_nodes;
	Vector<Node> visited_nodes;
	int length;
	
	public Node(State_p2 state, Vector<Node> visited_node) {
		this.state = state;
		this.visited_nodes = new Vector<Node>();
		for(int i = 0; i < visited_node.size(); i++){
			this.visited_nodes.addElement(visited_node.elementAt(i));
		}
		this.visited_nodes.addElement(this);
		next_nodes = new Vector<Node>();
		parent_nodes = new Vector<Node>();
		pathCost = PathCost(this.state.directions);
		h = 0;
		id = "";
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int x = state.matrix[i][j] / 3;
				int y = state.matrix[i][j] % 3;
				if(x > i)
					h += x - i;
				else
					h += i - x;
				if(y > j)
					h += y - j;
				else
					h += j - y;
				
				id += (""+this.state.matrix[i][j]).trim();
			}
		}
		
		f = h + pathCost;
		length = pathCost;
	}
	
	public void next_node(){
//		System.out.print(this.id+":");
		Action_set_p2 actions = Actions(this.state);
		for(int i = 0; i < actions.action_set.size(); i++){
			State_p2 s = Result(this.state, actions.action_set.elementAt(i));
			Node n = new Node(s,this.visited_nodes);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.print(n.id+"          ");
			next_nodes.addElement(n);
		}
//		System.out.println();
	}
	
	public void parent_node(){
		Action_set_p2 actions = Actions(this.state);
		for(int i = actions.action_set.size()-1; i >= 0; i--){
			State_p2 s = Result(this.state, actions.action_set.elementAt(i));
			Node n = new Node(s,this.visited_nodes);
			parent_nodes.addElement(n);
		}
	}
	
	public int PathCost(Vector<String> directions){
		return directions.size();
	}
	
	public int ActionCost(State_p2 s, Action_p2 a){
		return 1;
	}
	
	public State_p2 Result(State_p2 s, Action_p2 a){
		State_p2 state_p2;
		int[][] matrix = new int[3][3];
		Vector<String> directions = new Vector<String>();
		for(int i = 0; i < s.directions.size(); i++){
			directions.addElement(s.directions.elementAt(i));
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				matrix[i][j] = s.matrix[i][j];
			}
		}
		if(a.DirectionNo == 1){
			matrix[s.EmptyRoomRow][s.EmptyRoomCol] = matrix[s.EmptyRoomRow-1][s.EmptyRoomCol];
			matrix[s.EmptyRoomRow-1][s.EmptyRoomCol] = 0;
			directions.addElement("up");
		}
		if(a.DirectionNo == 2){
			matrix[s.EmptyRoomRow][s.EmptyRoomCol] = matrix[s.EmptyRoomRow+1][s.EmptyRoomCol];
			matrix[s.EmptyRoomRow+1][s.EmptyRoomCol]= 0;
			directions.addElement("down");
		}
		if(a.DirectionNo == 3){
			matrix[s.EmptyRoomRow][s.EmptyRoomCol] = matrix[s.EmptyRoomRow][s.EmptyRoomCol+1];
			matrix[s.EmptyRoomRow][s.EmptyRoomCol+1] = 0;
			directions.addElement("left");
		}
		if(a.DirectionNo == 4){
			matrix[s.EmptyRoomRow][s.EmptyRoomCol] = matrix[s.EmptyRoomRow][s.EmptyRoomCol-1];
			matrix[s.EmptyRoomRow][s.EmptyRoomCol-1] = 0;
			directions.addElement("right");
		}
		state_p2 = new State_p2(matrix, directions);
		return state_p2;
	}
	
	public Action_set_p2 Actions(State_p2 s){
		Action_set_p2 actions = new Action_set_p2();
		if(s.EmptyRoomRow != 0){
			Action_p2 a3 = new Action_p2("up", 1);
			actions.action_set.addElement(a3);
		}
		if(s.EmptyRoomCol != 2){
			Action_p2 a1 = new Action_p2("left", 3);
			actions.action_set.addElement(a1);
		}
		if(s.EmptyRoomRow != 2){
			Action_p2 a4 = new Action_p2("down", 2);
			actions.action_set.addElement(a4);
		}
		if(s.EmptyRoomCol != 0){
			Action_p2 a2 = new Action_p2("right", 4);
			actions.action_set.addElement(a2);
		}
		return actions;
	}
	
	
	
}
