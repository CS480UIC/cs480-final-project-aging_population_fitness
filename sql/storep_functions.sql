CREATE DEFINER=`root`@`localhost` PROCEDURE `injury_count`(IN user_profile_user_id INTEGER, OUT quantity INTEGER)
BEGIN
	SELECT COUNT(*)
    INTO quantity
    FROM user_injury
    WHERE user_id = user_profile_user_id;
END

CREATE DEFINER=`root`@`localhost` FUNCTION `average_injuries`() RETURNS decimal(10,0)
    READS SQL DATA
BEGIN
	DECLARE avgInjuries DECIMAL;
    
	SELECT AVG( SUM(user_id))
    INTO avgInjuries
    FROM user_injury
    GROUP BY user_id;
    
RETURN avgInjuries;
END