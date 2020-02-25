/* START OF FILE -----------------------------------------------------------------*/


/* CLEAR ALL DATAS ---------------------------------------------------------------*/

DELETE FROM `kkv_company_datas`;
ALTER TABLE `kkv_company_datas` AUTO_INCREMENT = 1;
DELETE FROM `kkv_message_records`;
ALTER TABLE `kkv_message_records` AUTO_INCREMENT = 1;
DELETE FROM `kkv_tool_records`;
ALTER TABLE `kkv_tool_records` AUTO_INCREMENT = 1;
DELETE FROM `kkv_user_datas`;
ALTER TABLE `kkv_user_datas` AUTO_INCREMENT = 1;
DELETE FROM `kkv_user_groups`;
ALTER TABLE `kkv_user_groups` AUTO_INCREMENT = 1;
DELETE FROM `kkv_tool_datas`;
ALTER TABLE `kkv_tool_datas` AUTO_INCREMENT = 1;
DELETE FROM `kkv_tool_groups`;
ALTER TABLE `kkv_tool_groups` AUTO_INCREMENT = 1;


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
INSERT INTO `kkv_user_groups` VALUES(NULL, 'shopper', 'shoppermysql');
INSERT INTO `kkv_user_groups` VALUES(NULL, 'accountant', 'accountantmysql');


/*            USERS --------------------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV USER DATAS                        */
/* NAME, BIRTHDAY, USERGROUP             */
/* PASSWORD MD5 WITH 128-bit checksum    */

INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Super User', '1960-01-01', MD5('superuserpassword'), 2 );

INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Dana Dóra', '1975-01-01', MD5('employee1password'), 3 );
INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Dózsa Dávid', '1985-01-01', MD5('employee2password'), 3 );
INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Albert Alfonz', '1960-01-01', MD5('directorpassword'), 4 );
INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Bálint Béla', '1990-01-01', MD5('shopperpassword'), 5 );
INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`)
    VALUES ('Cinka Cecília', '1970-01-01', MD5('accountantpassword'), 6);


/* TOOLGROUPS                 ----------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV TOOLGROUPS:                       */
/*                                       */

INSERT INTO `kkv_tool_groups` VALUES(NULL, 'bútorok');
INSERT INTO `kkv_tool_groups` VALUES(NULL, 'irodaszerek');
INSERT INTO `kkv_tool_groups` VALUES(NULL, 'szoftverek');
INSERT INTO `kkv_tool_groups` VALUES(NULL, 'hardverek');
INSERT INTO `kkv_tool_groups` VALUES(NULL, 'egyéb');


/*             TOOLS          ----------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV TOOL DATAS                        */
/* NAME, TOOLGROUP                       */

INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('asztal', 1, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('szék', 1, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('virágállvány', 1, 2 );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('falikép', 1, 2 );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('fotel', 1, 4 );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('toll', 2, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('ceruza', 2, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('radír', 2, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('vonalzó', 2, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('számológép', 2, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('Windows 10', 3, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('Office 365', 3, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('Archicad', 3, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('plotter', 4, 2 );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('desktop', 4, DEFAULT );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('printer', 4, 2 );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('szerver', 4, 2 );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('switch', 4, 4 );
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`,`tool_min_quantity`) VALUES ('router', 4, 2 );


/*                    RECORDS ----------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV RECORDS                           */
/* TOOL, QUANTITY                        */

/*                    RECORDS - NOTES --------------------------------------------*/

INSERT INTO `kkv_message_records` (`reporter`, `receiver`, `message`) 
    VALUES (1, 1, 'Az adatbázis elkészült');
INSERT INTO `kkv_message_records` (`reporter`, `receiver`, `message`) 
    VALUES (1, 1, 'Felhasználói szintek bejegyzésre kerültek');
INSERT INTO `kkv_message_records` (`reporter`, `receiver`, `message`) 
    VALUES (1, 1, 'Alkalmazottak listája elkészült');

/*                    RECORDS - TOOLS --------------------------------------------*/

INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 1, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 1, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 1, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 1, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 1, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 1, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 2, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 3, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 3, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 3, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 3, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 3, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 3, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 3, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 4, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 4, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 4, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 4, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 5, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 6, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 6, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 6, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 6, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 6, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 6, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 6, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 7, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 8, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 9, 12000, 'induló készlet');
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (1, 10, 12000, 'induló készlet');



/* END OF FILE -------------------------------------------------------------------*/

