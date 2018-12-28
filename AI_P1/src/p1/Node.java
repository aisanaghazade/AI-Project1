package p1;

import java.util.Vector;


public class Node {

	int[][] distances;
	String[] cities;
	Vector<Node> next_nodes;
	Vector<Node> parent_nodes;
	Vector<Node> visited_nodes;
	State_p1 state;
	String id;
	int pathCost;
	int h;
	int f;
	int length;
	
	public Node(State_p1 s, int[][] distances, String[] cities, Vector<Node> visited_node) {
		this.state = s;
		this.cities = cities;
		this.distances = distances;
		next_nodes = new Vector<Node>();
		parent_nodes = new Vector<Node>();
		this.visited_nodes = new Vector<Node>();
		for(int i = 0; i < visited_node.size(); i++){
			this.visited_nodes.addElement(visited_node.elementAt(i));
		}
		this.visited_nodes.addElement(this);
//		next_node();
		pathCost = PathCost(state.visited_number);
		id = this.state.city_name;
		h = 150;
		int j = 0;
		for(int i = 0; i < cities.length; i++){
			if(cities[i].equals(this.state.city_name))
				j = i;
		}
		for(int i = 0; i < distances[j].length; i++){
			if(distances[j][i] < h && distances[j][i] != 0)
				h = distances[j][i];
		}
		f = pathCost + h;
		length = this.state.visited_cities.size();
	}
	
	public void next_node(){
		Action_set_p1 actions = Actions(this.state);
		for(int i = 0; i < actions.action_set.size(); i++){
			State_p1 s = Result(this.state, actions.action_set.elementAt(i));
			Node n = new Node(s, this.distances, this.cities, this.visited_nodes);
			next_nodes.addElement(n);
		}
	}
	
	public void parent_node(){
		Action_set_p1 actions = Actions(this.state);
		for(int i = 0; i < actions.action_set.size(); i++){
			State_p1 s = Result(this.state, actions.action_set.elementAt(i));
			Node n = new Node(s, this.distances, this.cities, this.visited_nodes);
			parent_nodes.addElement(n);
		}
	}
	
	public Action_set_p1 Actions(State_p1 s){
		Action_set_p1 actions = new Action_set_p1();
		int x=0;
		for(int i=0; i<cities.length; i++){
			if(s.city_name.equals(cities[i]))
				x = i;
		}
		for(int i=0; i<20; i++){
			if(distances[x][i] > 0){
				Action_p1 a = new Action_p1(cities[i],ActionCost(x, i), i);
				actions.action_set.addElement(a);
			}
		}
		return actions;
	}
	
	public int ActionCost(int beginning, int Destination){
		return distances[beginning][Destination];
	}
	
	public int PathCost(Vector<Integer> path){
		int pathcost = 0;
		for(int i = 0; i < path.size()-1; i++){
			pathcost += distances[path.elementAt(i)][path.elementAt(i+1)];
		}
		return pathcost;
	}
	
	public State_p1 Result(State_p1 s, Action_p1 a){
		
		State_p1 state_p1 = new State_p1(a.nextCity, s.visited_cities, s.visited_number, a.nextcityNO);
		return state_p1;
	}
	
	
	
}
