package Orange.Chatter.Server;

import java.util.HashSet;
import java.util.Set;

public class ClientManager {

	Set<ClientUser> _clients;

	public ClientManager() {
		_clients = new HashSet<ClientUser>();
	}

	public boolean exists(ClientUser clientuser) {
		for (ClientUser cuser : _clients) {
			if (cuser.getUniqueIdentifier().equals(clientuser.getUniqueIdentifier())) {
				return true;
			}
		}
		return false;
	}

	public void addClient(ClientUser clientuser, BroadCaster _bcaster) {
		if (!exists(clientuser)) {
			System.out.println(_clients.size());
			_clients.add(clientuser);
			_bcaster.broadCast(clientuser, clientuser.getUniqueIdentifier() + " has joined.");
		}
	}

	public Set<ClientUser> getAllUsers() {
		return _clients;
	}

	public int generateId() {
		return _clients.size();
	}
}
