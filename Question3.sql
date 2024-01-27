/*
1. Write SQL query to create the above tables
*/
CREATE TABLE DEPARTMENT (
    ID INT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Location VARCHAR(255) NOT NULL
);

CREATE TABLE EMPLOYEE (
    ID INT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Department INT,
    Manager INT,
    Salary DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (Department) REFERENCES DEPARTMENT(ID),
    FOREIGN KEY (Manager) REFERENCES EMPLOYEE(ID)
);

/*
2. Add the keys and indexes for the above table
*/
CREATE INDEX idx_department ON EMPLOYEE(Department);

/*
3. Write SQL query to insert the data given
*/
-- Insert data into DEPARTMENT table
INSERT INTO DEPARTMENT (ID, Name, Location)
VALUES
    (1, 'HR', 'Building A'),
    (2, 'Finance', 'Building B'),
    (3, 'IT', 'Building C');

-- Insert data into EMPLOYEE table
INSERT INTO EMPLOYEE (ID, Name, Department, Manager, Salary)
VALUES
    (101, 'John', 1, NULL, 60000),
    (102, 'Alice', 1, 101, 55000),
    (103, 'Bob', 2, 102, 70000),
    (104, 'Charlie', 2, 102, 75000),
    (105, 'David', 3, 101, 80000);

/*
4. Write SQL query to list department wise employee count at each location
*/
SELECT
    D.Name AS Department,
    D.Location,
    COUNT(E.ID) AS EmployeeCount
FROM
    DEPARTMENT D
LEFT JOIN
    EMPLOYEE E ON D.ID = E.Department
GROUP BY
    D.ID, D.Name, D.Location;

/*
5. Write SQL query to calculate and list the average salary of employees under each manager
*/
SELECT
    M.Name AS Manager,
    AVG(E.Salary) AS AverageSalary
FROM
    EMPLOYEE E
JOIN
    EMPLOYEE M ON E.Manager = M.ID
GROUP BY
    M.ID, M.Name;
    