DROP DATABASE IF EXISTS bookdb;
DROP USER IF EXISTS `bookadmin`@`%`;
DROP USER IF EXISTS `bookuser`@`%`;
CREATE DATABASE IF NOT EXISTS bookdb character set utf8mb4 collate utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `bookadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `bookdb`.* TO `bookadmin`@`%`;
CREATE USER IF NOT EXISTS `bookuser`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW on `bookdb`.* TO `bookuser`@`%`;
FLUSH PRIVILEGES
