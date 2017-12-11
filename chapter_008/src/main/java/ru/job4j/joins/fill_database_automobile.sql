INSERT INTO transmission (type, vendor) VALUES('mechanical', 'vw');
INSERT INTO transmission (type, vendor) VALUES('automatic', 'audi');
INSERT INTO transmission (type, vendor) VALUES('hydrostatic', 'bmw');
INSERT INTO transmission (type, vendor) VALUES('hydrostatic', 'vw');

INSERT INTO engine (type, vendor) VALUES('petrol', 'vw');
INSERT INTO engine (type, vendor) VALUES('diesel', 'audi');
INSERT INTO engine (type, vendor) VALUES('gas', 'bmw');
INSERT INTO engine (type, vendor) VALUES('diesel', 'audi');
INSERT INTO engine (type, vendor) VALUES('diesel', 'audi');

INSERT INTO gearbox (type, vendor) VALUES('mechanical', 'vw');
INSERT INTO gearbox (type, vendor) VALUES('automatical', 'audi');
INSERT INTO gearbox (type, vendor) VALUES('robotic', 'bmw');
INSERT INTO gearbox (type, vendor) VALUES('robotic', 'bmw');
INSERT INTO gearbox (type, vendor) VALUES('robotic', 'bmw');
INSERT INTO gearbox (type, vendor) VALUES('robotic', 'bmw');

INSERT INTO automobile (type, vendor, transm_id, engine_id, gear_id) VALUES('cargo', 'vw', '1', '1', '1');
INSERT INTO automobile (type, vendor, transm_id, engine_id, gear_id) VALUES('sedan', 'audi', '2', '2', '2');
INSERT INTO automobile (type, vendor, transm_id, engine_id, gear_id) VALUES('hatchback', 'bmw', '3', '3', '3');