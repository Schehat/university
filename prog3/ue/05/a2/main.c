#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define SIZE 10
#define NAME_LEN 40

typedef struct
{
    char name[NAME_LEN + 1];
    int personalnummer;
    float gehalt;
} angestellter;

void clearPuffer()
{
    do
    {
    } while (getchar() != '\n');
}

int main(void)
{
    angestellter *array[SIZE] = {NULL};

    bool run = true;
    int index;
    char input;
    while (run == true)
    {
        printf("Welchen Angestellten wollen Sie hinzufügen/bearbeiten (0 bis 9): ");
        scanf("%d", &index);

        clearPuffer();

        if (array[index] != NULL)
        {
            free(array[index]);
            array[index] = NULL;
            printf("Angestellter wurde gelöscht\n");
        }
        else
        {
            array[index] = (angestellter *)malloc(sizeof(angestellter));
            printf("Bitte Personalnummer eingeben: ");
            scanf("%d", &array[index]->personalnummer);

            clearPuffer();

            printf("Bitte Name eingeben: ");
            scanf("%40s", array[index]->name);

            printf("Bitte Gehalt eingeben: ");
            scanf("%f", &array[index]->gehalt);

            clearPuffer();
        }

        printf("\nIhre Eingaben\n");
        for (int i = 0; i < SIZE; i++)
        {
            if (array[i] != NULL)
            {
                printf("Personalnummer: %d\nName: %s\nGehalt: %f\n\n",
                       array[i]->personalnummer, array[i]->name, array[i]->gehalt);
            }
        }

        printf("Möchten Sie weiter am Programm arbeiten? (j / n): ");

        scanf("%c", &input);
        printf("\n");

        if (input == 'n' || input == 'N')
        {
            run = false;
        }
    }
}
