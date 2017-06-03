package Orange.Chatter.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Orange.Chatter.IdGen;

public class Server {

	private ServerSocket echoServer = null;
	private Socket clientSocket = null;
	private IdGen idgen;

	public Server() {
		idgen = new IdGen();
	}

	public void start() {
		try {
			echoServer = new ServerSocket(2222);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("The server started. To stop it press <CTRL><C>.");

		while (true) {
			try {
				clientSocket = echoServer.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			new ServerThread(clientSocket, "Client_" + idgen.getId()).start();
		}
	}
}
