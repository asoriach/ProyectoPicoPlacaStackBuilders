-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sysmed
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sysmed` ;

-- -----------------------------------------------------
-- Schema sysmed
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sysmed` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ecommerce` ;

-- -----------------------------------------------------
-- Schema ecommerce
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecommerce` DEFAULT CHARACTER SET utf8 ;
USE `sysmed` ;

-- -----------------------------------------------------
-- Table `sysmed`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysmed`.`paciente` (
  `id_pac` INT NOT NULL AUTO_INCREMENT,
  `nombre_pac` VARCHAR(45) NOT NULL,
  `apellido_pac` VARCHAR(45) NOT NULL,
  `identification_pac` VARCHAR(13) NULL,
  `fecha_nac_pac` DATE NULL,
  `direccion_pac` VARCHAR(100) NOT NULL,
  `telefono_pac` VARCHAR(45) NOT NULL,
  `correo_pac` VARCHAR(45) NOT NULL,
  `genero_pac` VARCHAR(45) NOT NULL,
  `seguro_pac` VARCHAR(45) NULL,
  PRIMARY KEY (`id_pac`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sysmed`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysmed`.`rol` (
  `idrol` INT NOT NULL AUTO_INCREMENT,
  `nombre_rol` VARCHAR(45) NOT NULL,
  `descripcion_rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sysmed`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysmed`.`usuario` (
  `id_usu` INT NOT NULL AUTO_INCREMENT,
  `nombre_usu` VARCHAR(45) NOT NULL,
  `clave_usu` VARCHAR(45) NOT NULL,
  `rol_idrol` INT NOT NULL,
  PRIMARY KEY (`id_usu`),
  INDEX `fk_usuario_rol_idx` (`rol_idrol` ASC),
  CONSTRAINT `fk_usuario_rol`
    FOREIGN KEY (`rol_idrol`)
    REFERENCES `sysmed`.`rol` (`idrol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sysmed`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysmed`.`doctor` (
  `id_doc` INT NOT NULL AUTO_INCREMENT,
  `nombre_doc` VARCHAR(45) NOT NULL,
  `apellido_doc` VARCHAR(45) NOT NULL,
  `especialidad_doc` VARCHAR(45) NOT NULL,
  `sucursal_doc` VARCHAR(45) NOT NULL,
  `horarior_doc` DATETIME NOT NULL,
  PRIMARY KEY (`id_doc`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sysmed`.`tipo_cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysmed`.`tipo_cita` (
  `id_tipo_cita` INT NOT NULL AUTO_INCREMENT,
  `nombre_tipo_cita` VARCHAR(45) NOT NULL,
  `cen_tipo_cita` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_cita`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sysmed`.`centro_atencion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysmed`.`centro_atencion` (
  `id_cen` INT NOT NULL,
  `nombre_cen` VARCHAR(45) NOT NULL,
  `ubicacion_cen` VARCHAR(45) NOT NULL,
  `sector_cen` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cen`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sysmed`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sysmed`.`cita` (
  `id_cita` INT NOT NULL AUTO_INCREMENT,
  `especialidad_cita` VARCHAR(45) NOT NULL,
  `fecha_cita` DATE NOT NULL,
  `tipo_cita_id_tipo_cita` INT NOT NULL,
  `paciente_id_pac` INT NOT NULL,
  PRIMARY KEY (`id_cita`),
  INDEX `fk_cita_tipo_cita1_idx` (`tipo_cita_id_tipo_cita` ASC),
  INDEX `fk_cita_paciente1_idx` (`paciente_id_pac` ASC),
  CONSTRAINT `fk_cita_tipo_cita1`
    FOREIGN KEY (`tipo_cita_id_tipo_cita`)
    REFERENCES `sysmed`.`tipo_cita` (`id_tipo_cita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_paciente1`
    FOREIGN KEY (`paciente_id_pac`)
    REFERENCES `sysmed`.`paciente` (`id_pac`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `ecommerce` ;

-- -----------------------------------------------------
-- Table `ecommerce`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`cliente` (
  `id_cli` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_per` VARCHAR(25) NOT NULL,
  `apellido_per` VARCHAR(25) NOT NULL,
  `identificacion_per` VARCHAR(13) NULL DEFAULT NULL,
  `fecha_nac_per` DATE NULL DEFAULT NULL,
  `direccion_per` VARCHAR(45) NOT NULL,
  `telefono_per` VARCHAR(10) NOT NULL,
  `correo_per` VARCHAR(45) NOT NULL,
  `cuota_ven_cli` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id_cli`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`factura` (
  `id_fac` INT(11) NOT NULL AUTO_INCREMENT,
  `fac_numero` VARCHAR(16) NULL DEFAULT NULL,
  `fecha_fac` DATE NOT NULL,
  `subtotal_fac` DECIMAL(10,2) NOT NULL,
  `iva_fac` DECIMAL(10,2) NOT NULL,
  `total_fac` DECIMAL(10,2) NOT NULL,
  `id_cli` INT(11) NOT NULL,
  PRIMARY KEY (`id_fac`),
  INDEX `fk_factura_cliente1_idx` (`id_cli` ASC),
  CONSTRAINT `fk_factura_cliente1`
    FOREIGN KEY (`id_cli`)
    REFERENCES `ecommerce`.`cliente` (`id_cli`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`tipo_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`tipo_producto` (
  `id_tip_pro` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_tip_pro` VARCHAR(25) NOT NULL COMMENT 'Nombre del Tipo Producto',
  `descripcion_tip_pro` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tip_pro`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`producto` (
  `id_pro` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_pro` VARCHAR(25) NOT NULL,
  `descripcion_pro` VARCHAR(200) NULL DEFAULT NULL,
  `precio_pro` DECIMAL(10,2) NULL DEFAULT NULL,
  `id_tip_pro` INT(11) NOT NULL,
  PRIMARY KEY (`id_pro`),
  INDEX `fk_producto_tipo_producto_idx` (`id_tip_pro` ASC),
  CONSTRAINT `fk_producto_tipo_producto`
    FOREIGN KEY (`id_tip_pro`)
    REFERENCES `ecommerce`.`tipo_producto` (`id_tip_pro`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`proveedor` (
  `id_prov` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_per` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_prov`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`proveedor_has_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`proveedor_has_producto` (
  `id_prov` INT(11) NOT NULL,
  `id_pro` INT(11) NOT NULL,
  PRIMARY KEY (`id_prov`, `id_pro`),
  INDEX `fk_proveedor_has_producto_producto1_idx` (`id_pro` ASC),
  INDEX `fk_proveedor_has_producto_proveedor1_idx` (`id_prov` ASC),
  CONSTRAINT `fk_proveedor_has_producto_producto1`
    FOREIGN KEY (`id_pro`)
    REFERENCES `ecommerce`.`producto` (`id_pro`),
  CONSTRAINT `fk_proveedor_has_producto_proveedor1`
    FOREIGN KEY (`id_prov`)
    REFERENCES `ecommerce`.`proveedor` (`id_prov`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`detalle_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`detalle_factura` (
  `id_detfac` INT(11) NOT NULL AUTO_INCREMENT,
  `id_fac` INT(11) NOT NULL,
  `can_detfac` INT(11) NOT NULL,
  `obs_detfac` INT(11) NOT NULL,
  `subtotal_detfac` DECIMAL(10,2) NOT NULL,
  `total_detfac` DECIMAL(10,2) NOT NULL,
  `detalle_facturacol` VARCHAR(45) NULL DEFAULT NULL,
  `iva_decfac` INT(11) NULL DEFAULT NULL,
  `proveedor_has_producto_id_prov` INT(11) NOT NULL,
  `proveedor_has_producto_id_pro` INT(11) NOT NULL,
  PRIMARY KEY (`id_detfac`),
  INDEX `fk_detalle_factura_factura1_idx` (`id_fac` ASC),
  INDEX `fk_detalle_factura_proveedor_has_producto1_idx` (`proveedor_has_producto_id_prov` ASC, `proveedor_has_producto_id_pro` ASC),
  CONSTRAINT `fk_detalle_factura_factura1`
    FOREIGN KEY (`id_fac`)
    REFERENCES `ecommerce`.`factura` (`id_fac`),
  CONSTRAINT `fk_detalle_factura_proveedor_has_producto1`
    FOREIGN KEY (`proveedor_has_producto_id_prov` , `proveedor_has_producto_id_pro`)
    REFERENCES `ecommerce`.`proveedor_has_producto` (`id_prov` , `id_pro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`rol` (
  `id_rol` INT(11) NOT NULL,
  `nombre_rol` VARCHAR(45) NOT NULL,
  `descripcion_rol` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`usuario` (
  `id_usu` INT(11) NOT NULL,
  `nombre_usu` VARCHAR(10) NOT NULL,
  `clave_usu` VARCHAR(10) NOT NULL,
  `id_rol` INT(11) NOT NULL,
  PRIMARY KEY (`id_usu`),
  INDEX `fk_usuario_rol1_idx` (`id_rol` ASC),
  CONSTRAINT `fk_usuario_rol1`
    FOREIGN KEY (`id_rol`)
    REFERENCES `ecommerce`.`rol` (`id_rol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ecommerce`.`table1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`table1` (
)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
