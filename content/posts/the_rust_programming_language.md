---
title: "The Rust Programming Language (2018)"
date: 2023-08-01T23:24:43-06:00
draft: false
---

## **INDEX**

# [Chapter 1 Getting Started](#chapter-1-getting-started)

# Chapter 1 Getting Started

## Installing rustup on macOS

```shell
curl https://sh.rustup.rs -sSf | sh
```

Add on your .zshrc

```shell
. "$HOME/.cargo/env"
```

## Updating and Unistalling

```shell
rustc update
```

```shell
rustup self unistall
```

## Creating a Project Directory

```shell
mkdir ~/projects
cd ~/projects
mkdir hello_world
cd hello_world
```

## Writing and Running a Rust Program

```rust
fn main(){
    println!("hello wolf");
}
```

Go to the terminal and enter the following commands to compule and run the file

```shell
rustc main.rs
./main
```

```text
hello wolf
```

## Hello, Cargo!

## Verify the instalation

```shell
cargo --version
```

