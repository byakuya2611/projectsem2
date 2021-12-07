-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2021 at 05:11 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie_ticket_group1_prjsem2`
--
CREATE DATABASE IF NOT EXISTS `movie_ticket_group1_prjsem2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `movie_ticket_group1_prjsem2`;

-- --------------------------------------------------------

--
-- Table structure for table `chair`
--

DROP TABLE IF EXISTS `chair`;
CREATE TABLE IF NOT EXISTS `chair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chair_name` varchar(16) NOT NULL,
  `chair_row` int(11) NOT NULL,
  `chair_column` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_chair_room` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=433 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chair`
--

INSERT INTO `chair` (`id`, `chair_name`, `chair_row`, `chair_column`, `room_id`) VALUES
(1, 'A9', 0, 0, 4),
(2, 'A8', 0, 1, 4),
(3, 'A7', 0, 2, 4),
(4, 'A6', 0, 3, 4),
(5, 'A5', 0, 4, 4),
(6, 'A4', 0, 5, 4),
(7, 'A3', 0, 6, 4),
(8, 'A2', 0, 7, 4),
(9, 'A1', 0, 8, 4),
(10, 'B9', 1, 0, 4),
(11, 'B8', 1, 1, 4),
(12, 'B7', 1, 2, 4),
(13, 'B6', 1, 3, 4),
(14, 'B5', 1, 4, 4),
(15, 'B4', 1, 5, 4),
(16, 'B3', 1, 6, 4),
(17, 'B2', 1, 7, 4),
(18, 'B1', 1, 8, 4),
(19, 'C9', 2, 0, 4),
(20, 'C8', 2, 1, 4),
(21, 'C7', 2, 2, 4),
(22, 'C6', 2, 3, 4),
(23, 'C5', 2, 4, 4),
(24, 'C4', 2, 5, 4),
(25, 'C3', 2, 6, 4),
(26, 'C2', 2, 7, 4),
(27, 'C1', 2, 8, 4),
(28, 'D9', 3, 0, 4),
(29, 'D8', 3, 1, 4),
(30, 'D7', 3, 2, 4),
(31, 'D6', 3, 3, 4),
(32, 'D5', 3, 4, 4),
(33, 'D4', 3, 5, 4),
(34, 'D3', 3, 6, 4),
(35, 'D2', 3, 7, 4),
(36, 'D1', 3, 8, 4),
(37, 'E9', 4, 0, 4),
(38, 'E8', 4, 1, 4),
(39, 'E7', 4, 2, 4),
(40, 'E6', 4, 3, 4),
(41, 'E5', 4, 4, 4),
(42, 'E4', 4, 5, 4),
(43, 'E3', 4, 6, 4),
(44, 'E2', 4, 7, 4),
(45, 'E1', 4, 8, 4),
(46, 'F9', 5, 0, 4),
(47, 'F8', 5, 1, 4),
(48, 'F7', 5, 2, 4),
(49, 'F6', 5, 3, 4),
(50, 'F5', 5, 4, 4),
(51, 'F4', 5, 5, 4),
(52, 'F3', 5, 6, 4),
(53, 'F2', 5, 7, 4),
(54, 'F1', 5, 8, 4),
(55, 'G8', 6, 1, 4),
(56, 'G7', 6, 2, 4),
(57, 'G6', 6, 3, 4),
(58, 'G5', 6, 4, 4),
(59, 'G4', 6, 5, 4),
(60, 'G3', 6, 6, 4),
(61, 'G2', 6, 7, 4),
(62, 'G1', 6, 8, 4),
(63, 'G9', 6, 0, 4),
(64, 'H9', 7, 0, 4),
(65, 'H8', 7, 1, 4),
(66, 'H7', 7, 2, 4),
(67, 'H5', 7, 3, 4),
(68, 'H5', 7, 4, 4),
(69, 'H4', 7, 5, 4),
(70, 'H3', 7, 6, 4),
(71, 'H2', 7, 7, 4),
(72, 'H1', 7, 8, 4),
(73, 'A9', 0, 0, 1),
(74, 'A8', 0, 1, 1),
(75, 'A7', 0, 2, 1),
(76, 'A6', 0, 3, 1),
(77, 'A5', 0, 4, 1),
(78, 'A4', 0, 5, 1),
(79, 'A3', 0, 6, 1),
(80, 'A2', 0, 7, 1),
(81, 'A1', 0, 8, 1),
(82, 'B9', 1, 0, 1),
(83, 'B8', 1, 1, 1),
(84, 'B7', 1, 2, 1),
(85, 'B6', 1, 3, 1),
(86, 'B5', 1, 4, 1),
(87, 'B4', 1, 5, 1),
(88, 'B3', 1, 6, 1),
(89, 'B2', 1, 7, 1),
(90, 'B1', 1, 8, 1),
(91, 'C9', 2, 0, 1),
(92, 'C8', 2, 1, 1),
(93, 'C7', 2, 2, 1),
(94, 'C6', 2, 3, 1),
(95, 'C5', 2, 4, 1),
(96, 'C4', 2, 5, 1),
(97, 'C3', 2, 6, 1),
(98, 'C2', 2, 7, 1),
(99, 'C1', 2, 8, 1),
(100, 'D9', 3, 0, 1),
(101, 'D8', 3, 1, 1),
(102, 'D7', 3, 2, 1),
(103, 'D6', 3, 3, 1),
(104, 'D5', 3, 4, 1),
(105, 'D4', 3, 5, 1),
(106, 'D3', 3, 6, 1),
(107, 'D2', 3, 7, 1),
(108, 'D1', 3, 8, 1),
(109, 'E9', 4, 0, 1),
(110, 'E8', 4, 1, 1),
(111, 'E7', 4, 2, 1),
(112, 'E6', 4, 3, 1),
(113, 'E5', 4, 4, 1),
(114, 'E4', 4, 5, 1),
(115, 'E3', 4, 6, 1),
(116, 'E2', 4, 7, 1),
(117, 'E1', 4, 8, 1),
(118, 'F9', 5, 0, 1),
(119, 'F8', 5, 1, 1),
(120, 'F7', 5, 2, 1),
(121, 'F6', 5, 3, 1),
(122, 'F5', 5, 4, 1),
(123, 'F4', 5, 5, 1),
(124, 'F3', 5, 6, 1),
(125, 'F2', 5, 7, 1),
(126, 'F1', 5, 8, 1),
(127, 'G9', 6, 0, 1),
(128, 'G8', 6, 1, 1),
(129, 'G7', 6, 2, 1),
(130, 'G6', 6, 3, 1),
(131, 'G5', 6, 4, 1),
(132, 'G4', 6, 5, 1),
(133, 'G3', 6, 6, 1),
(134, 'G2', 6, 7, 1),
(135, 'G1', 6, 8, 1),
(136, 'H9', 7, 0, 1),
(137, 'H8', 7, 1, 1),
(138, 'H7', 7, 2, 1),
(139, 'H5', 7, 3, 1),
(140, 'H5', 7, 4, 1),
(141, 'H4', 7, 5, 1),
(142, 'H3', 7, 6, 1),
(143, 'H2', 7, 7, 1),
(144, 'H1', 7, 8, 1),
(145, 'A9', 0, 0, 2),
(146, 'A8', 0, 1, 2),
(147, 'A7', 0, 2, 2),
(148, 'A6', 0, 3, 2),
(149, 'A5', 0, 4, 2),
(150, 'A4', 0, 5, 2),
(151, 'A3', 0, 6, 2),
(152, 'A2', 0, 7, 2),
(153, 'A1', 0, 8, 2),
(154, 'B9', 1, 0, 2),
(155, 'B8', 1, 1, 2),
(156, 'B7', 1, 2, 2),
(157, 'B6', 1, 3, 2),
(158, 'B5', 1, 4, 2),
(159, 'B4', 1, 5, 2),
(160, 'B3', 1, 6, 2),
(161, 'B2', 1, 7, 2),
(162, 'B1', 1, 8, 2),
(163, 'C9', 2, 0, 2),
(164, 'C8', 2, 1, 2),
(165, 'C7', 2, 2, 2),
(166, 'C6', 2, 3, 2),
(167, 'C5', 2, 4, 2),
(168, 'C4', 2, 5, 2),
(169, 'C3', 2, 6, 2),
(170, 'C2', 2, 7, 2),
(171, 'C1', 2, 8, 2),
(172, 'D9', 3, 0, 2),
(173, 'D8', 3, 1, 2),
(174, 'D7', 3, 2, 2),
(175, 'D6', 3, 3, 2),
(176, 'D5', 3, 4, 2),
(177, 'D4', 3, 5, 2),
(178, 'D3', 3, 6, 2),
(179, 'D2', 3, 7, 2),
(180, 'D1', 3, 8, 2),
(181, 'E9', 4, 0, 2),
(182, 'E8', 4, 1, 2),
(183, 'E7', 4, 2, 2),
(184, 'E6', 4, 3, 2),
(185, 'E5', 4, 4, 2),
(186, 'E4', 4, 5, 2),
(187, 'E3', 4, 6, 2),
(188, 'E2', 4, 7, 2),
(189, 'E1', 4, 8, 2),
(190, 'F9', 5, 0, 2),
(191, 'F8', 5, 1, 2),
(192, 'F7', 5, 2, 2),
(193, 'F6', 5, 3, 2),
(194, 'F5', 5, 4, 2),
(195, 'F4', 5, 5, 2),
(196, 'F3', 5, 6, 2),
(197, 'F2', 5, 7, 2),
(198, 'F1', 5, 8, 2),
(199, 'G9', 6, 0, 2),
(200, 'G8', 6, 1, 2),
(201, 'G7', 6, 2, 2),
(202, 'G6', 6, 3, 2),
(203, 'G5', 6, 4, 2),
(204, 'G4', 6, 5, 2),
(205, 'G3', 6, 6, 2),
(206, 'G2', 6, 7, 2),
(207, 'G1', 6, 8, 2),
(208, 'H9', 7, 0, 2),
(209, 'H8', 7, 1, 2),
(210, 'H7', 7, 2, 2),
(211, 'H5', 7, 3, 2),
(212, 'H5', 7, 4, 2),
(213, 'H4', 7, 5, 2),
(214, 'H3', 7, 6, 2),
(215, 'H2', 7, 7, 2),
(216, 'H1', 7, 8, 2),
(217, 'A9', 0, 0, 3),
(218, 'A8', 0, 1, 3),
(219, 'A7', 0, 2, 3),
(220, 'A6', 0, 3, 3),
(221, 'A5', 0, 4, 3),
(222, 'A4', 0, 5, 3),
(223, 'A3', 0, 6, 3),
(224, 'A2', 0, 7, 3),
(225, 'A1', 0, 8, 3),
(226, 'B9', 1, 0, 3),
(227, 'B8', 1, 1, 3),
(228, 'B7', 1, 2, 3),
(229, 'B6', 1, 3, 3),
(230, 'B5', 1, 4, 3),
(231, 'B4', 1, 5, 3),
(232, 'B3', 1, 6, 3),
(233, 'B2', 1, 7, 3),
(234, 'B1', 1, 8, 3),
(235, 'C9', 2, 0, 3),
(236, 'C8', 2, 1, 3),
(237, 'C7', 2, 2, 3),
(238, 'C6', 2, 3, 3),
(239, 'C5', 2, 4, 3),
(240, 'C4', 2, 5, 3),
(241, 'C3', 2, 6, 3),
(242, 'C2', 2, 7, 3),
(243, 'C1', 2, 8, 3),
(244, 'D9', 3, 0, 3),
(245, 'D8', 3, 1, 3),
(246, 'D7', 3, 2, 3),
(247, 'D6', 3, 3, 3),
(248, 'D5', 3, 4, 3),
(249, 'D4', 3, 5, 3),
(250, 'D3', 3, 6, 3),
(251, 'D2', 3, 7, 3),
(252, 'D1', 3, 8, 3),
(253, 'E9', 4, 0, 3),
(254, 'E8', 4, 1, 3),
(255, 'E7', 4, 2, 3),
(256, 'E6', 4, 3, 3),
(257, 'E5', 4, 4, 3),
(258, 'E4', 4, 5, 3),
(259, 'E3', 4, 6, 3),
(260, 'E2', 4, 7, 3),
(261, 'E1', 4, 8, 3),
(262, 'F9', 5, 0, 3),
(263, 'F8', 5, 1, 3),
(264, 'F7', 5, 2, 3),
(265, 'F6', 5, 3, 3),
(266, 'F5', 5, 4, 3),
(267, 'F4', 5, 5, 3),
(268, 'F3', 5, 6, 3),
(269, 'F2', 5, 7, 3),
(270, 'F1', 5, 8, 3),
(271, 'G9', 6, 0, 3),
(272, 'G8', 6, 1, 3),
(273, 'G7', 6, 2, 3),
(274, 'G6', 6, 3, 3),
(275, 'G5', 6, 4, 3),
(276, 'G4', 6, 5, 3),
(277, 'G3', 6, 6, 3),
(278, 'G2', 6, 7, 3),
(279, 'G1', 6, 8, 3),
(280, 'H9', 7, 0, 3),
(281, 'H8', 7, 1, 3),
(282, 'H7', 7, 2, 3),
(283, 'H5', 7, 3, 3),
(284, 'H5', 7, 4, 3),
(285, 'H4', 7, 5, 3),
(286, 'H3', 7, 6, 3),
(287, 'H2', 7, 7, 3),
(288, 'H1', 7, 8, 3),
(289, 'A9', 0, 0, 5),
(290, 'A8', 0, 1, 5),
(291, 'A7', 0, 2, 5),
(292, 'A6', 0, 3, 5),
(293, 'A5', 0, 4, 5),
(294, 'A4', 0, 5, 5),
(295, 'A3', 0, 6, 5),
(296, 'A2', 0, 7, 5),
(297, 'A1', 0, 8, 5),
(298, 'B9', 1, 0, 5),
(299, 'B8', 1, 1, 5),
(300, 'B7', 1, 2, 5),
(301, 'B6', 1, 3, 5),
(302, 'B5', 1, 4, 5),
(303, 'B4', 1, 5, 5),
(304, 'B3', 1, 6, 5),
(305, 'B2', 1, 7, 5),
(306, 'B1', 1, 8, 5),
(307, 'C9', 2, 0, 5),
(308, 'C8', 2, 1, 5),
(309, 'C7', 2, 2, 5),
(310, 'C6', 2, 3, 5),
(311, 'C5', 2, 4, 5),
(312, 'C4', 2, 5, 5),
(313, 'C3', 2, 6, 5),
(314, 'C2', 2, 7, 5),
(315, 'C1', 2, 8, 5),
(316, 'D9', 3, 0, 5),
(317, 'D8', 3, 1, 5),
(318, 'D7', 3, 2, 5),
(319, 'D6', 3, 3, 5),
(320, 'D5', 3, 4, 5),
(321, 'D4', 3, 5, 5),
(322, 'D3', 3, 6, 5),
(323, 'D2', 3, 7, 5),
(324, 'D1', 3, 8, 5),
(325, 'E9', 4, 0, 5),
(326, 'E8', 4, 1, 5),
(327, 'E7', 4, 2, 5),
(328, 'E6', 4, 3, 5),
(329, 'E5', 4, 4, 5),
(330, 'E4', 4, 5, 5),
(331, 'E3', 4, 6, 5),
(332, 'E2', 4, 7, 5),
(333, 'E1', 4, 8, 5),
(334, 'F9', 5, 0, 5),
(335, 'F8', 5, 1, 5),
(336, 'F7', 5, 2, 5),
(337, 'F6', 5, 3, 5),
(338, 'F5', 5, 4, 5),
(339, 'F4', 5, 5, 5),
(340, 'F3', 5, 6, 5),
(341, 'F2', 5, 7, 5),
(342, 'F1', 5, 8, 5),
(343, 'G9', 6, 0, 5),
(344, 'G8', 6, 1, 5),
(345, 'G7', 6, 2, 5),
(346, 'G6', 6, 3, 5),
(347, 'G5', 6, 4, 5),
(348, 'G4', 6, 5, 5),
(349, 'G3', 6, 6, 5),
(350, 'G2', 6, 7, 5),
(351, 'G1', 6, 8, 5),
(352, 'H9', 7, 0, 5),
(353, 'H8', 7, 1, 5),
(354, 'H7', 7, 2, 5),
(355, 'H5', 7, 3, 5),
(356, 'H5', 7, 4, 5),
(357, 'H4', 7, 5, 5),
(358, 'H3', 7, 6, 5),
(359, 'H2', 7, 7, 5),
(360, 'H1', 7, 8, 5),
(361, 'A9', 0, 0, 6),
(362, 'A8', 0, 1, 6),
(363, 'A7', 0, 2, 6),
(364, 'A6', 0, 3, 6),
(365, 'A5', 0, 4, 6),
(366, 'A4', 0, 5, 6),
(367, 'A3', 0, 6, 6),
(368, 'A2', 0, 7, 6),
(369, 'A1', 0, 8, 6),
(370, 'B9', 1, 0, 6),
(371, 'B8', 1, 1, 6),
(372, 'B7', 1, 2, 6),
(373, 'B6', 1, 3, 6),
(374, 'B5', 1, 4, 6),
(375, 'B4', 1, 5, 6),
(376, 'B3', 1, 6, 6),
(377, 'B2', 1, 7, 6),
(378, 'B1', 1, 8, 6),
(379, 'C9', 2, 0, 6),
(380, 'C8', 2, 1, 6),
(381, 'C7', 2, 2, 6),
(382, 'C6', 2, 3, 6),
(383, 'C5', 2, 4, 6),
(384, 'C4', 2, 5, 6),
(385, 'C3', 2, 6, 6),
(386, 'C2', 2, 7, 6),
(387, 'C1', 2, 8, 6),
(388, 'D9', 3, 0, 6),
(389, 'D8', 3, 1, 6),
(390, 'D7', 3, 2, 6),
(391, 'D6', 3, 3, 6),
(392, 'D5', 3, 4, 6),
(393, 'D4', 3, 5, 6),
(394, 'D3', 3, 6, 6),
(395, 'D2', 3, 7, 6),
(396, 'D1', 3, 8, 6),
(397, 'E9', 4, 0, 6),
(398, 'E8', 4, 1, 6),
(399, 'E7', 4, 2, 6),
(400, 'E6', 4, 3, 6),
(401, 'E5', 4, 4, 6),
(402, 'E4', 4, 5, 6),
(403, 'E3', 4, 6, 6),
(404, 'E2', 4, 7, 6),
(405, 'E1', 4, 8, 6),
(406, 'F9', 5, 0, 6),
(407, 'F8', 5, 1, 6),
(408, 'F7', 5, 2, 6),
(409, 'F6', 5, 3, 6),
(410, 'F5', 5, 4, 6),
(411, 'F4', 5, 5, 6),
(412, 'F3', 5, 6, 6),
(413, 'F2', 5, 7, 6),
(414, 'F1', 5, 8, 6),
(415, 'G9', 6, 0, 6),
(416, 'G8', 6, 1, 6),
(417, 'G7', 6, 2, 6),
(418, 'G6', 6, 3, 6),
(419, 'G5', 6, 4, 6),
(420, 'G4', 6, 5, 6),
(421, 'G3', 6, 6, 6),
(422, 'G2', 6, 7, 6),
(423, 'G1', 6, 8, 6),
(424, 'H9', 7, 0, 6),
(425, 'H8', 7, 1, 6),
(426, 'H7', 7, 2, 6),
(427, 'H5', 7, 3, 6),
(428, 'H5', 7, 4, 6),
(429, 'H4', 7, 5, 6),
(430, 'H3', 7, 6, 6),
(431, 'H2', 7, 7, 6),
(432, 'H1', 7, 8, 6);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(250) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `subject_name` varchar(350) NOT NULL,
  `note` varchar(1000) NOT NULL,
  `status` int(11) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
CREATE TABLE IF NOT EXISTS `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `thumbnail` varchar(300) NOT NULL,
  `start_at` date NOT NULL,
  `description` varchar(500) NOT NULL,
  `type_id` int(11) NOT NULL,
  `director` varchar(255) NOT NULL,
  `cast` text NOT NULL,
  `age` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_movie_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `movie_schedule`
--

DROP TABLE IF EXISTS `movie_schedule`;
CREATE TABLE IF NOT EXISTS `movie_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `schedule_date` date NOT NULL,
  `start_time` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_movie_schedule_movie` (`movie_id`),
  KEY `fk_movie_schedule_room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `movie_type`
--

DROP TABLE IF EXISTS `movie_type`;
CREATE TABLE IF NOT EXISTS `movie_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie_type`
--

INSERT INTO `movie_type` (`id`, `type_name`) VALUES
(1, 'Horror'),
(2, 'Action'),
(3, 'Cartoon'),
(4, 'Family'),
(5, 'Drama'),
(6, 'Comedy');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  `note` varchar(1000) NOT NULL,
  `order_date` datetime NOT NULL,
  `status` int(11) NOT NULL,
  `total_money` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `ticket_id` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `total_money` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_detail_ticket` (`ticket_id`),
  KEY `fk_oder_detail_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'Employee'),
(3, 'customer');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `room_name`) VALUES
(1, 'Room 1'),
(2, 'Room 2'),
(3, 'Room 3'),
(4, 'Room 4'),
(5, 'Room 5'),
(6, 'Room 6');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_id` int(11) NOT NULL,
  `chair_id` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_schedule` (`schedule_id`),
  KEY `fk_ticket_chair` (`chair_id`),
  KEY `fk_ticket_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `fullname`, `email`, `phone_number`, `address`, `password`, `role_id`, `create_at`, `update_at`, `gender`) VALUES
(1, 'admin', 'admin@gmail.com', '1234567', 'ha noi', '123456', 1, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Male'),
(5, 'employee', 'employee@gmail.com', '4656546', 'HN', '123456', 2, '2021-11-26 21:02:58', '2021-11-26 21:02:58', 'Female'),
(7, 'nguyen van a', 'a@gmail.com', '1234567890', 'HN', '123456aA', 3, '2021-11-27 03:17:55', '2021-12-01 16:15:43', 'Male'),
(8, 'tran van b', 'b@gmail.com', '8786465123', 'HN', '123456aA', 3, '2021-12-01 16:16:42', '2021-12-01 16:16:42', 'Male'),
(9, 'Nguyen Thi C', 'c@gmail.com', '8766563214', 'HN', '123456aA', 3, '2021-12-01 21:33:08', '2021-12-01 23:04:36', 'Female');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chair`
--
ALTER TABLE `chair`
  ADD CONSTRAINT `fk_chair_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`);

--
-- Constraints for table `movie`
--
ALTER TABLE `movie`
  ADD CONSTRAINT `fk_movie_type` FOREIGN KEY (`type_id`) REFERENCES `movie_type` (`id`);

--
-- Constraints for table `movie_schedule`
--
ALTER TABLE `movie_schedule`
  ADD CONSTRAINT `fk_movie_schedule_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`),
  ADD CONSTRAINT `fk_movie_schedule_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `fk_oder_detail_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  ADD CONSTRAINT `fk_order_detail_ticket` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_ticket_chair` FOREIGN KEY (`chair_id`) REFERENCES `chair` (`id`),
  ADD CONSTRAINT `fk_ticket_schedule` FOREIGN KEY (`schedule_id`) REFERENCES `movie_schedule` (`id`),
  ADD CONSTRAINT `fk_ticket_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
