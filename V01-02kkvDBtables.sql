/* START OF FILE -----------------------------------------------------------------*/


/* DROP TABLES -------------------------------------------------------------------*/

/* DROP TABLES IF THEY EXIST             */
DROP TABLE IF EXISTS `kkv_message_records`;
DROP TABLE IF EXISTS `kkv_company_datas`;
DROP TABLE IF EXISTS `kkv_user_datas`;
DROP TABLE IF EXISTS `kkv_user_groups`;


/* COMPANY DATAS -----------------------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV COMPANY DATAS:                    */
/* NAME, ADDRESS, PHONES, MAIL           */
CREATE TABLE `kkv_company_datas` (
  name VARCHAR(60) NOT NULL,
  zipcode INT NOT NULL,
  address1 VARCHAR(60) NOT NULL,
  address2 VARCHAR(60) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  fax VARCHAR(20) NOT NULL,
  mobile VARCHAR(20) NOT NULL,
  email VARCHAR(60) NOT NULL,
  superuser INT DEFAULT 2
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;


/* USEGROUPS        --------------------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV USERGROUPS:                       */
/* USER PRIVILEGES AND MYSQL GRANTS      */
CREATE TABLE `kkv_user_groups` (
  usergroup_key INT AUTO_INCREMENT, 
  usergroup_name VARCHAR(40) NOT NULL, 
  usergroup_password varchar(255) NOT NULL,
  CONSTRAINT pk_usergroup PRIMARY KEY (usergroup_key)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;


/*            USERS --------------------------------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV USER DATAS                        */
/* NAME, BIRTHDAY, USERGROUP             */
CREATE TABLE `kkv_user_datas` (
  user_key INT AUTO_INCREMENT,
  user_name VARCHAR(40) NOT NULL,
  user_birthday DATE NOT NULL,
  user_password varchar(255) NOT NULL,
  usergroup INT,
  CONSTRAINT pk_user PRIMARY KEY (user_key, user_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

/* SET FOREIGN KEY IN KKV USER DATAS     */
ALTER TABLE `kkv_user_datas` ADD FOREIGN KEY(usergroup) 
  REFERENCES `kkv_user_groups`(usergroup_key);


/*                    RECORDS - MESSAGES --------------------------------------*/

/* KKV SAMPLE DATABASE 2019-2020         */
/* KKV RECORDS                           */
/* TOOL, QUANTITY                        */
CREATE TABLE `kkv_message_records` (
  record_key INT AUTO_INCREMENT,
  recorded DATETIME DEFAULT CURRENT_TIMESTAMP,
  reporter INT NOT NULL,
  receiver INT,
  message TEXT, 
  CONSTRAINT pk_comment PRIMARY KEY (record_key)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

/* SET FOREIGN KEY IN KKV COMMENT       */
ALTER TABLE `kkv_message_records` ADD FOREIGN KEY(reporter)
  REFERENCES `kkv_user_datas`(user_key);


/* END OF FILE -------------------------------------------------------------------*/

