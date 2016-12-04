-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.6.33-log - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Export de données de la table ticketshackds.associer : ~39 rows (environ)
/*!40000 ALTER TABLE `associer` DISABLE KEYS */;
REPLACE INTO `associer` (`ID_CATEGORIE`, `ID_THEME`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(1, 6),
	(1, 7),
	(1, 8),
	(2, 9),
	(2, 10),
	(2, 11),
	(2, 12),
	(2, 13),
	(2, 14),
	(3, 15),
	(3, 16),
	(3, 17),
	(3, 18),
	(3, 19),
	(4, 20),
	(4, 21),
	(4, 22),
	(4, 23),
	(4, 24),
	(5, 25),
	(5, 26),
	(5, 27),
	(5, 28),
	(5, 29),
	(5, 30),
	(6, 31),
	(6, 32),
	(6, 33),
	(6, 34),
	(6, 35),
	(6, 36),
	(6, 37),
	(6, 38),
	(6, 39);
/*!40000 ALTER TABLE `associer` ENABLE KEYS */;

-- Export de données de la table ticketshackds.categorie : ~6 rows (environ)
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
REPLACE INTO `categorie` (`ID_CATEGORIE`, `LIBELLE_CATEGORIE`) VALUES
	(1, 'Cinéma'),
	(2, 'Concert'),
	(3, 'Musée'),
	(4, 'Parc'),
	(5, 'Spectacle'),
	(6, 'Sport');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;

-- Export de données de la table ticketshackds.civilite : ~2 rows (environ)
/*!40000 ALTER TABLE `civilite` DISABLE KEYS */;
REPLACE INTO `civilite` (`ID_CIVILITE`, `LIBELLE_CIVILITE`) VALUES
	(1, 'Madame'),
	(2, 'Monsieur');
/*!40000 ALTER TABLE `civilite` ENABLE KEYS */;

-- Export de données de la table ticketshackds.commande : ~4 rows (environ)
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
REPLACE INTO `commande` (`ID_COMMANDE`, `ID_UTILISATEUR`, `REFERENCE`, `DATE_CREATION`) VALUES
	(15, 1, '710334505', '2016-11-03'),
	(16, 1, '710997988', '2016-11-03'),
	(17, 1, '711707900', '2016-11-03'),
	(18, 1, '713547701', '2016-11-03'),
	(19, 1, '713917548', '2016-11-03');
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;

-- Export de données de la table ticketshackds.departement : ~97 rows (environ)
/*!40000 ALTER TABLE `departement` DISABLE KEYS */;
REPLACE INTO `departement` (`ID_DEP`, `LIBELLE_DEP`) VALUES
	(1, 'Ain'),
	(2, 'Aisne'),
	(3, 'Allier'),
	(4, 'Alpes-de-Haute-Provence'),
	(5, 'Hautes-Alpes'),
	(6, 'Alpes-Maritimes'),
	(7, 'Ardèche'),
	(8, 'Ardennes'),
	(9, 'Ariège'),
	(10, 'Aube'),
	(11, 'Aude'),
	(12, 'Aveyron'),
	(13, 'Bouches-du-Rhône'),
	(14, 'Calvados'),
	(15, 'Cantal'),
	(16, 'Charente'),
	(17, 'Charente-Maritime'),
	(18, 'Cher'),
	(19, 'Corrèze'),
	(20, 'Corse-du-Sud'),
	(21, 'Haute-Corse'),
	(22, 'Côte-d\'Or'),
	(23, 'Côte-d\'Armor'),
	(24, 'Creuse'),
	(25, 'Dordogne'),
	(26, 'Doubs'),
	(27, 'Drôme'),
	(28, 'Eure'),
	(29, 'Eure-et-Loir'),
	(30, 'Finistère'),
	(31, 'Gard'),
	(32, 'Haute-Garonne'),
	(33, 'Gers'),
	(34, 'Gironde'),
	(35, 'Hérault'),
	(36, 'Ille-et-Vilaine'),
	(37, 'Indre'),
	(38, 'Indre-et-Loire'),
	(39, 'Isère'),
	(40, 'Jura'),
	(41, 'Landes'),
	(42, 'Loir-et-Cher'),
	(43, 'Loire'),
	(44, 'Haute-Loire'),
	(45, 'Loire-Atlantique'),
	(46, 'Loiret'),
	(47, 'Lot'),
	(48, 'Lot-et-Garonne'),
	(49, 'Lozère'),
	(50, 'Maine-et-Loire'),
	(51, 'Manche'),
	(52, 'Marne'),
	(53, 'Haute-Marne'),
	(54, 'Mayenne'),
	(55, 'Meurthe-et-Moselle'),
	(56, 'Meuse'),
	(57, 'Morbihan'),
	(58, 'Moselle'),
	(59, 'Nièvre'),
	(60, 'Nord'),
	(61, 'Oise'),
	(62, 'Orne'),
	(63, 'Pas-de-Calais'),
	(64, 'Puy-du-Dôme'),
	(65, 'Pyrénées-Atlantiques'),
	(66, 'Hautes-Pyrénées'),
	(67, 'Pyrénées-Orientales'),
	(68, 'Bas-Rhin'),
	(69, 'Haut-Rhin'),
	(70, 'Rhône'),
	(71, 'Lyon'),
	(72, 'Haute-Saône'),
	(73, 'Saône-et-Loire'),
	(74, 'Sarthe'),
	(75, 'Savoie'),
	(76, 'Haute-Savoie'),
	(77, 'Paris'),
	(78, 'Seine-Maritime'),
	(79, 'Seine-et-Marne'),
	(80, 'Yvelines'),
	(81, 'Deux-Sèvres'),
	(82, 'Somme'),
	(83, 'Tarn'),
	(84, 'Tarn-et-Garonne'),
	(85, 'Var'),
	(86, 'Vaucluse'),
	(87, 'Vendée'),
	(88, 'Vienne'),
	(89, 'haute-Vienne'),
	(90, 'Vosges'),
	(91, 'Yonne'),
	(92, 'Territoire de Belfort'),
	(93, 'Essonne'),
	(94, 'Hauts-de-Seine'),
	(95, 'Seine-Saint-Denis'),
	(96, 'Val-de-Marne'),
	(97, 'Val-d\'Oise');
/*!40000 ALTER TABLE `departement` ENABLE KEYS */;

-- Export de données de la table ticketshackds.evenement : ~19 rows (environ)
/*!40000 ALTER TABLE `evenement` DISABLE KEYS */;
REPLACE INTO `evenement` (`ID_EVENEMENT`, `ID_CATEGORIE`, `LIBELLE_EVENEMENT`, `DESCRIPTIF`, `PARUTION`, `AFFICHE`, `VIDEO`, `PERSONNAGE1`, `PERSONNAGE2`, `PERSONNAGE3`) VALUES
	(1, 2, 'Céline Dion l\'ultime concert', ' Ces derniers concerts de CELINE DION seront les ultimes de la tournée Européenne.', '2016-10-28', '1.jpg', NULL, 'Céline Dion', NULL, NULL),
	(2, 2, 'Christophe en Concert', ' Tounée de Concerts de Christope à travers la France.', '2016-09-30', '2.jpg', NULL, 'Christophe', NULL, NULL),
	(3, 2, 'Johny HallyDay. Festival le printemps de Perouges', 'Le Festival Printemps de Pérouges présente en accord avec Decibels Productions et Bornrocker le concert de Johnny Hallyday en clôture et à l\'occasion des 20 ans du festival. ', '2016-12-30', '3.jpg', NULL, 'Johnny Hallyday', NULL, NULL),
	(4, 2, 'Pascal Obispo avec orchestre symphonique', ' PASCAL OBISPO « BILLET DE FEMME » CONCERT AVEC ORCHESTRE SYMPHONIQUE Après le succès de sa dernière tournée « Le Grand Amour », PASCAL OBISPO est de retour sur scène avec ses musiciens.', '2016-11-30', '4.jpg', NULL, 'Pascal Obispo', NULL, NULL),
	(5, 2, 'Patrick Bruel. "Très souvent, je pense à vous..." ', ' De retour avec son nouvel album Très souvent, je pense à vous... , Patrick Bruel est actuellement en tournée à travers la France, la Belgique et la Suisse.', '2016-11-05', '5.jpg', NULL, 'Patrick Bruel', NULL, NULL),
	(6, 2, 'Muse à la tour Eiffel', ' Après avoir enflammé l’AccorHotels Arena lors de six concerts en février et mars dernier, MUSE retrouve son public français pour un concert événement dans un des plus beau décor de la capitale : la Tour Eiffel.', '2016-11-23', '6.jpg', NULL, 'Céline Dion', NULL, NULL),
	(7, 2, 'Red Hot Chili Peppers', ' Les Red Hot Chili Peppers annoncent leur grand retour en France ! Ils se produiront à Paris, sur la scène de l’AccorHotels Arena les 15,16 et 18 octobre.', '2016-11-25', '7.jpg', NULL, 'RHCP', NULL, NULL),
	(8, 2, 'Coldplayed', 'Coldplayed Tribute Coldplay C est avant tout un hommage au talent et au génie du groupe "Coldplay". Avec un line-up de quatre musiciens, identique à l original, ce tribute band recrée avec énergie l ambiance des concerts d un groupe déjà mythique. ', '2016-11-27', '8.jpg', NULL, NULL, NULL, NULL),
	(9, 2, 'Bruce Springsteen', ' Bruce Springsteen et the e-street band.', '2017-01-01', '4.jpg', NULL, 'Bruce SPringsteen', NULL, NULL),
	(10, 2, 'Archive', ' Le collectif londonien est de retour à Paris pour un concert exceptionnel à la Salle Pleyel le 29 novembre 2016 ', '2017-01-09', '5.jpg', NULL, NULL, NULL, NULL),
	(11, 3, 'Sakura', 'Venez decouvrir la culture du sakura, plante legendaire au japon!', '2017-02-02', '11.jpg', NULL, 'Sakura Mai', NULL, NULL),
	(12, 4, 'Les lumieres de la Villette', 'Le parc de la Villette s habille aux couleurs de la planete. Folklore, gastronomie, exposition, venez faire le tour du monde dans 20 Ha.', '2016-12-12', '12.jpg', NULL, 'Bernard De La Villardiere', 'Julien Leperse', NULL),
	(13, 5, 'Kev et Gad', 'Le paradoxe entre un jeune qui a  l avenir devant lui et un homme qui a vecu. Nous avons reuni sur scene deux grands de l\'humour. Ne manquez pas cet evenement unique.', '2017-09-25', '13.jpg', NULL, 'Gad Elmaley', 'Kev Adams', NULL),
	(14, 6, 'PSG - BARCELONE', 'Le parc de princes accueille le plus grande club d\'Europe! Cavani et les autres ont-ils leur chance face a eux!', '2017-02-10', '14.jpg', NULL, 'PSG', 'BARCELONE', NULL),
	(15, 6, 'MONACO - INTER MILAN', 'La legende italienne tente de prendre d\'assaut le rocher! Monaco apres un debut de saison tonitruant, s\'apprete a defendre sa place sur la scene europeenne. Venez vivre ce match haut en couleur!', '2017-03-11', '15.jpg', NULL, 'MONACO', 'INTER MILAN', NULL),
	(16, 1, 'African Cats', 'Encore un documentaire a couper le souffle! Suivez l histoire d un jeune lion destine a reprendre le territoire de son pere. Les hyenes, les guepards et d\'autres lion vont lui barrer le chemin ... Lutte pour la suivie ou pour la gloire, vous ne manquerez pas de lacher une petite larme', '2017-05-23', '16.jpg', NULL, 'Hanz Zimmer', 'Johny Depp', 'Kad Merad'),
	(17, 1, 'Tortues ninja', 'Retour d un grand classique du cinema. Les tortues se font capturer par le mechant Shreder et maitre Splinter, accompagne par April, va tenter de delivrer ses fils!', '2016-12-20', '17.jpg', NULL, 'Oroku Saki', NULL, NULL),
	(18, 1, 'Marvel cross Universe', 'Avez-vous deja reve de voir les X-men, les avengers et les 4 fantastiques reunis ? Voici chose faite! Ils croiseront le fer avec le nouveau maitre du mal, Docteur VON FATALIS!', '2016-12-23', '18.jpg', NULL, NULL, NULL, NULL),
	(19, 1, 'The Lunch Box', 'La celebre romance indienne reveint sous un format remasterise au cinema. Revenez vivre cette histoire d\'amour passionnante et accrocheuse ...', '2016-12-23', '19.jpg', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `evenement` ENABLE KEYS */;

-- Export de données de la table ticketshackds.ligne_commande : ~4 rows (environ)
/*!40000 ALTER TABLE `ligne_commande` DISABLE KEYS */;
REPLACE INTO `ligne_commande` (`ID_LIGNE_COMMANDE`, `ID_COMMANDE`, `ID_TARIF`, `QUANTITIE`) VALUES
	(15, 15, 1, 1),
	(16, 16, 1, 2),
	(17, 17, 1, 1),
	(18, 18, 1, 1),
	(19, 19, 1, 1);
/*!40000 ALTER TABLE `ligne_commande` ENABLE KEYS */;

-- Export de données de la table ticketshackds.occurence : ~28 rows (environ)
/*!40000 ALTER TABLE `occurence` DISABLE KEYS */;
REPLACE INTO `occurence` (`ID_OCCURENCE`, `ID_DEP`, `ID_EVENEMENT`, `DATE_`, `LIEU_`, `NOMBRE_PLACES`, `DATE_FIN`) VALUES
	(1, 77, 1, '2017-06-09 19:30:00', 'Accorhotels Arena', 15, NULL),
	(2, 77, 1, '2017-09-09 19:30:00', 'Bercy', 0, NULL),
	(3, 77, 2, '2017-08-07 20:00:00', 'Salle Pleyel, rue Saint Honoré, Paris', 100, NULL),
	(4, 71, 2, '2017-08-14 20:00:00', 'Salle de concert, Paris', 100, NULL),
	(5, 1, 3, '2017-07-05 20:00:00', 'Polo Club de la Plaine de l\'Ain', 100, NULL),
	(6, 1, 4, '2017-03-05 19:00:00', 'Olympia Paris', 200, NULL),
	(7, 77, 5, '2017-01-14 20:00:00', 'Salle Pleyel Paris 8', 250, NULL),
	(8, 77, 5, '2017-01-15 20:00:00', 'Salle Pleyel Paris 8', 250, NULL),
	(9, 77, 5, '2017-01-16 20:00:00', 'Salle Pleyel Paris 8', 250, NULL),
	(10, 77, 7, '2016-12-24 20:00:00', 'AccorHotels Arena', 0, NULL),
	(11, 77, 7, '2016-12-25 20:00:00', 'AccorHotels Arena', 0, NULL),
	(12, 77, 7, '2016-12-26 20:00:00', 'AccorHotels Arena', 100, NULL),
	(13, 60, 8, '2017-07-25 20:00:00', 'Le Splendid, Lille', 100, NULL),
	(14, 77, 9, '2017-07-11 19:30:00', 'AccorHotels Arena', 200, NULL),
	(15, 77, 9, '2017-07-13 19:30:00', 'AccorHotels Arena', 200, NULL),
	(16, 77, 5, '2017-09-29 20:00:00', 'Salle Pleyel Paris', 250, NULL),
	(17, 77, 16, '2016-12-23 20:00:00', 'Gaumont-Chatelet-les-Halles', 200, NULL),
	(18, 77, 17, '2016-12-11 21:00:00', 'UGC-Champs Elysees', 200, NULL),
	(19, 77, 19, '2016-12-23 20:00:00', 'MK2-Saint-Michel', 200, NULL),
	(20, 77, 14, '2016-12-11 20:45:00', 'La Plaine Stade De France', 70000, '2016-12-11'),
	(21, 77, 6, '2017-06-08 20:00:00', 'Champs de Mars Paris', 250, NULL),
	(22, 77, 10, '2017-06-28 20:00:00', 'CalleryArchive', 250, NULL),
	(23, 77, 10, '2017-06-29 20:00:00', 'CalleryArchive', 250, NULL),
	(24, 77, 11, '2017-07-29 20:00:00', 'BercyCollectionCallery', 250, NULL),
	(25, 77, 12, '2017-05-29 20:00:00', 'Parc Villete', 250, NULL),
	(26, 77, 13, '2017-03-29 20:00:00', 'Theatre chatelet', 250, NULL),
	(27, 77, 14, '2017-04-29 20:00:00', 'La Plaine Stade De France', 250, NULL),
	(28, 77, 15, '2017-05-30 20:00:00', 'La Plaine Stade De France', 250, NULL),
	(29, 77, 18, '2017-05-30 20:00:00', 'UGC-Champs Elysees', 250, NULL),
	(30, 77, 18, '2017-05-30 20:00:00', 'UGC-Ladefense', 250, NULL);
/*!40000 ALTER TABLE `occurence` ENABLE KEYS */;

-- Export de données de la table ticketshackds.preferer : ~6 rows (environ)
/*!40000 ALTER TABLE `preferer` DISABLE KEYS */;
REPLACE INTO `preferer` (`ID_THEME`, `ID_UTILISATEUR`) VALUES
	(7, 1),
	(35, 1),
	(1, 2),
	(6, 2),
	(10, 3),
	(21, 3);
/*!40000 ALTER TABLE `preferer` ENABLE KEYS */;

-- Export de données de la table ticketshackds.qualifier : ~21 rows (environ)
/*!40000 ALTER TABLE `qualifier` DISABLE KEYS */;
REPLACE INTO `qualifier` (`ID_EVENEMENT`, `ID_THEME`) VALUES
	(16, 3),
	(17, 6),
	(18, 6),
	(19, 7),
	(1, 9),
	(2, 9),
	(3, 9),
	(4, 9),
	(5, 9),
	(1, 10),
	(3, 10),
	(6, 10),
	(7, 10),
	(8, 10),
	(9, 10),
	(10, 10),
	(12, 17),
	(11, 19),
	(13, 26),
	(14, 31),
	(15, 31);
/*!40000 ALTER TABLE `qualifier` ENABLE KEYS */;

-- Export de données de la table ticketshackds.reduction : ~4 rows (environ)
/*!40000 ALTER TABLE `reduction` DISABLE KEYS */;
REPLACE INTO `reduction` (`ID_REDUCTION`, `LIBELLE_REDUCTION`, `POURCENTAGE`, `SEUIL`) VALUES
	(1, 'Basic', 10, 100),
	(2, 'Premium', 15, 200),
	(3, 'Golden', 20, 300),
	(4, 'Platinum', 30, 1000);
/*!40000 ALTER TABLE `reduction` ENABLE KEYS */;

-- Export de données de la table ticketshackds.statut_utilisateur : ~3 rows (environ)
/*!40000 ALTER TABLE `statut_utilisateur` DISABLE KEYS */;
REPLACE INTO `statut_utilisateur` (`ID_STATUT_UTILISATEUR`, `LIBELLE_STATUT_UTILISATEUR`) VALUES
	(1, 'Client'),
	(2, 'Administrateur'),
	(3, 'Organisateur');
/*!40000 ALTER TABLE `statut_utilisateur` ENABLE KEYS */;

-- Export de données de la table ticketshackds.tarif : ~56 rows (environ)
/*!40000 ALTER TABLE `tarif` DISABLE KEYS */;
REPLACE INTO `tarif` (`ID_TARIF`, `ID_OCCURENCE`, `LIBELLE_TARIF`, `PRIX`) VALUES
	(1, 1, 'Tarif adulte', 150),
	(2, 1, 'Tarif enfant', 100),
	(3, 2, 'Tarif adulte', 150),
	(4, 2, 'Tarif enfant', 100),
	(5, 3, 'Tarif orchestre', 70),
	(6, 3, 'Tarif Balcon', 50),
	(7, 4, 'Tarif orchestre', 60),
	(8, 4, 'Tarif Balcon', 40),
	(9, 5, 'Tarif chômeur', 70),
	(10, 6, 'Gradins', 70),
	(11, 6, 'Mezzanine', 60),
	(12, 7, 'Parterre', 80),
	(13, 7, 'Balcon haut pair', 75),
	(14, 7, 'Balcon haut impair', 75),
	(15, 8, 'Parterre', 80),
	(16, 8, 'Balcon haut pair', 75),
	(17, 8, 'Balcon haut impair', 75),
	(18, 9, 'Parterre', 80),
	(19, 9, 'Balcon haut pair', 75),
	(20, 9, 'Balcon haut impair', 75),
	(21, 9, 'Tarif normal PORTE 1', 55),
	(22, 9, 'Tarif normal PORTE 2', 55),
	(23, 10, 'Gradins', 80),
	(24, 10, 'Tarif Balcon', 70),
	(25, 10, 'Fosse debout', 50),
	(26, 11, 'Gradins', 80),
	(27, 11, 'Tarif Balcon', 70),
	(28, 11, 'Fosse debout', 50),
	(29, 12, 'Gradins', 80),
	(30, 12, 'Tarif Balcon', 70),
	(31, 12, 'Fosse debout', 50),
	(32, 13, 'Tarif normal debout', 25),
	(33, 14, 'Tarif normal', 50),
	(34, 14, 'Tarif normal', 50),
	(35, 16, 'Parterre', 55),
	(36, 5, 'Tarif normal', 100),
	(37, 5, 'Tarif étudiant', 80),
	(38, 15, 'Tarif étudiant', 80),
	(39, 15, 'Tarif normal', 100),
	(40, 17, 'Tarif normal', 9),
	(41, 17, 'Tarif étudiant', 6),
	(42, 18, 'Tarif étudiant', 6),
	(43, 19, 'Tarif étudiant', 6),
	(44, 19, 'Tarif normal', 6),
	(45, 19, 'Tarif normal', 6),
	(46, 20, 'Tarif normal', 50),
	(47, 20, 'Tarif étudiant', 35),
	(48, 21, 'Tarif normal', 35),
	(49, 22, 'Tarif normal', 20),
	(50, 23, 'Tarif normal', 20),
	(51, 24, 'Tarif normal', 20),
	(52, 25, 'Tarif normal', 20),
	(53, 26, 'Tarif normal', 25),
	(54, 26, 'Tarif Balcon', 35),
	(55, 27, 'Tarif normal', 50),
	(56, 28, 'Tarif normal', 50),
	(57, 29, 'Tarif normal', 9),
	(58, 29, 'Tarif étudiant', 6),
	(59, 30, 'Tarif étudiant', 6),
	(60, 30, 'Tarif normal', 9);
/*!40000 ALTER TABLE `tarif` ENABLE KEYS */;

-- Export de données de la table ticketshackds.theme : ~39 rows (environ)
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
REPLACE INTO `theme` (`ID_THEME`, `LIBELLE_THEME`) VALUES
	(1, 'Comédie'),
	(2, 'Thriller'),
	(3, 'Documentaire'),
	(4, 'Drame'),
	(5, 'Peplum'),
	(6, 'Science fiction'),
	(7, 'Romance'),
	(8, 'Historique'),
	(9, 'Variété et chanson française'),
	(10, 'Pop-rock'),
	(11, 'Hard-rock/Métal'),
	(12, 'Musique électronique'),
	(13, 'Classique-Lyrique'),
	(14, 'Rap/Hip-hop/Slam'),
	(15, 'Peinture'),
	(16, 'Sculpture'),
	(17, 'Art Moderne'),
	(18, 'Histoire'),
	(19, 'Nature'),
	(20, 'Sensations fortes'),
	(21, 'Jeux d\'eaux'),
	(22, 'Historiques'),
	(23, 'Pour les plus petits'),
	(24, 'Nature, animalier'),
	(25, 'One man show'),
	(26, 'Comique'),
	(27, 'Comédie musicale'),
	(28, 'Magie'),
	(29, 'Théâtre pour enfants'),
	(30, 'Théâtre classique'),
	(31, 'Football'),
	(32, 'Basketball'),
	(33, 'Handball'),
	(34, 'Magie'),
	(35, 'Théâtre pour enfants'),
	(36, 'Théâtre classique'),
	(37, 'Athlétisme'),
	(38, 'Sports de combats'),
	(39, 'Patinge artistique');
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;

-- Export de données de la table ticketshackds.utilisateur : ~4 rows (environ)
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
REPLACE INTO `utilisateur` (`ID_UTILISATEUR`, `ID_REDUCTION`, `ID_STATUT_UTILISATEUR`, `ID_CIVILITE`, `NOM`, `PRENOM_`, `MAIL_`, `MDP_`, `MOBILE_`, `NAISSANCE_`, `INSCRIPTION`) VALUES
	(1, 1, 2, 1, 'Wang', 'Fen', 'admin@hotmail.fr', 'admin', '0600000000', '1985-11-11', '2015-11-11'),
	(2, 2, 2, 2, 'DJafa', 'Steve', 'djafasteve@yahoo.fr', 'steve', '0626177144', '1988-11-24', '2015-06-15'),
	(3, 2, 3, 2, 'Basdevant', 'Adrien', 'abasdevant@gmail.com', 'adrien', '0783288073', '1985-12-01', '2015-11-11'),
	(4, 2, 1, 1, 'WANG', 'Fen', 'fenwang@hotmail.fr', 'fen', '0783288073', '1985-12-01', '2015-11-11');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
