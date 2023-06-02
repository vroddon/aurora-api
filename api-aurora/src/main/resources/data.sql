INSERT INTO aurora.demo_sites (`id`,`city`,`country`) VALUES (1,'Madrid','Spain');
INSERT INTO aurora.demo_sites (`id`,`city`,`country`) VALUES (2,'Evora','Portugal');
INSERT INTO aurora.demo_sites (`id`,`city`,`country`) VALUES (3,'Ljubljana','Slovenia');
INSERT INTO aurora.demo_sites (`id`,`city`,`country`) VALUES (4,'Aarhus','Denmark');
INSERT INTO aurora.demo_sites (`id`,`city`,`country`) VALUES (5,'Forest of Dean','England');

INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (1, 'Fuel car');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (2, 'Electric car');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (3, 'Hybrid car');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (4, 'Motorcycle');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (5, 'Electric motorcycle');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (6, 'Electric bike');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (7, 'Electric scooter');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (8, 'Bus');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (9, 'Metro, tram, urban light train');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (10, 'Electric passenger train');
INSERT INTO aurora.vehicle_types  (`id`, `name`) VALUES (11, 'High speed train');


INSERT INTO aurora.level_of_accupancy  (`id`, `name`) VALUES (1, '1');
INSERT INTO aurora.level_of_accupancy  (`id`, `name`) VALUES (2, '2');
INSERT INTO aurora.level_of_accupancy  (`id`, `name`) VALUES (3, '3');
INSERT INTO aurora.level_of_accupancy  (`id`, `name`) VALUES (4, '4');
INSERT INTO aurora.level_of_accupancy  (`id`, `name`) VALUES (5, '5');
INSERT INTO aurora.level_of_accupancy  (`id`, `name`) VALUES (6, 'Almost empty');
INSERT INTO aurora.level_of_accupancy  (`id`, `name`) VALUES (7, 'Average');
INSERT INTO aurora.level_of_accupancy  (`id`, `name`) VALUES (8, 'Nearly full');

CREATE TABLE countries (
  id bigint NOT NULL AUTO_INCREMENT,
  country varchar(255),
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8


INSERT INTO aurora.countries (`id`,`country`) VALUES (1,'Spain');
INSERT INTO aurora.countries (`id`,`country`) VALUES (2,'Portugal');
INSERT INTO aurora.countries (`id`,`country`) VALUES (3,'Slovenia');
INSERT INTO aurora.countries (`id`,`country`) VALUES (4,'Denmark');
INSERT INTO aurora.countries (`id`,`country`) VALUES (5,'England');
INSERT INTO aurora.countries (`id`,`country`) VALUES (6,'EU');

INSERT INTO aurora.heating_sources (`id`,`name`) VALUES (1,'Heating oil');
INSERT INTO aurora.heating_sources (`id`,`name`) VALUES (2,'Natural gas');
INSERT INTO aurora.heating_sources (`id`,`name`) VALUES (3,'LPG');
INSERT INTO aurora.heating_sources (`id`,`name`) VALUES (4,'LNG');
INSERT INTO aurora.heating_sources (`id`,`name`) VALUES (5,'Biomass');
INSERT INTO aurora.heating_sources (`id`,`name`) VALUES (6,'Geothermal');
INSERT INTO aurora.heating_sources (`id`,`name`) VALUES (7,'Solar thermal');
INSERT INTO aurora.heating_sources (`id`,`name`) VALUES (8,'District heating');