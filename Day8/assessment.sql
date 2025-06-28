CREATE TABLE departments (
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(100) NOT NULL,
    location VARCHAR(100)
);


CREATE TABLE employees (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    salary DECIMAL(10, 2),
    dept_id INT,
    
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id) ON DELETE SET NULL
);


INSERT INTO employees (name, email, salary, dept_id) VALUES
('Anitha', 'anitha@example.com', 32000.00, 1),
('Bhuvana', 'bhuvana@example.com', 34000.00, 2),
('Chitra', 'chitra@example.com', 36000.00, 3),
('Deepa', 'deepa@example.com', 39000.00, 2),
('Eshwari', 'eshwari@example.com', 35000.00, 1);


INSERT INTO employees (name, email, salary, dept_id) VALUES
('Anitha', 'anitha@example.com', 32000.00, 1),
('Bhuvana', 'bhuvana@example.com', 34000.00, 2),
('Chitra', 'chitra@example.com', 36000.00, 3),
('Deepa', 'deepa@example.com', 39000.00, 2),
('Eshwari', 'eshwari@example.com', 35000.00, 1);
