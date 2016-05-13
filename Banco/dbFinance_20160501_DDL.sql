/* 
*  Autor - Adriano
*  MySQL - 2016-05-01 09:09:43
*  2016-04-26 07:51:31
*/ 
CREATE DATABASE IF NOT EXISTS `dbFinance`
    DEFAULT CHARACTER SET utf8
    DEFAULT COLLATE utf8_general_ci;

USE `dbFinance`;



/* 
*  movimentos
*  2016-04-26 07:52:15
*/ 
DROP TABLE IF EXISTS `movimentos`;
CREATE TABLE IF NOT EXISTS `movimentos` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `titulo` VARCHAR(50) COLLATE utf8_general_ci,
    `descricao` TEXT(100) NOT NULL,
    `vencimento` DATE,
    `valor` NUMERIC(10,2),
    `categoria_id` INTEGER(10),
    `tipo_lancamento` TINYINT(1) DEFAULT '0',
    `conta_fixa` TINYINT(1) DEFAULT '0' NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=1 ;



/* 
*  categoria
*  2016-04-26 07:52:27
*/ 
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(20) COLLATE utf8_general_ci,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=1 ;



/* 
*  lanc_freq
*  2016-04-26 08:04:35
*/ 
DROP TABLE IF EXISTS `lanc_freq`;
CREATE TABLE IF NOT EXISTS `lanc_freq` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `lancamento_id` INTEGER(10),
    `periodo` VARCHAR(20) COLLATE utf8_general_ci,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=1 ;