---
title: "Shortcuts"
date: 2026-11-14T17:50:24-06:00
draft: false
---

# Shortcuts

## Setup core keymaps

| newest           | oldest                        | description                    |
| ---------------- | ----------------------------- | ------------------------------ |
| jk               | &lt;ESC&gt;                   | Exit insert mode with jk       |
| &lt;leader&gt;nh | :noh1&lt;CR&gt;               | Clear search highlights        |
| &lt;leader&gt;+  | &lt;C-a&gt;                   | Increment number               |
| &lt;leader&gt;-  | &lt;C-x&gt;                   | Decrement number               |
| &lt;leader&gt;sv | &lt;C-w&gt;v                  | Split window vertically        |
| &lt;leader&gt;sh | &lt;C-w&gt;s                  | Split window horizontally      |
| &lt;leader&gt;se | &lt;C-w&gt;=                  | Make splits equal size         |
| &lt;leader&gt;sx | &lt;cmd&gt;close&lt;CR&gt;    | Close current split            |
| &lt;leader&gt;to | &lt;cmd&gt;tabnew&lt;CR&gt;   | Open new tab                   |
| &lt;leader&gt;tx | &lt;cmd&gt;tabclose&lt;CR&gt; | Open current tab               |
| &lt;leader&gt;tn | &lt;cmd&gt;tabn&lt;CR&gt;     | Open nex tab                   |
| &lt;leader&gt;tp | &lt;cmd&gt;tabp&lt;CR&gt;     | Open previous tab              |
| &lt;leader&gt;tf | &lt;cmd&gt;tabnew %&lt;CR&gt; | Open current buffer in new tab |

## Setup nvim-tree file explorer

| newest           | oldest                                      | description                          |
| ---------------- | ------------------------------------------- | ------------------------------------ |
| &lt;leader&gt;ee | &lt;cmd&gt;NvimTreeToggle&lt;CR&gt;         | Toggle file explorer                 |
| &lt;leader&gt;ef | &lt;cmd&gt;NvimTreeFindFileToggle&lt;CR&gt; | Toggle file explorer on current file |
| &lt;leader&gt;ec | &lt;cmd&gt;NvimTreeCollapse&lt;CR&gt;       | Collapse file explorer               |
| &lt;leader&gt;er | &lt;cmd&gt;NvimTreeRefresh&lt;CR&gt;        | Refresh file exlorer                 |

## Setup telescope fuzzy finder

| newest           | oldest                                     | description                     |
| ---------------- | ------------------------------------------ | ------------------------------- |
| &lt;leader&gt;ff | &lt;cmd&gt;Telescope find_files&lt;CR&gt;  | Fuzzy find files in cwd         |
| &lt;leader&gt;fr | &lt;cmd&gt;Telescope oldfiles&lt;CR&gt;    | Fuzzy find recent files         |
| &lt;leader&gt;fs | &lt;cmd&gt;Telescope live_grep&lt;CR&gt;   | Find string in cwd              |
| &lt;leader&gt;fc | &lt;cmd&gt;Telescope grep_string&lt;CR&gt; | Find string under cursor in cwd |
| &lt;leader&gt;ft | &lt;cmd&gt;TodoTelescope&lt;CR&gt;         | Find todos                      |

## Setup automated session manager

| newest           | oldest                              | description                            |
| ---------------- | ----------------------------------- | -------------------------------------- |
| &lt;leader&gt;wr | &lt;cmd&gt;SessionRestore&lt;CR&gt; | Restore session for cwd                |
| &lt;leader&gt;ws | &lt;cmd&gt;SessionSave&lt;CR&gt;    | Save session for auto session root dir |

## Setup vim-maximizer

| newest           | oldest                               | description               |
| ---------------- | ------------------------------------ | ------------------------- |
| &lt;leader&gt;sm | &lt;cmd&gt;MaximizerToggle&lt;CR&gt; | Maximize/minimize a split |

## Setup commenting plugin

| shortcut                | description             |
| ----------------------- | ----------------------- |
| &lt;C-space&gt;         | Start to mark the text  |
| :InspectTree            | Start highlight         |
| &lt;leader&gt;gcc       | Comment a line          |
| &lt;leader&gt;gcG       | Comment all document    |
| &lt;leader&gt;gc_number | Commnet number of lines |

## Setup substitution plugin

| shortcut    | description               |
| ----------- | ------------------------- |
| NORMAL - s  | Substitute with motion    |
| NORMAL - ss | Substitute line           |
| NORMAL - S  | Substitute to end of line |
| VISUAL - s  | Substitute in visual mode |

## LSP Shortcuts

### Code Navigation

| shorcut | description                                        |
| ------- | -------------------------------------------------- |
| gR      | Show LSP references                                |
| gD      | Go to declaration                                  |
| gd      | Go to definition                                   |
| gi      | Show LSP implementations                           |
| gt      | Show LSP type definitions                          |
| K       | Show documentation for the symbol under the cursor |

### Code Actions & Refactoring

| shortcuts        | description                 |
| ---------------- | --------------------------- |
| &lt;leader&gt;ca | Show available code actions |
| &lt;leader&gt;rn | Smart rename symbol         |

### Diagnostics

| shortcuts       | description                |
| --------------- | -------------------------- |
| &lt;leader&gt;D | Show buffer diagnostics    |
| &lt;leader&gt;d | Show line diagnostics      |
| [d              | Go to previous diagnostics |
| ]d              | Go to next diagnostics     |

### LSP Management

| shortcuts        | description        |
| ---------------- | ------------------ |
| &lt;leader&gt;rs | Restart LSP server |

## Setup trouble.nvim

| shortcuts        | description                       |
| ---------------- | --------------------------------- |
| &lt;leader&gt;xw | Open workspace diagnostics        |
| &lt;leader&gt;xd | Open current document diagnostics |
| &lt;leader&gt;xq | Open Quickfix list                |
| &lt;leader&gt;xl | Open Location List                |
| &lt;leader&gt;xt | Open TODO comments                |

## Setup linting

| shortcuts       | Column2                              |
| --------------- | ------------------------------------ |
| &lt;leader&gt;l | Trigger linting for the current file |

## Setup gitsigns plugin

### Navigation

| shortcuts | description         |
| --------- | ------------------- |
| ]h        | Go to next hunk     |
| [h        | Go to previous hunk |

### Git Actions

| shortcuts        | description         |
| ---------------- | ------------------- |
| &lt;leader&gt;hs | Stage current hunk  |
| &lt;leader&gt;hr | Reset current hunk  |
| &lt;leader&gt;hS | Stage entire buffer |
| &lt;leader&gt;hR | Reset entire buffer |
| &lt;leader&gt;hu | Undo stage buffer   |

### Preview

| shortcuts        | description          |
| ---------------- | -------------------- |
| &lt;leader&gt;hp | Preview current hunk |

### Git Blame

| shortcuts        | description                      |
| ---------------- | -------------------------------- |
| &lt;leader&gt;hb | Show full blame for current line |
| &lt;leader&gt;hB | Toggle current line blame        |

### Diff

| shortcuts        | description                                 |
| ---------------- | ------------------------------------------- |
| &lt;leader&gt;hd | Diff current line                           |
| &lt;leader&gt;hD | Diff current file against previous revision |

### Text Objects

| shortcuts | description                                             |
| --------- | ------------------------------------------------------- |
| ih        | Select current hunk (Visual and Operator-pending modes) |

## Setup lazygit integration

| shortcuts        | description   |
| ---------------- | ------------- |
| &lt;leader&gt;lg | Open lazy git |

## Keyboard shortcuts SKHD

### Changing Focus Shortcuts

| shortcut | description |
| -------- | ----------- |
| alt - j  | focus south |
| alt - k  | focus north |
| alt - h  | focus west  |
| alt - l  | focus east  |

### Change focus between displays

| shortcut | description |
| -------- | ----------- |
| alt - s  | focus west  |
| alt - g  | focus east  |

### Shortcuts for modifying the layout

| shortcut        | description   |
| --------------- | ------------- |
| shift + alt - r | rotate        |
| shift + att - y | mirror y-axis |
| shift + att - x | mirror x-axis |
| shift + att - t | toggle float  |

### Modifying Window size shortcuts

| shortcut        | description     |
| --------------- | --------------- |
| shift + alt - m | zoom-fullscreen |
| shift + alt - e | balance         |

### Stop/Start/Restart Yabai

| shortcut       | description     |
| -------------- | --------------- |
| ctrl + alt - q | stop-service    |
| ctrl + alt - s | start-service   |
| ctrl + alt - r | restart-service |

## fzf (command line fuzzy finder)

| example       | description                                      |
| ------------- | ------------------------------------------------ |
| ctrl-t        | look to files and directories                    |
| ctrl-r        | look through command history                     |
| Tab           | mark a result                                    |
| shift + tab   | unmark a result                                  |
| cd **tab      | open up fzf to find directory                    |
| export **tab  | look for env variable to export                  |
| unset **tab   | look for env variable to unset                   |
| unalias **tab | look for alias to unalias                        |
| ssh **tab     | look for recently visited host names             |
| kill -9 **tab | look for files & directories to complete command |
