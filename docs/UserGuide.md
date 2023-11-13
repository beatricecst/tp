---
layout: page
title: User Guide
---
## Table of Contents <a id="toc"></a>

---
1. [Introduction](#1-introduction)
2. [About the User Guide](#2-about-the-user-guide)
    - [2.1 Navigating the User Guide](#2.1-navigating-the-user-guide)
    - [2.2 Reading the User Guide](#2.2-reading-the-user-guide)
      * [2.2.1 GUI Terminology](#2.2.1-gui-terminology)
      * [2.2.2 Icons](#2.2.2-icons)
      * [2.2.3 Command Syntax and Usage](#2.2.3-command-syntax-and-usage)
3. [Quick Start](#3-quick-start)
4. [Features](#4-features)
   - 4.1 [General](#4.1-general)
      * 4.1.1 [Viewing help :`help`](#4.1.1-viewing-help)
      * 4.1.2 [Exiting from the application :`exit`](#4.1.2-exiting-from-the-application)
      * 4.1.3 [Clearing the FoodNotes database :`clear`](#4.1.3-clearing-foodnotes)
   - 4.2 [Stall Management](#4.2-stall-management)
      * 4.2.1 [Listing all stalls :`list`](#4.2.1-listing-all-stalls)
      * 4.2.2 [Viewing a stall :`view-stall`](#4.2.2-viewing-a-stall)
      * 4.2.3 [Adding a stall :`add-stall`](#4.2.3-adding-a-stall)
      * 4.2.4 [Deleting a stall :`delete-stall`](#4.2.4-deleting-a-stall)
      * 4.2.5 [Editing a stall :`edit-stall`](#4.2.5-editing-a-stall)
      * 4.2.6 [Reviewing a stall :`review-stall`](#4.2.6-reviewing-a-stall)
      * 4.2.7 [Deleting a stall review :`delete-stall-review`](#4.2.7-deleting-a-stall-review)
   - 4.3 [Stall Sorting](#4.3-stall-sorting)
     * 4.3.1 [Sort stalls by locations :`sort-stalls-locations`](#4.3.1-sort-stalls-by-location)
     * 4.3.2 [Sort stalls by ratings :`sort-stalls-ratings`](#4.3.2-sort-stalls-by-rating)
     * 4.3.3 [Sort stalls by price :`sort-stalls-price`](#4.3.3-sort-stalls-by-price)
   - 4.4 [Stall Finding](#44-stall-finding)
     * 4.4.1 [Find stalls by name :`find-by-stall`](#4.4.1-find-stalls-by-name)
     * 4.4.2 [Find stalls by location :`find-by-location`](#4.4.2-find-stalls-by-location)
     * 4.4.3 [Find stalls by menu items :`find-by-item`](#4.4.3-find-stalls-by-menu-items)
   - 4.5 [Item Management](#45-item-management)
     * 4.5.1 [Viewing an item :`view-item`](#4.5.1-viewing-an-item)
     * 4.5.2 [Adding an item :`add-item`](#4.5.2-adding-an-item)
     * 4.5.3 [Deleting an item :`delete-item`](#4.5.3-deleting-an-item)
     * 4.5.4 [Editing an item :`edit-item`](#4.5.4-editing-an-item)
     * 4.5.5 [Reviewing an item :`review-item`](#4.5.5-reviewing-an-item)
     * 4.5.6 [Deleting an item review :`delete-item-review`](#4.5.6-deleting-an-item-review)
5. [Glossary](#5-glossary)
6. [Command summary](#6-command-summary)
   - 6.1 [General Commands](#61-general-commands-summary)
   - 6.2 [Stall Management Commands](#62-stall-management-summary)
   - 6.3 [Stall Sorting Commands](#63-stall-sorting-summary)
   - 6.4 [Stall Finding Commands](#64-stall-finding-summary)
   - 6.5 [Item Management Commands](#65-item-management-summary)
7. [FAQ](#7-faq)
<div style="page-break-after: always;"></div>

# 1. Introduction <a id="1-introduction"></a>
Welcome to the User Guide of **FoodNotes**!

Ever find yourself forgetting the delightful dishes you savored? Hungry for a way to recall your favorite food experiences? FoodNotes has the solution.

FoodNotes is a quick, simple and beautiful food diary made specifically for you, NUS student foodies. With FoodNotes, you can add stalls that you want to keep track of and manage your reviews for them.

This application is optimised for use via a Command Line Interface (CLI) this means that you operate the application by typing commands into a Command Box. If you are fast at typing, you can manage your food reviews faster than other Graphical User Interface (GUI) applications; GUI applications allow users to interact with the application through graphical icons such as buttons.
FoodNotes is available for the Linux, Unix, Windows and Mac OS operating systems.
<div markdown="block" class="index">

<div style="page-break-after: always;"></div>


# 2. About the user guide <a id="2-about-the-user-guide"></a>
## 2.1 Navigating the user guide <a id="2.1-navigating-the-user-guide"></a>

**If you are a first time user**:

1. the [Quick start](#3-quick-start) section provides instructions for you on how to get started.
2. Once you have set up FoodNotes, you can check out the [Screen layout](#2.2.1-gui-terminology) section to get familiar
with the different components of FoodNotes.
To learn the basics of using FoodNotes, head over to the [Features](#4-features) section.

**If you are an experienced user:**:
you can refer to the [Command summary](#6-command-summary) section for an overview of FoodNotes' commands.

If you have any queries about using FoodNotes, you can check out the [FAQ](#7-faq) section.

## 2.2 Reading the User Guide <a id="2.2-reading-the-user-guide"></a>
Before you jump into the next section, take a moment to familiarise yourself with the technical terms, symbols, and syntax used throughout this document. This subsection contains all the essential information you need to understand the content better.

### 2.2.1 Terminology related to the Graphical User Interface (GUI) <a id="2.2.1-gui-terminology"></a>
The following figure shows the GUI of FoodNotes. It is annotated with the name of the GUI components.

<p align="center">
<img src="images/userGuide/Frame.png" alt="Layout of GUI">
</p>
What the main components of the GUI do:

* _Data Display_: This is where **FoodNotes** displays the information of the page that you are viewing.

* _Result Display_: This is where **FoodNotes** displays guiding messages.

* _Command Box_: This is where you type your commands.

* _Command List_: This is where the list of valid commands is displayed.

### 2.2.2 Icons <a id="2.2.2-icons"></a>

This section will run you through the icons used in this guide.

| Icon                | Meaning                                                          |
|---------------------|------------------------------------------------------------------|
| :information_source: | An information icon indicates that the enclosed text are notes regarding this section. |
| :warning:           | A warning sign indicates that the enclosed text is important, and usually entails details about potential errors. |
|  :bulb:             | A light bulb indicates that the enclosed text is a tip.|

<div style="page-break-after: always;"></div>

### 2.2.3 Command Syntax and Usage <a id="2.2.3-command-syntax-and-usage"></a>
Since FoodNotes is a CLI application, knowing how to use commands is very important. The following subsection will teach you how to read and use commands in FoodNotes. All commands in FoodNotes follow similar formats as described below and examples will be provided to help you understand their usage. Examples of commands and their formats will be written in code-blocks.

The table below explains some important technical terms. An example will be provided to help you visualize these terms.

|**Technical Term** | **Meaning**                                                                                                                |
|---------------------|----------------------------------------------------------------------------------------------------------------------------|
| Command word | The first word of a command. It determines the action that **FoodNotes** should perform.                                   |
| Parameter | The word or group of words following the command word. They are values given to a command to perform the specified action. |
| Prefix | A prefix is a word that precedes a parameter. It is used to identify the **type of parameter** that is being inputted.     |

### 2.2.2 Input parameters <a id="parameters"></a>

This section provides a summary of the parameters used when inputting commands into the application.

| Prefix | Parameter          | Meaning                                    | Input                                     |
|--------|--------------------|--------------------------------------------|-------------------------------------------|
| `n/`   | `STALL_NAME`       | Name of the stall                          | Characters with length of at least 1      |
| `s/`   | `STALL_INDEX`      | Index of the stall in the list             | Integer from 1 to 2147483647 (inclusive)  |
| `l/`   | `STALL_LOCATION`   | Location of the stall                      | Characters with length of at least 1      |
| `n/`   | `ITEM_NAME`        | Name of the item                           | Characters with length of at least 1      |
| `i/`   | `ITEM_INDEX`       | Index of the item in the menu              | Integer from 1 to 2147483647 (inclusive)  |
| `p/`   | `ITEM_PRICE`       | Price of the item                          | Non-negative number with 2 decimal places |
| `r/`   | `STALL_RATING`     | Rating of the stall                        | Integer from 1 to 5 (inclusive)           |
| `r/`   | `ITEM_RATING`      | Rating of the item                         | Integer from 1 to 5 (inclusive)           |
| `d/`   | `DESCRIPTION`      | Descriptive review for the stalls or items | Characters with length of at least 1      |
| N/A    | `NAME_KEYWORD`     | Keyword of the stall name                  | Characters with length of at least 1      |
| N/A    | `LOCATION_KEYWORD` | Keyword of the stall location              | Characters with length of at least 1      |
| N/A    | `ITEM_KEYWORD`     | Keyword of the menu items in the stall     | Characters with length of at least 1      |


--------------------------------------------------------------------------------------------------------------------

## 3. Quick start <a id="3-quick-start"></a>

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `FoodNotes.jar` from [here](https://github.com/AY2324S1-CS2103T-W10-4/tp/releases/download/v1.3.1/FoodNotes.jar).

3. Copy the file to the folder you want to use as the _home folder_ for your FoodNotes.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar foodnotes.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:


   * `add-stall n/Japanese stall l/Deck` : Adds a stall named `Japanese stall` located at `Deck` to the list of stalls.

   * `view-stall s/1` : Shows the 1st stall shown in the current list.

   * `list` : Lists all stalls.

6. Refer to the [Features](#4-features) below for details of each command.

<div markdown="block" class="alert alert-info">

:bulb: **Tip:**<br>

* If double-clicking `FoodNotes.jar` does not work,

    1. Search for "Command Prompt" or "Terminal" on your computer.
    2. Navigate to the location where `FoodNotes.jar` is saved via the terminal. (_Unsure how to navigate?_ You can try running this in your terminal: `cd Downloads`.)
    3. Run the following in the terminal: `java -jar FoodNotes.jar`.


</div>

--------------------------------------------------------------------------------------------------------------------

# 4. Features <a id="4-features"></a>

----

## 4.1 General Features <a id="4.1-general"></a>

The commands in this section allow you to perform operations on the entire system. They include:
- Viewing help
- Exiting from the application
- Clearing the FoodNotes database


### 4.1.1 Viewing help : `help` <a id="4.1.1-viewing-help"></a>

You can use this command to view the online user guide, which contains information about all the instructions in **FoodNotes**.

<div markdown="block" class="alert alert-info">

:information_source: Ensure that you have a stable internet connection and have a web browser on your computer in order to access the user guide.

</div>

**Format:**

`help`

<div markdown="block" class="alert alert-white">

Requesting for help:

1. Type `help` into the *Command Box* and press `Enter` to execute.
2. A new window will appear as shown below. Click on the `Copy URL` button to copy the URL containing the **FoodNotes** user guide.
   ![HelpOutcome](images/userGuide/helpOutcome.png)
3. Open your preferred web browser on your computer and paste the link into the address bar.
4. Press `Enter` to load the website.

Outcome:

1. Your browser will now show the user guide of **FoodNotes**.
2. You can now access information about all commands in **FoodNotes** via the browser.

</div>

### 4.1.2 Exiting from the application: `exit` <a id="4.1.2-exiting-from-the-application"></a>

You can use this command to exit **FoodNotes**.

<div markdown="block" class="alert alert-info">

**:information_source: This command will exit the application immediately. All data is saved automatically and will be reloaded upon restart of the application**

</div>

**Format:**

`exit`

<div markdown="block" class="alert alert-white">

Exiting the application:

Type `exit` into the *Command Box* and press `Enter` to execute.

Outcome:

The **FoodNotes** application window is now closed.

### 4.1.3 Clearing the FoodNotes database: `clear` <a id="4.1.3-clearing-foodnotes"></a>

You can use this command to clear the database in **FoodNotes**.

<div markdown="block" class="alert alert-info">

**:warning: This command will permanently delete all data stored in FoodNotes. You should make a backup of `addressbook.json` if you still want to keep your old data.**

</div>

**Format:**

`clear`

**Example:**

In this example, you want to clear all data stored in **FoodNotes**.

<div markdown="block" class="alert alert-white">

Exiting the application:

Type `clear` into the *Command Box* and press `Enter` to execute.

Outcome:

The **FoodNotes** database is now empty.

----
## 4.2 Stall Management <a id="4.2-stall-management"></a>

These features allow you to manage information about the stalls in **FoodNotes**. You can record and perform the following actions:
- Listing all stalls
- Viewing a stall
- Adding a stall
- Deleting a stall
- Editing a stall
- Reviewing a stall
- Deleting a stall review


-----
### 4.2.1 Listing all stalls : `list` <a id="4.2.1-listing-all-stalls"></a>

You can use this command to view the list of all the stalls in **FoodNotes**.

**Format:**

`list`


<div markdown="block" class="alert alert-white">

Listing all your stalls:
Type `list` into the *Command Box* and press `Enter` to execute.

Outcome:

1. The Result Display will show a success message.
1. You can now see all your stalls in the *List Panel*.
</div>

![ListOutcome](images/userGuide/listOutcome.png)

### 4.2.2 Viewing a stall : `view-stall` <a id="4.2.2-viewing-a-stall"></a>

You can use this command to view details from a specific stall from **FoodNotes**, which includes the menu items and reviews of the stall.

**Format:**

`view-stall s/STALL_INDEX`

**Example:**

You wish to view the details of the first stall in the list.

<div markdown="block" class="alert alert-white">

Viewing a specific stall:

1. Type `view-stall s/1` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The *Result Display* will show a success message.
1. You can now see the details of the specific stall you entered.
</div>

![ListOutcome](images/userGuide/viewStallOutcome.png)

### 4.2.3 Adding a stall : `add-stall` <a id="4.2.3-adding-a-stall"></a>

You can use this command to add a new stall to **FoodNotes**.

**Format:**

`add-stall n/STALL_NAME l/LOCATION`

**Example:**
You just visited the newly opened Subway at Utown and wish to add it to FoodNotes.
<div markdown="block" class="alert alert-white">

Adding a new stall:

1. Type `add-stall n/Subway l/Utown` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The *Result Display* will show a success message.
1. You have now added a new stall with the specified name and location.
</div>

![ListOutcome](images/userGuide/addStallOutcome.png)

<div markdown="block" class="alert alert-info">

:warning: **Take note:**<br>

* If a stall already exist, you are not allowed to add another stall of the same name.


</div>


### 4.2.4 Deleting a stall : `delete-stall` <a id="4.2.4-deleting-a-stall"></a>

The stall no longer exists? You can use this command to delete a stall from **FoodNotes**, making sure that your food diary is always up to date!

**Format:**

`delete-stall s/STALL_INDEX`

**Example:**

<div markdown="block" class="alert alert-white">

Deleting the third stall from the list:

1. Type `delete-stall s/3` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The *Result Display* will show a success message.
1. You have now deleted the third stall from the list, and the list of stalls will be updated.
</div>

![ListOutcome](images/userGuide/deleteStallOutcome.png)

### 4.2.5 Editing a stall : `edit-stall` <a id="4.2.5-editing-a-stall"></a>

You can use this command to edit an existing stall, and update its name, location. If the stall has a review,
you may edit its rating and/or description.

:information_source: You must specify at least one of the optional parameters, and you can only edit ratings and descriptions if the stall already has an existing review.

**Format:**

`edit-stall s/STALL_INDEX [n/STALL_NAME] [l/LOCATION] [r/STALL_RATING] [d/STALL_DESCRIPTION] `

**Example:**

You wish to change the location of the seventh stall in the list, as the stall has relocated from Utown to Frontier.

<div markdown="block" class="alert alert-white">

Editing the seventh stall from the list:

1. Type `edit-stall s/7 l/Frontier` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The *Result Display* will show a success message.
1. You have now edited the seventh stall from the list, and the list of stalls will be updated.
</div>

![ListOutcome](images/userGuide/editStallOutcome.png)

### 4.2.6 Reviewing a stall : `review-stall` <a id="4.2.6-reviewing-a-stall"></a>

You can use this command to review an existing stall, and add your own star rating and even some text descriptions for the stall.

**Format:**

`review-stall s/STALL_INDEX r/STALL_RATING d/STALL_DESCRIPTION`

**Example:**

You revisited the second stall on the list and decided to give it a five star rating.
<div markdown="block" class="alert alert-white">

Reviewing the stall:

1. Type `review-stall s/2 r/5 d/Best chicken rice with generous portion` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The *Result Display* will show a success message.
1. You have now reviewed the specific stall from the list, and the star ratings will be reflected.
</div>

![ListOutcome](images/userGuide/stallReviewOutcome.png)

### 4.2.7 Deleting a stall review: `delete-stall-review` <a id="4.2.7-deleting-a-stall-review"></a>

Change your mind? You can use this command to delete a review of an existing stall.

**Format:**

`delete-stall-review s/STALL_INDEX`

**Example:**

You decide to delete the review for the second stall in the list.
<div markdown="block" class="alert alert-white">

Deleting the stall review:

1. Type `delete-stall-review s/2` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The *Result Display* will show a success message.
1. You have now deleted the review of the specified stall from the list, and the list will be updated.
</div>

---------------------------------------------------------------------------------------------------------------------
## 4.3 Stall Sorting <a id="4.3-stall-sorting"></a>
This feature allows you to sort the stalls by their location, rating and price, so you can now easily find the stalls based on these criterias.


### 4.3.1 Sort stalls by location: `sort-stalls-location` <a id="4.3.1-sort-stalls-by-location"></a>

You can use this command to sort the stalls by their location in alphabetical order.

**Command format:** `sort-stalls-location`

1. Type `sort-stalls-location` in the command box.
2. press `Enter` to execute.

**Outcome:**
1. The `Result Display` will display a success message.
2. You will now see that the stalls are sorted by location in alphabetical order in the `Data Display`, as illustrated
   in the screenshot below.

![ListOutcome](images/userGuide/sort-stalls-location.png)

### 4.3.2 Sort stalls by rating: `sort-stalls-rating` <a id="4.3.2-sort-stalls-by-rating"></a>

You can use this command to sort the stalls by their rating in descending order, so the stall with the highest rating will appear right at the top!

**Command format:** `sort-stalls-rating`

1. Type `sort-stalls-rating` in the command box.
2. press `Enter` to execute.

**Outcome:**
1. The `Result Display` will display a success message.
2. You will now see that the stalls are sorted by rating in descending order in the `Data Display`, as illustrated
   in the screenshot below.

![ListOutcome](images/userGuide/sort-stalls-rating.png)

### 4.3.3 Sort stalls by price: `sort-stalls-price` <a id="4.3.3-sort-stalls-by-price"></a>

You can use this command to sort the stalls by their price in ascending order, and the stall with the cheapest food options will be easily retrieved!

**Command format:** sort-stalls-price

1. Type `sort-stalls-price` in the command box.
2. press `Enter` to execute.

**Outcome:**
1. The `Result Display` will display a success message.
2. You will now see that the stalls are sorted by price in ascending order in the `Data Display`, as illustrated
   in the screenshot below.

![ListOutcome](images/userGuide/sort-stalls-price.png)




--------------------------------------------------------------------------------------------------------------------

## 4.4 Stall Finding <a id="44-stall-finding"></a>
This feature allows you to find stalls by their name, location and menu items. Whichever small detail you can remember, you can easily find that stall.

### 4.4.1 Finding stalls by name: `find-by-name`<a id="4.4.1-find-stalls-by-name"></a>
The command is a powerful tool for quickly locating specific food stalls based on their names. Even if you can only remember part of the stall name, this command can help you narrow down your choices effectively.
You need to type in the entire word instead of part of the word for it to find the stall.

**Command function:** Finds all stalls whose names contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.

**Command format:** `find-by-name NAME_KEYWORD`

**Example:**
You wish to find stalls with the name 'Subway'. You can use the command as follows:
1. Type `find-by-name Subway` in the command box.
2. Press `Enter` to execute.

Outcome:
1. The `Result Display` will display a success message.
2. You will now see the matching stalls in the `Data Display`, as illustrated in the screenshot below.

![ListOutcome](images/userGuide/find-by-name.png)

<div markdown="block" class="alert alert-info">

:bulb: **Tip:**<br>

* You can enter more than one keyword, separated by a space, and all the stalls containing any of the keywords will be listed!

</div>
---
### 4.4.2 Find stalls by location: `find-by-location` <a id="4.4.2-find-stalls-by-location"></a>
The command is a powerful tool for quickly locating specific food stalls based on their locations. If you want to find the nearest food options, this command can help you narrow down your choices effectively.

**Command function:** Finds all stalls whose location contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.

**Command format:** `find-by-location LOCATION_KEYWORD`

**Example:**
You wish to find stalls that are located at the Deck. You can use the command as follows:
1. Type `find-by-location deck` in the command box.
2. Press `Enter` to execute.

Outcome:
1. The `Result Display` will display a success message.
2. You will now see the matching stalls in the `Data Display`, as illustrated in the screenshot below.

![ListOutcome](images/userGuide/find-by-location.png)

<div markdown="block" class="alert alert-info">

:bulb: **Tip:**<br>

* You can enter more than one keyword, separated by a space, and all the stalls containing any of the keywords will be listed!

</div>
---
### 4.4.3 Find stalls by menu items: `find-by-item`<a id="4.4.3-find-stalls-by-menu-items"></a>
The command is a powerful tool for quickly locating specific food stalls based on the items on their menu. If you are craving for a specific dish, this command can help you narrow down your choices effectively.

**Command function:** Finds all stalls whose menu items contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.

**Command format:** `find-by-item ITEM_KEYWORD`

**Example:**
You wish to find stalls that sells chicken rice. You can use the command as follows:
1. Type `find-by-item chicken rice` in the command box.
2. Press `Enter` to execute.

Outcome:
1. The `Result Display` will display a success message.
2. You will now see the matching stalls in the `Data Display`, as illustrated in the screenshot below.
3. When you enter `view-stall s/1`, you will be able to see 'chicken rice' in the list of menu items.

<table>
  <tr>
    <td><img src="images/userGuide/find-by-item.png" alt="find-by-name"></td>
    <td><img src="images/userGuide/view-chicken-rice.png" alt="view-chicken-rice"></td>
  </tr>
</table>


<div markdown="block" class="alert alert-info">

:bulb: **Tip:**<br>

* You can enter more than one keyword, separated by a space, and all the stalls containing any of the keywords will be listed!
</div>
-----
## 4.5 Item Management <a id="45-item-management"></a>
This feature allows you to manage information about the items in **FoodNotes**. You can record and perform the following actions:
- Viewing an item: `view-item`
- Adding an item: `add-item`
- Deleting an item: `delete-item`
- Editing an item: `edit-item`
- Reviewing an item: `review-item`
- Deleting an item review: `delete-item-review`

### 4.5.1 Viewing an item : `view-item` <a id="4.5.1-viewing-an-item"></a>


You can use this command to view details of a specific item from a specific stall in **FoodNotes**,
which includes the price, rating and description of the item.

**Format:**

`view-item s/STALL_INDEX i/ITEM_INDEX`

**Example:**

<div markdown="block" class="alert alert-white">

Viewing the first item from the first stall:

1. Type `view-item s/1 i/1` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The Result Display will show a success message.
1. You can now see the details of the specific item you entered.
</div>

![ListOutcome](images/userGuide/view-item.png)

### 4.5.2 Adding an item : `add-item` <a id="4.5.2-adding-an-item"></a>

Tried a new menu item from the stall? You can use this command to add this new item to FoodNotes.

**Format:**

`add-item s/STALL_INDEX n/ITEM_NAME p/ITEM_PRICE`

**Example:**

<div markdown="block" class="alert alert-white">

You wish to add a new item name 'Pork Chop' with the price of $5.50 to the first stall in the list

1. Type `add-item s/1 n/Pork Chop p/5.50` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The Result Display will show a success message.
1. You have now added a new item with the specified name and price.
</div>

![ListOutcome](images/userGuide/add-item.png)

### 4.5.3 Deleting an item : `delete-item` <a id="4.5.3-deleting-an-item"></a>

You can use this command to delete an item from the database.

**Format:**

`delete-item s/STALL_INDEX i/ITEM_INDEX`

**Example:**

<div markdown="block" class="alert alert-white">

Deleting the third item from the menu:

1. Type `delete-item s/1 i/2` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The Result Display will show a success message.
1. You have now deleted the second menu item of the first stall, and the list of items will be updated.
</div>


### 4.5.4 Editing an item : `edit-item` <a id="4.5.4-editing-an-item"></a>

You can use this command to edit an existing item, and update its name, location, rating and/or description.

:information_source: You must specify at least one of the optional parameters, and you can only edit ratings and descriptions if the item already has an existing review.

**Format:**

`edit-item s/STALL_INDEX i/ITEM_INDEX [n/ITEM_NAME] [p/ITEM_PRICE] [r/ITEM_RATING] [d/ITEM_DESCRIPTION] `

**Example:**

<div markdown="block" class="alert alert-white">

You wish to edit the price of the sixth item in the first stall, as there is a change in price to Pork Chop that you have added previously.

1. Type `edit-item s/1 i/6 p/6.50` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The Result Display will show a success message.
1. You have now edited the sixth menu item of the first stall, and the list of items will be updated.
</div>

![ListOutcome](images/userGuide/editItemOutcome.png)

### 4.5.5 Reviewing an item : `review-item` <a id="4.5.5-reviewing-an-item"></a>

You can use this command to review an existing item, and add your own star rating and text description for your experience at the stall.

**Format:**

`review-item s/STALL_INDEX i/ITEM_INDEX r/ITEM_RATING d/ITEM_DESCRIPTION`

**Example:**

<div markdown="block" class="alert alert-white">

Reviewing the item:

1. Type `review-item s/1 i/1 r/4 d/Very Flavourful` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The Result Display will show a success message.
1. You have now reviewed the first menu item of the first stall, and the star ratings will be reflected.
</div>

![ListOutcome](images/userGuide/reviewItemOutcome.png)

### 4.5.6 Deleting an item review: `delete-item-review` <a id="4.5.6-deleting-an-item-review"></a>

You can use this command to delete a review of an existing item.

**Format:**

`delete-item-review s/STALL_INDEX i/ITEM_INDEX`

**Example:**

<div markdown="block" class="alert alert-white">

Deleting the review:

1. Type `delete-item-review s/1 i/1` into the *Command Box*.
1. Press `Enter` to execute.

Outcome:

1. The Result Display will show a success message.
1. You have now deleted the review of the first menu item of the first stall, and the menu will be updated.
</div>


--------------------------------------------------------------------------------------------------------------------


# 5. Glossary <a id="5-glossary"></a>

| Term              | Explanation                                                                                                                                                                |
|-------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **FoodNotes**     | Can refer to name of the application as a whole or to the app’s storage file.<br>                                                                                          |
| **Stalls**        | Refers to the name of the food stall.<br>                                                                                                                                  |
| **Item**          | Refers to a specific food item. <br>                                                                                                                                       |
| **CLI**           | A Command Line Interface (CLI) is a text-based user interface that allows users to type text commands instructing the program to do specific tasks.                        |
| **GUI**           | A Graphical User Interface (GUI) is a form of user interface that allows users to interact with the program through graphical icons instead of text-based user interfaces. |


--------------------------
# 6. Command summary <a id="6-command-summary"></a>

## 6.1 General Commands <a id="61-general-commands-summary"></a>

| Features  | Format, Examples |
|-----------|------------------|
| **Help**  | `help`           |
| **Exit**  | `exit`           |
| **Clear** | `clear`          |

## 6.2 Stall Management Commands <a id="62-stall-management-summary"></a>

| Features                | Format, Examples                                                                                                                   |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| **List**                | `list` <br> e.g. `list`                                                                                                            |
| **View stall**          | `view-stall s/STALL_INDEX` <br> e.g. `view-stall` s/1                                                                              |
| **Add stall**           | `add-stall n/STALL_NAME l/LOCATION` <br> e.g.`add-stall` n/Japanese Stall l/Deck                                                   |
| **Delete stall**        | `delete-stall s/STALL_INDEX` <br> e.g. `delete-stall` s/1                                                                          |
| **Edit stall**          | `edit-stall s/STALL_INDEX [n/STALL_NAME] [l/LOCATION] [r/STALL_RATING] [d/STALL_DESCRIPTION]` <br> e.g. `edit-stall` s/1 l/Terrace |
| **Review stall**        | `review-stall s/STALL_INDEX r/STALL_RATING d/DESCRIPTION` <br> e.g. `review-stall` s/1 r/5 d/Good food and service                 |                                                                                                                                                             |
| **Delete stall review** | `delete-stall-review s/STALL_INDEX` <br> e.g. `delete-stall-review` s/1                                                            |

## 6.3 Stall Sorting Commands <a id="63-stall-sorting-summary"></a>

| Features                    | Format, Examples                                        |
|-----------------------------|---------------------------------------------------------|
| **Sort stalls by location** | `sort-stalls-location` <br> e.g. `sort-stalls-location` |
| **Sort stalls by rating**   | `sort-stalls-rating` <br> e.g. `sort-stalls-rating`     |
| **Sort stalls by price**    | `sort-stalls-price` <br> e.g. `sort-stalls-price`       |

## 6.4 Stall Finding Commands <a id="64-stall-finding-summary"></a>

| Features                    | Format, Examples                                             |
|-----------------------------|--------------------------------------------------------------|
| **Find stalls by name**     | `find-by-name` <br> e.g. `find-by-name` western japanese     |
| **Find stalls by location** | `find-by-location` <br> e.g. `find-by-location` deck terrace |
| **Find stalls by item**     | `find-by-item` <br> e.g. `find-by-item` chicken              |

## 6.5 Item-Related Commands <a id="65-item-management-summary"></a>

| Features               | Format, Examples                                                                                                                              |
|------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| **View item**          | `view-item s/STALL_INDEX i/ITEM_INDEX` <br> e.g. `view-item` s/1 i/1                                                                          |
| **Add item**           | `add-item s/STALL_INDEX n/ITEM_NAME p/ITEM_PRICE` <br> e.g.`add-item` s/1 n/Chicken Rice l/4.50                                               |
| **Delete item**        | `delete-item s/STALL_INDEX i/ITEM_INDEX` <br> e.g. `delete-item` s/1 i/1                                                                      |
| **Edit item**          | `edit-item s/STALL_INDEX i/ITEM_INDEX [n/ITEM_NAME] [p/ITEM_PRICE] [r/ITEM_RATING] [d/ITEM_DESCRIPTION]` <br> e.g. `edit-item` s/1 i/1 p/5.00 |
| **Review item**        | `review-item s/STALL_INDEX i/ITEM_INDEX r/ITEM_RATING d/ITEM_DESCRIPTION` <br> e.g. `review-item` s/1 i/1 r/5 d/Flavorful                     |                                                                                                                                                             |
| **Delete item review** | `delete-item-review s/STALL_INDEX i/ITEM_INDEX` <br> e.g. `delete-item-review` s/1 i/1                                                        |

--------------------------------------------------------------------------------------------------------------------
# 7. FAQ <a id="7-faq"></a>
