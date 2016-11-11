# onlinepass
Password storage based on spring mvc / bootstrap

1. How to start app ?

1.1
    Copy file from repo/files/config.properties to user.home/.onlinepass/config.properties.

    Create keepass2 database file and place it in place when java app would have access.
    Preferable path is user.home/.onlinepass/keepass.kdbx.

    (Optional) If you didn't change default path for kdbx file then change value for the key keepass.file.location to path
    which is pointing to your file.

    Change value for keepass.password to your password to open your kdbx file.

1.2
    Copy file from repo/files/user.properties to user.home/.onlinepass/config.properties.

    Add users accounts in format user=password. By default there is created one account with login/password credentials.
    This default account can be deleted.

1.3
    You may need update/install Unlimited Strength JCE (Java Cryptography Extension). It was not needed for my on Windows,
    but on Mac I've needed to do that :(. There is a link with help for OSX:
    http://stackoverflow.com/questions/37741142/how-to-install-unlimited-strength-jce-for-java-8-in-os-x


