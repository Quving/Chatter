package Orange.Chatter.Client;

public class ClientMain {

	public static void main(String[] args) {
		Client client;
		if (args.length == 2) {
			client = new Client(args[0], Integer.parseInt(args[1]));

		} else {
			client = new Client("vingu.online", 25552);
		}
		client.connect();
	}
}
