-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 24 mai 2023 à 12:29
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `project`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `passager` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `escale`
--

CREATE TABLE `escale` (
  `id_escale` int(11) NOT NULL,
  `heure_d` varchar(10) DEFAULT NULL,
  `heure_a` varchar(10) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `id_vol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `escale`
--

INSERT INTO `escale` (`id_escale`, `heure_d`, `heure_a`, `ville`, `id_vol`) VALUES
(1, '16', '14', 'toulouse', 7);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `num_reservation` int(11) NOT NULL,
  `client_id` int(11) DEFAULT NULL,
  `vol_num_vol` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`num_reservation`, `client_id`, `vol_num_vol`, `status`) VALUES
(16, 4, 7, '1'),
(17, 4, 7, '0');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `question` varchar(50) NOT NULL,
  `answer` varchar(40) NOT NULL,
  `date` date NOT NULL,
  `update_date` date DEFAULT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`user_id`, `email`, `username`, `password`, `question`, `answer`, `date`, `update_date`, `nom`, `prenom`, `role`) VALUES
(1, 'admin@gmail.com', 'admin', 'azizaziz', 'What is your favorite color?', 'Red', '2023-04-21', '2023-05-20', 'aziz', 'hassine', 'admin'),
(2, 'test@gmail.com', 'test', 'admin123', 'What is your most favorite sport?', 'Football', '2023-04-21', NULL, '', '', 'user'),
(3, 'achrafhafsia36@gmail.com', 'achraf', 'admin123', 'What is the name of your pet?', 'Bunny', '2023-04-21', '2023-04-21', 'achraf', 'hafisa', 'user'),
(4, 'jihenhhedhi@gmail.com', 'jihen', 'jihenjihen', 'What is your favorite color?', 'red', '2023-05-24', NULL, 'hdheli', 'jihen', 'user');

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

CREATE TABLE `vol` (
  `num_vol` int(11) NOT NULL,
  `dateDepart` date DEFAULT NULL,
  `heure_d` varchar(10) DEFAULT NULL,
  `heure_a` varchar(10) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `depart` varchar(20) NOT NULL,
  `destination` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `vol`
--

INSERT INTO `vol` (`num_vol`, `dateDepart`, `heure_d`, `heure_a`, `prix`, `depart`, `destination`) VALUES
(5, '2023-05-24', '14', '17:55', 25, 'toulouse', 'paris '),
(6, '2023-05-24', '14:00', '16:30', 500, 'sfax', 'montreal'),
(7, '2023-05-25', '15:00', '18:00', 600, 'sfax', 'espagne');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `escale`
--
ALTER TABLE `escale`
  ADD PRIMARY KEY (`id_escale`),
  ADD KEY `FK1` (`id_vol`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`num_reservation`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `vol_num_vol` (`vol_num_vol`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Index pour la table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`num_vol`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `num_reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `escale`
--
ALTER TABLE `escale`
  ADD CONSTRAINT `FK1` FOREIGN KEY (`id_vol`) REFERENCES `vol` (`num_vol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`vol_num_vol`) REFERENCES `vol` (`num_vol`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
