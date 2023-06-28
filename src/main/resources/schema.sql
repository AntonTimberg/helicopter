CREATE TABLE drone(
    id BIGINT NOT NULL AUTO_INCREMENT,
    serial_number VARCHAR(100) NOT NULL,
    model VARCHAR(25) NOT NULL,
    load INTEGER NOT NULL,
    battery_level INTEGER NOT NULL,
    status VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);