-- Ensure the 'patient' table exists
CREATE TABLE IF NOT EXISTS USERS
(
    id       LONG  PRIMARY KEY,
    username VARCHAR(255)    NOT NULL,
    password VARCHAR(255)        NOT NULL,
    role     VARCHAR(255)        NOT NULL
);

INSERT INTO USERS (id, username, password,role)
SELECT '1',
       'admin',
       'admin',
       'ADMIN'
WHERE NOT EXISTS (SELECT 1
                  FROM users
                  WHERE id = '1');
