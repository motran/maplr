# Test Développeur JAVA/Spring intermédiaire

## Pré-requis
- Maven
- Java 11

## Procédure d'installation du projet
- Récupérer le contenu de la branche develop
- Ouvrir une fenêtre de commande à la racine du projet
- Exécuter la commande : `mvn clean install -DskipTests`
- Pour lancer l'application : `mvn spring-boot:run` ou lancer un run de la classe "TestHockeyGameApplication.java" 
situé "src/main/java/com/maplr/testhockeygame/"

## Lien vers le contrat d'interface Swagger
http://localhost:8080/swagger-ui/

## Lien de monitoring de l'application avec actuator
http://localhost:8080/actuator

## Remarques
- Les données sont initialisées au démarrage de l'application.
- Des logs à partir du niveau de trace "WARN" sont générés dans un fichier appelé "app.log" situé dans le dossier /logs à la racine du projet.
- Les tests sont exécutables à travers le contrat d'interface Swagger.
