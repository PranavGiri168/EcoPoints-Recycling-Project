# EcoPoints Recycling Program

A console-based Java application developed to track household recycling activities and reward eco points based on recycled materials. This project helps simulate a city recycling system where households earn points for contributing to environmental sustainability.

## Project Overview

The EcoPoints Recycling Program allows households to register, log recycling activities, calculate eco points, and generate community recycling reports.

Each recycling event records:

* Material type
* Weight in kilograms
* Date of recycling
* Eco points earned

The system awards **10 eco points per kilogram** of recycled material.

## Features

* Register new households
* Store household information using unique IDs
* Log recycling events
* Calculate eco points automatically
* Track total recycled weight per household
* View all registered households
* View all recycling events for a household
* View total eco points earned by a household
* Generate community recycling reports
* Save data into files for persistence
* Handle invalid inputs and duplicate household IDs

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Encapsulation
* Method Overriding
* ArrayList
* HashMap
* File Handling
* Exception Handling
* Java Date & Time API

## Project Structure

```text
EcoPointsProject/
│── Household.java
│── RecyclingEvent.java
│── EcoPointsSystem.java
│── households.txt
│── recycling_logs.txt
```

## Class Details

### Household.java

Stores household information:

* Unique ID
* Name
* Address
* Join Date
* Total Eco Points
* Recycling Event List

Methods:

* Add recycling event
* Calculate total recycled weight
* Get household details

---

### RecyclingEvent.java

Stores recycling activity details:

* Material type
* Weight
* Recycling date
* Eco points earned

Methods:

* Get recycling event details

---

### EcoPointsSystem.java

Main application logic:

* Register households
* Log recycling events
* Display household records
* Generate reports
* Save data into files

## Menu Options

```text
1. Register Household
2. Log Recycling Event
3. View All Households
4. View Household Events
5. View Household Summary
6. Generate Reports
7. Save Data
8. Exit
```

## How to Run

### Compile

```bash
javac Household.java RecyclingEvent.java EcoPointsSystem.java
```

### Run

```bash
java EcoPointsSystem
```

## Sample Output

```text
===== EcoPoints Recycling Program =====
1. Register Household
2. Log Recycling Event
3. View All Households
4. View Household Events
5. View Household Summary
6. Generate Reports
7. Save Data
8. Exit
```

## Reports Generated

The system provides:

* Household with highest eco points
* Total community recycling weight
* Household total recycling weight
* Household total eco points

## Learning Outcomes

This project demonstrates practical implementation of:

* Java fundamentals
* OOP principles
* Encapsulation
* Arrays, ArrayList, and HashMap
* Exception handling
* File input/output
* Loops and conditionals
* Real-world data tracking systems

## Author

**Pranav Giri**
Software Engineer | Java Full Stack Developer | AI/ML Enthusiast
