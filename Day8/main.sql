
CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(100),
    genre VARCHAR(50),
    available BOOLEAN DEFAULT TRUE
);


CREATE TABLE members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    membership_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE issues (
    issue_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    member_id INT,
    issue_date DATE DEFAULT CURRENT_DATE,
    return_date DATE,

    FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE CASCADE
);


INSERT INTO books (title, author, genre) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction'),
('1984', 'George Orwell', 'Dystopian'),
('To Kill a Mockingbird', 'Harper Lee', 'Classic'),
('The Alchemist', 'Paulo Coelho', 'Philosophy'),
('Harry Potter and the Sorcerer''s Stone', 'J.K. Rowling', 'Fantasy');


INSERT INTO members (name, email) VALUES
('Alice', 'alice@example.com'),
('brindha', 'brindha@example.com'),
('Charu', 'charue@example.com'),
('ISHU', 'ishu@example.com'),
('DARANI', 'darani@example.com');


INSERT INTO issues (book_id, member_id, issue_date, return_date) VALUES
(1, 2, '2025-06-01', '2025-06-10'),
(3, 1, '2025-06-15', NULL),
(5, 3, '2025-06-20', NULL);
