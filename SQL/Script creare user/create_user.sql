CREATE USER ioneanua IDENTIFIED BY ioneanua; -- you should replace my user name with yours. â€œIDENTIFIED BYâ€? means the password.
GRANT CREATE SESSION TO ioneanua; -- necessary for connecting to the database with your new user.
GRANT CREATE ANY INDEX TO ioneanua; -- we use indexes for faster queries.
GRANT ALTER ANY INDEX TO ioneanua;
GRANT DROP ANY INDEX TO ioneanua;
GRANT CREATE ANY PROCEDURE TO ioneanua; -- we will use them in following workshops.
GRANT ALTER ANY PROCEDURE TO ioneanua;
GRANT DROP ANY PROCEDURE TO ioneanua;
GRANT EXECUTE ANY PROCEDURE TO ioneanua;
GRANT CREATE ANY SEQUENCE TO ioneanua; -- we need sequences for inserting data.
GRANT ALTER ANY SEQUENCE TO ioneanua;
GRANT DROP ANY SEQUENCE TO ioneanua;
GRANT SELECT ANY SEQUENCE TO ioneanua;
GRANT CREATE ANY TABLE TO ioneanua;
GRANT ALTER ANY TABLE TO ioneanua;
GRANT DELETE ANY TABLE TO ioneanua;
GRANT DROP ANY TABLE TO ioneanua;
GRANT INSERT ANY TABLE TO ioneanua;
GRANT LOCK ANY TABLE TO ioneanua;
GRANT SELECT ANY TABLE TO ioneanua;
GRANT UPDATE ANY TABLE TO ioneanua;
GRANT CREATE TABLESPACE TO ioneanua;
GRANT ALTER TABLESPACE TO ioneanua;
GRANT DROP TABLESPACE TO ioneanua;
GRANT CREATE ANY VIEW TO ioneanua;
GRANT DROP ANY VIEW TO ioneanua;
GRANT UNDER ANY VIEW TO ioneanua;
alter user ioneanua quota 50m on system;
