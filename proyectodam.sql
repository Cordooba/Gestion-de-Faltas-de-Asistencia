-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-03-2014 a las 11:07:59
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyectodam`
--
CREATE DATABASE IF NOT EXISTS `proyectodam` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proyectodam`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `ID_ALUMNO` int(11) NOT NULL DEFAULT '0',
  `CURSO` varchar(10) DEFAULT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `APELLIDO` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID_ALUMNO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`ID_ALUMNO`, `CURSO`, `NOMBRE`, `APELLIDO`) VALUES
(1, '1 DAM', 'Alejandro ', 'Córdoba Muñoz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `faltas`
--

CREATE TABLE IF NOT EXISTS `faltas` (
  `ID_MODULO` int(11) NOT NULL DEFAULT '0',
  `ID_ALUMNO` int(11) NOT NULL DEFAULT '0',
  `HORAS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ALUMNO`,`ID_MODULO`),
  KEY `ID_MODULO` (`ID_MODULO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `faltas`
--

INSERT INTO `faltas` (`ID_MODULO`, `ID_ALUMNO`, `HORAS`) VALUES
(1, 1, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulos`
--

CREATE TABLE IF NOT EXISTS `modulos` (
  `ID_MODULO` int(11) NOT NULL DEFAULT '0',
  `CURSO` varchar(10) DEFAULT NULL,
  `NOMBRE` varchar(40) DEFAULT NULL,
  `SIGLAS` varchar(6) DEFAULT NULL,
  `HORAS` int(5) DEFAULT NULL,
  `PORCENTAJE` int(2) DEFAULT NULL,
  PRIMARY KEY (`ID_MODULO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `modulos`
--

INSERT INTO `modulos` (`ID_MODULO`, `CURSO`, `NOMBRE`, `SIGLAS`, `HORAS`, `PORCENTAJE`) VALUES
(1, '1 DAM', 'Programacion', 'PR', 250, 15);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `faltas`
--
ALTER TABLE `faltas`
  ADD CONSTRAINT `faltas_ibfk_1` FOREIGN KEY (`ID_MODULO`) REFERENCES `modulos` (`ID_MODULO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `faltas_ibfk_2` FOREIGN KEY (`ID_ALUMNO`) REFERENCES `alumnos` (`ID_ALUMNO`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
