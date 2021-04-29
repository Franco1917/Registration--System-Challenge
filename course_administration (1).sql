-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-04-2021 a las 20:30:49
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `course_administration`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authorities_users`
--

CREATE TABLE `authorities_users` (
  `usuario_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `authorities_users`
--

INSERT INTO `authorities_users` (`usuario_id`, `authority_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authority`
--

CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL,
  `authority` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `authority`
--

INSERT INTO `authority` (`id`, `authority`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscriptions`
--

CREATE TABLE `inscriptions` (
  `id` bigint(20) NOT NULL,
  `class_id` bigint(20) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `student_dni` int(11) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inscriptions`
--

INSERT INTO `inscriptions` (`id`, `class_id`, `class_name`, `student_dni`, `student_name`) VALUES
(13, 1, '1', 33059359, 'Franco'),
(14, 2, '2', 33059359, 'Franco'),
(15, 2, 'History', 33059359, 'Franco'),
(21, 20, 'Magic', 99999999, 'Rusell'),
(22, 20, 'Magic', 444444, 'Potter'),
(23, 1, 'Math', 3453435, 'Stark'),
(26, 25, 'Fisics', 33059359, 'Lategano');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subject`
--

CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quota` int(11) DEFAULT NULL,
  `schedule` varchar(255) DEFAULT NULL,
  `teacher` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `subject`
--

INSERT INTO `subject` (`id`, `name`, `quota`, `schedule`, `teacher`) VALUES
(1, 'Math', 50, 'morning', 'Adams'),
(2, 'History', 50, 'night', 'Smith'),
(20, 'Magic', 50, 'night', 'Snape'),
(25, 'Fisics', 30, 'nigth', 'Einstein'),
(17, 'Science', 50, 'afternoon', 'Deniro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teacher`
--

CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL,
  `dni` int(11) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `teacher`
--

INSERT INTO `teacher` (`id`, `dni`, `enabled`, `name`, `surname`) VALUES
(1, 232324, b'1', 'John', 'Smith'),
(16, 33333333, b'1', 'Robert', 'Deniro'),
(18, 44444444, b'1', 'Steve', 'Rogers'),
(19, 99999999, b'1', 'Severus', 'Snape'),
(24, 88888888, b'1', 'Albert ', 'Einstein');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `enabled`, `name`, `password`, `surname`, `username`, `dni`) VALUES
(1, b'1', 'administrator', '$2a$04$uV4LuCfAgbN59rfqpNpPm.vaATwchHOmRu9KvyemZHuxAfBaCOIbG', 'administrator', 'admin', 0),
(2, b'1', 'Franco', '$2a$04$jtW8vSMV9wEmSXPdHTSqruvGfeC2j9gWqrHw7UroLZY68w6YG2Ybu', 'Lategano', 'FLATEGANO', 33059359),
(3, b'1', 'Juan', '$2a$04$0wwsqop/bpYnS6KA6FFPUuBRBz9wx3p9AicNamwZY8p.dgizBNYXq', 'Baltazar', 'JBALTAZAR', 77777777),
(4, b'1', 'Jose', '$2a$04$YkSBm3flZRT.dX5X83Jv4OtRm2R7HCXF8PUV6NZlHY7yeiPh62/QO', 'Font', 'CFONT', 11111111),
(5, b'1', 'Miguel', '$2a$04$Msr8KCN8IOMNOqliTEg9Zuyi2PAEmE45MTwFgCHyNOXJqqaTWBz1O', 'Baltazar', 'MBALTAZAR', 22222222),
(6, b'1', 'Carlos', '$2a$04$WGwH4sl4lLVoL.Nzx0xJUetRtVLwCYDV/O9Yja8dybK8yewDjCFK2', 'Baltazar', 'CBALTAZAR', 33333333),
(7, b'1', 'Esteban', '$2a$04$pv0vOYtknsU5Y3UeNoP4k.SGH7ZOXGTHA9LSG1aTqfJsui3vXEtwK', 'Trujillo', 'ETRUJILLO', 44444444),
(8, b'1', 'Alejo', '$2a$04$fH6Hij435DLPLChBcva3/OJTqaKi7lMMAh5OByNqOafdmpvud0py2', 'Charles', 'ACHARLES', 55555555);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `authorities_users`
--
ALTER TABLE `authorities_users`
  ADD PRIMARY KEY (`usuario_id`,`authority_id`),
  ADD KEY `FK1hk335nyb5icwqy64y2mhov2v` (`authority_id`);

--
-- Indices de la tabla `authority`
--
ALTER TABLE `authority`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `inscriptions`
--
ALTER TABLE `inscriptions`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `subject`
--
ALTER TABLE `subject`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
