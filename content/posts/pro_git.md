---
title: "Pro Git"
date: 2024-04-08T23:46:43-06:00
draft: false
---

# **INDEX**
# [Getting Started](#getting-started)
# [Git Basics](#git-basics)

# Getting Started

## Installing Git
### Installing on Linux

If you want ton install the basic Git tools on Linux via a binary installer

```terminal
sudo dfn install git-all
```

If you are on a Debian-based distribution, such a Ubuntu, try _apt_

```terminal
sudo apt install git-all
```

### Installing on macOS

The easiest is probably to install the Xcode Command Line Tools. On Mavericks (10.9) above you can do this simply by trying to run _git_ from the Terminal the very first time.

```terminal
git --version
```

If you don't have it installed already, it will prompt you to install it.

If you want a more up to date version, you can also install it via a binary installer. A macOS Git installer is maintained and available for download at the Git website, at [https://git-scm.com/download/mac](https://git-scm.com/download/mac).

### Installing on Windows

The are also a few ways to install Git on Windows.

The most official build is available for download on the Git website: [https://git-scm.com/download/win](https://git-scm.com/download/win)

To get an automated installation you can use the [Git Chocolatey package](https://community.chocolatey.org/packages/git)

## First-Time Git Setup

You should have to do these things only once on any given computer. You can also change them at any time by running through the commands again.

### git config

Thats lets get and set configuration variables that control all aspects of how Git looks and operates. The variables can be stored in three different places:

> 1. `[path]/etc/gitconfig` file: Contains values applied to every user on the system and all their repositories. If you pass the option `--system` to `git config`, it reads and writes from this file specifically.

> 2. `~/.gitconfig` or `~/.config/git/config` file: Values specific personally to you, the user. You can make Git read and write to this file specifically by passing the `--global` option, and this affects all of the repositories you work with on your system.

> 3. `config` file in the Git directory (that is, .git/config) of whatever repository you are currently using: Specific to that single repositoy. You can force Git to read from and write to this dile with the `--local` option.

Each level overrides values in the previous level, so values in `.git/config` trump those in `[path]/etc/gitcconfig`

You can view all of you settings and where they are coming from using:

```terminal
git config --list --show-origin
```

### Your Identity

the first thing you shoul do when you install Git is set your user name and email address.

```terminal
git config --global user.name "Julio Ramirez"
git config --global user.email rrodriguez.julio@gmail.com
```

### Your Editor

If you want to user a different text editor, such as Emacs, you can do the following:

```terminal
git config --global core.editor emacs
```

In the case of Notepad++

```terminal
git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -notabbar -nosession -noPlugin"
```

### Your default branch name

To set main as the default branch name do:

```terminal
git config --global init.defaultBranch main
```

### Checking your Settings

If you want to check your configuration settings do:

```terminal
git config --list
```

You may see keys more than once, because Git reads the same key from different files ([path]/etc/gitconfig and ~/.gitconfig, for example). In this case, Git uses the last value for each unique key it sees.

You can also check what Git thinks a specifiv key's values typing:

```terminal
git config user.name
```

Even you can see the origin of property doing:

```terminal
git config --show-origin user.name
```

## Getting Help

If you ever need help while using Git, do:

```terminal
git help <verb>
git <verb> --help
man git-<verb>
```

# Git Basics

## Initializing a Repository in an Existing Directory

```terminal
git init
```

## Cloning an Existenting Repository

```terminal
git clone <url>
```

You can specify the new directory name as an aditional argument

```terminal
git clone https://github.com/julitiux/julitiux.git julito
```

## Checking the status of your files

```terminal
git status
```

## Tracking new files

```terminal
git add <file>
```

## Short status

```terminal
git status -s
```

or

```terminal
git status --short
```

## Ignoring files

The rules for the patterns you can put in the .gitignore files are as follow:

* Blank lines or lines stating with `#` are ignored.
* Standard glob patterns work, and will be applied recursively throughout the entire working tree.
* You can start patterns with a forward slash (`/`) to avoid recursivity
* You can end patterns with a forward slash (`/`) to specify a directory.
* You can negate a patter by starting it with an exclamation point (`!`).
* An asterisk (`*`) matches zero or more characteres.
* [`abc`] matches any character inside the brackets (in this case a, b, or c)
* A question mark (`?`) matches a single character.
* Brackets enclosing characters separated by a hyphen (`[0-9]`).
* You can also use two asterisks to match nested directories; `a/**/z` would match a/z, a/b/z, a/b/c/z and so on.

Here is an example `.gitignore` file

```file
# ignore all -a files
*.a

# but do track lib.a, even though you're ignoring .a files above
!lib.a

# only ignore the TODO file in the current directory, not subdir/TODO
/TODO

# ignore all files in any directory named build
build/

# ignore doc/notes.txt, but not doc/server/arch.txt
doc/*.txt

# ignore all .pdf files in the doc/ directory and any of its subdirectories
doc/**/*.pdf
```
> GitHub maintains a fairly comprehensive list of good .gitignore.
> https://github.com/github/gitignore

## Viewing your staged and unstaged changes

Show you the exact lines added and removed

```terminal
git diff
```

If you want to see what you've staged that will go into your next commit

```terminal
git diff --staged
```

To see what you've staged so far (--staged and --cached are synonyms)

```terminal
git diff --cached
```

## Committing your changes

```terminal
git commit
```
