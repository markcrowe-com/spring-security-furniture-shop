
# Java Spring framework Security Products Sample Test

A Furniture Shop web application written in Java using the Spring framework to demonstrate implementing user security.

## Overview

Given the following scenario, develop a Java Spring framework application that meets the requirements outlined below. For a Furniture Shop:

1. A Product class. This class models products which underpin this assignment.
2. A ProductService class. This class maintains a List of Product objects providing methods to retrieve the list of products, insert a product into the list and finally a method to delete a product object from the list.
3. A view template (products.html) for displaying all product objects in an HTML table.
4. A view template (product-insert.html) for inserting a product to the list (via the ProductService class)
5. An internationalisation (i18n) (messages.properties) file for the application.

See [snippets.md](snippets.md) for code snippets to start the project.

Using the snippets outlined above develop the following functionality:

1. Display all product objects in an HTML table.
2. Allow the user to insert a product object into the list managed by the ProductService class.
3. Allow the user to select a product object and then delete it from the list managed by the ProductService class.
4. Create three user accounts with the following passwords, roles and privileges:

### Users and Roles

| User Name | Password | Role        | Authorized to access                                           |
|-----------|----------|-------------|----------------------------------------------------------------|
| ann       | pass     | User        | Display all Products                                           |
| bob       | pass     | Admin       | Display all Products<br/>Delete a product                      |
| tom       | pass     | SuperAdmin  | Display all Products<br/>Delete a product<br/>Insert a product |


### Guests

Unauthenticated users (guests) can also view the Display All Products. For example:

Hi Guest, Please <a>Login</a>

Products

| Code  | Name                     | Description          | Buy Price | Sell Price | Qty |
|-------|--------------------------|----------------------|----------:|-----------:|----:|
| XG809 | Contemporary Office Desk | Concentrating on ... |    $25.00 |     €69.00 |  18 |
| BG565 | Bed Frame With Storage   | With the comfort...  |   $139.00 |    €175.00 |   5 |
| ...   | ...                      | ...                  |       ... |        ... | ... |

Note, the message displayed at the top of the page ("Hi Guest") and the provision of a link to login. Clicking on this link should lead to the login form being displayed.

### Users

When a "User" authenticates themselves (and requests the view all products page) they are presented with the following:

Hi Ann, <a>Logout</a>

Products

| Code  | Name                     | Description          | Buy Price | Sell Price | Qty |
|-------|--------------------------|----------------------|----------:|-----------:|----:|
| XG809 | Contemporary Office Desk | Concentrating on ... |    $25.00 |     €69.00 |  18 |
| BG565 | Bed Frame With Storage   | With the comfort...  |   $139.00 |    €175.00 |   5 |
| ...   | ...                      | ...                  |       ... |        ... | ... |

As "Ann" is a User, she has no actions (i.e. delete/insert) available to her.

### Admins

When an "Admin" authenticates themselves (and requests the view all products page) they are presented with the following:

Hi bob, <a>Logout</a>

Products

| Code  | Name                     | Description          | Buy Price | Sell Price | Qty |                |
|-------|--------------------------|----------------------|----------:|-----------:|----:|----------------|
| XG809 | Contemporary Office Desk | Concentrating on ... |    $25.00 |     €69.00 |  18 | <a>delete</a>  |
| BG565 | Bed Frame With Storage   | With the comfort...  |   $139.00 |    €175.00 |   5 | <a>delete</a>  |
| ...   | ...                      | ...                  |       ... |        ... | ... |                |

As "bob" is an Admin, the only option available to him is to delete a product.

### SuperAdmins

When a "SuperAdmin" authenticates themselves (and requests the view all products page) they are presented with the following:

Hi tom, <a>Logout</a>

Products

<a>Insert Product</a>

| Code  | Name                     | Description          | Buy Price | Sell Price | Qty |                |
|-------|--------------------------|----------------------|----------:|-----------:|----:|----------------|
| XG809 | Contemporary Office Desk | Concentrating on ... |    $25.00 |     €69.00 |  18 | <a>delete</a>  |
| BG565 | Bed Frame With Storage   | With the comfort...  |   $139.00 |    €175.00 |   5 | <a>delete</a>  |
| ...   | ...                      | ...                  |       ... |        ... | ... |                |

As "tom" is a SuperAdmin, options to "Delete" and "Insert" are provided.

### All Users

When a "SuperAdmin", "Admin" or "User" authenticates themselves note the following:

- The authenticated username is displayed.
- An option to Logout is provided. If the logout link is clicked, the user should be "logged out" and the login form displayed.
- The buy and sell price are formatted as currency values.
- The buy is the currency of the locale of the user (e.g. € for Ireland, $ for the US, £ for the UK, etc.)
- The sell price is always in Euros.

### Security Actions 

If an authenticated user (or a guest) attempts to access a feature that they do not have authorization for, an error message (403: Access Denied) should be displayed and/or redirected to the login page. For example, when "Ann" attempts to access the "add a product" feature she should be restricted by teh application.


Any other errors that occur should lead to the displaying of suitable error pages/messages. Your application should not crash.

After a product has been inserted/deleted the display all products page should be displayed immediately.
You must ensure that double posting is prevented across your solution.
Finally, any unsuccessful login attempts should result in the login form being redisplayed along with a suitable error message (i.e. "Your login attempt was not successful, try again" etc).

### Marks

Indicative marks for this assignment are as follows:

| Task                         |   Marks |
|------------------------------|--------:|
| Display all products         |      12 |
| Delete a product             |       8 |
| Insert a product             |       8 |
| Authentication/Authorization |      60 |
| Exception Handling           |      12 |
| &nbsp;                       | **100** |
