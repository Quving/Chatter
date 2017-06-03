upload:
	rsync -r -v $(shell pwd)/releases/server.jar root@vingu.online:/root/workspace/chatter/
