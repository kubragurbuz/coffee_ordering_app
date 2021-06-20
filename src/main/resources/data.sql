DROP TABLE IF EXISTS coffee;
DROP TABLE IF EXISTS cur;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS coffee_material_rel;

CREATE TABLE cur (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  descr VARCHAR(250) NOT NULL,
  symbol VARCHAR(10) NOT NULL,
  is_actv INT NOT NULL DEFAULT 1
);


CREATE TABLE coffee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price INT NOT NULL,
  cur_id INT NOT NULL,
  is_actv INT NOT NULL DEFAULT 1
);

CREATE TABLE material(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  is_actv INT NOT NULL DEFAULT 1
);

CREATE TABLE coffee_material_rel (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  coffee_id INT NOT NULL,
  material_id INT NOT NULL,
  measure INT NOT NULL,
  is_actv INT NOT NULL DEFAULT 1,
  CONSTRAINT FK_MATERIAL FOREIGN KEY (material_id) REFERENCES  material(id),
  CONSTRAINT FK_COFFEE FOREIGN KEY (coffee_id) REFERENCES  coffee(id)
);

INSERT INTO cur (name, descr, symbol) VALUES
  ('TL','Türk Lirası', '₺');

INSERT INTO coffee (name, price, cur_id) VALUES
  ('Espresso', 7, 1),
  ('Double Espresso', 12, 1),
  ('Cappuccino', 12, 1),
  ('Caffe Latte', 12, 1),
  ('Mocha', 13, 1),
  ('Americano', 10, 1),
  ('Hot Water', 3, 1);

INSERT INTO material (name) VALUES
  ('espresso'),
  ('sıcak süt'),
  ('süt köpüğü'),
  ('sıcak çikolata'),
  ('sıcak su');

INSERT INTO coffee_material_rel (coffee_id, material_id, measure) VALUES
  (1, 1, 1),
  (2, 1, 2),
  (3, 1, 1),
  (3, 2, 2),
  (3, 3, 2),
  (4, 1, 1),
  (4, 2, 3),
  (4, 3, 1),
  (5, 1, 1),
  (5, 2, 1),
  (5, 3, 1),
  (5, 4, 2),
  (6, 5, 4),
  (6, 1, 1),
  (7, 5, 5);
