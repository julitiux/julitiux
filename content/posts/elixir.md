---
title: "Elixir"
date: 2021-07-20T08:23:40-05:00
draft: false
tags:
  - untagged
---

# **INDEX**


# Install
## macOS
* Using Homebrew
```shell
brew install elixir
```
* Using Macports (I dont use it)
```shell
sudo port install elixir
```

## Docker
```shell
docker run -it --rm elixir
```
Enter bash within container with installed _elixir_
```shell
docker run -it --rm elixir bash
```

## To install and manage multiple Erlang and Elixir version
* asdf - install and manage different Elixir and Erlang versions,
* exenv -  install and manage different Elixir versions.
* kiex - install and manage different Elixir versions.
* kerl - install and manage different Elixir versions.

## Basic types

Some basic types are:

```elixir
iex> 1              # integer
iex> 0x1F           # integer
iex> 1.0            # float
iex> true           # boolean
iex> :atom          # atom / symbol
iex> "elixir"       # string
iex> [1,2,3]        # list
iex> {1,2,3}        # tuple
```
