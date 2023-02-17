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

The default mode is the foreground mode in which the container starts in the foreground, and _stdin_, _stdout_ and _stderr_ streams are attached to the host command line console. 
 
The `_-name_` option may be used to specify a name for the Docker container.

The `-p` option used to specify a port the process running in the container.

```docker
sudo docker run -d -p 80 --name helloapp tutum/hello-world
```