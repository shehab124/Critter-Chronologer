-- Insert data into customer table
INSERT INTO customer (name, notes, phone_number) VALUES
('John Doe', 'Regular customer', '555-1234'),
('Jane Smith', 'Prefers weekend appointments', '555-5678'),
('Mike Johnson', 'VIP customer', '555-8765'),
('Sarah Connor', 'New customer', '555-3456'),
('Tom Hanks', 'Loves pets', '555-7890');

-- Insert data into employee table
INSERT INTO employee (name) VALUES
('Alice Brown'),
('Bob Green'),
('Charlie White'),
('Diana Prince'),
('Eve Black');

-- Insert data into employee_days_available table
INSERT INTO employee_days_available (employee_id, days_available) VALUES
(1, 'MONDAY'),     -- Alice Brown available on Monday
(1, 'WEDNESDAY'),  -- Alice Brown available on Wednesday
(2, 'TUESDAY'),    -- Bob Green available on Tuesday
(2, 'THURSDAY'),   -- Bob Green available on Thursday
(3, 'FRIDAY'),     -- Charlie White available on Friday
(3, 'SATURDAY'),   -- Charlie White available on Saturday
(3, 'SUNDAY'),     -- Charlie White available on Sunday
(4, 'MONDAY'),     -- Diana Prince available on Monday
(4, 'THURSDAY'),   -- Diana Prince available on Thursday
(5, 'WEDNESDAY'),  -- Eve Black available on Wednesday
(5, 'FRIDAY');     -- Eve Black available on Friday

-- Insert data into employee_skills table
INSERT INTO employee_skills (employee_id, skills) VALUES
(1, 'FEEDING'),    -- Alice Brown has FEEDING skill
(1, 'PETTING'),    -- Alice Brown has PETTING skill
(2, 'MEDICATING'), -- Bob Green has MEDICATING skill
(2, 'WALKING'),    -- Bob Green has WALKING skill
(3, 'SHAVING'),    -- Charlie White has SHAVING skill
(3, 'FEEDING'),    -- Charlie White has FEEDING skill
(4, 'PETTING'),    -- Diana Prince has PETTING skill
(4, 'WALKING'),    -- Diana Prince has WALKING skill
(5, 'MEDICATING'), -- Eve Black has MEDICATING skill
(5, 'SHAVING');    -- Eve Black has SHAVING skill

-- Insert data into pet table
INSERT INTO pet (birth_date, customer_id, name, notes, type) VALUES
('2020-01-01', 1, 'Buddy', 'Friendly dog', 'DOG'),  -- John Doe's pet
('2019-05-12', 2, 'Whiskers', 'Loves to climb', 'CAT'),  -- Jane Smith's pet
('2021-02-20', 3, 'Goldie', 'Swims all day', 'FISH'),  -- Mike Johnson's pet
('2021-07-15', 4, 'Rex', 'Guard dog', 'DOG'),  -- Sarah Connor's pet
('2020-10-25', 5, 'Tweety', 'Sings all day', 'BIRD');  -- Tom Hanks' pet

-- Insert data into schedule table
INSERT INTO schedule (date) VALUES
('2023-06-01'),
('2023-06-02'),
('2023-06-03'),
('2023-06-04'),
('2023-06-05');

-- Insert data into schedule_activities table
INSERT INTO schedule_activities (schedule_id, activities) VALUES
(1, 'FEEDING'),
(1, 'WALKING'),
(2, 'MEDICATING'),
(2, 'PETTING'),
(3, 'SHAVING'),
(3, 'FEEDING'),
(4, 'WALKING'),
(4, 'PETTING'),
(5, 'MEDICATING'),
(5, 'SHAVING');

-- Insert data into schedule_employees table
INSERT INTO schedule_employees (employee_id, schedule_id) VALUES
(1, 1),  -- Alice Brown on schedule 1
(2, 2),  -- Bob Green on schedule 2
(3, 3),  -- Charlie White on schedule 3
(4, 4),  -- Diana Prince on schedule 4
(5, 5);  -- Eve Black on schedule 5

-- Insert data into schedule_pets table
INSERT INTO schedule_pets (pet_id, schedule_id) VALUES
(1, 1),  -- Buddy on schedule 1
(2, 2),  -- Whiskers on schedule 2
(3, 3),  -- Goldie on schedule 3
(4, 4),  -- Rex on schedule 4
(5, 5);  -- Tweety on schedule 5
