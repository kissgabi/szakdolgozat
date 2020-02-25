/* B6KKV DB QUERIES                      */
/* INSERT INTO                           */
/* USER GROUPS & USER DATAS              */
/* TOOL GROUPS & TOOL DATAS              */
/* RECORDS -tool -notes                  */

/* új felhasználói szint meghatározása   */
INSERT INTO `kkv_user_groups` ('NULL', ?, ?);
INSERT INTO `kkv_user_groups` (`usergroup_name`, `usergroup_password`) 
    VALUES (?, ?);

/* új felhasználó felvétele              */
INSERT INTO `kkv_user_datas` ('NULL', ?, ?, ?, ?);
INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`) 
    VALUES (?, ?, ?, ?);

/* felhasználói jog visszavonása         */
INSERT INTO `kkv_user_datas` ('NULL', ?, ?, 'NULL', 'NULL');
INSERT INTO `kkv_user_datas` (`user_name`, `user_birthday`,`user_password`, `usergroup`) 
    VALUES (?, ?, 'NULL', 'NULL');

/* új eszköz csoport meghatározása       */
INSERT INTO `kkv_tool_groups` ('NULL', ?);
INSERT INTO `kkv_tool_groups` (`toolgroup_name`) 
    VALUES (?);

/* új eszköz meghatározása               */
INSERT INTO `kkv_tool_datas` ('NULL', ?, ?);
INSERT INTO `kkv_tool_datas` (`tool_name`, `toolgroup`) 
    VALUES (?, ?);

/* új eszköz leltárba vétele             */
INSERT INTO `kkv_tool_records` ('NULL', DEFAULT, 'NULL', ?, ?, ?, ?);
INSERT INTO `kkv_tool_records` (`reporter`, `tool`, `price`, `notes`) 
    VALUES (?, ?, ?, ?);

/* új feljegyzés rögzítése               */
INSERT INTO `kkv_message_records` ('NULL', DEFAULT, ?, ?, ?);
INSERT INTO `kkv_message_records` (`reporter`, `receiver`, `message`) 
    VALUES (?, ?, ?);


/* B6KKV DB QUERIES                      */
/* UPDATE                                */
/* USER DATAS -user_password -usergroup  */
/* RECORDS -rollout                      */

/* új felhasználói jelszó rögzítése     */
UPDATE `kkv_user_datas` SET `user_password` = ? WHERE `user_key` = ?;
/* felhasználó beosztás megváltoztatása  */
UPDATE `kkv_user_datas` SET `usergroup` = ? WHERE `user_key` = ?;

/* eszköz selejtezése                    */
UPDATE `kkv_records` SET `reciever` = ?, `rollout` = NOW() WHERE `record_key` = ? AND `reciever` = 'NULL';


/* B6KKV DB QUERIES                      */
/* SELECT                                */
/* USER GROUPS & USER DATAS              */
/* TOOL GROUPS & TOOL DATAS              */
/* RECORDS -tools -notes                 */

/* felhasználói szintek listája          */
SELECT `usergroup_name` AS 'Felhasználói csoportok' FROM `kkv_user_groups` ORDER BY `usergroup_key`;

/* felhasználók listája - névsor         */
SELECT `user_name` AS 'Felhasználók' FROM `kkv_user_datas` 
    ORDER BY `user_name`;
/* felhasználók listája - születésnap    */
SELECT `user_name` AS 'Felhasználók', user_birthday AS 'Születésnap' FROM `kkv_user_datas` 
    ORDER BY `user_name`;
/* felhasználók listája - beosztás       */
SELECT usergroup_name AS 'Beosztás', `user_name` AS 'Felhasználók' FROM `kkv_user_datas` 
    JOIN `kkv_user_groups` ON `usergroup` = `usergroup_key`
    ORDER BY `usergroup_key`, `user_name`;

/* eszköz csoportok listája              */
SELECT `toolgroup_name` AS 'Eszköz csoportok' FROM `kkv_tool_groups` ORDER BY `toolgroup_key`;


/* a leltárban lévő eszközök listája     */
/* összes                                */
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
    GROUP BY `tool_key`
    ORDER BY `toolgroup_key`, `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `toolgroup` = ?
    GROUP BY `tool_key` 
    ORDER BY `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `tool` = ?
    GROUP BY `tool_key` ;


/* a leltárban lévő eszközök listája     */
/* személyhez nem köthető                */
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `tool_min_quantity` IS NOT NULL
    GROUP BY `tool_key` 
    ORDER BY `toolgroup`_key, `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `tool_min_quantity` IS NOT NULL
        AND `toolgroup` = ?
    GROUP BY `tool_key` 
    ORDER BY `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `tool_min_quantity` IS NOT NULL
        AND `tool` = ?
    GROUP BY `tool_key` ;


/* a leltárban lévő eszközök listája     */
/* személyhez köthető                    */
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `tool_min_quantity` IS NULL
    GROUP BY `tool_key` 
    ORDER BY `toolgroup`_key, `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `tool_min_quantity` IS NULL
        AND `toolgroup` = ?
    GROUP BY `tool_key` 
    ORDER BY `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `tool_min_quantity` IS NULL
        AND `tool` = ?
    GROUP BY `tool_key` ;


/* a kifogyó eszközök listája            */
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`,
                `tool_name` AS 'Eszköz',
                COUNT ( `tool` )  AS 'Leltárban (db)',
                IF (`tool_min_quantity`,
                    `tool_min_quantity` - COUNT ( `tool` ) ,
                    (SELECT COUNT(*) FROM `kkv_user_datas` ) + 2 - COUNT ( `tool` ) 
                   ) AS 'Hiányzik (db)'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
    GROUP BY `tool_key` , `tool_min_quantity`
    HAVING COUNT ( `tool` )  < ( SELECT COUNT(*) FROM `kkv_user_datas` ) + 2
        OR `tool_min_quantity` > COUNT ( `tool` ) 
    ORDER BY `toolgroup`_key, `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`,
                `tool_name` AS 'Eszköz',
                COUNT ( `tool` )  AS 'Leltárban (db)',
                IF (`tool_min_quantity`,
                    `tool_min_quantity` - COUNT ( `tool` ) ,
                    (SELECT COUNT(*) FROM `kkv_user_datas` ) + 2 - COUNT ( `tool` ) 
                   ) AS 'Hiányzik (db)'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `toolgroup` = ?
    GROUP BY `tool_key` , `tool_min_quantity`
    HAVING COUNT ( `tool` )  < ( SELECT COUNT(*) FROM `kkv_user_datas` ) + 2
        OR `tool_min_quantity` > COUNT ( `tool` ) 
    ORDER BY `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`,
                `tool_name` AS 'Eszköz',
                COUNT ( `tool` )  AS 'Leltárban (db)',
                IF (`tool_min_quantity` ,
                    `tool_min_quantity` - COUNT ( `tool` ) ,
                    (SELECT COUNT(*) FROM `kkv_user_datas` ) + 2 - COUNT ( `tool` ) 
                   ) AS 'Hiányzik (db)'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NULL
        AND `tool_key`  = ?
    GROUP BY `tool_key` , `tool_min_quantity`
    HAVING COUNT ( `tool` )  < ( SELECT COUNT(*) FROM `kkv_user_datas` ) + 2
        OR `tool_min_quantity` > COUNT ( `tool` ) 


/* a kiselejtezett eszközök listája     */
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NOT NULL
    GROUP BY `tool_key` 
    ORDER BY `toolgroup`_key, `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NOT NULL
        AND `toolgroup` = ?
    GROUP BY `tool_key` 
    ORDER BY `tool_name`;
SELECT DISTINCT `toolgroup_name` AS `Eszköz csoport`, `tool_name` AS 'Eszköz', COUNT ( `tool` )  AS 'db'
    FROM `kkv_tool_datas` 
    JOIN `kkv_tool_groups` ON `toolgroup` = `toolgroup_key`
    LEFT JOIN `kkv_tool_records` ON `tool` = `tool_key`
    WHERE `rollout` IS NOT NULL
        AND `tool` = ?
    GROUP BY `tool_key` ;


/* feljegyzések listája -boss, -owner    */
SELECT  `recorded` AS `Időpont`, 
        `message` AS `Feljegyzés`, 
        (SELECT `user_name` FROM `kkv_user_datas` WHERE `user_key` = `reporter` ) AS `Rögzítette`, 
        (SELECT `user_name` FROM `kkv_user_datas` WHERE `user_key` = `receiver` ) AS `Címzett`
    FROM `kkv_message_records`
    ORDER BY `recorded` DESC;
SELECT  `recorded` AS `Időpont`, 
        `message` AS `Feljegyzés`, 
        (SELECT `user_name` FROM `kkv_user_datas` WHERE `user_key` = `reporter` ) AS `Rögzítette`, 
        (SELECT `user_name` FROM `kkv_user_datas` WHERE `user_key` = `receiver` ) AS `Címzett`
    FROM `kkv_message_records`
    WHERE `reporter` = ? OR `receiver` = ?
    ORDER BY `recorded` DESC;

/* vásárlások listája -boss, -owner      */
SELECT `recorded` AS `Vásárlás`, `rollout` AS `Selejtezés`,
    `tool_name` AS `Eszköz`, `user_name` AS `Beszerző`, notes AS `Megjegyzés`
    FROM `kkv_tool_records`
    JOIN `kkv_user_datas` ON `reporter` = `user_key` 
    JOIN `kkv_tool_datas` ON `tool` = `tool_key`
    ORDER BY `recorded` DESC;
SELECT `recorded` AS `Vásárlás`, `rollout` AS `Selejtezés`,
    `tool_name` AS `Eszköz`, `user_name` AS `Beszerző`, notes AS `Megjegyzés`
    FROM `kkv_tool_records`
    JOIN `kkv_user_datas` ON `reporter` = `user_key`
    JOIN `kkv_tool_datas` ON  `tool` = `tool_key`
    WHERE `reporter` = ?
    ORDER BY `recorded` DESC;



