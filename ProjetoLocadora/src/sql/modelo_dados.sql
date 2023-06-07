-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema locadora
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema locadora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `locadora` DEFAULT CHARACTER SET utf8 ;
USE `locadora` ;

-- -----------------------------------------------------
-- Table `locadora`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`Cliente` (
  `id` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`filme` (
  `id` INT NOT NULL,
  `nomeFilme` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`Emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`Emprestimo` (
  `id` INT NOT NULL,
  `dataEmpre` DATE NOT NULL,
  `dataDev` DATE NOT NULL,
  `desc` VARCHAR(100) NOT NULL,
  `Cliente_id` INT NOT NULL,
  `filme_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Emprestimo_Cliente1_idx` (`Cliente_id` ASC) VISIBLE,
  INDEX `fk_Emprestimo_filme1_idx` (`filme_id` ASC) VISIBLE,
  CONSTRAINT `fk_Emprestimo_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `locadora`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Emprestimo_filme1`
    FOREIGN KEY (`filme_id`)
    REFERENCES `locadora`.`filme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
