---
title: "Python"
date: 2020-09-01T22:05:10-05:00
draft: true
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
