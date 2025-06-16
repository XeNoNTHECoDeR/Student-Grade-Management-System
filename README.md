# Student Grade Management System

A beginner-level Java Swing application to manage student academic records, calculate grades, and store data in MySQL using JDBC.

## Features
- GUI-based student data entry
- Grade calculation logic
- Save and fetch from MySQL
- Built using Java Swing, OOP, JDBC

## How to Run
1. Set up MySQL DB:
```sql
CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    marks INT,
    grade VARCHAR(2)
);
