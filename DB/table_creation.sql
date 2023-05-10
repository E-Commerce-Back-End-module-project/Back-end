
drop table backend.products_color ;
drop table backend.products ;
DROP TABLE BACKEND.CATEGORY CASCADE;
DROP TABLE BACKEND.COLOR CASCADE;
-- DROP TABLE BACKEND.Size CASCADE;


drop schema BackEnd;
CREATE SCHEMA BackEnd;

CREATE TABLE IF NOT EXISTS `BackEnd`.`Category` (
  `id_category` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_category`),
  UNIQUE INDEX `id_category_UNIQUE` (`id_category` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `BackEnd`.`Color` (
  `id_color` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_color`))
ENGINE = InnoDB

-- CREATE TABLE IF NOT EXISTS `BackEnd`.`size` (
--   `idSize` BIGINT NOT NULL AUTO_INCREMENT,
--   `size` VARCHAR(45) NULL,
--   PRIMARY KEY (`idSize`))
-- ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `BackEnd`.`Products` (
  `id_Products` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Price` DOUBLE NULL,
  `Description` VARCHAR(500) NULL,
  `id_category` BIGINT NULL,
  PRIMARY KEY (`id_Products`),
  UNIQUE INDEX `idProducts_UNIQUE` (`id_Products` ASC) VISIBLE,
  INDEX `id_category_idx` (`id_category` ASC) VISIBLE,
  CONSTRAINT `id_category`
    FOREIGN KEY (`id_category`)
    REFERENCES `BackEnd`.`Category` (`id_category`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `BackEnd`.`products_color` (
  `id_products` BIGINT NOT NULL,
  `id_color` BIGINT NOT NULL,
  PRIMARY KEY (`id_products`, `id_color`))
ENGINE = InnoDB;





