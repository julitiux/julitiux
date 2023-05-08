---
title: "Vim"
date: 2023-05-05T14:10:47-06:00
draft: false
---


# 1. Introduction to Vim

## Diferent mode of vim

1. Normal
Vim start in normal mode, this is the central mode. You can change to another modes beginning in normal mode. Press the `Esc` key always turn normal mode.

2. Insert
In this mode you can add text. You can add text press the `i` key. There are another commands that turn the insert mode..

3. Command
In this mode you can access press the `:` key. This mode you can add different commands like save, open, find, replace words with regrex between Files.

4. Visual
In this mode you can access press the `v` key. In this mode, you can select text whit the cursor and you can apply commands just for drive it.

5. Select
In this mode you can acces press the `Ctrl-G`. Has a similar behavior to the visual mode, except that when writing we will not carry out commands.

6. Ex
This mode is similar to command mode, with the difference that after executing it does not return to normal mode. Tou enter by press `Q` key and exit.


## vim like a lenguage
Using vim is a different experience than usgin any other code editor. You have to use the next sintax

`verb - modifier - object`

Verbs
* v - visual
* c - change
* d - delete
* y - yank, copy

Modifier
* i - inside
* a - around
* t - till
* f - find
* / - search

Objects
* w - word
* s - sentence
* p - paragraph
* b - block
* t - tag (html)

## Let's talk vim
Now that we are in normal mode we can talk to vim.

You don't press everything at once you do it letter by letter.

Delete the word where the cursor is
```code
diw - delete inside word
```
Change the sentense you are on
```code
cis - change inside sentence
```
Change what is inside the quotes
```code
ci" - change inside quote
```
Change anything up to 'foo'
```code
c/foo - change search foo
```
Change everything up to the letter X
```code
ctX - change till X
```

When we have finished editing the file, in `normal` mode:

__save__
```code
:w
```
__exit__
```code
:q
```
__save and exit__
```code
:wq
```
__exit without save the changes__
```code
:q!
```

# 2. Edit the vim style
First, create a file `.vimrc`

## Know the power of the dot command
### dot command
```code
.
```
The dot command allow us repeat the last change. Later, press the dot command, you can keep the same behavior from delete a line. This is the function of dot command; repeat the behavior of the las command.

### Delete a line
```code
dd
```

### Indent a line
```code
>>
```
