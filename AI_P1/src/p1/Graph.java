package p1;

import java.util.Vector;

public class Graph {

	int[][] distances;
	String[] cities;
	Node init;
	Node Goal;

	// Vector<Node> nodes;

	public Graph() {

		distances = new int[20][20];
		cities = new String[] { "Neamt", "Iasi", "Vaslui", "Eforie", "Hirsova",
				"Urziceni", "Bucharest", "Giurigia", "pitesti", "Fagaras",
				"Craiova", "Riminivo Vilcea", "Sibiu", "Dobreta", "Mehadia",
				"Lugoj", "Timisoara", "Arad", "Zerind", "Oradea" };
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				distances[i][j] = 0;
			}
		}
		// map initialize
		distances[0][1] = 87;
		distances[1][2] = 92;
		distances[2][5] = 142;
		distances[5][4] = 98;
		distances[4][3] = 86;
		distances[5][6] = 85;
		distances[6][7] = 90;
		distances[6][8] = 101;
		distances[6][9] = 211;
		distances[8][10] = 138;
		distances[8][11] = 97;
		distances[9][12] = 99;
		distances[10][11] = 146;
		distances[11][12] = 80;
		distances[12][19] = 151;
		distances[12][17] = 140;
		distances[10][13] = 120;
		distances[13][14] = 75;
		distances[14][15] = 70;
		distances[15][16] = 111;
		distances[16][17] = 118;
		distances[17][18] = 75;
		distances[18][19] = 71;
		distances[1][0] = 87;
		distances[2][1] = 92;
		distances[4][5] = 98;
		distances[5][2] = 142;
		distances[3][4] = 86;
		distances[6][5] = 85;
		distances[7][6] = 90;
		distances[8][6] = 101;
		distances[9][6] = 211;
		distances[10][8] = 138;
		distances[11][8] = 97;
		distances[12][9] = 99;
		distances[11][10] = 146;
		distances[12][11] = 80;
		distances[19][12] = 151;
		distances[17][12] = 140;
		distances[13][10] = 120;
		distances[14][13] = 75;
		distances[15][14] = 70;
		distances[16][15] = 111;
		distances[17][16] = 118;
		distances[18][17] = 75;
		distances[19][18] = 71;

		Vector<Node> visited_nodes = new Vector<Node>();
		init = new Node(initialState(), distances, cities, visited_nodes);
		State_p1 gState_p1 = new State_p1("Vaslui", new Vector<String>(), new Vector<Integer>(), 2);
		Goal = new Node(gState_p1, distances, cities, new Vector<Node>());
	}

	public State_p1 initialState() {
		Vector<String> vc = new Vector<String>();
		Vector<Integer> vn = new Vector<Integer>();
		State_p1 s = new State_p1("Arad", vc, vn, 17);
		return s;
	}

	public boolean Goal_Test(State_p1 s) {
		if (s.city_name.equals("Vaslui"))
			return true;
		else
			return false;
	}
	
	public void printB(Node n1, Node n2){
		System.out.println("path: ");
		if (n1.length > 0) {
			for (int i = 0; i < n1.state.visited_cities.size(); i++) {
				System.out.print(n1.state.visited_cities.elementAt(i) + " --> ");
			}
		}
		if(n2.length > 0){
			for(int i = n2.length -1; i > 0; i--){
				System.out.print(n2.state.visited_cities.elementAt(i) + " --> ");
			}
			System.out.println(n2.state.visited_cities.elementAt(0));
		}
		System.out.println("path cost: " + (n1.pathCost+n2.pathCost));
	}

	public void print(Node n) {
		System.out.println("path: ");
		if (n.length > 0) {
			for (int i = 0; i < n.state.visited_cities.size() - 1; i++) {
				System.out.print(n.state.visited_cities.elementAt(i) + " --> ");
			}
			System.out.println(n.state.visited_cities
					.elementAt(n.state.visited_cities.size() - 1));
		}
		System.out.println("path cost: " + n.PathCost(n.state.visited_number));
	}

}
