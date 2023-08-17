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

## Handling Potential Failure with the Result Type

The second part the method

```rust
.expect("Failed to read line");
```

Read_line puts what the user types into the string we're passing it, but it also returns a value - in this case, an io::Result. Rust has a number of types named Result int its standard library: a generic Result as well as specific versions of submodules, such as io::Result

The Result  types are _enumerations_, often referred to as _enums_

For Result, the variants are *Ok* or *Err*

The _Ok_ variant indicates the operation was successful, and inside _Ok_ is the successfully generated value. The Err variant means the operation failed, and Err contains information about how or why the operation failed.

## Printing Values with println! Placeholders.

This line prints the string we saved the user's input in. The set of curly brackets, {}, is a placeholder: think of {}as little crab pincers that hold a values in place.

```rust
println!("You guessed: {}", guess);
```

Printing multiples values in one call to println!

```rust
let x = 5
let y = 5

println!("x = {} and y = {}", x, y)
```

## Testing the First Part

```shell
cargo run
Compiling guessing_game v0.1.0 (file:///projects/guessing_game)
  Finished dev [unoptimized + debuginfo] target(s) in 1.50 secs
    Running `target/debug/guessing_game`
Guess the number!
Please input your guess.
6
You guessed: 6
```

At this point, the first part of the game is done

## Generating a Secret Number

## Using a Grate to Get More Functionality

The project we've benn building is a _binary crate_, which is an executable. The _rand_ crate us a _binary crate_, which contains code intended to be used in other programs.

Cargo's use of external crates is where it really shines.

```toml
// Cargo.toml

[dependencies]

rand = "0.3.14"
```

In the _Cargo.toml_ file, everything that follows a header is part of a section that continues until another section starts. The [dependencies] section is where you tell Cargo which external crates you project depends on and which version of those crate you require.

Cargo understands Semantic Versioning; sometimes called _SemVer_

Now without changing any of the code, build the project

```shell
cargo build
    Updating registry `https://github.com/rust-lang/crates.io-index`
 Downloading rand v0.3.14
 Downloading libc v0.2.14
   Compiling libc v0.2.14
   Compiling rand v0.3.14
  Compiling guessing_game v0.1.0 (file:///projects/guessing_game)
   Finished dev [unoptimized + debuginfo] target(s) in 1.50 secs
```

Cargo fetches the lastest versions of everything fromt he _registry_, which is a copy of data from [https://crates.io/](https://crates.io/). Crates.io is where people in the Rust ecosystem post their open source Rust projects for others to use.

## Ensuring Reproducible Builds with the Cargo.link File

Cargo has a mechanism that ensures you can rebuild the same artifact every time you or anyone else builds your code: Cargo will use only the ver- sions of the dependencies you specified until you indicate otherwise. For example, what happens if next week version 0.3.15 of the rand crate comes out and contains an important bug fix but also contains a regression that will break your code?
The answer to this problem is the Cargo.lock file, which was created the first time you ran cargo build and is now in your guessing_game directory. When you build a project for the first time, Cargo figures out all the ver- sions of the dependencies that fit the criteria and then writes them to the Cargo.lock file. When you build your project in the future, Cargo will see that the Cargo.lock file exists and use the versions specified there rather than doing all the work of figuring out versions again. This lets you have a reproducible build automatically. In other words, your project will remain at 0.3.14 until you explicitly upgrade, thanks to the Cargo.lock file.

## Updating a Crate to Get a New Version

When you _do_ want to update a crate, Cargo provides another command, **update**, which will ignore the _Cargo.lock_ file and figure out all the latest versions that fit your specifications in _Cargo.toml_. If that works, Cargo will write those versions to the _Cargo.lock_ file

```shell
cargo update
   Updating registry `https://github.com/rust-lang/crates.io-index`
   Updating rand v0.3.14 -> v0.3.15
```

If you want to use rand version 0.4.0 or any version in the 0.4.x series

```toml
[dependencies]

rand = "0.4.0"
```


