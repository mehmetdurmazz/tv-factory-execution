-- Produced panels to be used in TV

CREATE TABLE panel (
   id IDENTITY,
   panel_barcode UUID,
   produced_by VARCHAR(10),
   UNIQUE (panel_barcode)
);

-- Produced Main Boards to be used in TV

CREATE TABLE main_board (
   id IDENTITY,
   main_board_barcode UUID,
   produced_by VARCHAR(10),
   UNIQUE (main_board_barcode)
);

-- Produced TVs

CREATE TABLE tv_production (
   id IDENTITY,
   panel_barcode UUID,
   main_board_barcode UUID,
   assembled_by VARCHAR(10)
);

-- Robot

CREATE TABLE sales (
   tv_id BIGINT PRIMARY KEY,
   price INTEGER,
   sold_by VARCHAR(10)
);

-- Robots in the system

CREATE TABLE robot (
   id IDENTITY,
   name VARCHAR(10),
   buyer VARCHAR(10)
);

INSERT INTO robot
VALUES
    (0, 'Robot-1', 'Default'),
    (-1, 'Robot-2', 'Default');

-- For PKs which needs to be generated

CREATE SEQUENCE "PANEL_SEQ"
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE "MAIN_BOARD_SEQ"
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE "TV_PRODUCTION_SEQ"
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE "ROBOT_SEQ"
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;