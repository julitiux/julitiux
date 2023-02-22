---
title: "Docker"
date: 2023-02-13T18:22:08-06:00
draft: false
---

# Chapter 1

## Setting the Environment
## Installing Docker on Red Hat 7
## Uninstalling Docker 
## Installing a Specific Docker Version
## Installing Docker on Ubuntu
## Starting the Docker Service

```docker
sudo service docker start
```
Docker gets started via systemctl as indecated by the OK message.

## Finding the Docker Service Status.
To verify the status of the Docker service run the following command.

```docker
sudo service docker status
```

## Running a Docker Hello World Application

To test Docker, run the Hello World application with th following docker __run__ command.

```docker
sudo docker run hello-world
```

The "Hello from Docker" message gets output

## Downloading a Docker Image

When we ran the hello-world application using the docker run command, the Docker image hello-world got downloaded and a Docker container for the HelloWorld application started. A Docker image may be downloaded automatically when a Docker container for the Docker image is started, or the Docker image may be downloaded separately.

The docker pull command is used to download a Docker image:

```docker
sudo docker pull tutum/hello-world
```

List the downloaded Docker images using the following command:

```docker
sudo docker images
```

## Running an Application in a Docker Container.

The Docker run command is used to run a process , which is another term for an application, in a separate container. The syntax for the docker  run command is as follows:

```docker
docker run [OPTIONS] IMAGE[:TAG|@DIGEST] [COMMAND] [ARG...]
```

** The only required command paramter is a Docker image.

A Docker container may be started in a detached mode (or background) or foreground mode. In detached mode the process's _stdin_, _stdout_, and _stderr_ streams are detached from the command line from which the docker command is run.

To start a container in detached mode set `-d=true` or just `-d`

The default mode is the foreground mode in which the container starts in the foreground, and `stdin`, `stdout` and `stderr` streams are attached to the host command line console. 
 
The `-name` option may be used to specify a name for the Docker container.

The `-p` option used to specify a port the process running in the container.

```docker
sudo docker run -d -p 80 --name helloapp tutum/hello-world
```
In this example, start a Docker container for the `tutum/hello-world` image in detached mode using the `-d` parameter, with container name as helloapp and port on which the application runs as 80 using the `-p` parameter.

## Listing Running Docker Containers.

To list Docker container run the following command.
```docker
sudo docker ps
```

The external port may also be listed using the docker port command.
```docker
sudo docker port [CONTAINER ID | CONTAINER NAME]
```

by example 
```docker
sudo docker port 5c97f1633fb3
```

To list all Docker containers, running or exited, run the following command.
```docker
sudo docker ps -a
```

## Accessing the Application Output on Command Line.

The `curl` tool may be used to connect to the host and port on which the helloapp is running.
```docker
curl http://localhost:50733
```

## Accessing the Application Output in a Browser

Put the next url in the browser
```url
http://localhost:50733
```

## Stopping a Docker Container

```docker
sudo docker stop [CONTAINER ID | CONTAINER NAME]
```

by example
```docker
sudo docker stop helloapp
```

## Removing a Docker Container
```docker
sudo docker rm [CONTAINER ID | CONTAINER NAME]
```

by example
```docker
sudo docker rm helloapp
```

## Removing a Docker Image

```docker
sudo docker rmi [IMAGE NAME]
```

by example 
```docker
sudo docker rmi tutum/hello-world
```

All containers accessing a Docker image must be stopped and removed before a Docker image can be removed. Sometimes some incompletely downloaded Docker imahes could get listed with the docker images command. Such Docker images do not have a name assigned to them and instead are listed as <>.

All such dangling images may be removed with the following command
```docker
sudo docker rmi $(sudo docker images -f "dangling=true" -p)
```

## Stopping the Docker Service
```docker
sudo service docker stop
```

The Docker service may be started again with the following command.
```docker
sudo service docker start
```

Alternatively, a running Docker service may be restarted with the following command
```docker
sudo service docker restart
```

# Chapter 2

## Setting the Enviroment