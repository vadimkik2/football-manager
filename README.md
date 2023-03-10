# Football-manager

## 📋 Description:
This application is a Football-manager simulation, 
where you can add,delete,update, and read list of a football teams/players.

* create team/player.
* read list of team/player.
* update team/player.
* delete team/player.
* transfer player from one team to another

## 🔎 Project structure
The project has an 3-Tier Architecture

* Controller - This level allows the user to work with this application.
* Service - This level of architecture is responsible for processing the data received from the DAO level.
* Repository - This level of architecture is responsible for communicating with the database.

## ⚙ Technologies:

* Java 17
* Maven
* H2 DataBase
* Lombok
* Spring Boot

## 🚀 INSTRUCTIONS FOR LAUNCHING THE PROJECT:
1) Fork this repository
2) Create new project from Version Control
3) Edit application.properties - set the necessary parameters'
   
  * spring.datasource.url =
  * spring.datasource.driver-class-name =
  * spring.datasource.username =
  * spring.datasource.password =

4) Run project

### For testing, you can use ready-made profiles players/teams.