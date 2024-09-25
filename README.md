# Spring Security with H2 Database
1. Add User entity to store user details
2. Add Repository interface
3. Add **CustomUserDetails** which will use our custom User object
    This will be used to extract uname, password, roles, and other properties based on user object.
    Spring will use this internally since we customized this now spring will use our User
4. Add **CustomUserDetailsService** which will use our CustomUserDetails to load the user
    Spring will use this service to get the user details based on name loadByName since we cusomized it to use our repository now data will be 
    populated from our db
5. Configure SpringSecurityConfig to have custom config for security
6. Create User service and controller for saving users
7. Insert some initial users for log in(Encode the password using password encoder)
8. Enable swagger access through http://localhost:8080/swagger-ui/index.html
9. Configure authority in config class and check for 403 error

Note: We are not externally telling it to call our services we are configuring it when spring search for
implementation it will find our implementation and use ours
CustomUserDetailsService(load user from db and return CustomUserDetails with the user)
CustomUserDetails(populate data based on user set before)
