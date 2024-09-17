CREATE TABLE AP_Staff(
    Staff_ID int NOT NULL PRIMARY KEY,
    Staff_FirstName VARCHAR(20) NOT NULL,
    Staff_LastName VARCHAR(20) NOT NULL,
    HireDate TIMESTAMP NOT NULL,
    StaffPosition VARCHAR(100) NOT NULL,
    StaffDepartment VARCHAR(100) NOT NULL,
    StaffPhoneNumber VARCHAR(20) NOT NULL,
    SchoolEmail VARCHAR(20) NOT NULL
);