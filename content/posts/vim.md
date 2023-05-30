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
The dot command allow us repeat the last change. Press the dot command, you can keep the same behavior from delete a line.

### Delete a line
```code
dd
```

### Indent a line
```code
>>
```

### Go to the end of the line without edit
```code
$
```

### Go to the end of the line with edit
```code
A
```

### Exit the insert mode to normal pressing the <esc> key
```code
<esc>
```

# 3. Normal mode.
Normal mode is a rest state.

## Regulate how you undo your changes.

### undo
```code
u
```

### redo
```code
Ctrl-R
```
## Essential commands.
### first line of document
```code
gg
```
### last line of document
```code
G
```
### beginning of the sentence
```code
0
```
### ending of the sentence
```code
$
```
### end to the word
```code
e / E
```
### end to the word
```code
w / W
```
### begin of the word
```code
b / B
```
### begin and end of the sentence
```code
{ - }
```
### yank, copy
```code
y
```
### paste
```code
p
```
### find
```code
f / F
```
### till
```code
t / T
```
### add a number
```code
Ctrl-a
```
### rest a number
```code
Ctrl-x
```

# 4. Insert mode
## Make corrections instantly from Insert mode
### Delete around word
```code
daw
```
### Center the content where the cursor is present.
```code
zz
```
## Insert special characters
### insert special chatacter (insert mode)
```code
Ctrl-v {code}
```
### how to know the code of special caracter
```code
ga
```
### Insert special character decimal (insert mode)
```code
Ctrl-v u{code}
```
## Overwrite text with replace mode
### Replace the following characters until you press <esc>
```code
R
```
### Replace just a caracters
```code
r
```
### Delete a character and kept in insert mode
```code
s
```
### fix the capitalization of a character
```code
option-ñ
```

# 5. visual mode
The visual mode resembles the text selection in other code editors. But in this case we eill select text and execute actions on it.

The visula mode has three variants of selections:
* by characteres and words
* by complete lines
* by rectangular blocks of text

### to enter the visual mode
```code
v
```
In visual mode you can use the command for to seleect the text like:
### in visual mode. find until letter
```code
f{letter}
```

### repeat the `find`
```code
; / ,
```
### replace all the text selected and deleted it, on visual mode
```code
c
```
### visual-lineal mode
```code
V
```
### visual-block mode
```code
Ctrl-v
```
### convert text to uppercase (in visual mode)
```code
U
```
### convert text to lowercase (in visual mode)
```code
u
```
### convert text to uppercase/lowercase (in visual mode)
```code
~
```

# 6. command mode
The fundamental is know is that to enter vim's command mode have to press `:`

In command mode you can access `find mode`, this mode is specialized in searches
```code
/
```
some commands.

### delete the specified lines
```code
:[range]d[elete]
```
### copy lines
```code
:[range]y[ank]
```
### paste lines
```code
:[line]put
```
### copy lines below the address
```code
:[range]c[opy]{direction}
```
### copy lines below the addres with :t
```code
:t
```
### move specified lines in the chosen direction.
```code
:[range]m[ove]{direction}
```
### join lines
```code
:[range]j[oin]
```
### execute commands in the normal mode on the specified lines
```code
:[range]norm[al]{command}
```
### replace occurrences of {pattern} with {string} on each specified line
```code
:[range]s[ubstitute]/{pattern}/{string}/[flags]
```
### execute a command on the each specified line that matches the seach {pattern}
```code
:[range]g[lobal]/{pattern}/[command]
```
### show us the range, just for practicing
```code
:[range]p[rint]
```
### detail information of each command
```code
:h
```

## Command line positions
### first line of file
```code
:1
```
### last line of file
```code
:$
```
### previous line of the first line
```code
:1
```
### line where the cursos is located
```code
:.
```
### line containing the mark
```code
:'m
```
### if we select some lines in visual mode and press `:` the next range will be created
```code
:'<,'>
```
### the whole file
```code
:%
```

## Perfect for practicing ranges
### show the line five
```code
:5p
```
### show the content of lines between two and ten
```code
:2,10p
```
### show the current line and three more down
```code
:.,+3p
```
### show the current visual selection
```code
:'<,'>p
```

## Now some exercies
### put semicolon in the whole file
```code
A;<esc> (normal mode)
gg
V
G
:'<,'> norm .
```
### move current line after line 1
```code
:.,m0
```
### copy the line 4 before to line 9
```code
:4t9
```
### replace the word `Madrid` by `Bilbao` in the whole file
```code
:%s/Madrid/Bilbao
```
### execute a command in the shell, exit to return to vim
```code
:shell
```
### execute a command in the shell
```code
:![command's shell]
```
### repeat the last command in normal mode
```code
@:
```
# 7. Edit multiple files
## Buffer's list
A file is saved on disk while a buffer is saved on memory

### show us a list of buffers
```code
:ls
```
- `#` previous buffer
- `%` current buffer
### open next buffer
```code
:bn[ext]
```
### open previous buffer
```code
:bp[revious]
```
### open first buffer
```code
:bf[irst]
```
### open last buffer
```code
:bl[ast]
```
### remove buffer from list, does not remove file
```code
bd[elete] [buffer]
```
### show a list using arguments
```code
:args **/*.md
```
### allow us execute a command on all the buffers in the list at once
```code
:argdo [command]
```
### save all files
```code
:w[rite]a[all]
```
### exit all files without save
```code
:!q[uit]a[all]
```

# 8. Panels and tabs
## Panels
 Vim called windows, when open vim, it has only one panel but we can split it both horizontally and vertically
### divide the panel horizontally
```code
:sp[lit] {file}
```
### divide the panel vertically
```code
:vsp[lit] {file}
```
## Moving between panels
### Move between panels
```code
<Ctrl-w> w
```
### go to left panel
```code
<Ctrl-w> left
```
### go to down panel
```code
<Ctrl-w> down
```
### go to up panel
```code
<Ctrl-w> up
```
### go to right panel
```code
<Ctrl-w> rigth
```
### close a panel
```code
<Ctrl-w> c
:cl[ose]
```
### keep the panel active and closing the other one
```code
<Ctrl-w> o
:on[ly]
```
### equalize the height and width of the panels
```code
<Ctrl-w> =
```
### maximizes the height of the active panel
```code
<Ctrl-w> _
```
### maximize the width of the active panel
```code
<Ctrl-w> |
```
## Tabs
### open a new tab
```code
:tabnew
```
### change the path (the forlder) where the panel points to.
```code
:lcd {path}
```
### change the path where all the panels in a tab point to.
```code
:windo lcd {path}
```
### move the current panel to a new tab
```code
<Ctrl-w> T
```
### open a file in a new tab
```code
:tabe[dit] {file}
```
### close a tab
```code
:tabc[lose]
```
### close all tabs except the active one
```code
:tabo[only]
```
### go to tab {N}
```code
:tabn[ext] {N}
```
### go to tab {N}
```code
:tabn[ext] {N} gt
```
### next tab
```code
:tabn[ext]
```
### previous tab
```code
:tabp[revious]
```
### move tab {N}
```code
:tabmove {N}
```
### help about tabs
```code
:h tabpage
```

# 9. How to move quickly through files 1
## disable arrow keys
```code
noremap <up> <nop>
noremap <down> <nop>
noremap <left> <nop>
noremap <right> <nop>
```
## motions
### down a line
```code
j
```
### up a line
```code
k
```
### go to beginning of the line
```code
0
```
### go to end of the line
```code
$
```
### go to beginning of the paragraph
```code
{
```
### go to the end of the paragraph
```code
}
```
### go to the beginning of the file
```code
gg
```
### go to the end of the file
```code
G
```
### go to the beginning of the next word
```code
w
```
### go to the end of the next word
```code
e
```
### go back to the beginning of the current or previous word
```code
b
```
### find any character
```code
f/{character}
```
### find any character (reverse)
```code
F/{character}
```
### go forward and stop one column before the character
```code
t/{character}
```
### go forward and stop one column before the character (reverse)
```code
T/{character}
```
### repeat last search character
```code
;
```
### repeat last search character ((reverse)
```code
,
```

# 10. How to move quickly through files 2
## make accurate selections
This commands you are going execute from normal mode is thta they are proceded by v (visual selection), c (change text) or d (delete text)

### v/c/d around )
```code
a)
```
### v/c/d inside )
```code
i)
```
### v/c/d around }
```code
a}
```
### v/c/d inside }
```code
i}
```
### v/c/d aroung ]
```code
a]
```
### v/c/d inside ]
```code
i]
```
### v/c/d around >
```code
a>
```
### v/c/d inside <
```code
i<
```
### v/c/d around '
```code
a'
```
### v/c/d inside '
```code
i'
```
### v/c/d around "
```code
a"
```
### v/c/d inside "
```code
i"
```
### v/c/d around `
```code
a`
```
### v/c/d around tag HTML
```code
at
```
### v/c/d inside tag HTML
```code
it
```
### v/c/d around word
```code
aw
```
### v/c/d inside word
```code
iw
```
### v/c/d inside WORD
```code
iW
```
### v/c/d around WORD
```code
aW
```
### v/c/d inside phrase
```code
is
```
### v/c/d around phrase
```code
as
```
### v/c/d around paragraph
```code
ap
```
### v/c/d inside paragraph
```code
ip
```

## Bookmarks
### make a bookmark
```code
m{a-zA-Z}}
```
### return to the bookmark
```code
`{letter of mark}
```
### go to the position before the last jump in the current file
```
``
```
### go to the last change
```code
`.
```
### go to position of last insert
```code
`^
```
### go to the start position of the last change or copy
```code
`[
```
### go to the end position of the last change or copy
```code
`]
```
### go to the start position of the last visual selection
```code
`<
```
### go to the end position of the last visual selection
```code
`>
```

# 11. Registers.

There are 9 types of registers:
1. The unnamed register ""
2. 10 numbered register "0 to "9
3. The small delete register "-
4. 26 named registers "a to "z or "A to "Z
5. 4 read-only registers ":, "., "% and "#
6. The expression register "=
7. The selection and drop registers "\*, "+ and "~
8. The black hole register "_
9. Last search pattern register "/

To access register's vim is simple, just specify the register like this
```code
"{register}
```

### use the register `a` and copy a word like this
```code
"ayiw
```
### to acces the register has to do this:
```code
"ap
```
copy and paste the content of the register `a`
### access the content deleted
```code
""
```
## Other registers
### the black hole register
```code
#_
```
### the system clipboard
```code
"+ / "*
```

# 12. Thre power of macros

## Record and execute a macro
Macros start recording as soon as we press the `q` key and assign a record to it. To stop recording we will press `q` again.
### start to record a macro
```code
q
```
### end to record a macro
```code
q
```
### start to record a macro with register
```code
q{letter's register}
```
### execute a macro
```code
@{letter's register}
```

## variables
### declare a variable
```code
:let {variable}={number}
:ley i=1
```
### you can modify the variable even inside the macro
```code
let i+=1
```
### execute a macro in parallel (visual mode)
```code
:'<,'> normal @{letter's macro}
```
### lets paste the content of variable (insert mode)
```code
<ctrl-r>=i
```

## tricks
### for macros use commands like `A` and `I` just for normalize the position of cursor
### to repeat a macro just we have will use `@@` as many times as we want
