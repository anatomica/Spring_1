BEGIN;
DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (id bigserial PRIMARY KEY, name VARCHAR(255), score int);
INSERT INTO students (name, score) VALUES
('Bob1', 70),
('Bob2', 80),
('Bob3', 50),
('Bob4', 60),
('Bob5', 80),
('Bob6', 80),
('Bob7', 60),
('Bob8', 90),
('Bob9', 50),
('Bob10', 60),
('Bob11', 40),
('Bob12', 70),
('Bob13', 80),
('Bob14', 40),
('Bob15', 50),
('Bob16', 70),
('Bob17', 80),
('Bob18', 90),
('Bob19', 90),
('Bob20', 50);
COMMIT;
