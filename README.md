# noir-auth-example

An example for the noir-auth library.

## Running

To start a web server for the application, run:

    lein ring server

## Routes    

First you have to log into the system. Navigate to "localhost:3000/html/login.html".
Enter user "dim" and password "dim". You will see the message "authenticated".

Check the user on the URL "localhost:3000/current-user".

There are three authrorized routes:

* localhost:3000/user -- allowed only for the role "user".
* localhost:3000/root -- allowed only for the role "root".
* localhost:3000/admin -- allowed only for the role "admin".

The user "dim" is has the "root" role which derives from the "user". Thats why first two routes are available for the user. But the third one is restricted.

The last route -- "localhost:3000/logout" logs the user out of the system.


## License

Copyright © 2013 by Dmitry Bushenko
