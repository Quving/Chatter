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
			if (cuser.getId().equals(clientuser.getId())) {
				return true;
			}
		}
		return false;
	}

	public void addClient(ClientUser clientuser) {
		if (!exists(clientuser)) {
			clientuser.setId(_clients.size());
			_clients.add(clientuser);
		}
	}

	public Set<ClientUser> getAllUsers() {
		return _clients;
	}
}
