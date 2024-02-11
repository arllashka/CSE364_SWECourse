# AAA web service for movie recommendation

The web service providing basic movie recommendation API along with the web client. The movie are retrieved and processed from our database of movies and their corresponding ratings given by the users. Movies contain the following information:
- title 
- genre
- movie poster
- movie imdb link


# How to start a server:

The repository contains a Dockerfile with all the necessary dependencies to run our service. To build the image, use
```
$ docker build -t <image_name> -f <Dockerfile_name> <path_to_directory_with_Dockerfile>
```
Once built, start the container

```
$ docker run -p 8080:8080 <image_name> 
```

This will start the web service with tomcat servlet on the port 8080 on the endpoint

```
localhost:8080/cse364milestone1/
```

tomcat adds additional prefix of cse364milestone1 for all endpoints

If you want to run without docker, install all the following dependencies first:

- MongoDB v4.4
- JDK v11
- Maven

and run the service with the command

```
mvn clean spring-boot:run
```

The service if run via maven, does not have the cse364milestone1 prefix in the endpoints.

```
localhost:8080
``` 

To run the tests via maven

```
mvn clean test
```

# API Endpoints

We provide basic API endpoints with the movie recommendation functionality

## GET [/cse364milestone1]/api/movies

Does not expect any parameters, returns all
movies existing in our database serialized in JSON

## GET [/cse364milestone1]/api/movies/recommendations?title=[string]&limit=[int]

Provides recommended movies based on the provided
movie title serialized in JSON. Limits results to %limit% amount of movies

Example: 
```
localhost:8080[/cse364milestone1]/api/movies/recommendations?title=Superman&limit=20
```
## GET [/cse364milestone1]/api/users/recommendations?gender=[M | F]&age=[number]&occupation=[string]&genres=[string]

Provides recommended movies based on the personal information
provided by the user: user's gender, age, occupation and preferred movie genres.

Remark: genres parameter is expected to be comma-separated strings of supported movie genres. refer to data/movies.dat

Example: 
```
localhost:8080[/cse364milestone1]/api/users/recommendations?gender=M&age=25&occupation=programmer&genres=action,adventure
```

# Database of movies/ratings/users

Our algorithm relies on the database of movies/ratings/users,
we gathered thousands of different data to facilitate our recommendation algorithm. For more information refer to 

```
src/main/resources/data
```

# Web client

Our web service also provides a web client for use to test out the API. To run the web client, go to

```
localhost:8080[/cse364milestone]
```

## Supported browsers (PC)
- Chromium v85
- Yandex.Browser v20.9
- Mozilla Firefox v89.0

we provide minimum support for the mobile devices, even though
the website supports the screens >= 480px wide, we do not support
any particular mobile browsers, hence for the better experience
use PC

# For developers

Our stack includes 
- Tomcat, MongoDB, Java (Spring) for backend
- Javascript, JQuery for frontend

if you want to contribute, open up an issue and we'll first 
discuss the problem and you may open the pull request solving the problem afterwards.

Possible contributions:
- population of the database
- integration tests
- expanding web client support for more devices/browsers
- expanding API functionality
- etc.