-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06 Mei 2017 pada 07.55
-- Versi Server: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tubesabsensi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `absenp_honorer`
--

CREATE TABLE IF NOT EXISTS `absenp_honorer` (
  `id_absensi` varchar(20) NOT NULL,
  `Jam` int(11) DEFAULT NULL,
  `Menit` int(11) DEFAULT NULL,
  `Tanggal` varchar(10) DEFAULT NULL,
  `Status` varchar(6) DEFAULT NULL,
  `Terlambat` char(1) DEFAULT NULL,
  `id_PegawaiHonorer` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `absenp_tetap`
--

CREATE TABLE IF NOT EXISTS `absenp_tetap` (
  `id_absensi` varchar(20) NOT NULL,
  `Jam` int(11) DEFAULT NULL,
  `Menit` int(11) DEFAULT NULL,
  `Tanggal` varchar(10) DEFAULT NULL,
  `Status` varchar(6) DEFAULT NULL,
  `Terlambat` char(1) DEFAULT NULL,
  `id_pegawaiTetap` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `departemen`
--

CREATE TABLE IF NOT EXISTS `departemen` (
  `Nama_Departemen` varchar(20) NOT NULL DEFAULT '',
  `Nama_Perusahaan` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `departemen`
--

INSERT INTO `departemen` (`Nama_Departemen`, `Nama_Perusahaan`) VALUES
('Cashier', 'PT.DemiTubes'),
('Finance', 'PT.DemiTubes'),
('IT', 'PT.DemiTubes'),
('Shipping', 'PT.DemiTubes');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai_honorer`
--

CREATE TABLE IF NOT EXISTS `pegawai_honorer` (
  `id_pegawaihonorer` varchar(20) NOT NULL,
  `Username` varchar(16) DEFAULT NULL,
  `Password` varchar(16) DEFAULT NULL,
  `Nama_Pegawai` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Umur` int(11) DEFAULT NULL,
  `Alamat` varchar(50) DEFAULT NULL,
  `Jenis_Kelamin` char(1) DEFAULT NULL,
  `totaljamSebulan` int(11) DEFAULT NULL,
  `Gaji_Perjam` double DEFAULT NULL,
  `lama_kontrak` int(11) DEFAULT NULL,
  `nama_departemen` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai_tetap`
--

CREATE TABLE IF NOT EXISTS `pegawai_tetap` (
  `id_pegawaitetap` varchar(20) NOT NULL,
  `Username` varchar(16) DEFAULT NULL,
  `Password` varchar(16) DEFAULT NULL,
  `nama_pegawai` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Umur` int(11) DEFAULT NULL,
  `Alamat` varchar(50) DEFAULT NULL,
  `Jenis_Kelamin` char(1) DEFAULT NULL,
  `Gaji` double DEFAULT NULL,
  `nama_departement` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `perusahaan`
--

CREATE TABLE IF NOT EXISTS `perusahaan` (
  `Nama_Perusahaan` varchar(20) NOT NULL,
  `Alamat` varchar(50) DEFAULT NULL,
  `NomorKontak` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `perusahaan`
--

INSERT INTO `perusahaan` (`Nama_Perusahaan`, `Alamat`, `NomorKontak`) VALUES
('PT.DemiTubes', 'JL.TELEKOMUNIKASI 1', '500-600');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tunjangan`
--

CREATE TABLE IF NOT EXISTS `tunjangan` (
  `Nama_Tunjangan` varchar(20) NOT NULL,
  `Jumlah` double DEFAULT NULL,
  `id_pegawaitetap` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absenp_honorer`
--
ALTER TABLE `absenp_honorer`
 ADD PRIMARY KEY (`id_absensi`), ADD KEY `id_PegawaiHonorer` (`id_PegawaiHonorer`);

--
-- Indexes for table `absenp_tetap`
--
ALTER TABLE `absenp_tetap`
 ADD PRIMARY KEY (`id_absensi`), ADD KEY `id_pegawaiTetap` (`id_pegawaiTetap`);

--
-- Indexes for table `departemen`
--
ALTER TABLE `departemen`
 ADD PRIMARY KEY (`Nama_Departemen`), ADD KEY `Nama_Perusahaan` (`Nama_Perusahaan`);

--
-- Indexes for table `pegawai_honorer`
--
ALTER TABLE `pegawai_honorer`
 ADD PRIMARY KEY (`id_pegawaihonorer`), ADD KEY `nama_departemen` (`nama_departemen`);

--
-- Indexes for table `pegawai_tetap`
--
ALTER TABLE `pegawai_tetap`
 ADD PRIMARY KEY (`id_pegawaitetap`), ADD KEY `nama_departement` (`nama_departement`);

--
-- Indexes for table `perusahaan`
--
ALTER TABLE `perusahaan`
 ADD PRIMARY KEY (`Nama_Perusahaan`);

--
-- Indexes for table `tunjangan`
--
ALTER TABLE `tunjangan`
 ADD PRIMARY KEY (`Nama_Tunjangan`), ADD KEY `id_pegawaitetap` (`id_pegawaitetap`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `absenp_honorer`
--
ALTER TABLE `absenp_honorer`
ADD CONSTRAINT `AH_PH_FK` FOREIGN KEY (`id_PegawaiHonorer`) REFERENCES `pegawai_honorer` (`id_pegawaihonorer`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `absenp_tetap`
--
ALTER TABLE `absenp_tetap`
ADD CONSTRAINT `AT_PT_FK` FOREIGN KEY (`id_pegawaiTetap`) REFERENCES `pegawai_tetap` (`id_pegawaitetap`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `departemen`
--
ALTER TABLE `departemen`
ADD CONSTRAINT `D_P_FK` FOREIGN KEY (`Nama_Perusahaan`) REFERENCES `perusahaan` (`Nama_Perusahaan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pegawai_honorer`
--
ALTER TABLE `pegawai_honorer`
ADD CONSTRAINT `PH_D_FK` FOREIGN KEY (`nama_departemen`) REFERENCES `departemen` (`Nama_Departemen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pegawai_tetap`
--
ALTER TABLE `pegawai_tetap`
ADD CONSTRAINT `PT_D_FK` FOREIGN KEY (`nama_departement`) REFERENCES `departemen` (`Nama_Departemen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tunjangan`
--
ALTER TABLE `tunjangan`
ADD CONSTRAINT `T_PT_FK` FOREIGN KEY (`id_pegawaitetap`) REFERENCES `pegawai_tetap` (`id_pegawaitetap`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
