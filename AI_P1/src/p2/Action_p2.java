package p2;

public class Action_p2 {

	String Direction;
	int ActionCost;
	int DirectionNo;
	public Action_p2(String Direction, int DirectionNo) {
		this.ActionCost = 1;
		this.Direction = Direction;
		this.DirectionNo = DirectionNo;//up:1 down:2 left:3 right:4
	}
}
