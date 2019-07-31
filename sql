./mysql -u root -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 8
Server version: 8.0.12 MySQL Community Server - GPL

Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> mysql --version
    -> 
    -> 
    -> 
    -> SHOW DATABASES
    -> SHOW DATABASE
    -> :q
    -> 
    -> ^C
mysql> SHOW DATABASES
    -> ;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.00 sec)

mysql> CREATE DATABASE hotels;
Query OK, 1 row affected (0.07 sec)

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| hotels             |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

mysql> USE DATABASE hotels;
ERROR 1049 (42000): Unknown database 'database'
mysql> USE hotels;
Database changed
mysql> CREATE TABLE hotel(
    -> id int primary key, 
    -> name varchar(255),
    -> city varchar(90)
    -> );
Query OK, 0 rows affected (0.11 sec)

mysql> SHOW TABLES;
+------------------+
| Tables_in_hotels |
+------------------+
| hotel            |
+------------------+
1 row in set (0.00 sec)

mysql> ALTER TABLE `hotel` CHANGE `id` `id` int not null AUTO_INCREEMENT PRIMARY KEY;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'AUTO_INCREEMENT PRIMARY KEY' at line 1
mysql> ALTER TABLE hotel CHANGE id id int not null AUTO_INCREEMENT PRIMARY KEY;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'AUTO_INCREEMENT PRIMARY KEY' at line 1
mysql> ALTER TABLE hotel CHANGE id id int not null AUTO_INCREMENT PRIMARY KEY;
ERROR 1068 (42000): Multiple primary key defined
mysql> ALTER TABLE hotel CHANGE id id int not null AUTO_INCREMENT;
Query OK, 0 rows affected (0.05 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> DESC hotel;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| id    | int(11)      | NO   | PRI | NULL    | auto_increment |
| name  | varchar(255) | YES  |     | NULL    |                |
| city  | varchar(90)  | YES  |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

mysql> clear
mysql> INSERT INTO hotel(`name`,`city`) VALUES ("Grand Paradise","Bangalore");
Query OK, 1 row affected (0.06 sec)

mysql> INSERT INTO hotel(`name`,`city`) VALUES ("Leela Palace","Bangalore");
Query OK, 1 row affected (0.08 sec)

mysql> INSERT INTO hotel(`name`,`city`) VALUES ("Aloft","Bangalore");
Query OK, 1 row affected (0.07 sec)

mysql> INSERT INTO hotel(`name`,`city`) VALUES ("Orange County","Ooty");
Query OK, 1 row affected (0.07 sec)

mysql> INSERT INTO hotel(`name`,`city`) VALUES ("Hotel Landmark","Kanpur");
Query OK, 1 row affected (0.10 sec)

mysql> Select * from hotel;
+----+----------------+-----------+
| id | name           | city      |
+----+----------------+-----------+
|  1 | Grand Paradise | Bangalore |
|  2 | Leela Palace   | Bangalore |
|  3 | Aloft          | Bangalore |
|  4 | Orange County  | Ooty      |
|  5 | Hotel Landmark | Kanpur    |
+----+----------------+-----------+
5 rows in set (0.00 sec)

mysql> 
