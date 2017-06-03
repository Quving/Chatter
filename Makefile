upload:
	rsync -r -v $(shell pwd)/releases/server.java root@vingu.online:/root/workspace/chatter/
