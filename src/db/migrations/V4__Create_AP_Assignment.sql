CREATE TABLE AP_Assignment(
    Assignment_ID int NOT NULL PRIMARY KEY,
    DateAssigned TIMESTAMP NOT NULL,
    Student_ID int NOT NULL,
    Room_ID int NOT NULL,
    Staff_ID int NOT NULL,
    FOREIGN KEY (Student_ID) REFERENCES AP_Student(Student_ID),
    FOREIGN KEY (Room_ID) REFERENCES AP_Room(Room_ID),
    FOREIGN KEY (Staff_ID) REFERENCES AP_Staff(Staff_ID)  
);