Gestion de Note est une application web back-end développée avec le framework Spring Boot 
(Java). L'architecture du projet repose sur la structure classique MVC / Layered Architecture 
(Controller, Service, Repository, Entity), garantissant une séparation claire des responsabilités
et une maintenabilité optimale du code.
Le système gère les entités principales d'un établissement
d'enseignement : les étudiants (Student), les professeurs (Prof), les modules (Module),
les cours (Cours) ainsi que les inscriptions (Inscri). La persistance des données est assurée via Spring Data JPA (Hibernate), 
et la sécurité de l'application est configurée avec Spring Security (gestion des utilisateurs et rôles avec
PROFSecurityconfig et CustomUserDetailService).
