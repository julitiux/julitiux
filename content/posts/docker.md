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

The docker pull command is used to download a Docker image.

```shell
sudo docker pull tutum/hello-world
```

List the downloaded Docker images using the following command.

```shell
sudo docker images
```