-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 01, 2021 lúc 03:46 PM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `movie_ticket_group1_prjsem2`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `thumbnail` varchar(300) NOT NULL,
  `start_at` date NOT NULL,
  `time` time NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `movie`
--

INSERT INTO `movie` (`id`, `name`, `thumbnail`, `start_at`, `time`, `description`) VALUES
(1, 'abc', 'ahfkjdsf', '2021-11-03', '00:00:00', 'ádfasdfasdfsadf'),
(2, 'abasdjfjhjsaf', 'ahfkapiruwioeuriqwie', '2021-11-19', '09:20:00', 'oiruetoiuwejroithdflgnkjdfshgklsdfg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
