/* START OF FILE -----------------------------------------------------------------*/


/* DROP USERS --------------------------------------------------------------------*/

DROP USER IF EXISTS 'rootschield'@'localhost';
DROP USER IF EXISTS 'rootschield'@'::1';
DROP USER IF EXISTS 'rootschield'@'127.0.0.1';
DROP USER IF EXISTS 'rootschield'@'%';

DROP USER IF EXISTS 'testuser'@'localhost';
DROP USER IF EXISTS 'tsetuser'@'::1';
DROP USER IF EXISTS 'testuser'@'127.0.0.1';
DROP USER IF EXISTS 'testuser'@'%';

DROP USER IF EXISTS 'superuser'@'localhost';
DROP USER IF EXISTS 'director'@'localhost';
DROP USER IF EXISTS 'accountant'@'localhost';
DROP USER IF EXISTS 'shopper'@'localhost';
DROP USER IF EXISTS 'employee'@'localhost';


/* CREATE ROOT USER -------------------------------------------------------------*/

CREATE USER IF NOT EXISTS 'rootschield'@'localhost' IDENTIFIED BY 'rootschield';
GRANT ALL PRIVILEGES ON *.* TO 'rootschield'@'localhost' REQUIRE NONE
WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
CREATE USER IF NOT EXISTS 'rootschield'@'::1' IDENTIFIED BY 'rootschield';
GRANT ALL PRIVILEGES ON *.* TO 'rootschield'@'::1' REQUIRE NONE
WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
CREATE USER IF NOT EXISTS 'rootschield'@'127.0.0.1' IDENTIFIED BY 'rootschield';
GRANT ALL PRIVILEGES ON *.* TO 'rootschield'@'127.0.0.1' REQUIRE NONE
WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
CREATE USER IF NOT EXISTS 'rootschield'@'%' IDENTIFIED BY 'rootschield';
GRANT ALL PRIVILEGES ON *.* TO 'rootschield'@'%' REQUIRE NONE
WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;


/* CREATE TEST USER -------------------------------------------------------------*/

CREATE USER IF NOT EXISTS 'testuser'@'localhost' IDENTIFIED BY 'testuser';
GRANT USAGE ON `kkv\_sample`.* TO 'testuser'@'localhost'; 
GRANT SELECT (`user_name`, `user_password`, `usergroup`) 
    ON `kkv_sample`.`kkv_user_datas` TO 'testuser'@'localhost'; 
CREATE USER IF NOT EXISTS 'testuser'@'::1' IDENTIFIED BY 'testuser';
GRANT USAGE ON `kkv\_sample`.* TO 'testuser'@'::1'; 
GRANT SELECT (`user_name`, `user_password`, `usergroup`) 
    ON `kkv_sample`.`kkv_user_datas` TO 'testuser'@'::1'; 
CREATE USER IF NOT EXISTS 'testuser'@'127.0.0.1' IDENTIFIED BY 'testuser';
GRANT USAGE ON `kkv\_sample`.* TO 'testuser'@'127.0.0.1'; 
GRANT SELECT (`user_name`, `user_password`, `usergroup`) 
    ON `kkv_sample`.`kkv_user_datas` TO 'testuser'@'127.0.0.1'; 
CREATE USER IF NOT EXISTS 'testuser'@'%' IDENTIFIED BY 'testuser';
GRANT USAGE ON `kkv\_sample`.* TO 'testuser'@'%'; 
GRANT SELECT (`user_name`, `user_password`, `usergroup`) 
    ON `kkv_sample`.`kkv_user_datas` TO 'testuser'@'%'; 


/* CREATE USERS -----------------------------------------------------------------*/

CREATE USER IF NOT EXISTS 'superuser'@'localhost' IDENTIFIED BY 'superusermysql';
GRANT SELECT, INSERT
    ON `kkv_sample`.* TO 'superuser'@'localhost';
GRANT UPDATE (`name`, `zipcode`, `address1`, `address2`, `phone`, `fax`, `mobile`, `email`) 
    ON `kkv_sample`.`kkv_company_datas` TO 'superuser'@'localhost';
GRANT UPDATE (`toolgroup_name`)
    ON `kkv_sample`.`kkv_tool_groups` TO 'superuser'@'localhost';
GRANT UPDATE (`tool_name`, `toolgroup`, `tool_min_quantity`)
    ON `kkv_sample`.`kkv_tool_datas` TO 'superuser'@'localhost'; 
GRANT UPDATE (`usergroup_name`)
    ON `kkv_sample`.`kkv_user_groups` TO 'superuser'@'localhost';
GRANT UPDATE (`user_name`, `user_birthday`, `user_password`, `usergroup`)
    ON `kkv_sample`.`kkv_user_datas` TO 'superuser'@'localhost';

CREATE USER IF NOT EXISTS 'director'@'localhost' IDENTIFIED BY 'directormysql';
GRANT SELECT (`user_key`, `user_name`, `user_birthday`, `usergroup`), INSERT 
    ON `kkv_sample`.`kkv_user_datas` TO 'director'@'localhost';
GRANT SELECT, INSERT
    ON `kkv_sample`.`kkv_tool_datas` TO 'director'@'localhost';
GRANT SELECT, INSERT 
    ON `kkv_sample`.`kkv_tool_records` TO 'director'@'localhost';
GRANT SELECT (`recorded`, `reporter`, `receiver`, `message`)
    ON `kkv_sample`.`kkv_message_records` TO 'director'@'localhost'; 
/*GRANT UPDATE (`user_password`)
    ON `kkv_sample`.`kkv_user_datas` TO 'director'@'localhost';*/

CREATE USER IF NOT EXISTS 'accountant'@'localhost' IDENTIFIED BY 'accountantmysql';
GRANT SELECT (`user_key`, `user_name`, `user_birthday`, `usergroup`), INSERT 
    ON `kkv_sample`.`kkv_user_datas` TO 'accountant'@'localhost';
GRANT SELECT, INSERT
    ON `kkv_sample`.`kkv_tool_datas` TO 'accountant'@'localhost';
GRANT SELECT, INSERT 
    ON `kkv_sample`.`kkv_tool_records` TO 'accountant'@'localhost';
GRANT SELECT (`recorded`, `reporter`, `receiver`, `message`)
    ON `kkv_sample`.`kkv_message_records` TO 'accountant'@'localhost'; 


/*GRANT UPDATE (`user_password`)
    ON `kkv_sample`.`kkv_user_datas` TO 'accountant'@'localhost';*/




CREATE USER IF NOT EXISTS 'shopper'@'localhost' IDENTIFIED BY 'shoppermysql';
GRANT SELECT 
    ON `kkv_sample`.`kkv_tool_records` TO 'shopper'@'localhost';
GRANT INSERT (`recorded`, `reporter`, `tool`, `price`, `notes`)
    ON `kkv_sample`.`kkv_tool_records` TO 'shopper'@'localhost';
GRANT SELECT (`recorded`, `reporter`, `receiver`, `message`)
    ON `kkv_sample`.`kkv_message_records` TO 'shopper'@'localhost'; 


/*GRANT UPDATE (`user_password`)
    ON `kkv_sample`.`kkv_user_datas` TO 'shopper'@'localhost';*/

CREATE USER IF NOT EXISTS 'employee'@'localhost' IDENTIFIED BY 'employeemysql';
GRANT SELECT (`recorded`, `reporter`, `receiver`, `message`)
    ON `kkv_sample`.`kkv_message_records` TO 'employee'@'localhost'; 
/*GRANT UPDATE (`user_password`)
    ON `kkv_sample`.`kkv_user_datas` TO 'employee'@'localhost';*/

/* END OF FILE -------------------------------------------------------------------*/

