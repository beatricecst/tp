## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### add-item/delete-item feature

#### Implementation:

The add-item/delete-item mechanism is facilitated by `ModelManager`. It extends `Model`, stored internally as an `UniqueItemLis`. 

These operations are exposed in the `Model` interface as `Model#addItem()` and `Model#deleteItem()` respectively with the addition of getters and setters.

The following sequence diagram shows how the add-item operation works:

![AddItemSequenceDiagram](images/AddItemSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `AddItemCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `delete-item` command does the opposite — it calls `Model#deleteItem()`, which deletes the specified item from its specified stall.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `stallIndex` or `itemIndex` is at index out of range of `filteredStallList.size() - 1` or , then there are no stalls to delete the item from. The `redo` command uses `Model#canRedoFoodNotes()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.
</div>

The following activity diagram summarizes what happens when a user executes a new command:

<img src="images/AddItemActivityDiagram.png" width="250" />

#### Design considerations:

**Aspect: Number of fields needed to be entered by the user:**

* **Alternative 1 (current choice): Only require them to enter the stall they belong to and the name of the item** 
    * Pros: Users are not restricted to only adding items when they have a review.
    * Cons: Causes some fields to be null when initialised (e.g. `rating` and `review`) and more code is needed to implement.

* **Alternative 2: Require all fields required to be present when adding an item:**
    * Pros: Less code is needed to implement.
    * Cons: Users are restricted to only adding items when they have a review.

_{more aspects and alternatives to be added}_
