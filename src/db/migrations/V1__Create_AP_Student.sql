CREATE TABLE AP_Student(
    Student_ID int NOT NULL PRIMARY KEY,
    Student_FirstName VARCHAR(20) NOT NULL,
    Student_LastName VARCHAR(20) NOT NULL,
    DateOfBirth TIMESTAMP NOT NULL,
    SchoolEmail VARCHAR(20) NOT NULL,
    PhoneNumber VARCHAR(20) NOT NULL
);