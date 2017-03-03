# TP Architecture Logicielle / Inf4043 - 2017 - Jeux de lettres

## Description :

-**Membres du projet :**

PASCOLO Rémi
WONG Gallien

## Trois principes SOLID ou Design Patterns utilisés :

-**Open/Close Principle (Player) :**

La classe Player est fermée à la modification à part pour l'ajout ou le retrait de mots à son playerBoard.
Elle possède des accesseurs mais aucun mutateur ce qui offre une sécurité dans l'intégrité de la classe.

Ce principe est un des principes de base de codage propre, et il est exploité au maximum dans notre projet,
dans lequel aucun champ de classe ne peut être modifié directement et les mutateurs sont tous régulés par des limites.

-**Design Pattern Iterator (Dictionnary) :**

while (scanner.hasNext())
	{
		dictionnaryWords.add(scanner.nextLine().toUpperCase());
	}

Le Scanner de Java est implémenté selon le design pattern iterator qui permet de parcourir l'ensemble du dictionnaire 
sous forme de texte sans en connaître la taille ni les caractéristiques (vide, nombre de lignes, structure).

-**Design Pattern Factory (LetterFactory)**

On utilise içi une factory qui permet d'encapsuler les mécaniques complexes de génération de lettre.
La fonction statique getLetter() permet d'obtenir facilement une lettre et de garder le code de Game 
compréhensible et court.
La clarté du code est grandement améliorée et les règles de génération d'une lettre peuvent ainsi être facilement changées.

