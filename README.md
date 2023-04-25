# Diffie Helmen Password Store
For my Programming Design and Construction Course at AUT (Auckland University of Technology) I created a simple Diffie Helmen Password Storage Program.
This application follows the MVC architecture Structure. I currently am not working on improving or continue working on this project

**IMPORTANT: This is in by no means secure, or an actual functionable password storage tool.
The diffie helmen key exchange formula is used for the user login method and for storing the user's master pin number. The master pin number is used as the user's secret key, while the program uses a random number to generate its own secret key for the exchange. The public key is then stored in a derby database. Passwords associated with user accounts are kept in plaintext, and the only encryption part of this program is the login functionality. Please do not use this as a password storage replacement.**
Passwords associated with user accounts are kept in plaintext, the only encryption part of this program is the login functionality. Please do not use this as a password storage replacement.

# Features
- Users can Log in and Out
- Users can create accounts
- When intializing the application, users create an admin account that has functionality to delete users
- Users can create and delete passwords with the parameters ID, email or username and passwords
- Passwords and user secret keys are all stored using a derby database

# User Interface
The application provides a simple GUI for users to interact with

# Future Improvements
- Implementing proper encyrption for Password Storage
- Implementing additional security measures such as hashing and salting

