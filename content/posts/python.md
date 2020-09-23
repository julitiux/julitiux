---
title: "Python"
date: 2020-09-01T22:05:10-05:00
draft: false
toc: false
images:
tags:
  - untagged
---

# GETTING STARTED

## How To Install

There are two versions of Python available: Python 2 and the newer Python 3. By default in Mac OS has Python 2.

How to know the version that you has, type something like this:

```python
~ » python --version
Python 2.7.16
```

Python comes with an interpreter that runs a terminal. For launch the interpreter, open a terminal and write something like this:
```python
~ » python

WARNING: Python 2.7 is not recommended.
This version is included in macOS for compatibility with legacy software.
Future versions of macOS will not include Python 2.7.
Instead, it is recommended that you transition to using 'python3' from within Terminal.

Python 2.7.16 (default, Feb 29 2020, 01:55:37)
[GCC 4.2.1 Compatible Apple LLVM 11.0.3 (clang-1103.0.29.20) (-macos10.15-objc- on darwin
Type "help", "copyright", "credits" or "license" for more information.
>>>
```

To install Python 3, go on your terminal and run the following command:


```shell
~ » brew install python3
```

## How To Install PyEnv

### Build Build Dependencies

pyenv builds Python from source, which means you will need build dependencies to actually use pyenv.

This command relies on Homebrew and installs the few dependencies for macOS users.

```shell
brew install openssl readline sqlite3 xz zlib
```

### Using the pyenv-installer

After you have installed the build dependencies, you are ready to install pyenv itself.

```shell
curl https://pyenv.run | bash
```

This command will install pyenv along with a few plugins that are useful:

* *pyenv*: The actual pyenv application
* *pyenv-virtualenv*: Plugin for pyenv and virtual environments
* *pyenv-update*: Plugin for updating pyenv
* *pyenv-doctor*: Plugin to verify that pyenv and build dependencies are installed
* *pyenv-which-ext*: Plugin to automatically lookup system commands

At the end of the run, you should see something like this:

```shell
WARNING: seems you still have not added 'pyenv' to the load path.

# Load pyenv automatically by adding
# the following to ~/.bashrc:

export PATH="$HOME/.pyenv/bin:$PATH"
eval "$(pyenv init -)"
eval "$(pyenv virtualenv-init -)"
```

Once you have done this, you need to reload your shell:

```shell
soruce .zshrc
```

## Using pyenv.

### List all pythons availables.

```shell
pyenv install --list
pyenv install --list | grep "jython"
pyenv install --list | grep " 3\.[678]"
```

### Install a version of python.

```shell
pyenv install -v 3.7.2
pyenv install 3.8-dev
```

### Installation Location.

```shell
ls ~/.pyenv/versions/
```

### Uninstall a version of python.
```shell
rm -rf ~/.pyenv/versions/2.7.15
```

or

```shell
pyenv uninstall 2.7.15
```









## Running Python Programs from a terminal

To start your first program, make a file called hello_world.py and enter the following line:


```python
print("Hello Python world!")
```

Open a terminal and then, run the file using the command python, like this:


```shell
python hello_world.py
```

# VARIABLES AND SIMPLE DATA TYPES

## Naming and Using Variables

In the same file, we are going to do something like this:

```python
message = "Hello Python World!"
print(message)
```

* Variable names can contain only letters, numbers, and underscores.
* Spaces are not allowed in variable names, but underscores can be used to separate words in variable names.
* Variable names should be short but descriptive

## Strings

```python
"This is a string."
'This is a string.'

'This flexibility "allows" you to use quotes and apostrophes within your strings.'
"This flexibility 'allows' you to use quotes and apostrophes within your strings."
"This flexibility allows you to use quotes and apostrophe's within your strings."
```
### Changing Case in a String with Methods

```python
name = "julio ramirez"
print(name.title())
print(name.upper())
print(name.lower())
```

### Combining or Concatenating Strings

```python
first_name = 'Julio'
last_name = 'Ramirez'
full_name = first_name + " " + last_name
print("Hello, " + full_name.title() + "!")
```

### Adding Whitespace to String with Tabs or Newlines

```python
>>> print("\tPython")
>>> print("Languages:\n\tPython\n\tSwift\n\tGroovy")
```

### Stripping Whitespace

```python
>>> language = ' groovy '
>>> language
' python '
>>> language.rstrip()
' python'
>>> language.lstrip()
'python '
>>> language.strip()
'python'
>>> language
' python '
```

## Numbers

### Integers

You can add (+), subtract (-), multiply ( * ), divide (/), exponents( ** ) integers in Python.
```python
>>> 2 + 3
5
>>> 3 - 2
1
>>> 2 * 3
6
>>> 3 / 2
1.5
>>> 3 ** 3
27
```
### Floats

Python calls any number with a decimal point a float.
```python
>>> 0.1 + 0.1
0.2
>>> 0.2 + 0.2
0.4
>>> 2 * 0.1
0.2
>>> 2 * 0.2
0.4
```
But be aware that you can sometimes get an arbitrary number of decimal places in your answer.
```python
>>> 0.2 + 0.1
0.30000000000000004
>>> 3 * 0.1
0.30000000000000004
```

### Avoid Type Errors with the str() Function

This is a type error. It means Python can not recognize the kind of information you are using. In ths example Python sees that you are using variable that has an integer value (int), but it is not sure how to interpret that value.
```python
>>> age = 23
>>> message = "happy " + age + " anios!!"

Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: can only concatenate str (not "int") to str
```
you have to fix it like this.
```python
>>> message = "happy " + str(age) + " anios!!"
>>> print(message)
happy 23 anios!!
```

### Comments

In Python, the hash mark (#) indicates a comment.
```python
# Never say goodbye
```

# Introducing List

A list is a collection of items in a particular order. You can make a list that includes the letters of the alphabet, the digits from 0-9, or the names of all things that you want.

### Accessing Elements in a List

```python
bicycles = ['trek', 'cannondale', 'redline','specialized']
print(bicycles[0])
```
## Changing, Adding, and Removing Elements

### Modifying Elements in a List.

```python
motorcycles = ['honda','yamaha','suzuki']
print(motorcycles)

motorcycles[0] = 'ducati'
print(motorcycles)
```
### Adding Elements to a List

```python
motorcycles = ['honda','yamaha','suzuki']
print(motorcycles)

motorcycles.append('ducati')
print(motorcycles)
```

### Inserting Elements into a List

```python
motorcycles = ['honda','yamaha','suzuki']

motorcycles.insert(0,'ducati')
print(motorcycles)
```

### Removing Elements from a List using the _del_ Statement

```python
motorcycles = ['honda','yamaha','suzuki']
print(motorcycles)

del motorcycles[0]
print(motorcycles)
```

### Removing Elements from a List using the _pop()_ method

```python
motorcycles = ['honda','yamaha','suzuki']
print(motorcycles)

popped_motorcycle = motorcycles.pop()
print(motorcycles)
print(popped_motorcycle)
```

### Popping items from any Position in a list

```python
motorcycles = ['honda','yamaha','suzuki']

first_owned = motorcycles.pop(0)
print(first_owned)
print(motorcycles)
```

### Removing Items by Value

```python
motorcycles = ['honda','yamaha','suzuki']
print(motorcycles)

motorcycles.remove('ducati')
print(motorcycles)
```
## Organizing a List

### Sorting a List permanently with the sort() method

```python
cars = ['bmw','audi','toyota','subaru']
cars.sort()
print(cars)
```

### Sorting a List temporarily with the sorted() function

```python
cars = ['bmw','audi','toyota','subaru']
print(sorted(cars))
print(cars)
```

### Printing a List in reverse order

```python
cars = ['bmw','audi','toyota','subaru']
print(cars)

cars.reverse()
print(cars)
```

### Finding the length of a List

```python
cars = ['bmw','audi','toyota','subaru']
print(len(cars))
```

# Working with Lists

## Looping an entire List

In a file magicians.py

```python
magicians = ['alice', 'davis', 'carolina']
for magician in magicians:
	print(magician)
```

### Do something after a for loop

```python
magicians = ['alice', 'davis', 'carolina']
for magician in magicians:
	print(magician)
print("Thank you, everyone. That was a great magic show!")
```

### Forgetting to ident additional lines

```python
magicians = ['alice', 'davis', 'carolina']
for magician in magicians:
	print(magician)
print("The last magician is " + magician)
```

### Identing unnecessarily

```python
message = "Hello Python world"
	print(message)
```

### Identing unnecessarily after the loop

```python
magicians = ['alice', 'davis', 'carolina']
for magician in magicians:
	print(magician)

	print("Thank you, everyone. That was a great magic show!")
```

### Forgetting the colon

```python
magicians = ['alice', 'davis', 'carolina']
for magician in magicians
	print(magician)
```


# Making numerical lists

## Using the range() function

In a file numbers.py

In this example, range() prints only the numbers 1 through 4.

```python
for value in range(1,5):
	print(value)
```

## Using range() to make a list of numbers

```python
numbers = list(range(1,5))
print(numbers)
```

using a increment

```python
pairs_numbers = list(range(2,11,2))
print(pairs_numbers)
```

You can create almost any set of numbers you want to using the range() function

```python
squares = []
for value in range(1,11)
	square = value**2
	squares.append(square)

print(squares)
```

To write this code more concisely, omit the temporary variable square and append each new value directly to the list:

```python
squares = []
for value in range(1,11)
	squares.append(value**2)

print(squares)
```

or better

```python
squares = [value**2 for value in range(1,11)]
print(squares)
```

### Simple statistics with a list of number

```python
digits = list(range(1,11))

print(min(digits))
print(max(digits))
print(sum(digits))
```

# Working with part of a list

In a file players.py

```python
players = ['charles', 'martina', 'michael', 'florence', 'eli']
print(players[0:3])
print(players[1:4])
print(players[:4])
print(players[2:])
print(players[-3:])
```

### Looping through a slice

```python
players = ['charles', 'martina', 'michael', 'florence', 'eli']

print("Here are the first three players on my team:")

for player in players[:3]:
	print(player)
```

### Copyiing a list

```python
my_foods = ['pizza', 'falafel', 'carrot cake']

friend_foods = my_foods[:]

print("My favorite foods are:")
print(my_foods)

print("My friend's favorite foods are:")
print(friend_foods)
```

This does not work

```python
friend_foods = my_foods
```

# Tuples

List of items that cannot change. Python refers to values that cannot change as immutable, and an immutable list is called a tuple.

### Defining a Tuple

```python
dimensions = (200, 50)
print(dimensions[0])
print(dimensions[1])
```

### Looping through all values in a tupla

```python
dimensions = (200, 50)
for dimension in dimensions:
	print(dimension)
```

You can not modify a tuple, you can assign a new value to a variable that holds a tuple

```python
dimensions = (200, 50)
for dimension in dimensions:
	print(dimension)

dimensions = (400, 100)
print("Modified dimensions")
for dimension in dimensions:
	print(dimension)
```

# if statements

### A simple example

In a file cars.py

```python
cars = ['audi', 'bmw', 'subaru', 'toyota']

for car in cars:
  if car == 'bmw':
    print(car.upper())
  else:
    print(car.title())
```

## Checking for Equality

The _equality_ operator checks whether the value of car is 'Audi' using a double equal sign (==)

```python
car = 'Audi'
car == 'Audi'
True
```

### Ignoring case when checking for equality

Testing for equality is case sensitive in Python. For example, two values with different capitalization are not considered equal.

```python
car = 'Audi'
car == 'audi'
False
```

## Checking for Inequality

When you want to determine whether two values are not equal, ypu can combine an exclamation point and an equal sigh (!=).

In a file topping.py

```python
requested_topping = 'mushrooms'

if requested_topping != 'anchovies'
  print('Hold the anchovies')
```

## Numerical Comparisons

```python
age = 19
age < 21
True
age <= 21
True
age > 21
False
age >= 21
False
```

## Checking mmultiple conditions

Using _and_ or _or_ conditions

```python
age_0 = 22
age_1 = 18
age_0 >= 21 and age_1 >= 21
False

age_0 >= 21 or age_1 >= 21
True
```

## Checking whether a value is in a list

```python
requested_topping = ['mushrooms', 'onions', 'pineaple']
'mushrooms' in requested_topping
True
'pepperoni' in requested_topping
False
```

## If Statement

The simple kind of if statement has one test and one action:

```python
if _conditional_test_:
  _do something_
```
by example, in a file voting.py

```pyhton
age = 19
if age >= 18:
  print("You are old enough to vote!")
```

## if-else statements

```python
age = 20
if age >= 18:
  print("You are old enough to vote!")
else:
  print("You are too young to vote")
```

## The if-elif-else chain

```python
age = 12

if age < 4:
  print("Your admission cost is $0.")
elif age < 18:
  print("Yout admission cost is $5.")
else:
  print("Yout admission cost is $10.")
```

In summary, if you wnat only execute one block of code to run, use an if-elif-else chain. If more than one block of code needs to run, use a series of independent if statement,
