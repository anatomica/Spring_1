BEGIN;

DROP TABLE IF EXISTS Product CASCADE;
CREATE TABLE Product (id bigserial PRIMARY KEY, title VARCHAR(255), cost int);
INSERT INTO Product (title, cost) VALUES
('box', 10),
('sphere', 20),
('maul', 100),
('door', 50),
('camera', 500),
('box1', 10),
('sphere1', 20),
('maul1', 100),
('door1', 50),
('camera1', 500),
('box2', 10),
('sphere2', 20),
('maul2', 100),
('door2', 50),
('camera2', 500),
('box3', 10),
('sphere3', 20),
('maul3', 100),
('door3', 50),
('camera3', 500);

COMMIT;