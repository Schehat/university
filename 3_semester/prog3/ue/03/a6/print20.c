#include <stdio.h>
#include "int20.h"
#include <string.h>

void print20(struct int20 x)
{

	int icnt = 0;

	// läuft bis zum ersten Index ab der die Zahl beginnt (!= 0 ist) und merkt sich diesen
	for (int i = 0; i < LEN; i++)
	{
		if (x.number[i] != '0')
		{
			icnt = i;
			break;
		}
	}

	// druckt ab dem gemerkten Index alle folgenden Zahlen aus
	for (int i = icnt; i < LEN; i++)
	{
		printf("%c", x.number[i]);
	}
}
