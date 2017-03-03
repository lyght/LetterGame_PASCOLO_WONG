# TP Architecture Logicielle / Inf4043 - 2017 - Jeux de lettres

## Description

-**Membres du projet :**

PASCOLO Rémi  
WONG Gallien

-**Objectif :**

Utiliser des principes d'architecture logicielle afin de créer un jeu de lettres multijoueurs respectant 
des normes et principes de génie logiciel tels que les principes SOLID ou les design patterns.
Les règles du jeu sont visibles sur le GitHub du professeur de l'ESIEA responsable du projet, M.Labusquière :  

https://github.com/MLabusquiere/TP_4A_2017_Letter_Game

## Comment jouer

-**Lignes de commande :**

Le jeu est en affichage console et il est nécéssaire, pour pouvoir générer le .jar,  
d'exécuter lers commandes bash suivantes sur Linux :

```
$ git clone https://github.com/MLabusquiere/TP_4A_2017_Letter_Game.git LetterGame
$ cd LetterGame
$ git remote rm origin
$ git remote add origin <your_git_repository_url>
$ git push -u origin master
```


## Trois principes SOLID ou Design Patterns utilisés

-**Open/Close Principle (Player) :**

La classe Player est fermée à la modification à part pour l'ajout ou le retrait de mots à son playerBoard.  
Elle possède des accesseurs mais aucun mutateur ce qui offre une sécurité dans l'intégrité de la classe.  
  
Ce principe est un des principes de base de codage propre, et il est exploité au maximum dans notre projet,
dans lequel aucun champ de classe ne peut être modifié directement et les mutateurs sont tous régulés par des limites.

-**Design Pattern Iterator (Dictionnary) :**
```java
while (scanner.hasNext())
	{
		dictionnaryWords.add(scanner.nextLine().toUpperCase());
	}
```
Le Scanner de Java est implémenté selon le design pattern iterator qui permet de parcourir l'ensemble du dictionnaire 
sous forme de texte sans en connaître la taille ni les caractéristiques (vide, nombre de lignes, structure).

-**Design Pattern Factory (LetterFactory)**

On utilise içi une factory qui permet d'encapsuler les mécaniques complexes de génération de lettre.  
La fonction statique getLetter() permet d'obtenir facilement une lettre et de garder le code de Game 
compréhensible et court.  
La clarté du code est grandement améliorée et les règles de génération d'une lettre peuvent ainsi être facilement changées.

