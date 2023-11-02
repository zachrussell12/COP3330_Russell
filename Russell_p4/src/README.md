Project requirements:

- A task list shall contain 0 or more task items
- An task item shall contain a title
- A title shall be 1 or more characters in length
- An task item shall contain a description
- A description shall be 0 or more characters in length
- An task item shall contain a due date
- A due date shall be in the format of YYYY-MM-DD

- A user shall be able to create a new task list
- A user shall be able to load an existing task list

- A user shall be able to view the current task list
- A user shall be able to save the current task list
- A user shall be able to add an item to the current task list
- A user shall be able to edit an item in the current task list
- A user shall be able to remove an item from the current task list
- A user shall be able to mark an item in the current task list as completed
- A user shall be able to unmark an item in the current task list as completed

As part of this application, you must decide how to store your data both internally (int RAM) and externally (on the hard drive).
Your solution must encapsulate item data in a class called TaskItem and list data in a class called TaskList.
Your solution must possess a class called App to handle interaction with the user.
You must have automated unit tests (using JUnit) for all of the behaviors required in a TaskList. You must test both expected successes and expected failures, such as trying to remove or change part of an item that doesn't exist.
