package Orange.Chatter.Client;

public class ClientMain {

	public static void main(String[] args) {
		Client client = new Client("vingu.online", 25552);
		client.connect();
	}

}
