package p3;

public class Action_p3 {

	int numberOfMissionaries;
	int numberOfCannibals;
	int direction; //left=1,right=2
	int ActionCost;
	public Action_p3(int numberOfMissionaries, int numberOfCannibals, int direction) {
		this.numberOfCannibals = numberOfCannibals;
		this.numberOfMissionaries = numberOfMissionaries;
		this.direction = direction;
		this.ActionCost = 1;
	}
}
