/*create database esercitazione;
use esercitazione;*/

drop table if exists `SoftSkills`;
create table SoftSkills(
	id bigint NOT NULL AUTO_INCREMENT,
    descrizione varchar(255)  DEFAULT NULL,
    livello varchar(255) DEFAULT NULL,
    primary key(id));
drop table if exists `HardSkills`;
create table HardSkills(
	id bigint NOT NULL AUTO_INCREMENT,
    descrizione varchar(255)  DEFAULT NULL,
    livello varchar(255)  DEFAULT NULL,
    provenienza varchar(255)  DEFAULT NULL,
    primary key(id));
drop table if exists `Progetti`;
create table Progetti(
	id bigint NOT NULL AUTO_INCREMENT,
    nome varchar(255)  DEFAULT NULL,
    descrizione varchar(255)  DEFAULT NULL,
    link varchar(255)  DEFAULT NULL,
    primary key(id));

INSERT INTO `esercitazione`.`hardskills` (`descrizione`, `livello`, `provenienza`) VALUES ('Programmazione Java', 'Medio', 'Accademica');
INSERT INTO `esercitazione`.`hardskills` (`descrizione`, `livello`, `provenienza`) VALUES ('HTML', 'Medio-Alto', 'Corsi');

INSERT INTO `esercitazione`.`softskills` (`descrizione`, `livello`) VALUES ('team-working', 'alto');
INSERT INTO `esercitazione`.`softskills` (`descrizione`, `livello`) VALUES ('problem-solving', 'medio-alto');

INSERT INTO `esercitazione`.`progetti` (`nome`, `descrizione`, `link`) VALUES ('Spring1', 'primo progetto Spring', 'https://github.com/teoXIX/Spring1');
INSERT INTO `esercitazione`.`progetti` (`nome`, `descrizione`, `link`) VALUES ('SpringBootDataJSP', 'SpringBoot', 'https://github.com/teoXIX/SpringBootDataJSp');
