DROP TABLE IF EXISTS alumne;
CREATE TABLE alumne (
    id      INT         NOT NULL  AUTO_INCREMENT,
    nom     VARCHAR(25) NOT NULL,
    curs     VARCHAR(25) ,
    nota    INT,
    PRIMARY KEY (id)
);