package p3;

import java.util.Vector;

public class Graph {

	Node init;
	Node Goal;
	public Graph() {
		Vector<Node> visited_nodes = new Vector<Node>();
		init = new Node(this.initial_state(), visited_nodes);
		State_p3 state = new State_p3(3, 3, 0, 0, new Vector<String>(), new Vector<Integer>(), new Vector<Integer>(), 1);
		Goal = new Node(state, new Vector<Node>());
	}
	
	public State_p3 initial_state() {
		Vector<String> directions = new Vector<String>();
		Vector<Integer> nm = new Vector<Integer>();
		Vector<Integer> nc = new Vector<Integer>();
		State_p3 s = new State_p3(0, 0, 3, 3, directions, nm, nc, 2);
		return s;
	}
	
	public boolean Goal_Test(State_p3 s){
		boolean t;
		if(s.numofCleft == 3 && s.numofMleft == 3)
			t = true;
		else
			t = false;
		return t;
	}
	
	public void print(Node n){
		System.out.println("path: ");
		for(int i = 0; i < n.state.direction.size(); i++){
			System.out.println("direction: " + n.state.direction.elementAt(i) + "  Number of Missionaries: " + n.state.numofM.elementAt(i) + "   Number of Cannibals: " + n.state.numofC.elementAt(i)+ "-->"+ n.visited_nodes.elementAt(i+1).id);
		}
		System.out.println(n.id);
		System.out.println("path cost:" + n.pathCost);
	}
	
	public void printB(Node n1, Node n2){
		
	}
	
}
