-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbfinance
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbfinance
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbfinance` DEFAULT CHARACTER SET utf8 ;
USE `dbfinance` ;

-- -----------------------------------------------------
-- Table `dbfinance`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbfinance`.`categoria` (
  `id_categoria` SMALLINT(6) NOT NULL AUTO_INCREMENT,
  `nome_categoria` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbfinance`.`movimentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbfinance`.`movimentos` (
  `id_movimento` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(50) NULL DEFAULT NULL,
  `descricao` VARCHAR(100) NULL DEFAULT NULL,
  `vencimento` DATE NULL DEFAULT NULL,
  `valor` DECIMAL(12,2) NULL DEFAULT NULL,
  `id_categoria` SMALLINT(10) NOT NULL,
  `tipo_lancamento` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_movimento`),
  INDEX `id_categoria` (`id_categoria` ASC),
  CONSTRAINT `movimentos_ibfk_1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `dbfinance`.`categoria` (`id_categoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dbfinance`.`lanc_freq`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbfinance`.`lanc_freq` (
  `id_lfreq` INT(11) NOT NULL AUTO_INCREMENT,
  `id_movimento` INT(11) NOT NULL,
  `periodo` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id_lfreq`),
  INDEX `id_movimento` (`id_movimento` ASC),
  CONSTRAINT `lanc_freq_ibfk_1`
    FOREIGN KEY (`id_movimento`)
    REFERENCES `dbfinance`.`movimentos` (`id_movimento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;