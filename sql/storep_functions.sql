CREATE DEFINER=`root`@`localhost` PROCEDURE `injury_count`(IN user_profile_user_id INTEGER, OUT quantity INTEGER)
BEGIN
	SELECT COUNT(*)
    INTO quantity
    FROM user_injury
    WHERE user_id = user_profile_user_id;
END

CREATE DEFINER=`root`@`localhost` FUNCTION `average_injuries`() 
	RETURNS decimal(10,0)
    READS SQL DATA
BEGIN
	DECLARE avgInjuries DECIMAL;
    
	SELECT AVG( SUM(user_id))
    INTO avgInjuries
    FROM user_injury
    GROUP BY user_id;
    
RETURN avgInjuries;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `user_injury_count`(IN users_id INT, OUT quantity INT)
BEGIN
	SELECT COUNT(*)
    INTO quantity
    FROM user_injury
    WHERE user_id = users_id;
END

CREATE DEFINER=`root`@`localhost` FUNCTION `average_difficulty`() 
	RETURNS decimal(10,0)
    READS SQL DATA
BEGIN
	DECLARE avgDifficulty DECIMAL;
    
	SELECT AVG( exercise_difficulty)
    INTO avgDifficulty
    FROM exercise;
    
    
RETURN avgDifficulty;
END

