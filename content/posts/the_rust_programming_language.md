---
title: "The Rust Programming Language (2018)"
date: 2023-08-01T23:24:43-06:00
draft: false
---

## **INDEX**

# [Chapter 1 Getting Started](#chapter-1-getting-started)
# [Chapter 2 Programming a Guessing Game](#chapter-2-programming-a-guessing-game)

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

## Creating a Project with Cargo

```shell
cargo new hello_cargo
cd hello_cargo
```

## Building and Running a Cargo Project

Build your project and create an executable.

```shell
cargo build
```
You can run the executable with this command

```shell
./target/debug/hello_cargo
```

Also use cargo run to compile the code and then run: the resulting executable all in one command:

```shell
cargo run
```

This command quickly checks your code to make sure it compiles but doesn't produce an executable

```shell
cargo check
```

## Building for Release

```shell
cargo build --release
```

This command will create an executable in _target/release_ instead of _target/debug_

# Chapter 2 Programming a Guessing Game

## Setting Up a New Project

Using `cargo`

```shell
cargo new guessing_game
cd guessing_game
```

Look at the generated `Cargo.toml` file

```toml
[package]
name = "guessing_game"
version = "0.1.0"
authors = ["Your Name <you@example.com>"]
edition = "2018"

[dependencies]
```

src/main.rs

```rust
fn main() {
    println!("Hello, world!");
}
```

Compile and run it in the same step using the `cargo run` command

```shell
cargo run
Compiling guessing_game v0.1.0 (file:///projects/guessing_game)
 Finished dev [unoptimized + debuginfo] target(s) in 1.50 secs
  Running `target/debug/guessing_game`
Hello, world!
```
