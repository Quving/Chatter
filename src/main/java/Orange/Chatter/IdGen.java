package Orange.Chatter;

public class IdGen {
	private int _id;

	public IdGen() {
		_id = 0;
	}

	public int getId() {
		return ++_id;
	}

}
