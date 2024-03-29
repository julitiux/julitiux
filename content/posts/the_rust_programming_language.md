---
title: "The Rust Programming Language (2018)"
date: 2023-08-01T23:24:43-06:00
draft: false
---

## **INDEX**

# [Chapter 1 Getting Started](#chapter-1-getting-started)
# [Chapter 2 Programming a Guessing Game](#chapter-2-programming-a-guessing-game)
# [Chapter 3 Common Programming Concepts](#chapter-3-common-programming-concepts)
# [Chapter 4 Understanding Ownership](#chapter-4-understanding-ownership)

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

We create a place to store the user input.

```rust
let mut guess = String::new
```

The following example shows how to use mut before the variable name to make a variable mutable.

```rust
let foo = 5; // immutable

let mut bar = 5; // mutable
```

> The // syntax starts a comment that continues intul the end of the line. Rust ignores everything in comments.

The :: syntax in the ::new line indicates that new is an _associated function_ of the String type.

This new function creates a new, empty string.

To summarize, the let mut guess = String::new(); has created a mutable variable that is currently bound to a new, empty instance of a String.

Now we'll call the stdin function from the io module.

```rust
io::stdin().read_line(&mut guess)
    .expect("Failed to read line");
```

We could have writtern this function call as std::io::stdin. The stdin function returns an instance of std::io::Stdin, which is a type that represents a handle to the standard input for you terminal.

.read_line(&mut guess), calls the read_line method on the standard input handle to get input from the user. We're also passing one argument to read_line: &mut guess.

The job of read_line is to take whatever the user tyes into stadard input and place that into a string.

The & indicates that this argument is a _reference_

## Handling Potential Failure with the Result Type

The second part the method.

```rust
.expect("Failed to read line");
```

Read_line puts what the user types into the string we're passing it, but it also returns a value - in this case, an io::Result. Rust has a number of types named Result int its standard library: a generic Result as well as specific versions of submodules, such as io::Result.

The Result  types are _enumerations_, often referred to as _enums_.

For Result, the variants are *Ok* or *Err*.

The _Ok_ variant indicates the operation was successful, and inside _Ok_ is the successfully generated value. The Err variant means the operation failed, and Err contains information about how or why the operation failed.

## Printing Values with println! Placeholders.

This line prints the string we saved the user's input in. The set of curly brackets, {}, is a placeholder: think of {}as little crab pincers that hold a values in place.

```rust
println!("You guessed: {}", guess);
```

Printing multiples values in one call to println!.

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

At this point, the first part of the game is done.

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

Cargo understands Semantic Versioning; sometimes called _SemVer_.

Now without changing any of the code, build the project.

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

When you _do_ want to update a crate, Cargo provides another command, **update**, which will ignore the _Cargo.lock_ file and figure out all the latest versions that fit your specifications in _Cargo.toml_. If that works, Cargo will write those versions to the _Cargo.lock_ file.

```shell
cargo update
   Updating registry `https://github.com/rust-lang/crates.io-index`
   Updating rand v0.3.14 -> v0.3.15
```

If you want to use rand version 0.4.0 or any version in the 0.4.x series.

```toml
[dependencies]

rand = "0.4.0"
```

## Generation a Random Number

After to add the rand crate to Cargo.toml, let's start using rand.

```rust
use std::io;
use rand::Rng;

fn main() {

    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1, 101);

    println!("The secret number is: {}", secret_number);

    println!("Please input your guess.");

    let mut guess = String::new();

    io::stdin().read_line(&mut guess)
        .expect("Failed to read line");

    println!("You guessed: {}", guess);
}
```

The Rng trait defines methods that random number generators implement.

```rust
use rand::Rng
```

The rand::thread_rng function will give us the particular random number generator that we're going to use.

Then we call the gen_range method on the random number generator.

The gen_range method takes two number as arguments and generates a random number between them, so we need to specify 1 and 101 to request a number between 1 and 100.

```rust
let secret_number = rand::thread_rng().gen_range(1, 101);

println!("The secret number is: {}", secret_number);
```

## Comparing the Guess to the Secret Number

Now we compare two numbers

```rust
use std::io;
use std::cmp::Ordering;
use rand::Rng;

fn main() {

    // --snip--

    println!("You guessed: {}", guess);

    match guess.cmp(&secret_number) {
        Ordering::Less => println!("Too small!"),
        Ordering::Greater => println!("Too big!"),
        Ordering::Equal => println!("You win!"),
    }
}
```

Bringing a type called std::cmp::Ordering into scope from the standard library. Like Result, Ordering is another enum, but the variants for Ordering are Less, Greater, and Equal.

These are the three outcomes that are possible when yoy compare two values.

```rust
use std::cmp::Ordering;
```

The cmp method compares two values and can be called on anything that can be compared. Here it's comparing the guess to the secret_number. Then it returns a variant of the Ordering enum. We use a match expression to decide what do next based on which variant of Ordering was returned from the call to cmp.

```rust
match guess.cmp(&secret_number) {
    Ordering::Less => println!("Too small!"),
    Ordering::Greater => println!("Too big!"),
    Ordering::Equal => println!("You win!"),
}
```

A match expression is made uo of _arms_. An arm consists of a _pattern_ and the code should be run if the value given to the beginning of the match expression fits that arm's pattern.

Building the code

```shell
cargo build
 Compiling guessing_game v0.1.0 (file:///projects/guessing_game)
error[E0308]: mismatched types
  --> src/main.rs:23:21
   |
23 |     match guess.cmp(&secret_number) {
   |                     ^^^^^^^^^^^^^^ expected struct `std::string::String`,
found integral variable
   |
   = note: expected type `&std::string::String`
   = note:    found type `&{integer}`

error: aborting due to previous error
Could not compile `guessing_game`.
```
Now the core of the error states that there are _mismatched types_. Rust has a string, static type system. Afew number types can have a value between 1 and 100: i32, a 32-bit number; u32, an unsigned 32-bit number; i64, a 64-bit number. Rust defaults to an i32, which is the type of secret_number. The reason for the error here is that Rust cannot compare a string and a number type.

```rust
// --snip--
    let mut guess = String::new();

    io::stdin().read_line(&mut guess)
        .expect("Failed to read line");

    let guess: u32 = guess.trim().parse()
        .expect("Please type a number!");

    println!("You guessed: {}", guess);

    match guess.cmp(&secret_number) {
        Ordering::Less => println!("Too small!"),
        Ordering::Greater => println!("Too big!"),
        Ordering::Equal => println!("You win!"),
    }
}
```

Rust allows us to _shadow_ the previous value of guess with a new one. The trim method on a String instance will eliminate any whitespace at the beginning and end.

The parse method on strings parses a string into some kind of number.

The colon (:) after guess tells Rust we’ll annotate the variable’s type.

If parse can successfully convert the string to a num- ber, it will return the Ok variant of Result, and expect will return the number that we want from the Ok value.

Let's run the program now!

```rust
cargo run
Compiling guessing_game v0.1.0 (file:///projects/guessing_game)
 Finished dev[unoptimized + debuginfo] target(s) in 1.50 secs
  Running `target/debug/guessing_game`
Guess the number!
The secret number is: 58
Please input your guess.
  76
You guessed: 76
Too big!
```

Nice!

## Allowing Multiple Guesses with Looping

The loop keyword creates an infinite loop.

```rust
// --snip--
    println!("The secret number is: {}", secret_number);

    loop {
        println!("Please input your guess.");

        // --snip--

        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => println!("You win!"),
        }
    }
}
```

The user could always interrupt the program by using the keyboard shortcut CTRL-C.

## Quitting After a Correct Guess

Let's program the game to quit when the user wins by adding a break statement.

```rust
// --snip--

        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
    }
}
```

Adding the break line after You Win! makes the program wxit the loop when the user guesses the secret number correctly.

## Handling Invalid Input

We make the game ignore a non-number so the user can continue guessing.

```rust
// --snip--

io::stdin().read_line(&mut guess)
    .expect("Failed to read line");

let guess: u32 = match guess.trim().parse() {
    Ok(num) => num,
    Err(_) => continue,
};

println!("You guessed: {}", guess);

// --snip--
```

Switching from an expect call to match expression is how you generally move from crashing on an error to handling the error. Remember that parse returns a Result type and Result is an enum that has the variants Ok or Err.

The underscore, is a cathallvakue; in this example, we're saying we want to match all Err values, no matter what information the have inside them. So the program will execute the second arm's code, continue, which tells the program to go to the next iteration of the loop and ask for another guess.

The final code

```rust
use std::io;
use std::cmp::Ordering;
use rand::Rng;

fn main() {
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1, 101);

    loop {
        println!("Please input your guess.");

        let mut guess = String::new();

        io::stdin().read_line(&mut guess)
            .expect("Failed to read line");

        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => continue,
        };

        println!("You guessed: {}", guess);

        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
    }
}
```


# Chapter 3 Common Programming Concepts

## Variables and Mutability

By default variables are immutables, however you still have the option to make variables mutables.

```rust
fn main() {
    //let x = 5;
    let mut x = 5;
    println!("The value of x is: {}", x);
    x = 6;
    println!("The value of x is: {}", x);
}
```

## Differeces Between Variables and Constants

You are not allowed to use _mut_ with constants; they are always immutables.

You declare constants using the _const_ keyword instead of the let keyword and the tyoe of the value must be annotated.

Constants can be declared in any scope, including the global scope.

```rust
const MAX_POINTS: u32 = 10_000;
```

## Shadowing

We can shadow a variable by using the same variable's name and repeating the use of the let keyword

```rust
fn main() {
    let x = 5;
    let x = x + 1;
    let x = x * 2;
    println!("The value of x is: {}", x);
}
```

The big difference between mut and shadowing is that because we're effectively creating a new variable when we use keyword again, we can change the type of the value but reuse the same name.

```rust
// shadowing
let spaces = "    ";
let spaces = spaces.len();
```

```rust
// mismatched types
let mut spaces = "    ";
spaces = spaces.len();
```

## Data Types

Keep in mind that Rust is a _statically typed_ language, which means that it must know the types of all variables at compile time. The compiles can usually infer what type we want to use based on the value and how we use it.

If we don't add the type annotation, Rust will display the following error, which means the compiler needs more information from us to know whit type we want to use.

```shell
error[E0282]: type annotations needed
  --> src/main.rs:2:9
   |
 2 |     let guess = "42".parse().expect("Not a number!");
   |         ^^^^^
   |         |
   |         cannot infer type for `_`
   |         consider giving `guess` a type
```

## Scalar Types

A scalar type represent a single value. Rust has four primary scalar types: integers, floating-point numbers, Booleans, and characters.

## Integer Types

An _integer_ is a number without a fractional component. Each variant in the Signed and Unsigned columns can be used to declare the type of an insteger value

| Length | Signed | Unsigned |
|---|---|---|
| 8-bit | i8 | u8 |
| 16-bit | i16 | u16 |
| 32-bit | i32 | u32 |
| 64-bit | i64 | u64 |
| 128-bit | i128 | u128 |
| arch | isize | usize |

If you are unsure, Rust's defaults are generally good choices, and integer types default to i32: this types is generally the fastest, even on 64-bit systems.

## Floating-Point Types

Rust has two primitive types for _floating-point numbers_, which are numbers with decimal points: f32 and f64; wich are 32 bits and 64 bits in size, repectively. The default is f64 because on modern CPUs it's roughly the same speed as f32 but is capable or more precision.

```rust
fn main() {
    let x = 2.0; // f64
    let y: f32 = 3.0; // f32
}
```

## Numeric Operations

Rust support the basic mathematical operations: addition, substraction, multiplication, division, and remainder.

```rust
fn main() {
    // addition
    let sum = 5 + 10;

    // subtraction
    let difference = 95.5 - 4.3;

    // multiplication
    let product = 4 * 30;

    // division
    let quotient = 56.7 / 32.2;

    // remainder
    let remainder = 43 % 5;
}
```

## The Boolean Type

A Boolean type in Rust has two possible values: _true_ and _false_

```rust
fn main() {
    let t = true;
    let f: bool = false; // with explicit type annotation
}
```

## The Character Type

Rust supports letters too. That char literals are specified with single quotes, as opposed to string literals, which use doble quotes

```rust
fn main() {
    let c = 'z';
    let z = 'Ƶ';
    let heart_eyed_cat = '😻'; }
```

 ## Compound Types

_Coumpound types_ can group multiple values into one type. Rust has two primitive compound types: tuples and arrays.

## The Tuple Type

A tuple is a general way of grouping tohether some number of other values with a variety of types into one compound type. Tuples have a fixed length: once declared, they cannot grow or shrink in size.

```rust
fn main() {
    let tup: (i32, f64, u8) = (500, 6.4, 1);
}
```

The variable _tup_ binds to the entire tuple, because a tuple is considered a single compound element. To get the individual values out of a tuple, we can use pattern matching to destructure a tuple value.

```rust
fn main() {
    let tup = (500, 6.4, 1);
    let (x, y, z) = tup;
    println!("The value of y is: {}", y);
}
```

This is called _destructuring_, because it breaks the single tuple into three parts.

In addition to destructuring throught patter matching, we can access a tuple element directly by using a period (.) followed by the index of the value we want to access.

```rust
fn main() {
    let x: (i32, f64, u8) = (500, 6.4, 1);
    let five_hundred = x.0;
    let six_point_four = x.1;
    let one = x.2;
}
```

## The Array Type

Another way to have a collection of multiple values is with an array. Unlike a tuple, every element of an array must have the same type. The values going into an array are written as a comma-separated list inside square brackets.

```rust
fn main() {
    let a = [1, 2, 3, 4, 5];
}
```

You would write an array's type by using square bracketsm and within the brackets include the type of each element, a semicolon, and then the number of elements.

```rust
let a: [i32; 5] = [1, 2, 3, 4, 5];
```

If you want to create an array that containts the same value for each element, you can specify the initial value, followed by a semicolon, and then the length of the array in square brackets.

```rust
let a = [3; 5];
```

## Accessing Array Elements

An array is a single chunk of memory allocated on the stack. Tou can access elements of an array using indexing.

```rust
fn main() {
    let a = [1, 2, 3, 4, 5];
    let first = a[0];
    let second = a[1];
}
```

## Invalid Array Element Access

If you access an element of an array that is past the end of the array.

```rust
fn main() {
    let a = [1, 2, 3, 4, 5];
    let index = 10;
    let element = a[index];
    println!("The value of element is: {}", element);
}
```

Running this code using cargo _run_ produces the following result

```shell
cargo run
Compiling arrays v0.1.0 (file:///projects/arrays)
 Finished dev [unoptimized + debuginfo] target(s) in 1.50 secs
  Running `target/debug/arrays`
thread '<main>' panicked at 'index out of bounds: the len is 5 but the index
is 10', src/main.rs:6
note: Run with `RUST_BACKTRACE=1` for a backtrace.
```

## Functions

Functions are pervasive in Rust code. Rust code uses _snake case_ as the conventional atyle for function and variables names.

```rust
fn main() {
    println!("Hello, world!");
    another_function();
}

fn another_function() {
    println!("Another function.");
}
```

Function definition in Rust start with fn and have a set of parhentheses after the funtion name. You should be see the following output.

```rust
cargo run
Compiling functions v0.1.0 (file:///projects/functions)
 Finished dev [unoptimized + debuginfo] target(s) in 1.50 secs
  Running `target/debug/functions`
Hello, world!
Another function.
```

## Function Parameters

Functions can also be defines to have _parameters_, which are special variables that are part of a function's signature. The concrete values are called _arguments_, but in casual conversation, people tend to use the words _parameter_ and _arguement_.

```rust
fn main() {
    another_function(5);
}

fn another_function(x: i32) {
    println!("The value of x is: {}", x);
}
```

In function signatures, you must declare the type of each parameter. This is a deliberate decision in Rust design. When you want a function to have multiple parameters, separate the parameter declarations with comas.

```rust
fn main() {
    another_function(5, 6);
}

fn another_function(x: i32, y: i32) {
    println!("The value of x is: {}", x);
    println!("The value of y is: {}", y);
}
```

## Statements and Expressions in Functions Bodies.

Functions bodies are made up of a series of statements optionally ending in a expression. So far, we've only convered functions without an ending expression, buy yiu have seen and expression as part of statement.

> Rust is an expression-based language.

_Statements_ are instructions that perform some action and do not return a value.

_Expressions_ evaluate to a resulting value.

```rust
// this is a statement

fn main() {
    let y = 6;
}
```

> Calling a function is an expression.

> Calling a macro is an expression.

```rust
// this is an expression
fn main() {
    let x = 5;

    let y = {
        let x = 3;
        x + 1
    };

    println!("The value of y is: {}", y);
}
```

The expressions do not include ending semicolons.

If you add a semicolon to the end of an expression, you turn it into a statement, which will then not return a value.

## Functions with Return Values.

Functions can return values to the code that calls them. We don't name return values, but we do declare their type after an arrow ( -> ). In Rust, the return values of the function is synonymous with the value of the final expression in the block of the body of a function. You can return early from a function by using teh return keyword and specifying a value, but most functions return the last expression implicity

```rust
fn five() -> i32 {
    5
}

fn main() {
    let x = five();
    println!("The value of x is: {}", x);
}
```

There are no function calls, macros, or even let statements in the five function - just the number 5 by itself . That's a perfectly valid function in Rust.

Let's look at another example

```rust
fn main() {
    let x = plus_one(5);
    println!("The value of x is: {}", x);
}

fn plus_one(x: i32) -> i32 {
    x + 1
}

```

## Comments

Here's a simple comment

```rust
// hello, world
```

In Rust, comments must start with two slashes and continue until the end of the line.

For comments that extend beyond a single line, you'll need to include // on each line.

```rust
// So we're doing something complicated here, long enough that we need
// multiple lines of comments to do it! Whew! Hopefully, this comment will
// explain what's going on.
```

Comments can also be placed at the end of lines containing code

```rust
fn main() {
    let lucky_number = 7; // I'm feeling lucky today
}
```

## Control Flow

The most common contructs that let you control the flow of execution of Rust code are if expressions and loops.

## If Expressions

An if expression allows you to branch your code depending on condition. If this condition is met, run this block of code like this

```rust
fn main() {
    let number = 3;

    if number < 5 {
        println!("condition was true");
    } else {
        println!("condition was false");
    }
}
```

It's also worth noting that the condition in this code _must_ be a bool. If the condition isn't a bool, we'll get an error

```rust
fn main() {
    let number = 3;
    if number {
        println!("number was three");
    }
}
```

the error:

```shell
error[E0308]: mismatched types
 --> src/main.rs:4:8
  |
4 |     if number {
  |        ^^^^^^ expected bool, found integral variable
  |
  = note: expected type `bool`
             found type `{integer}`
```

Fixing the error

```rust
fn main() {
    let number = 3;
    if number != 0 {
        println!("number was something other than zero");
    }
}
```

## Handling Multiple Conditions with else if

You can have multiple conditions by combining if and else in an else if expression.

```rust
fn main() {
    let number = 6;
    if number % 4 == 0 {
        println!("number is divisible by 4");
    } else if number % 3 == 0 {
        println!("number is divisible by 3");
    } else if number % 2 == 0 {
        println!("number is divisible by 2");
    } else {
        println!("number is not divisible by 4, 3, or 2");
    }
}
```

this program will be check every if expression in turn and executes the first body for wich the condition holds true.

## Using if in a let Statement

Because ud is an expression, we can use it on the right side of a let statement.

```rust
fn main() {
    let condition = true;

    let number = if condition {
        5
    } else {
        6
    };

    println!("The value of number is: {}", number);
}
```

If the types are mismatched, as in the following example, we'll get an error

```rust
fn main() {
    let condition = true;

    let number = if condition {
        5
    } else {
        "six"
    };

    println!("The value of number is: {}", number);
}
```

The error

```shell
error[E0308]: if and else have incompatible types
 --> src/main.rs:4:18
  |
4 |       let number = if condition {
  |  __________________^
5 | |         5
6 | |     } else {
7 | |         "six"
8 | |     };
  | |_____^ expected integral variable, found &str
  |
  = note: expected type `{integer}`
             found type `&str`
```

## Repetition with Loops

It's often useful to execute a block of code more than once. For this task, Rust provides several _loops_

> Rust has three kinds of loops: loop, while, and for.

## Repeating Code with loop

The loop keyword tells Rust to execute a block of code over and over again forever or until you explicitly tell it to stop.

```rust
fn main() {
    loop {
        println!("again!");
    }
}
```

CTRL-C to interrupt. Try it

```shell
cargo run
Compiling loops v0.1.0 (file:///projects/loops)
    Finished dev [unoptimized + debuginfo] target(s) in 1.50 secs
     Running `target/debug/loops`
again!
again!
again!
again!
^Cagain!
```

## Returning Values from Loops

To do this, you can add the value you want returned after the break expression you use to stop the loop; that value will be returned out of the loop so you can use it.

```rust
fn main() {
    let mut counter = 0;

    let result = loop {
        counter += 1;

        if counter == 10 {
            break counter * 2;
        }
    };

    println!("The result is {}", result);
}
```

## Conditional Loops with while

While the condition is true, the loop runs. When the condition ceases to be true, the program calls break, stopping the loop.

```rust
fn main() {
    let mut number = 3;

    while number != 0  {
        println!("{}!", number);
        number = number - 1;
    }

    println!("LIFTOFF!!!");
}

```

## Looping Through a Collection with for

You could use the while construct to loop over the elements of a collection, such as an array.

```rust
fn main() {
    let a = [10, 20, 30, 40, 50];
    let mut index = 0;

    while index < 5 {
        println!("the value is: {}", a[index]);
        index = index + 1;
    }
}
```

As a more concise alternative, you can use a for loop and execute some code for each item in a collection.

```rust
fn main() {
    let a = [10, 20, 30, 40, 50];

    for element in a.iter() {
        println!("the value is: {}", element);
    }
}
```

Here's what the countdown would look like using a for loop and another method we've not yet talked about, rev, to reverse the range

```rust
fn main() {
    for number in (1..4).rev() {
        println!("{}!", number);
    }
    println!("LIFTOFF!!!");
}
```

Rust is nicer, isn't it?


# Chapter 4 Understanding Ownership

Ownership is Rust's most unique feature, and it enables Rust to make memory safety guarantees without needing a garbage collector.

## What is Ownership?

Rust's central feature is _ownership_. Although the feature is straighforward to explain, it has deep implications for the rest of the lenguaje.

The memory is managed through a system of ownership with a set of rules that the compiler checks at compiler time. None of the ownership feature slow down your program while it's running.

## The Stack and the Heap

Both the stack and the heap are parts of memory that are available to your code to use at runtime, but they are structured in different ways. The stack stores values in the order it gets them and removes the values in the opposite oder. This is referred to as _last in, first out_.

The heap is less organized; when you put data on the heap, you request a certain amount of space. the operating system finds an empty spot in the heap that is big enough, marks it as being in use, and return a _pointer_, which is the address of that location. This process is called _allocating on the heap_ and is something abbreviated as just _allocating_

## Ownership Rules

* Eache value in Rust has a variable that's called it _owner_.
* Ther can be only one owner at a time.
* When the owner goes out of the scope, the value will be dropped.

## Variable Scope

A scope is the range within a program for which an item is valid. Let's say we have a variable that looks like this:

```rust
let s = "hello";
```

The variable is valid from the point at which it's declared until the end of the current _scope_

```rust
{                       // s is not valid here; it's not yet declared
    let s = "hello";    // s is valid from this point forward

    // do stuff with s
}                       // this scope is now over, and s is no longer valid
```

In other words, there are two important points in time here

* When s comes _into scope_, it is valid.
* It remains calid until it goes _out of scope_

## The String Type

To illustrate the rules of ownership, we need a data type that is more complex than the ones we covered in "Data Types.

String literals are convenient, but they aren't suitables for every situation in which we may want to use text. One reason is that they're immutable. Another is that not every string value can be known when we write our code.

For these situations, Rust has a second string type, String. This type is allocated on the heap and as such is able to store an amount of text that is unknown to us compile time. You can create a String from a string literal using the from function, like so

```rust
let s = String::from("hello");
```

The double colon (::) is an operator that allows us to namespace this particular from function under the String type rather using some sort of name like string_from

This kind of string can be mutated

```rust
let mut s = String::from("hello");

s.push_str(", worlf");  // push_str() appends a literal to a String

println!("{}", s);      // this will print 'hello, wolf'
```

The difference is how these two types deal with memory.


