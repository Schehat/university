#!/bin/bash

# Game launcher der Programmierprojektgruppe 6.
# Insgesamt stehen 6 Spiele zur Verfügung, die ausgewählt und gespielt werden können.
# Das Skript erwartet als Eingabeargument eine Zahl, welcher für ein Spiel steht
# z.B.: ./game_launcher.sh 1

# Bedienungsanleitung: 

# Für die Benutung von Spiel 1 ist die java jdk 1.8 notwendig  

# Hier die Liste der Spieler mit den dazugehörigen Ziffern
# 1: Construct - ist ein Klon des Spiels World Hardest Game, welcher im Matrix Universum spielt 

if [ $# -ne 1 ] 
then
	echo 'bitte geben Sie einen Paramter an (1 bis 6). Benutzung z.B. ./game_launcher.sh 1';
	exit 1;
fi

if [ $1 -ge 6 ] || [ $1 -lt 1 ]
then 
    echo 'bitte geben Sie als Paramter eine Zahl von 1 bis 6 an';
	exit 1;
fi

num=$1;

if [ $1 -eq 1 ]
then
    java -jar Construct.jar
fi 

if [ $1 -eq 2 ]
then
    java -jar THWG.jar
fi 