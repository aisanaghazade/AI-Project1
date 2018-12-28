package p3;

import java.util.Vector;

public class Node {

	State_p3 state;
	String id;
	int pathCost;
	int h;
	int f;
	Vector<Node> next_nodes;
	Vector<Node> parent_nodes;
	Vector<Node> visited_nodes;
	int length;

	public Node(State_p3 state, Vector<Node> visited_nodes) {
		this.state = state;
		this.visited_nodes = new Vector<Node>();
		for (int i = 0; i < visited_nodes.size(); i++) {
			this.visited_nodes.addElement(visited_nodes.elementAt(i));
		}
		this.visited_nodes.addElement(this);
		this.pathCost = pathCost(this.state.direction);
		this.h = 6 - (this.state.numofCleft + this.state.numofMleft);
		this.f = this.h + this.pathCost;
		this.length = visited_nodes.size();
		this.next_nodes = new Vector<Node>();
		this.parent_nodes= new Vector<Node>();
		this.id = ("" + state.numofMleft) + ("" + state.numofCleft)
				+ ("" + state.numofMright) + ("" + state.numofCright);
		this.id += state.LR;
	}

	public void next_node() {
		Action_set_p3 actions = Actions(this.state);
		for (int i = 0; i < actions.action_set.size(); i++) {
			State_p3 s = Result(this.state, actions.action_set.elementAt(i));
			Node n = new Node(s, this.visited_nodes);
			next_nodes.addElement(n);
		}
	}
	
	public void parent_node(){
		Action_set_p3 actions = Actions(this.state);
		for (int i = 0; i < actions.action_set.size(); i++) {
			State_p3 s = Result(this.state, actions.action_set.elementAt(i));
			Node n = new Node(s, this.visited_nodes);
			parent_nodes.addElement(n);
		}
	}

	public int pathCost(Vector<String> direction) {
		return direction.size();
	}

	public Action_set_p3 Actions(State_p3 s) {
		Action_set_p3 actions = new Action_set_p3();
		if (s.LR == 2) {
			// M=2
			if ((s.numofCleft <= s.numofMleft + 2)
					&& (s.numofCright <= s.numofMright - 2) && (s.numofMright>=2)) {
				Action_p3 a = new Action_p3(2, 0, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if (s.numofMright - 2 == 0) {
				Action_p3 a = new Action_p3(2, 0, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			// M=1 C=0
			if ((s.numofCleft <= s.numofMleft + 1)
					&& (s.numofCright <= s.numofMright - 1)&& (s.numofMright>=1)) {
				Action_p3 a = new Action_p3(1, 0, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if (s.numofMright - 1 == 0) {
				Action_p3 a = new Action_p3(1, 0, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			// M=1 C=1
			if ((s.numofCleft + 1 <= s.numofMleft + 1) && (s.numofCright >= 1) && (s.numofMright >= 1)) {
				Action_p3 a = new Action_p3(1, 1, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if (s.numofMright - 1 == 0 && (s.numofCright >= 1)) {
				Action_p3 a = new Action_p3(1, 1, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			// M=0 C=1
			if((s.numofCleft+1 <= s.numofMleft) && (s.numofCright >= 1)){
				Action_p3 a = new Action_p3(0, 1, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if(s.numofMleft == 0 && s.numofCright>=1){
				Action_p3 a = new Action_p3(0, 1, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			//C=2
			if(s.numofCleft+2 <= s.numofMleft && s.numofCright >= 2){
				Action_p3 a = new Action_p3(0, 2, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if(s.numofMleft == 0 && s.numofCright >= 2){
				Action_p3 a = new Action_p3(0, 2, 1);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
		} else {
			// M=2
			if ((s.numofCleft <= s.numofMleft - 2)
					&& (s.numofCright <= s.numofMright + 2) && (s.numofMleft>=2)) {
				Action_p3 a = new Action_p3(2, 0, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if (s.numofMleft - 2 == 0) {
				Action_p3 a = new Action_p3(2, 0, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			// M=1 C=0
			if ((s.numofCleft <= s.numofMleft - 1)
					&& (s.numofCright <= s.numofMright + 1) && (s.numofMleft >= 1)) {
				Action_p3 a = new Action_p3(1, 0, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if (s.numofMleft - 1 == 0) {
				Action_p3 a = new Action_p3(1, 0, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			// M=1 C=1
			if (s.numofCright + 1 <= s.numofMright + 1 && s.numofCleft>0 && s.numofMleft>0) {
				Action_p3 a = new Action_p3(1, 1, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if (s.numofMleft - 1 == 0 && s.numofCleft >= 1) {
				Action_p3 a = new Action_p3(1, 1, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			//M=0 C=1
			if(s.numofCright+1 <= s.numofMright && s.numofCleft >= 1){
				Action_p3 a = new Action_p3(0, 1, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if(s.numofMright == 0 && s.numofCleft>=1){
				Action_p3 a = new Action_p3(0, 1, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			//c=2
			if(s.numofCright+2 <= s.numofMright && s.numofCleft >= 2){
				Action_p3 a = new Action_p3(0, 2, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
			if(s.numofMright == 0 && s.numofCleft >= 2){
				Action_p3 a = new Action_p3(0, 2, 2);
				boolean x = false;
				for (Action_p3 i : actions.action_set) {
					if (a.direction == i.direction
							&& a.numberOfCannibals == i.numberOfCannibals
							&& a.numberOfMissionaries == i.numberOfMissionaries) {
						x = true;
					}
				}
				if (!x)
					actions.action_set.addElement(a);
			}
		}
		
		return actions;
	}

	public State_p3 Result(State_p3 s, Action_p3 a) {
		State_p3 state;
		Vector<String> direction = new Vector<String>();
		Vector<Integer> nm = new Vector<Integer>();
		Vector<Integer> nc = new Vector<Integer>();
		for (int i = 0; i < s.direction.size(); i++) {
			direction.addElement(s.direction.elementAt(i));
			nm.addElement(s.numofM.elementAt(i));
			nc.addElement(s.numofC.elementAt(i));
		}
		nm.addElement(a.numberOfMissionaries);
		nc.addElement(a.numberOfCannibals);
		if (a.direction == 1) {
			direction.addElement("left");
			state = new State_p3(s.numofMleft + a.numberOfMissionaries,
					s.numofCleft + a.numberOfCannibals, s.numofMright
							- a.numberOfMissionaries, s.numofCright
							- a.numberOfCannibals, direction, nm, nc, 1);
		} else {
			direction.addElement("right");
			state = new State_p3(s.numofMleft - a.numberOfMissionaries,
					s.numofCleft - a.numberOfCannibals, s.numofMright
							+ a.numberOfMissionaries, s.numofCright
							+ a.numberOfCannibals, direction, nm, nc, 2);
		}
		if(state.numofCleft > 3){
			System.out.println(s.LR+ "ML"+s.numofMleft+"CL"+s.numofCleft+"MR"+s.numofMright+"CR"+s.numofCright);
			System.out.println(a.direction+" "+a.numberOfCannibals+" "+a.numberOfMissionaries);
			System.exit(0);
		}
		if(state.numofCright > 3){
			System.out.println(s.LR+ "ML"+s.numofMleft+"CL"+s.numofCleft+"MR"+s.numofMright+"CR"+s.numofCright);
			System.out.println(a.direction+" "+a.numberOfCannibals+" "+a.numberOfMissionaries);
			System.exit(0);
		}
		if(state.numofMleft > 3){
			System.out.println(s.LR+ "ML"+s.numofMleft+"CL"+s.numofCleft+"MR"+s.numofMright+"CR"+s.numofCright);
			System.out.println(a.direction+" "+a.numberOfCannibals+" "+a.numberOfMissionaries);
			System.exit(0);
		}
		if(state.numofMright > 3){
			System.out.println(s.LR+ "ML"+s.numofMleft+"CL"+s.numofCleft+"MR"+s.numofMright+"CR"+s.numofCright);
			System.out.println(a.direction+" "+a.numberOfCannibals+" "+a.numberOfMissionaries);
			System.exit(0);
		}
		return state;
	}

	public int ActionCost(State_p3 s, Action_p3 a) {
		return 1;
	}

}
