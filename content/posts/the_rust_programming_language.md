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

## Processing a Guess

The first part of the guessing game program will ask for user input

```rust
use std::io;

fn main() {
    println!("Guess the number!");

    println!("Please input your guess.");

    let mut guess = String::new();
    io::stdin().read_line(&mut guess)
        .expect("Failed to read line");

    println!("You guessed: {}", guess);
}
```

The io library comes from the stardard library, is known as std. Using the std::io library provides you with a number of useful features, including the ability to accept user input

```rust
use std::io;
```

This code is printing a prompt starting what the game is and requesting input from the user.

```rust
println!("Guess the number!");

println!("Please input your guess.");
```

## Storing Values with Variables

We create a place to store the user input

```rust
let mut guess = String::new
```

The following example shows how to use mut before the variable name to make a variable mutable

```rust
let foo = 5; // immutable

let mut bar = 5; // mutable
```

> The // syntax starts a comment that continues intul the end of the line. Rust ignores everything in comments.

The :: syntax in the ::new line indicates that new is an _associated function_ of the String type.

This new function creates a new, empty string.

To summarize, the let mut guess = String::new(); has created a mutable variable that is currently bound to a new, empty instance of a String.

Now we'll call the stdin function from the io module

```rust
io::stdin().read_line(&mut guess)
    .expect("Failed to read line");
```

We could have writtern this function call as std::io::stdin. The stdin function returns an instance of std::io::Stdin, which is a type that represents a handle to the standard input for you terminal

.read_line(&mut guess), calls the read_line method on the standard input handle to get input from the user. We're also passing one argument to read_line: &mut guess.

The job of read_line is to take whatever the user tyes into stadard input and place that into a string.

The & indicates that this argument is a _reference_
