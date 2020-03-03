/* START OF FILE -----------------------------------------------------------------*/


/* CLEAR ALL DATAS ---------------------------------------------------------------*/
/*
DELETE FROM `kkv_company_datas`;
ALTER TABLE `kkv_company_datas` AUTO_INCREMENT = 1;
DELETE FROM `kkv_message_records`;
ALTER TABLE `kkv_message_records` AUTO_INCREMENT = 1;
DELETE FROM `kkv_user_datas`;
ALTER TABLE `kkv_user_datas` AUTO_INCREMENT = 1;
DELETE FROM `kkv_user_groups`;
ALTER TABLE `kkv_user_groups` AUTO_INCREMENT = 1;
*/

/* COMPANY DATAS -----------------------------------------------------------------*/

INSERT INTO `kkv_company_datas` VALUES(
  'B6 példa KKV',
   1111,
  'Budapest 11',
  'Bercsényi utca 6.',
  '0036123456789',
  '0036123456789',
  '0036304654562',
  'b6@b6.hu',
  DEFAULT
);


/* USEGROUPS        --------------------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV USERGROUPS:                       */
/* USER PRIVILEGES AND MYSQL GRANTS      */

INSERT INTO `kkv_user_groups` VALUES(NULL, 'testuser', 'testuser');
INSERT INTO `kkv_user_groups` VALUES(NULL, 'superuser', 'superusermysql');
INSERT INTO `kkv_user_groups` VALUES(NULL, 'employee', 'employeemysql');
INSERT INTO `kkv_user_groups` VALUES(NULL, 'director', 'directormysql');


/*            USERS --------------------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV USER DATAS                        */
/* NAME, BIRTHDAY, USERGROUP             */
/* PASSWORD MD5 WITH 128-bit checksum    */

INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('BroadCastUser', '01-01-01', MD5('broadcastuserpassword'), 1 );

INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Super User', '1960-01-01', MD5('superuserpassword'), 2 );

INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Dana Dóra', '1975-01-01', MD5('employee1password'), 3 );
INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Dózsa Dávid', '1985-01-01', MD5('employee2password'), 3 );
INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Albert Alfonz', '1960-01-01', MD5('directorpassword'), 4 );


/*                    RECORDS ----------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV RECORDS                           */
/* TOOL, QUANTITY                        */

/*                    RECORDS - NOTES --------------------------------------------*/

INSERT INTO `kkv_message_records` (`record_key`, `recorded`, `reporter`, `receiver`, `message`) VALUES
(1, '2020-01-11 13:40:13', 2, 2, 'Az adatbázis elkészült'),
(2, '2020-01-11 13:42:41', 2, 2, 'Felhasználói szintek bejegyzésre kerültek'),
(3, '2020-01-11 13:45:27', 2, 2, 'Alkalmazottak listája elkészült'),
(4, '2020-01-11 13:58:02', 3, 5, 'Alfonznak\nD'),
(5, '2020-01-11 14:00:07', 3, 1, 'Dóri első körüzije'),
(6, '2020-01-11 18:55:46', 3, 4, 'Szia Dávid'),
(7, '2020-01-12 13:27:02', 2, 1, 'Szerver felülvizsgálat 2020.január 20-án 5:00-12:00. Az adatbázis nem lesz elérhető ebben az időszakban'),
(8, '2020-01-16 10:22:27', 2, 5, 'Holnap megbeszélés 8-kor'),
(9, '2020-01-17 09:05:22', 2, 1, 'Ma január 17-e van'),
(10, '2020-03-03 19:46:59', 2, 1, 'Ez egy fontos üzenet!\naábccsdeéfggyiíjkllymnnyoóöőpqrsszttyuúüűvwxyzzs'),
(11, '2020-03-03 19:52:09', 3, 5, 'Szia Alfonz'),
(12, '2020-03-03 19:53:14', 3, 1, 'Ezt mindenkinek küldöm\nDóri');


/* END OF FILE -------------------------------------------------------------------*/

