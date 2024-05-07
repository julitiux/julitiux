---
title: "Pro Git"
date: 2024-04-08T23:46:43-06:00
draft: false
---

# **INDEX**
# [Getting Started](#getting-started)
# [Git Basics](#git-basics)
# [Best Command Ever](#best-command-ever)

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

## Getting a Git repository

### Initializing a Repository in an Existing Directory

```terminal
git init
```

### Cloning an Existenting Repository

```terminal
git clone <url>
```

You can specify the new directory name as an aditional argument

```terminal
git clone https://github.com/julitiux/julitiux.git julito
```

## Recording changes to the repository

### Checking the status of your files

```terminal
git status
```

### Tracking new files

```terminal
git add <file>
```

### Short status

```terminal
git status -s
```

or

```terminal
git status --short
```

### Ignoring files

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

### Viewing your staged and unstaged changes

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

### Committing your changes

```terminal
git commit
```

Alternatively, you can type your commit message inline with the `commit` command by specifying it after a `-m` flag

```terminal
git commit -m
```

### Skipping the staging area

```terminal
git commit -a -m
```

```terminal
git commit -am
```

### Removing files

```terminal
git rm
```

```terminal
git rm --cached
```

You can pass files, directories, and file-glob patterns to:

```terminal
git rm log /\*.log
```

This command removes all files whose names end with a ~

```terminal
git rm \*~
```

### Moving files

```terminal
git mv file_from file_to
```

```terminal
git mv README.md README
```

## Viewing the commit history

By default, with no argument, `git log` lists the commits made in that repository in reverse chronological order.

```terminal
git log
```
### Option -p or --patch

```terminal
git log -p -2
```

### Option --stat

```terminal
git log --stat
```

### Option --pretty=oneline

```terminal
git log --pretty=oneline
```

### Option --pretty=short

```terminal
git log --pretty=short
```

### Option --pretty=full

```terminal
git --pretty=full
```

### Option --pretty=fuller

```terminal
git --pretty=fuller
```

### Option with format

```terminal
git log --pretty=format:"%h - %an, %ar : %s"
```

### Useful specifiers for git log --pretty=format

| Specifier | Description of Output |
|---|---|
| %H | Commit hash |
| %h | Abbreviated commit hash |
| %T | Tree hash |
| %t | Abbreviated tree hash |
| %P | Parent hashes |
| %p | Abbreviated parent hashes |
| %an | Author name |
| %ae | Author email |
| %ad | Author date (format respect the --date=option) |
| %ar | Author date, relative |
| %cn | Committer name |
| %ce | Committer email |
| %cd | Committer date |
| %cr | Committer date, relative |
| %s | Subject |

### Option --graph

```terminal
git log --pretty=format:"%h %s" --graph
```

## Common options to git

| Option | Description |
| --- | --- |
| -p | Show the patch introduced with each commit |
| --stat | Show statistics for files modified in each commit |
| --shorstats | Display only the changed/insertions/deletions line from the --stat command  |
| --name-only | Show the list of files modified after the commit information |
| --name-status | Show the list of files modified after the commmit information |
| --abbrev-commit | Show only the first few character of the SHA-1 cheksum instead of all 40  |
| --relative-date | Display the date in a relative format (for example, "2 weeks ago") instead of using the full date format |
| --graph | Display an ASCII graph of the branch and merge history beside the log output |
| --pretty | Show commits it an alternative format. Option values include `oneline`, `short`, `full`, `fuller` and `format` (where you specify you own format) |
| --online | Showrthand for --pretty=oneline --abbrev-commit used togheter |

## Limiting log output

### Option --since

```terminal
git log --since=2.weeks
```

### Option -S

```terminal
git log -S function_name
```

### Option -- path/to/file

```terminal
git log -- path/to/file
```

## Options to limit the output of git log

| Option | Description |
| --- | --- |
| -<n> | Show only the last n commits |
| --since, --after | Limit the commits to those made after the specified date |
| --unitl, --before | Limit the commits to those made before the specified date |
| --author | Only show commits in which the autor entry matcher the specified string |
| --committer | Only show commits in which the committer entry matcher the specified string |
| --grep | Only shiw commut with a commit message contraining the string |
| -S | Only show commits adding or removing code matching the string |

For example, if you want to see which commits modifying test files in the Git source code history were committed by Junio Humano in the month of Octuber 2008 and are not merge commits, you can run something like this:

```terminal
git log --pretty="%h - %s" --author='Junio C Hamano' --since"2008-10-01" --before="2008-11-01" --no-merges -- t/
```

# Best Command Ever

You can see your changes in a more compact way.

```terminal
git status -s
git status --short
```

If you want to see what you have staged that will go into your next commit.

```terminal
git diff --staged
git diff --cached
```

This is particularly useful if you forgot to add something to your .gitignore.

```terminal
git rm --cached <file>
```

If you forget add a file in a commit --amend and you dont want keep the commit's text

```terminal
git commit --amend --online
```
