# Website Similarity REST API

This application is a website Similarity REST API. It requires Java 8 to be installed and is built using Maven.

## Build and run instructions
Start the server with:

```bash
mvn spring-boot:run
```

To create an executable jar:

```bash
mvn package
```

To run:

```bash
java -jar target/url-similarity-0.0.1.jar
```

## How to Use API
REST API responds to `/compare` endpoint with either GET or POST and returns the Jaccard Index of two websites. Expects 2 parameters called `site1` and `site2`.

### cURL examples

GET request:

```bash
curl -G localhost:8080/compare --data-urlencode "site1=bbc.co.uk/news/uk" --data-urlencode "site2=news.sky.com/uk"
```

POST request:

```bash
curl -X POST localhost:8080/compare -d "site1=bbc.co.uk/news/uk&site2=news.sky.com/uk"
```

Example similarity scores:
1. http://blog.cloud66.com/cloud-native-transformation-containers-in-the-enterprise/
2. https://blog.docker.com/2018/01/docker-mac-kubernetes/
3. https://blogs.cisco.com/security/who-is-managing-our-data-assets

```
1 and 2: 0.15273775  
1 and 3: 0.104  
2 and 3: 0.12133891  
```
