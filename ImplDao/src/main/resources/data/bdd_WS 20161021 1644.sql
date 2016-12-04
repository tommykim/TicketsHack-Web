-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.31-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bdd_paiement
--

CREATE DATABASE IF NOT EXISTS bdd_paiement;
USE bdd_paiement;

--
-- Definition of table `carte`
--

DROP TABLE IF EXISTS `carte`;
CREATE TABLE `carte` (
  `numeroCarte` varchar(255) NOT NULL,
  `crypto` varchar(255) DEFAULT NULL,
  `dateExpiration` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `numeroCompte` int(11) DEFAULT NULL,
  PRIMARY KEY (`numeroCarte`),
  KEY `FK_hbbwy7gt6yk0sevwd4g28fbiy` (`numeroCompte`),
  CONSTRAINT `FK_hbbwy7gt6yk0sevwd4g28fbiy` FOREIGN KEY (`numeroCompte`) REFERENCES `compte` (`numeroCompte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carte`
--

/*!40000 ALTER TABLE `carte` DISABLE KEYS */;
INSERT INTO `carte` (`numeroCarte`,`crypto`,`dateExpiration`,`nom`,`prenom`,`numeroCompte`) VALUES 
 ('123456789','123','122017',NULL,NULL,1);
/*!40000 ALTER TABLE `carte` ENABLE KEYS */;


--
-- Definition of table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`idClient`,`nom`,`prenom`) VALUES 
 (1,'DJAFA','Steve');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;


--
-- Definition of table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE `compte` (
  `numeroCompte` int(11) NOT NULL,
  `solde` double DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  PRIMARY KEY (`numeroCompte`),
  KEY `FK_67cx5jpqkdrson94ueu4fvk1d` (`idClient`),
  CONSTRAINT `FK_67cx5jpqkdrson94ueu4fvk1d` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compte`
--

/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
INSERT INTO `compte` (`numeroCompte`,`solde`,`idClient`) VALUES 
 (1,8790,1);
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;


--
-- Definition of table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `transaction` int(11) NOT NULL AUTO_INCREMENT,
  `carte` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `montant` double DEFAULT NULL,
  PRIMARY KEY (`transaction`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` (`transaction`,`carte`,`date`,`montant`) VALUES 
 (1,'123456789','2016-10-21 08:34:19',100),
 (2,'123456789','2016-10-21 08:46:30',20),
 (3,'123456789','2016-10-21 09:33:09',20),
 (4,'123456789','2016-10-21 09:50:25',20),
 (5,'123456789','2016-10-21 09:50:35',20),
 (6,'123456789','2016-10-21 09:52:07',10),
 (7,'123456789','2016-10-21 14:36:46',10),
 (8,'123456789','2016-10-21 14:55:17',150),
 (9,'123456789','2016-10-21 14:59:07',150),
 (10,'123456789','2016-10-21 15:01:47',150),
 (11,'123456789','2016-10-21 15:03:56',150),
 (12,'123456789','2016-10-21 15:12:56',150),
 (13,'123456789','2016-10-21 15:15:24',150),
 (14,'123456789','2016-10-21 15:19:18',150),
 (15,'123456789','2016-10-21 16:19:40',150);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;

--
-- Create schema bdservicefournisseur
--

CREATE DATABASE IF NOT EXISTS bdservicefournisseur;
USE bdservicefournisseur;

--
-- Definition of table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `id_film` int(11) NOT NULL AUTO_INCREMENT,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime DEFAULT NULL,
  `descriptif` longtext,
  `titre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_film`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `film`
--

/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` (`id_film`,`date_debut`,`date_fin`,`descriptif`,`titre`) VALUES 
 (1,'2016-10-19 16:33:54','2016-10-19 16:33:54','Celine dion et ses chanson francaise ','Celine Dion'),
 (2,'2016-10-19 16:38:13','2016-10-19 16:38:13','Christophe et le concert qui vous attend','Christophe en concert');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;


--
-- Definition of table `occurence`
--

DROP TABLE IF EXISTS `occurence`;
CREATE TABLE `occurence` (
  `id_occurence` int(11) NOT NULL AUTO_INCREMENT,
  `date_seance` datetime NOT NULL,
  `lieu` longtext NOT NULL,
  `nbre_places_dispo` int(11) NOT NULL,
  `nbre_places_tot` int(11) NOT NULL,
  `id_film` int(11) NOT NULL,
  PRIMARY KEY (`id_occurence`),
  KEY `FK_52ak100il3261e9xoe69dewbn` (`id_film`),
  CONSTRAINT `FK_52ak100il3261e9xoe69dewbn` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `occurence`
--

/*!40000 ALTER TABLE `occurence` DISABLE KEYS */;
INSERT INTO `occurence` (`id_occurence`,`date_seance`,`lieu`,`nbre_places_dispo`,`nbre_places_tot`,`id_film`) VALUES 
 (1,'2016-10-19 16:33:54','Accorhotels Arena',98,200,1),
 (2,'2016-10-19 16:33:54','Bercy',50,150,1),
 (3,'2016-10-19 16:38:13','Salle Pleyel, rue Saint Honoré, Paris',200,300,2),
 (4,'2016-10-19 16:38:13','Salle de concert, Paris',150,350,2);
/*!40000 ALTER TABLE `occurence` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
