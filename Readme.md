### BUILD PROJECT WITH THIS COMMAND
mvn clean install

### Requires

+ Database: MySQL

### Main Features
+ Provide client-side API like [CRUD] API for News, User, Comment, Role, Category
+ Authentication and authorization.
+ Hash password with Bcrypt
+ Use JWT for authentication and authorization.


### Example

#### Account

+ [GET]: /admin/api/users: get all account but only "ROLE_ADMIN" has permission.
+ [POST]: /api/user: register new account. Everyone has access.
+ [PUT]:  /api/user: update info of account.Only "ROLE_USER" has permission.
+ [DELETE]: /admin/api/delete: soft-delete. Delete account. Only "ROLE_ADMIN" has permission.
