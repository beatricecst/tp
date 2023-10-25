---
layout: page
title: User Guide
---

FoodNotes is a desktop app made for foodies like you to **manage food reviews**, optimized for use via a **Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, foodnotes can get your food review tasks done faster than traditional GUI apps.

* Table of Contents
  {:toc}

<div markdown="block" class="index">

<div style="page-break-after: always;"></div>

## About the user guide

### Navigating the user guide

* If you are a **new user**, the [Quick start](#quick-start) section provides instructions for you on how to get started.

* Once you have set up FoodNotes, you can check out the [Screen layout](#screen-layout) section to get familiar with the different components of FoodNotes. To learn the basics of using FoodNotes, head over to the [Features](#features) section.

* If you are an **experienced user**, you can refer to the [Command summary](#command-summary) section for an overview of FoodNotes' commands.

* If you have any queries about using FoodNotes, you can check out the [FAQ](#faq) section.

### Reading the user guide

#### Icons

This section will run you through the icons used in this guide.

| Icon           | Meaning                                                          |
|----------------|------------------------------------------------------------------|
| :bulb:         | Extra information that you may find useful.                      |
| :exclamation:  | Information you should be aware of to avoid running into errors. |
| :fast_forward: | Information about future updates to a feature.                   |

<div style="page-break-after: always;"></div>

#### Input parameters

This section provides a summary of the parameters used when inputting commands into the application.

| Prefix | Parameter        | Meaning                                            | Input                                                                        |
|--------|------------------|----------------------------------------------------|------------------------------------------------------------------------------|
| `n/`   | `STALL_NAME`     | Name of the stall                                  | Alphanumeric value with 1 to 27 characters (inclusive)                       |
| `s/`   | `STALL_INDEX`    | Index of the stall in the list                     | Integer from 0 to 2147483647 (inclusive)                                     |
| `l/`   | `STALL_LOCATION` | Location of the stall                              | Alphanumeric value with 1 to 27 characters (inclusive)                       |
| `i/`   | `ITEM_NAME`      | Name of the item                                   | Alphanumeric value with 1 to 27 characters (inclusive)                       |
| `r/`   | `STALL_RATING`   | Rating of the stall                                | Integer from 0 to 5 (inclusive)                                              |
| `r/`   | `ITEM_RATING`    | Rating of the item                                 | Integer from 0 to 5 (inclusive)                                              |
| `d/`   | `DESCRIPTION`    | Descriptive review for the stalls or items         | Alphanumeric value with 1 to 27 characters (inclusive)                       |


--------------------------------------------------------------------------------------------------------------------

## Quick start (To be updated)

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `FoodNotes.jar` from [here](https://github.com/se-edu/FoodNotes-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your FoodNotes.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar foodnotes.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `list` : Lists all stalls.

    * `add-stall n/Japanese stall l/Deck` : Adds a stall named `Japanese stall` located at `Deck` to the list of stalls.

    * `view-stall s/3` : Shows the 3rd stall shown in the current list.

    * `delete-stall s/3` : Deletes the 3rd stall shown in the current list.


1. Refer to the [Features](#features) below for details of each command.

<div markdown="block" class="alert alert-info">

:bulb: **Note:**<br>

* For new users, the application will contain all the data of NUS food stalls and their menu items
* If double-clicking `foodNotes.jar` does not work,
  1. Search for "Command Prompt" or "Terminal" on your computer.
  2. Navigate to the location where `foodNotes.jar` is saved via the terminal. (_Unsure how to navigate?_ You can try running this in your terminal: `cd Downloads`.)
  3. Run the following in the terminal: `java -jar foodNotes.jar`.

</div>

<div markdown="block" class="alert alert-warning">

:exclamation: **Warning:**<br>

Upon launching the application, some files responsible for the storage of your data will be created in a folder called `data` located in the same folder as `foodNotes.jar`. If you are a new user, you are advised not to edit these files. If the changes you made to the data file invalidates its format, FoodNotes will discard all your data and start with an empty data file.

</div>

--------------------------------------------------------------------------------------------------------------------

# Features

**View all stalls:** list

**Command format:** list

**Expected output (Success):**
```
Japanese Stall at Deck  ★★★★☆
Cake shop at Engine  ★★★★☆
Noodle stall at Frontier  ★★★★☆
```
**Expected output (Fail):**
```
please enter list only
```

**Find stalls by name:** find-stall

**Command format:** find-stall <KEYWORD>

**Ex.:** find-stall japan

**Expected output (Success):**
```
Japanese Stall at Deck  ★★★★☆
Japanese Stall at Engine  ★★★★☆
Japan Delights at Frontier  ★★★★☆
```
**Expected output (Fail):**
```
re-enter in the format : find-stall <KEYWORD>
```

**Find stalls by item:** find-item

**Command format:** find-item <KEYWORD>

**Ex.:** find-item chicken

**Expected output (Success):**
```
Chicken Rice at Deck  ★★★★☆
Western Food at Deck  ★★★★☆
```
Chicken Rice at Deck has an item called Chicken Rice, and Western Food at Deck has an item called Chicken Chop, 
thus both will be shown when you search for chicken.


**Expected output (Fail):**
```
re-enter in the format : find-item <KEYWORD>
```
--------------------------------------------------------------------------------------------------------------------
## Stall Features

**1.1 Adding a stall:** add-stall

**Command format:** add-stall n/<STALL_NAME>  l/ <LOCATION>

**Ex.:** add-stall n/Japanese stall l/Deck

**Expected Output (Success):**
```
Yay! Japanese stall at Deck is successfully added to list of stalls.
```
**Expected Output (Fail):**
```
re-enter in the format : add-stall n/<STALL_NAME>  l/ <LOCATION>
```
**1.2 Viewing a stall:** view-stall

**Command format:** view-stall s/<STALL_NUMBER>

**Ex.:** view-stall s/1

**Expected output (Success):**
```
Japanese stall: ★★★★☆
Review: the auntie very chio
Menu
1. Chicken Karage Rice ★★★★☆
2. Chicken Katsu Curry Rice ★★★★★
```
**Expected output (Fail)**:
```
re-enter in the format : view-stall s/<STALL_NUMBER>
```
**1.3 Deleting a stall:** delete-stall

**Command format:** delete-stall s/<STALL_NUMBER>

**Ex.:** delete-stall s/1

**Expected output (Success):**
```
Japanese Stall ★★★★☆ has been deleted.
```

**Expected output (Fail):**

```
re-enter in the format : delete-stall s/<STALL_NUMBER>
```
**1.4 Reviewing a stall:** review-stall

**Command format:** review-stall s/STALL_NUMBER r/STALL_RATING d/DESCRIPTION

**Ex.:** review-stall s/1 r/5 d/the auntie very chio

**Expected output (Success):**
```
Yay! You have added a rating of ★★★★★ for the Japanese Stall
Review: the auntie very chio
```
**Expected output (Fail):**
```
re-enter in the format : review-stall s/STALL_NUMBER r/STALL_RATING d/DESCRIPTION
```
**Acceptable values:**
- s/: Positive Integer less than or equal to the size of list
- r/: Integer from 0 to 5
- d/: String
--------------------------------------------------------------------------------------------------------------------
## Item Features

**2.1 Adding an item to a stall:** add-item

**Command format:** add-item s/STALL_NUMBER i/ITEM

**Ex.:** add-item s/1 i/Chicken Rice

**Expected output (Success):**
```
Yay! Chicken Rice is successfully added as a menu item for Japanese Stall at Deck
```
**Expected output (Fail):**
```
re-enter in the format : add-item s/STALL_NUMBER i/ITEM
```
**Acceptable values:**

- s/: Positive Integer less than or equal to the size of list,

- i/: String

**2.2 Viewing an item from a stall:** view-item

**Command format:** view-item s/STALL_NUMBER i/ITEM_NUMBER

**Ex.:** view-item s/1 i/1

**Expected output (Success):**
```
Chicken Karage Rice ★★★☆☆
Review: Great fried chicken that’s crunchy and juicy, but there’s only 3 pieces and everything is in dire need of sauce, meaning it’s not quite bang for buck and you might be hungry again in a few hours.
```

**Expected output (Fail):**

```
re-enter in the format : view-item s/STALL_NUMBER i/ITEM_NUMBER
```
**Acceptable values:**
- s/: Positive Integer less than or equal to the size of list,
- i/: Positive Integer less than or equal to the size of list

**2.3 Deleting an item from a stall:** delete-item

**Command format:** delete-item s/STALL_NUMBER i/ITEM_NUMBER

**Ex.:** delete-item s/1 i/1

**Expected output (Success):**
```
Chicken Karaage Rice ★★★★☆ has been deleted from Japanese Stall
```
**Expected output (Fail):**
```
re-enter in the format : delete-item s/STALL_NUMBER i/ITEM_NUMBER
```
**Acceptable values:**
- s/: Positive Integer less than or equal to the size of list
- i/: Positive Integer less than or equal to the size of list

**2.4 Reviewing an item:** review-item

**Command format:** review-item s/STALL_NUMBER i/ITEM_NUMBER r/ITEM_RATING d/DESCRIPTION

**Ex.:** review-item s/1 i/1 r/5 d/Tasty chicken rice with a good amount of meat and rice. The chilli is also very good.

**Expected output (Success):**
```
Yay! You have added a review for the White Chicken Rice at the Chicken Rice Stall at Deck.
Review:
★★★★★
Tasty chicken rice with a good amount of meat and rice. The chilli is also very good.
```
**Expected output (Fail):**
```
re-enter in the format: review-item s/STALL_NUMBER i/ITEM_NUMBER r/ITEM_RATING d/DESCRIPTION
```
**Acceptable values:**
- s/: Positive Integer less than or equal to the size of stall list
- i/: Positive Integer less than or equal to the size of menu
- r/: Integer from 0 to 5
- d/: String

**2.5 Deleting an item review:** delete-item-review

**Command format:** delete-item-review s/STALL_NUMBER i/ITEM_NUMBER

**Ex.:** delete-item-review s/1 i/1

**Expected output (Success):**
```You have deleted the review for the White Chicken Rice at the Chicken Rice Stall at Deck.```

**Expected output (Fail):**
```
re-enter in the format: delete-item-review s/STALL_NUMBER i/ITEM_NUMBER
```

**Acceptable values:**
- s/: Positive Integer less than or equal to the size of stall list
- i/: Positive Integer less than or equal to the size of menu
--------------------------------------------------------------------------------------------------------------------

