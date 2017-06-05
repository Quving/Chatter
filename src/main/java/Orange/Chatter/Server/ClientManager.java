package Orange.Chatter.Server;

import java.util.HashSet;
import java.util.Set;

public class ClientManager {

	Set<ClientUser> _clients;

	public ClientManager() {
		_clients = new HashSet<ClientUser>();
	}

	public boolean exists(ClientUser cuser) {
		for (ClientUser c : _clients) {
			if (c.getUniqueIdentifier().equals(cuser.getUniqueIdentifier())) {
				return true;
			}
		}
		return false;
	}

	public void addClient(ClientUser cuser, BroadCaster _bcaster) {
		if (!exists(cuser)) {
			System.out.println(_clients.size());
			_clients.add(cuser);
			_bcaster.notifyAll("»» " + cuser.getUniqueIdentifier() + " has joined.");
		}
	}

	public Set<ClientUser> getAllUsers() {
		return _clients;
	}

	public int generateId() {
		return _clients.size();
	}

	public void removeClientUser(ClientUser cuser, BroadCaster _bcaster) {
		if (exists(cuser)) {
			_clients.remove(cuser);
			_bcaster.notifyAll("»» " + cuser.getUniqueIdentifier() + " has left.");
		}
	}

}
