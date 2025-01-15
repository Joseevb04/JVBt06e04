-- Insert into patient table
INSERT INTO patient (dni, name, birth_date, visit_reason, appointment_reason, previous_visit)
VALUES
('12345678A', 'John Doe', '1985-05-15', 'APPOINTMENT', 'General check-up', '2024-12-15'),
('87654321B', 'Jane Smith', '1990-03-22', 'RECIPE', 'Follow-up after surgery', '2024-10-10'),
('11223344C', 'Alice Johnson', '1978-11-30', 'REVISION', 'Severe headache', NULL);

-- Insert into recipe table
INSERT INTO recipe (recipe, patient_dni) VALUES
('Recipe1', '12345678A'),
('Recipe2', '12345678A'),
('Recipe3', '87654321B');

