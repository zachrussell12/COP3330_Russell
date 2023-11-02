Project Requirements:

- A user shall be able to create either a task list or a contact list

- A task list shall contain 1 or more task items
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

- A contact list shall contain 1 or more contact items

- A contact item shall contain a first name
- A contact item shall contain a last name
- A contact item shall contain a phone number
- A contact item shall contain an email address
- A contact item shall contain at least one of [first name], [last name], [phone number], or [email address]

- A user shall be able to create a new contact list
- A user shall be able to load an existing contact list
- A user shall be able to view the current contact list
- A user shall be able to save the current contact list
- A user shall be able to add a contact to the current contact list
- A user shall be able to edit a contact in the current contact list
- A user shall be able to remove a contact from the current contact list
 

As part of this application, you must decide how to store your data both internally (in RAM) and externally (on the hard drive).
Your solution must contain (at a minimum) the following classes: ContactApp, ContactItem, ContactList, TaskApp, TaskList, TaskItem, ContactItemTest, ContactListTest, TaskItemTest, and TaskListTest.
Files ending with "Test" must contain JUnit tests for the corresponding public classes. You must test both expected successes and expected failures, such as trying to remove or change part of an item that doesn't exist.
