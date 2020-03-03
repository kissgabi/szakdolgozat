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
DROP USER IF EXISTS 'superuser'@'%';
DROP USER IF EXISTS 'director'@'localhost';
DROP USER IF EXISTS 'employee'@'localhost';


/*------------------------------------------------------------------------------------------------------*/

GRANT USAGE ON *.* TO 'testuser'@'%' IDENTIFIED BY PASSWORD '*3A2EB9C80F7239A4DE3933AE266DB76A7846BCB8';
GRANT SELECT (user_password, user_name, usergroup, user_key) ON `kkv_sample`.`kkv_user_datas` TO 'testuser'@'%';

GRANT USAGE ON *.* TO 'testuser'@'127.0.0.1' IDENTIFIED BY PASSWORD '*3A2EB9C80F7239A4DE3933AE266DB76A7846BCB8';
GRANT SELECT (user_password, user_name, usergroup, user_key) ON `kkv_sample`.`kkv_user_datas` TO 'testuser'@'127.0.0.1';

GRANT USAGE ON *.* TO 'testuser'@'::1' IDENTIFIED BY PASSWORD '*3A2EB9C80F7239A4DE3933AE266DB76A7846BCB8';
GRANT SELECT (user_password, user_name, usergroup, user_key) ON `kkv_sample`.`kkv_user_datas` TO 'testuser'@'::1';

GRANT USAGE ON *.* TO 'testuser'@'localhost' IDENTIFIED BY PASSWORD '*3A2EB9C80F7239A4DE3933AE266DB76A7846BCB8';
GRANT SELECT (user_password, user_name, usergroup, user_key) ON `kkv_sample`.`kkv_user_datas` TO 'testuser'@'localhost';

/*------------------------------------------------------------------------------------------------------*/

GRANT ALL PRIVILEGES ON *.* TO 'rootschield'@'%' IDENTIFIED BY PASSWORD '*609F49858EF550B6556A011E4E551F69383453B5' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON *.* TO 'rootschield'@'127.0.0.1' IDENTIFIED BY PASSWORD '*609F49858EF550B6556A011E4E551F69383453B5' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON *.* TO 'rootschield'@'::1' IDENTIFIED BY PASSWORD '*609F49858EF550B6556A011E4E551F69383453B5' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON *.* TO 'rootschield'@'localhost' IDENTIFIED BY PASSWORD '*609F49858EF550B6556A011E4E551F69383453B5' WITH GRANT OPTION;

/*------------------------------------------------------------------------------------------------------*/

GRANT USAGE ON *.* TO 'superuser'@'%' IDENTIFIED BY PASSWORD '*4FB15991C85A2EB8A3B4B2D3411AA2AD094E7229';
GRANT SELECT, INSERT ON `kkv_sample`.* TO 'superuser'@'%';
GRANT UPDATE (zipcode, address1, fax, email, phone, mobile, name, address2) ON `kkv_sample`.`kkv_company_datas` TO 'superuser'@'%';
GRANT UPDATE (user_password, user_birthday, usergroup, user_name) ON `kkv_sample`.`kkv_user_datas` TO 'superuser'@'%';
GRANT UPDATE (usergroup_name) ON `kkv_sample`.`kkv_user_groups` TO 'superuser'@'%';

GRANT USAGE ON *.* TO 'superuser'@'localhost' IDENTIFIED BY PASSWORD '*4FB15991C85A2EB8A3B4B2D3411AA2AD094E7229';
GRANT SELECT, INSERT ON `kkv_sample`.* TO 'superuser'@'localhost';
GRANT UPDATE (user_password, user_birthday, usergroup, user_name) ON `kkv_sample`.`kkv_user_datas` TO 'superuser'@'localhost';
GRANT UPDATE (usergroup_name) ON `kkv_sample`.`kkv_user_groups` TO 'superuser'@'localhost';
GRANT UPDATE (zipcode, address1, fax, email, phone, mobile, name, address2) ON `kkv_sample`.`kkv_company_datas` TO 'superuser'@'localhost';

/*------------------------------------------------------------------------------------------------------*/

GRANT USAGE ON *.* TO 'director'@'localhost' IDENTIFIED BY PASSWORD '*1ABF1A3C7938A769F31C955E3D5CFC2FA2007598';
GRANT SELECT (user_name, user_birthday, usergroup, user_key), INSERT ON `kkv_sample`.`kkv_user_datas` TO 'director'@'localhost';
GRANT SELECT (reporter, message, receiver, recorded) ON `kkv_sample`.`kkv_message_records` TO 'director'@'localhost';

/*------------------------------------------------------------------------------------------------------*/

GRANT USAGE ON *.* TO 'employee'@'localhost' IDENTIFIED BY PASSWORD '*334AD31E3FB6986ED62F9C8D2F252E2FC475D5FA';
GRANT SELECT ON `kkv\_sample`.* TO 'employee'@'localhost';
GRANT SELECT, INSERT ON `kkv_sample`.`kkv_message_records` TO 'employee'@'localhost';

/* END OF FILE -------------------------------------------------------------------*/

