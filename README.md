# College System - Sparse Table Implementation using Linked List (Java)

This project implements a sparse table using a linked list to manage students and course enrollments in a college system. The sparse table represents a two-dimensional matrix where students and courses are stored, but only non-empty entries (enrollments) are maintained using linked lists to optimize memory.

## Project Overview

The objective of this project is to simulate a college system where students can enroll in courses, and both students and courses can be managed efficiently using a sparse table implemented with a linked list in Java. The system supports various operations, such as adding new students, adding new courses, enrolling students in courses, and removing students or courses.

### Features:
1. **Add Students**: Add new students to the system with a unique student ID and name.
2. **Add Courses**: Add new courses to the system by course name.
3. **Enroll Students in Courses**: Link students with courses they are enrolled in.
4. **Delete Students**: Remove a student and their associated enrollments.
5. **Delete Courses**: Remove a course and its related enrollments.
6. **View Student Details**: View all courses a student is enrolled in.
7. **View Course Details**: View all students enrolled in a particular course.

## Sparse Table Representation

The project uses a **sparse table** structure with linked lists:
- Each **student** is represented by a node, and each **course** is represented by a node.
- The linked lists are used to create connections between students and their respective courses, reducing memory usage compared to a full two-dimensional array.
- Students and courses are stored separately, and enrollments are linked by cross-referencing nodes in both lists.

### Data Structures Used:
- **Student Node**: Contains the student ID, student name, and a reference to the list of courses the student is enrolled in.
- **Course Node**: Contains the course name and a reference to the list of students enrolled in the course.

## Project Structure

```bash
├── src/
│   └── assignment1/
│       └── Assignment1.java      # Main class implementing the sparse table using linked list
├── README.md                     # Project README file
