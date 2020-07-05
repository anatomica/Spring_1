BEGIN;

DROP TABLE IF EXISTS Client CASCADE;
CREATE TABLE Client (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO Client (name) VALUES
('Arnold S.'),
('Silvester S.'),
('Willis B.');

DROP TABLE IF EXISTS Product CASCADE;
CREATE TABLE Product (id bigserial PRIMARY KEY, title VARCHAR(255), cost int);
-- INSERT INTO Product (title, cost) VALUES
-- ('box', 10),
-- ('sphere', 20),
-- ('maul', 100),
-- ('door', 50),
-- ('camera', 500);

DROP TABLE IF EXISTS OrderClient CASCADE;
CREATE TABLE OrderClient (id bigserial PRIMARY KEY, idClient INT, idProduct INT);
INSERT INTO OrderClient (idClient, idProduct) VALUES
(1, 1),
(2, 2),
(3, 2),
(1, 4),
(2, 5);

COMMIT;