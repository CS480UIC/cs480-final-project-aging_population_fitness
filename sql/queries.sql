CREATE VIEW `average_user_injury_severity_greater_than_three` AS
SELECT user_id, ROUND( AVG( user_injury_severity) )
FROM user_injury
GROUP BY user_id
HAVING ROUND( AVG( user_injury_severity) ) > 3;

CREATE VIEW `difficulty_greater_than_five` AS
SELECT * 
FROM exercise
WHERE exercise_difficulty >= 5;

CREATE VIEW `injury_greater_than_five` AS
SELECT *
FROM user_injury
WHERE user_injury_severity >= 5;

CREATE VIEW `profile_names_with_injury_age` AS
SELECT profile_name, user_injury_name, DATEDIFF(DATE(NOW()), user_injury_date)
FROM user_injury
JOIN user_profile
ON user_injury.user_id = user_profile.user_id;

CREATE VIEW `benefits_of_exercise_with_chest_in_description` AS
SELECT *
FROM benefit B
WHERE EXISTS 
	(SELECT *
	FROM exercise
	WHERE exercise_id = B.exercise_id AND exercise_description LIKE '%chest%');
    
CREATE VIEW `users_more_than_two_injuries` AS
SELECT user_id, profile_name
FROM user_profile A
WHERE 2 <=
	(SELECT COUNT(*)
	FROM user_injury
    WHERE user_id = A.user_id
    GROUP BY user_id);
    
SELECT username, profile_name, user_injury_name, user_injury_description, user_injury_severity
FROM user_profile
JOIN user_injury
ON user_profile.user_id = user_injury.user_id;

SELECT exercise_name, exercise_description, benefit_name, benefit_description
FROM exercise
JOIN benefit
ON exercise.exercise_id = benefit.exercise_id;



CREATE VIEW `exercise_name_lowercase` AS
SELECT LOWER(exercise_name), exercise_description
FROM exercise
ORDER BY exercise_name;

CREATE VIEW `injury_age_days` AS
SELECT user_id, user_injury_name, DATEDIFF(DATE(NOW()), user_injury_date)
FROM user_injury;



CREATE VIEW `exercise_difficulty_lessthan_avg` AS
SELECT exercise_name, exercise_description, exercise_difficulty
FROM exercise
WHERE exercise_difficulty < 
	(SELECT AVG(exercise_difficulty)
	FROM exercise);
    



