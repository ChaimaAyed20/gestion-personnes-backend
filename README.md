# Backend Gestion Personnes (JAX-RS + JDBC)

Backend RESTful developped with JEE : JAX-RS (Jersey 1.19.4) and JDBC MySQL.

## Technologies
- JAX-RS 1.1 (Jersey 1.19.4)
- JDBC MySQL
- Apache Tomcat 9.0.113
- Maven

## Endpoints
| Opération | Méthode | URL |
|-----------|---------|-----|
| Liste | GET | `/rest/personnes` |
| Ajouter | PUT | `/rest/personnes/add/{nom}/{age}` |
| Supprimer | DELETE | `/rest/personnes/remove/{id}` |
| Modifier | PUT | `/rest/personnes/update/{id}/{nom}/{age}` |
| Par ID | GET | `/rest/personnes/getid/{id}` |
| Recherche nom | GET | `/rest/personnes/getnom/{nom}` |

## Installation
1. Maven Update Project (Eclipse)
2. MySQL : CREATE DATABASE gestion_personnes; CREATE TABLE person(id INT AUTO_INCREMENT PRIMARY KEY, nom VARCHAR(100), age INT);
3. Run on Tomcat 8082

## Video
[Insère lien YouTube/Vimeo]
