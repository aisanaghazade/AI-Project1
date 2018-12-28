package p3;

import java.util.Vector;

public class BDS_G {

	Graph g;
	Vector<Node> f;
	Vector<Node> r;
	Vector<Node> f1;
	Vector<Node> r1;
	Vector<String> d;
	Vector<String> c;
	int fn = 0;
	int en = 0;
	int total = 0;

	public BDS_G() {
		g = new Graph();
		f = new Vector<Node>();
		r = new Vector<Node>();
		f1 = new Vector<Node>();
		r1 = new Vector<Node>();
		c = new Vector<String>();
		d = new Vector<String>();
		f.addElement(g.init);
		fn++;
		total++;
		r.addElement(g.Goal);
		fn++;
		total++;
		f1.addElement(g.init);
		r1.addElement(g.Goal);
		c.addElement(g.init.id);
		d.addElement(g.Goal.id);
	}

	public void search() {
		if (g.Goal_Test(f.elementAt(0).state)) {
			System.out.println();
			g.print(f.elementAt(0));
			System.out.println("created nodes: " + fn);
			System.out.println("expanded nodes: "+ en);
			System.out.println("max memory: "+ total);
			return;
		}
		System.out.println("visited nodes:");
		while (!f.isEmpty() && !r.isEmpty()) {
			if(f.size()+r.size()+c.size()+d.size()> total)
				total = f.size()+r.size()+c.size()+d.size();
			Node n = f.elementAt(0);
			System.out.print(n.id + "        ");
			f.removeElementAt(0);
			en++;
			n.next_node();
			for (int i = 0; i < n.next_nodes.size(); i++) {
				if (d.contains(n.next_nodes.elementAt(i).id)) {
					for (int j = 0; j < r1.size(); j++) {
						if (n.next_nodes.elementAt(i).id
								.equals(r1.elementAt(j).id)) {
							g.printB(n.next_nodes.elementAt(i), r1.elementAt(j));
							return;
						}
					}
				}
				if (!c.contains(n.next_nodes.elementAt(i).id)) {
					f.addElement(n.next_nodes.elementAt(i));
					fn++;
					f1.addElement(n.next_nodes.elementAt(i));
					c.addElement(n.next_nodes.elementAt(i).id);
				}
			}
			Node m = r.elementAt(0);
			System.out.println(m.id + "        ");
			r.removeElementAt(0);
			en++;
			m.parent_node();
			for (int i = 0; i < m.parent_nodes.size(); i++) {
				if (c.contains(m.parent_nodes.elementAt(i).id)) {
					for (int j = 0; j < f1.size(); j++) {
						if (m.parent_nodes.elementAt(i).id.equals(f1
								.elementAt(j).id)) {
							g.printB(m.parent_nodes.elementAt(i),
									f1.elementAt(j));
							return;
						}
					}
				}
				if (!d.contains(m.parent_nodes.elementAt(i).id)) {
					r.addElement(m.parent_nodes.elementAt(i));
					fn++;
					r1.addElement(m.parent_nodes.elementAt(i));
					d.addElement(m.parent_nodes.elementAt(i).id);
				}
			}

		}
	}

	public static void main(String[] args) {
		BDS_G b = new BDS_G();
		b.search();
	}

}
