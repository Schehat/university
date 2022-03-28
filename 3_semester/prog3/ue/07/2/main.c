#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define NAME_LEN 40
#define N_ANGEST 5

static const char FILE_NAME[] = "angestellte.dat";

typedef struct
{
    char name[NAME_LEN + 1];
    int personalnummer;
    float gehalt;
} angestellter;

angestellter init_angest(char name[], int pn, float gehalt)
{
    angestellter angest;
    strcpy(angest.name, name);
    angest.personalnummer = pn;
    angest.gehalt = gehalt;
    return angest;
}

void binaer_speichern(angestellter arr[], int anz)
{
    FILE *f = fopen(FILE_NAME, "wb");
    fwrite(&anz, sizeof(anz), 1, f);
    fwrite(&arr[0], sizeof(angestellter), anz, f);
    fclose(f);
}

void binaer_laden_und_ausgeben(void)
{
    FILE *f = fopen(FILE_NAME, "rb");
    int laenge;
    fread(&laenge, sizeof(laenge), 1, f);
    angestellter *angest_ptr = malloc(laenge * sizeof(*angest_ptr));
    fread(angest_ptr, sizeof(*angest_ptr), laenge, f);
    fclose(f);

    for (int i = 0; i < laenge; ++i)
    {
        printf("%s, %d, %0.2f\n", angest_ptr[i].name, angest_ptr[i].personalnummer, angest_ptr[i].gehalt);
    }
}

int main(void)
{
    angestellter angest[N_ANGEST];
    angest[0] = init_angest("Schehat", 1, 1000);
    angest[1] = init_angest("Deti", 2, 2000);
    angest[2] = init_angest("Furkan", 3, 3000);
    angest[3] = init_angest("Hien", 4, 4000);
    angest[4] = init_angest("Aland", 5, 5000);

    binaer_speichern(angest, N_ANGEST);
    binaer_laden_und_ausgeben();
}
