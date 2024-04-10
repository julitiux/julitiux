---
title: "Pro Git"
date: 2024-04-08T23:46:43-06:00
draft: false
---

# **INDEX**
# [Getting Started](#getting-started)

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

