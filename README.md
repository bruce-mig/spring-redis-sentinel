# Docker Compose - Spring Boot 3,Redis Sentinel,Lettuce client and Docker Compose for High availability

## Run the System
We can easily run the whole with only a single command:

* `docker-compose up -d`


### EndPoints ###

| Service           | EndPoint                      | Method | Description               |
| ----------------- | ----------------------------- | :-----:| ------------------------- |
| Redis Key Value   | /v1/redis/add    				| POST   | ValueOperations           |
| Redis Key Value   | /v1/redis?key={key}        	| GET    | ValueOperations       	 |

## ReadFrom Configuration

* `MASTER: Setting to read from the upstream only.`
* `MASTER_PREFERRED: Setting to read preferred from the upstream and fall back to a replica if the master is not available.`
* `UPSTREAM: Setting to read from the upstream only.`
* `UPSTREAM_PREFERRED: Setting to read preferred from the upstream and fall back to a replica if the upstream is not available.`
* `REPLICA_PREFERRED: Setting to read preferred from replicas and fall back to upstream if no replica is available.`
* `REPLICA: Setting to read from the replica only.`
* `ANY: Setting to read from any node.`

## Spring Boot 3 Configuration

* `Before the spring boot 3 : @ConfigurationProperties(prefix = "spring.redis")`
* `After the spring boot 3: @ConfigurationProperties(prefix = "spring.data.redis")`

## Assets

- **Redis GUI**

![Redis GUI](redis-gui.png)

--------------------------------------------------------------------------------------------------------------

- **DockerSentinel**

![DockerSentinel](sentinel-logs.png)

--------------------------------------------------------------------------------------------------------------
	
- **Docker**

![Docker](docker.png)

---
## Simulate failover

You can do the test manually to pause/unpause redis server through:

```bash
docker pause redis-master
docker unpause redis-master
```

And get the sentinel infomation with following commands:

```bash
docker exec sentinel-1 redis-cli -p 26379 SENTINEL get-master-addr-by-name mymaster
```

---

## Master IP

```bash
docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' redis-master