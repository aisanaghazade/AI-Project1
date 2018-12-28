package p3;

import java.util.Vector;

public class State_p3 {

	int numofMleft;
	int numofCleft;
	int numofMright;
	int numofCright;
	int LR;
	Vector<String> direction;
	Vector<Integer> numofM;
	Vector<Integer> numofC;
	public State_p3(int nMl, int nCl, int nMr, int nCr, Vector<String> dir, Vector<Integer> nm, Vector<Integer> nc, int LR) {
		this.numofMleft = nMl;
		this.numofCleft = nCl;
		this.numofMright = nMr;
		this.numofCright = nCr;
		this.numofM = nm;
		this.numofC = nc;
		this.direction = dir;
		this.LR = LR;
	}
}
