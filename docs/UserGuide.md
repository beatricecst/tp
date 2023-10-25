---
layout: page
title: User Guide
---
## Table of Contents <a id="toc"></a>

---
1. [Introduction](#1-introduction)
    - [1.1. Purpose](#11-purpose)
2. [About the User Guide](#2-about-the-user-guide)
    - [2.1. Navigating the User Guide](#21-navigating-the-user-guide)
    - [2.2. Reading the User Guide](#22-reading-the-user-guide)
        * [2.2.1. Icons](#icons)
        * [2.2.2. Parameters](#parameters)
3. [Quick Start](#3-quick-start)
4. [Features](#4-features)
    - 4.1 [General](#41-general)
    - 4.2 [Stalls](#42-stalls)
    - 4.3 [Items](#43-items)
5. [Glossary](#5-glossary)
6. [Command summary](#6-glossary)
    - 6.1 [Stall Commands](#61-stall-commands)
    - 6.2 [Item Commands](#62-item-commands)
    - 6.3 [General Commands](#63-general-commands)

<div style="page-break-after: always;"></div>

# 1. Introduction <a id="1-introduction"></a>
Welcome to the User Guide of **FoodNotes**!

Ever find yourself forgetting the delightful dishes you savored? Hungry for a way to recall your favorite food experiences? FoodNotes has the solution.



## **1.1 Purpose** <a id="11-purpose"></a>

FoodNotes is a desktop app made for foodies like you to **manage food reviews**, optimized for use via a **Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, foodnotes can get your food review tasks done faster than traditional GUI apps.

FoodNotes is available for the Linux, Unix, Windows and Mac OS operating systems.
<div markdown="block" class="index">

<div style="page-break-after: always;"></div>


# 2. About the user guide <a id="2-about-the-user-guide"></a>
## 2.1 Navigating the user guide <a id="21-navigating-the-user-guide"></a>

* If you are a **new user**, the [Quick start](#quick-start) section provides instructions for you on how to get started.

* Once you have set up FoodNotes, you can check out the [Screen layout](#screen-layout) section to get familiar with the different components of FoodNotes. To learn the basics of using FoodNotes, head over to the [Features](#features) section.

* If you are an **experienced user**, you can refer to the [Command summary](#command-summary) section for an overview of FoodNotes' commands.

* If you have any queries about using FoodNotes, you can check out the [FAQ](#faq) section.

## 2.2 Reading the User Guide <a id="22-reading-the-user-guide"></a>

### 2.2.1 Icons <a id="icons"></a>

This section will run you through the icons used in this guide.

| Icon           | Meaning                                                          |
|----------------|------------------------------------------------------------------|
| :bulb:         | Extra information that you may find useful.                      |
| :exclamation:  | Information you should be aware of to avoid running into errors. |
| :fast_forward: | Information about future updates to a feature.                   |

<div style="page-break-after: always;"></div>

### 2.2.2 Input parameters <a id="parameters"></a>

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

## 3. Quick start (To be updated) <a id="3-quick-start"></a>

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
</div>

--------------------------------------------------------------------------------------------------------------------

# 4. Features <a id="4-features"></a>

----
## 4.1 General Features <a id="41-general"></a>

-----
### 4.1.1 View all stalls
**Command function:** list

**Command format:** `list`

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
---
### 4.1.2 Find stall
**Command function:** Find stalls by name

**Command format:** `find-stall <KEYWORD>`

**Ex.:** `find-stall japan`

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
---
### 4.1.3 Find item

**Command function:** Find stalls by item

**Command format:** `find-item <KEYWORD>`

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
## 4.2 Stall Features <a id="42-stalls"></a>

----
### 4.2.1 Add Stall
**Command function:** Adding a stall

**Command format:** `add-stall n/<STALL_NAME>  l/<LOCATION>`

**Ex.:** `add-stall n/Japanese stall l/Deck`

**Expected Output (Success):**
```
Yay! Japanese stall at Deck is successfully added to list of stalls.
```
**Expected Output (Fail):**
```
re-enter in the format : add-stall n/STALL_NAME  l/LOCATION
```
---
### 4.2.2 View Stall
**Command function: Viewing a stall

**Command format:** `view-stall s/<STALL_NUMBER>`

**Ex.:** `view-stall s/1`

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
re-enter in the format : view-stall s/STALL_NUMBER
```
---
### 4.2.3 Delete Stall
**Command function:** Deleting a stall

**Command format:** `delete-stall s/<STALL_NUMBER>`

**Ex.:** `delete-stall s/1`

**Expected output (Success):**
```
Japanese Stall ★★★★☆ has been deleted.
```

**Expected output (Fail):**

```
re-enter in the format : delete-stall s/STALL_NUMBER
```
---
### 4.2.4 Review Stall
**Command function:** Reviewing a stall

**Command format:** `review-stall s/<STALL_NUMBER> r/<STALL_RATING> d/<DESCRIPTION>`

**Ex.:** `review-stall s/1 r/5 d/the auntie very chio`

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
## 4.3 Item Features <a id="43-items"></a>

----
### 4.3.1 View all items
**Command function:** Adding an item to a stall

**Command format:** `add-item s/<STALL_NUMBER> i/<ITEM>`

**Ex.:** `add-item s/1 i/Chicken Rice`

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
---
### 4.3.2 View all items
**Command function:** Viewing an item from a stall

**Command format:** `view-item s/<STALL_NUMBER> i/<ITEM_NUMBER>`

**Ex.:** `view-item s/1 i/1`

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
---
### 4.3.3 Delete an item from a stall
**Command function:** Deleting an item from a stall

**Command format:** `delete-item s/<STALL_NUMBER> i/<ITEM_NUMBER>`

**Ex.:** `delete-item s/1 i/1`

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

---
### 4.3.4 Rate an item from a stall
**Command function:** Reviewing an item

**Command format:** `review-item s/<STALL_NUMBER> i/<ITEM_NUMBER> r/<ITEM_RATING> d/<DESCRIPTION>`

**Ex.:** `review-item s/1 i/1 r/5 d/Tasty chicken rice with a good amount of meat and rice. The chilli is also very good.`

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
---
### 4.3.5 Delete an item review
**Command function:** Deleting an item review

**Command format:** `delete-item-review s/<STALL_NUMBER> i/<ITEM_NUMBER>`

**Ex.:** `delete-item-review s/1 i/1`

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


# 5. Glossary <a id="5-glossary"></a>

| Term              | Explanation                                                                                                                                             |
|-------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **FoodNotes**     | Can refer to name of the application as a whole or to the app’s storage file.<br>                                                                       |
| **Stalls**        | Refers to the name of the food stall.<br>                                                                                                               |
| **Item**          | Refers to a specific food item. <br>                                                                                                                    |
| **CLI**           | A Command Line Interface (CLI) is a text-based user interface that allows users to type text commands instructing the program to do specific tasks.     |
| **GUI**           | A Graphical User Interface (GUI) is a form of user interface that allows users to interact with the program through graphical icons instead of text-based user interfaces. |
| **Absolute Path** | The complete details needed to locate a file or folder, starting from the root element.                                                                 |

--------------------------
# 6. Command summary <a id="6-command-summary"></a>

## 6.1 Stall-Related Commands <a id="61-stall-commands"></a>

| Features                 | Format, Examples                                                                                                                                                     |
|--------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add stall**            | `add-stall n/<STALL_NAME> l/<LOCATION>` <br> e.g.`add-stall` n/Japanese Stall l/Deck                                                                                 |
| **View stall**           | `view-stall s/<STALL_NUMBER>` <br> e.g. `view-stall` s/1                                                                                                             |
| **Delete stall**         | `delete-stall s/<STALL_NUMBER>` <br> e.g. `delete-stall` s/1                                                                                                         |
| **Review stall**         | `review-stall s/<STALL_NUMBER> r/<STALL_RATING> d/<DESCRIPTION>` <br> e.g. review-stall s/1 r/5 d/the auntie very chio                                               |                                                                                                                                                             |

## 6.2 Item-Related Commands <a id="62-item-commands"></a>

| Features                                  | Format, Examples                                                                                                         |
|-------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| **Add item**                              | `add-item s/<STALL_NUMBER> i/<ITEM>`<br> e.g. `add-item` add-item s/1 i/ChickenRice                                      |
|
| **View item**                             | `view-item s/<STALL_NUMBER> i/<ITEM_NUMBER>`<br> e.g. `view-item` s/1 i/1                                                |
|
|
| **Delete item**                           | `delete-item s/<STALL_NUMBER> i/<ITEM_NUMBER>`<br> e.g. `delete-item` s/1 i/1                                            |
| **Rate item**                             | `rate-item s/STALL_NUMBER i/ITEM_NUMBER r/ITEM_RATING d/DESCRIPTION` <br> e.g. `rate-item` s/1 i/1 r/5 d/th chicken good |
|

## 6.3 General Commands <a id="63-general-commands"></a>

| Features | Format, Examples |
|----------|------------------|
| **Help** | `help`           |
| **Exit** | `exit`           |
| **list** | `list`           |

