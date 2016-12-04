USE person_info;
DROP TABLE IF EXISTS person;

CREATE TABLE person (
    id            int          NOT NULL AUTO_INCREMENT,  
    first_name    varchar(24)  NOT NULL,
    last_name     varchar(24)  NOT NULL,
    phone_number  varchar(16)  NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO person (first_name, last_name, phone_number) VALUES ('Patty', 'Smith', '+3584561234');
INSERT INTO person (first_name, last_name, phone_number) VALUES ('Sally', 'Jones', '+3581236789');
INSERT INTO person (first_name, last_name, phone_number) VALUES ('John', 'Algor', '+3589874321');
INSERT INTO person (first_name, last_name, phone_number) VALUES ('Mandy', 'Baskel', '+3581235689');

