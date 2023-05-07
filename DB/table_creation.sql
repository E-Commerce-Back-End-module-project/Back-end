CREATE SCHEMA BackEnd;

drop table backend.products ;
DROP TABLE BACKEND.CATEGORY CASCADE;
DROP TABLE BACKEND.COLOR CASCADE;
DROP TABLE BACKEND.Size CASCADE;

CREATE TABLE IF NOT EXISTS `BackEnd`.`Category` (
  `idCategory` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategory`),
  UNIQUE INDEX `idCategory_UNIQUE` (`idCategory` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `BackEnd`.`Size` (
  `idSize` BIGINT NOT NULL AUTO_INCREMENT,
  `size` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`idSize`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `BackEnd`.`Color` (
  `idColor` BIGINT NOT NULL AUTO_INCREMENT,
  `Color` VARCHAR(45) NULL,
  PRIMARY KEY (`idColor`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `BackEnd`.`Products` (
  `idProducts` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Price` DECIMAL NOT NULL,
  `Description` VARCHAR(500) NULL,
  `idCategory` BIGINT NULL,
  `idColor` BIGINT NULL,
  `idSize` BIGINT NULL,
  PRIMARY KEY (`idProducts`),
  UNIQUE INDEX `idProducts_UNIQUE` (`idProducts` ASC) VISIBLE,
  INDEX `idCategory_idx` (`idCategory` ASC) VISIBLE,
  CONSTRAINT `idCategory`
    FOREIGN KEY (`idCategory`)
    REFERENCES `BackEnd`.`Category` (`idCategory`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `idColor`
    FOREIGN KEY (`idColor`)
    REFERENCES `BackEnd`.`Color` (`idColor`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `idSize`
    FOREIGN KEY (`idSize`)
    REFERENCES `BackEnd`.`Size` (`idSize`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;
