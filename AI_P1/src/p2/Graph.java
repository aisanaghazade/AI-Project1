package p2;

import java.util.Scanner;
import java.util.Vector;

public class Graph {

	int[][] first_matrix;
	Node init;
	Node Goal;

	public Graph() {
		this.first_matrix = new int[3][3];
		System.out.println("plz enter the matrix:D");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			String r = sc.nextLine();
			String[] rs = r.trim().split(" ");
			for (int j = 0; j < 3; j++) {
				first_matrix[i][j] = Integer.parseInt(rs[j].trim());
			}
		}
		Vector<Node> visited_nodes = new Vector<Node>();
		init = new Node(initial_state(), visited_nodes);
		int [][] goal_matrix = new int[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				goal_matrix[i][j] = i*3 + j;
			}
		}
		State_p2 state = new State_p2(goal_matrix, new Vector<String>());
		Goal = new Node(state, new Vector<Node>());
	}

	public void print(Node n) {
//		System.out.println("directions: ");
//		if (n.state.directions.size() > 1) {
//			for (int i = 0; i < n.state.directions.size() - 1; i++) {
//				System.out.print(n.state.directions.elementAt(i) + "-->");
//			}
//			System.out.println(n.state.directions.elementAt(n.state.directions
//					.size() - 1));
//		}
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				System.out.print(n.state.matrix[i][j]);
//			}
//			System.out.println();
//		}
		for(int i = 0; i < n.visited_nodes.size(); i++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					System.out.print(n.visited_nodes.elementAt(i).id.charAt(j * 3 + k));
				}
				System.out.println();
			}
			System.out.println("**************");
		}
		System.out.println(n.pathCost);
	}

	public State_p2 initial_state() {
		Vector<String> directions = new Vector<String>();
		State_p2 s = new State_p2(first_matrix, directions);
		return s;
	}

	public Boolean Goal_Test(State_p2 s) {
		boolean t = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (s.matrix[i][j] != ((i * 3) + j)) {
					t = false;
				}
			}
		}
		return t;
	}
	
	public void printB(Node n2, Node n1){
//		System.out.println("directions: ");
//		if (n1.state.directions.size() > 1) {
//			for (int i = 0; i < n1.state.directions.size(); i++) {
//				System.out.print(n1.state.directions.elementAt(i) + "-->");
//			}
//		}
//		
//		if(n2.state.directions.size()>1){
//			for(int i = n2.state.directions.size()-1; i > 0; i--){
//				if(n2.state.directions.elementAt(i).equals("right")){
//					System.out.print("left-->");
//				}else{
//					if(n2.state.directions.elementAt(i).equals("left")){
//						System.out.print("right-->");
//					}else
//						if(n2.state.directions.elementAt(i).equals("up")){
//							System.out.print("down-->");
//						}else{
//							System.out.print("up-->");
//						}
//				}
//			}
//			if(n2.state.directions.elementAt(n2.state.directions.size()-1).equals("right")){
//				System.out.println("left");
//			}else{
//				if(n2.state.directions.elementAt(n2.state.directions.size()-1).equals("left")){
//					System.out.println("right");
//				}else
//					if(n2.state.directions.elementAt(n2.state.directions.size()-1).equals("up")){
//						System.out.println("down");
//					}else{
//						System.out.println("up");
//					}
//			}
//		}
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				System.out.print(Goal.state.matrix[i][j]);
//			}
//			System.out.println();
//		}
		for(int i = 0; i < n1.visited_nodes.size(); i++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					System.out.print(n1.visited_nodes.elementAt(i).id.charAt(j * 3 + k));
				}
				System.out.println();
			}
			System.out.println("**************");
		}
		System.out.println("**************");
		for(int i = n2.visited_nodes.size()-1; i >= 0 ; i--){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					System.out.print(n2.visited_nodes.elementAt(i).id.charAt(j * 3 + k));
				}
				System.out.println();
			}
			System.out.println("**************");
		}
		System.out.println(n1.pathCost+n2.pathCost);

	}

}
