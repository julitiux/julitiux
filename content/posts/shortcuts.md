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

## Setup automated session manager

| newest           | oldest                              | description                            |
| ---------------- | ----------------------------------- | -------------------------------------- |
| &lt;leader&gt;wr | &lt;cmd&gt;SessionRestore&lt;CR&gt; | Restore session for cwd                |
| &lt;leader&gt;ws | &lt;cmd&gt;SessionSave&lt;CR&gt;    | Save session for auto session root dir |

## Setup vim-maximizer

| newest           | oldest                               | description               |
| ---------------- | ------------------------------------ | ------------------------- |
| &lt;leader&gt;sm | &lt;cmd&gt;MaximizerToggle&lt;CR&gt; | Maximize/minimize a split |
