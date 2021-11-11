CREATE DATABASE aging_population_fitness;
USE aging_population_fitness;

CREATE TABLE exercise(
exercise_id  INTEGER UNSIGNED NOT NULL auto_increment,
exercise_name VARCHAR(50) NOT NULL,
exercise_description VARCHAR(1000) NOT NULL,
PRIMARY KEY (exercise_id));

CREATE TABLE exercise_injury(
injury_id INTEGER UNSIGNED NOT NULL auto_increment,
exercise_id INTEGER UNSIGNED NOT NULL,
exercise_injury_name VARCHAR(50) NOT NULL,
exercise_injury_description  VARCHAR(1000) NOT NULL,
PRIMARY KEY (injury_id),
FOREIGN KEY (exercise_id) REFERENCES exercise(exercise_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE benefit(
benefit_id INTEGER UNSIGNED NOT NULL auto_increment,
exercise_id INTEGER UNSIGNED NOT NULL,
benefit_name VARCHAR(50) NOT NULL,
benefit_description VARCHAR(1000) NOT NULL,
PRIMARY KEY (benefit_id),
FOREIGN KEY (exercise_id) REFERENCES exercise(exercise_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE user(
username VARCHAR(50),
password VARCHAR(50),
email VARCHAR(50),
PRIMARY KEY (username));

CREATE TABLE user_profile(
user_id INTEGER UNSIGNED NOT NULL auto_increment,
username VARCHAR(50) NOT NULL,
profile_name VARCHAR(50) NOT NULL,
PRIMARY KEY (user_id),
FOREIGN KEY (username) REFERENCES user(username)
	ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE user_injury(
injury_id INTEGER UNSIGNED NOT NULL auto_increment,
user_id INTEGER UNSIGNED NOT NULL,
user_injury_name VARCHAR(50) NOT NULL,
user_injury_description  VARCHAR(1000) NOT NULL,
user_injury_severity SMALLINT UNSIGNED,
user_injury_date DATE,
PRIMARY KEY (injury_id),
FOREIGN KEY (user_id) REFERENCES user_profile(user_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE entity1(
username VARCHAR(50),
password VARCHAR(50),
email VARCHAR(50),
PRIMARY KEY (username));

INSERT INTO `user` (`username`, `password`, `email`) 
VALUES ('Frank','ysdhf84hnh','frankPaulsen@gmail.com'),
	('Joe','4367753!@#','myemail@gmail.com'),
	('John','myPassword45','joeJohnson@gmail.com'),
	('smith','password123','smith7@gmail.com'),
	('susan','susan123','susan@gmail.com');

INSERT INTO `user_profile` (`user_id`, `username`, `profile_name`) 
VALUES (1,'susan','susanLiftsALot'),
	(2,'smith','SmithTheMachine'),
	(3,'Joe','WeakMan'),
	(4,'Frank','FrankieP'),
	(5,'John','JoeJohnnyBoy');
    
INSERT INTO `user_injury` (`injury_id`, `user_id`, `user_injury_name`, `user_injury_description`, `user_injury_severity`, `user_injury_date`) 
VALUES (1,1,'Sprained Ankle','Swollen sore ankle with a bruise',2,'2021-10-01'),
(2,1,'strained calf','sharp pain in left calf muscle',6,'2021-10-02'),
(3,3,'broken toe','right pinky toe is broken',4,'2021-10-03'),
(4,4,'Slipped disk','L4 disk slipped in lower back',9,'2021-10-04'),
(5,5,'Sprained Knee','left knee is sore and it hurts to bend it',3,'2021-10-05');

INSERT INTO `exercise` (`exercise_id`, `exercise_name`, `exercise_description`) 
VALUES (1,'chest press','one lies supine on a bench and with both hands pushes a barbell or fixed weight upward from chest level to arm\'s length and then lowers it back to chest level'),
(2,'leg press',' individual pushes a weight or resistance away from them using their legs'),
(3,'treadmill walk','Treadmills usually feature adjustable speeds and inclines to vary your workout, allowing you to simulate a hill with the push of a button'),
(4,'dumbbell row','compound exercise that mainly target your middle back, but also work the biceps, shoulders, and lats'),
(5,'weighted situps','Hold the weight against your chest and lie on your back. Bend your knees at a 90-degree angle, and keep your feet firmly planted on the floor. While holding the weight, slowly contract your core and raise your upper body toward your knees until your forearms touch your thighs. Your hip and feet should remain on the floor.');

INSERT INTO `exercise_injury` (`injury_id`, `exercise_id`, `exercise_injury_name`, `exercise_injury_description`) 
VALUES (1,1,'strained pectoral','chest injury'),
(2,2,'calf strain','strain on leg muscle'),
(3,3,'sprained ankle','sprain of foot bone'),
(4,4,'finger sprain','sprain on the finger'),
(5,5,'lower back pain','trouble standing or bending the back with pain in the lower region of the back');

INSERT INTO `benefit` (`benefit_id`, `exercise_id`, `benefit_name`, `benefit_description`) 
VALUES (1,1,'chest strength','strengthens chest'),
(2,2,'strengthen calf','helps with daily walking'),
(3,3,'strengthen ankle','helps cardiovascular strength'),
(4,4,'strengthen back','helps lift heavy objects off ground'),
(5,5,'strengthen abdominals','helps with getting one\'s self off the ground');
