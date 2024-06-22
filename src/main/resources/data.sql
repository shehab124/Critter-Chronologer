-- Insert data into customer table
INSERT INTO customer (name, notes, phone_number) VALUES
('John Doe', 'Regular customer', '555-1234'),
('Jane Smith', 'Prefers weekend appointments', '555-5678'),
('Mike Johnson', 'VIP customer', '555-8765');

-- Insert data into employee table
INSERT INTO employee (name) VALUES
('Alice Brown'),
('Bob Green'),
('Charlie White');

-- Insert data into employee_days_available table
INSERT INTO employee_days_available (employee_id, days_available) VALUES
(1, 'MONDAY'),     -- Alice Brown available on Monday
(1, 'WEDNESDAY'),  -- Alice Brown available on Wednesday
(2, 'TUESDAY'),    -- Bob Green available on Tuesday
(2, 'THURSDAY'),   -- Bob Green available on Thursday
(3, 'FRIDAY'),     -- Charlie White available on Friday
(3, 'SATURDAY'),   -- Charlie White available on Saturday
(3, 'SUNDAY');     -- Charlie White available on Sunday


-- Insert data into employee_skills table
INSERT INTO employee_skills (employee_id, skills) VALUES
(1, 'FEEDING'),    -- Alice Brown has FEEDING skill
(1, 'PETTING'),    -- Alice Brown has PETTING skill
(2, 'MEDICATING'), -- Bob Green has MEDICATING skill
(2, 'WALKING'),    -- Bob Green has WALKING skill
(3, 'SHAVING'),    -- Charlie White has SHAVING skill
(3, 'FEEDING');    -- Charlie White has FEEDING skill


-- Insert data into pet table
INSERT INTO pet (birth_date, customer_id, name, notes, type) VALUES
('2020-01-01', 1, 'Buddy', 'Friendly dog', 'DOG'),  -- John Doe's pet
('2019-05-12', 2, 'Whiskers', 'Loves to climb', 'CAT'),  -- Jane Smith's pet
('2021-02-20', 3, 'Goldie', 'Swims all day', 'FISH');  -- Mike Johnson's pet
