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

## Downloading the Docker Image
```docker
sudo docker pull oraclelinux
# doesn't work
```

To download the oraclelinux 7 version: 
```docker
sudo docker pull oraclelinux:7
```

## Listing Docker Images
```docker
sudo docker images
```

## Running a Container in Detached Mode
```docker
sudo docker run -d --name <container-name> <image-name>
```

by example 
```docker
sudo docker run -d --name oraclelinux6 oraclelinux:6
```

The `-i` `-t` options if specified with the `-d` option do not start an interactive terminal or shell. Even though the -i and -t options are apecified, the container runs in deteached mode.

In deteachd mode, the Docker container is detached from the STDIN, STDOUT and STDERR streams. the `-rm` option cannot be used in the detached mode. 

## Running a Container in Foreground

To run a Docker container in attached mode, omit the -d option
```docker
sudo docker run <image-run>
```

by example 
```docker
sudo docker run -i -t --rm --name oraclelinux7 oraclelinux:7
```

In attached mode, a container process is started and attached to all standard streams (STDIN, STDOUT and STDERR). The `-name` option may also be used in attached mode to specufy a container name. To start an interative terminal, use the `-i` and `-t` options, which allocates a tty to the container process.

The `--rm` option if specified cleans up the container resources including the filesystem allocated the container after the conteiner has exited.

## Listing Docker Containers

Docker container can be running or not running. Run the following command to list Docker containers that are running:
```docker
sudo doker ps
```

To list all containers running or exitedm run the following command:
```docker
sudo docker ps -a
```

## Finding Oracle Linux Container Information

Information about a container can be listed with the docker inspect command.
```docker
sudo docker inspect oraclelinux
```

The container detail gets listed in JSON format as follow:
```json
[
    {
        "Id": "sha256:48b64326b7043de97d375308dc36b346ef0d4b2491eef0ffb5a3ec9b3b3d0faf",
        "RepoTags": [
            "oraclelinux:7"
        ],
        "RepoDigests": [
            "oraclelinux@sha256:871e5763f5d28e8adecb37e05d0b9034cf4c1f4d2be72d4e5388256e06717107"
        ],
        "Parent": "",
        "Comment": "",
        "Created": "2023-01-27T22:41:18.00110776Z",
        "Container": "1a7a310b518805886737a2921877c1ad73320ff744dea0c7ef2272c314a254fc",
        "ContainerConfig": {
            "Hostname": "1a7a310b5188",
            "Domainname": "",
            "User": "",
            "AttachStdin": false,
            "AttachStdout": false,
            "AttachStderr": false,
            "Tty": false,
            "OpenStdin": false,
            "StdinOnce": false,
            "Env": [
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"
            ],
            "Cmd": [
                "/bin/sh",
                "-c",
                "#(nop) ",
                "CMD [\"/bin/bash\"]"
            ],
            "Image": "sha256:94f81eafe18aa033f89cd1c804efd1d99ce8e672307764e61d1b8417b6b88b5e",
            "Volumes": null,
            "WorkingDir": "",
            "Entrypoint": null,
            "OnBuild": null,
            "Labels": {}
        },
        "DockerVersion": "20.10.17",
        "Author": "",
        "Config": {
            "Hostname": "",
            "Domainname": "",
            "User": "",
            "AttachStdin": false,
            "AttachStdout": false,
            "AttachStderr": false,
            "Tty": false,
            "OpenStdin": false,
            "StdinOnce": false,
            "Env": [
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"
            ],
            "Cmd": [
                "/bin/bash"
            ],
            "Image": "sha256:94f81eafe18aa033f89cd1c804efd1d99ce8e672307764e61d1b8417b6b88b5e",
            "Volumes": null,
            "WorkingDir": "",
            "Entrypoint": null,
            "OnBuild": null,
            "Labels": null
        },
        "Architecture": "arm64",
        "Variant": "v8",
        "Os": "linux",
        "Size": 313518060,
        "VirtualSize": 313518060,
        "GraphDriver": {
            "Data": {
                "MergedDir": "/var/lib/docker/overlay2/642b6f2d6b80ecc112b38ddff652f31387e6c60ebf424ccff1b8fbc0d30ba606/merged",
                "UpperDir": "/var/lib/docker/overlay2/642b6f2d6b80ecc112b38ddff652f31387e6c60ebf424ccff1b8fbc0d30ba606/diff",
                "WorkDir": "/var/lib/docker/overlay2/642b6f2d6b80ecc112b38ddff652f31387e6c60ebf424ccff1b8fbc0d30ba606/work"
            },
            "Name": "overlay2"
        },
        "RootFS": {
            "Type": "layers",
            "Layers": [
                "sha256:82c78198c1ef3deba67e2901362d56562286f8df676809862fdbb74fddfa22c6"
            ]
        },
        "Metadata": {
            "LastTagTime": "0001-01-01T00:00:00Z"
        }
    }
]

```

## Listing the Container Processes

List the processes that a container is running with the docker top command.
```docker
sudo docker top oraclelinux:7
```

## Starting an Interactive Shell

The interactive shell or tty may be started when the container process is started with the docker run command using the attached mode and the `-i` `-t` options to indeicate an indicate an interactive terminal.
```docker
sudo docker run -i -t --rm <docker-image>
```

by example
```docker
sudo docker run -i -t --rm --name oraclelinux8.7 oraclelinux:8.7
```

If a container process has already been started in detached mode using the `-d` option, the interactive terminal may be started with the following command syntax 
```docker
docker exec -i -t <container> bash
```

The -i and -t options could be combined into -it. Run the following command to start a tty for the oraclelinux:8.7 container.
```docker
sudo docker exec -it oraclelinux8.7 bash
```