#include <stdio.h>
#define LEN 3

const double mehrwertsteuer = 0.19;

void steuern(double netto)
{
    printf("Mwst. vom Netto: %.2f\n", netto * mehrwertsteuer);
}

void brutto(double netto)
{
    printf("Brutto vom Netto: %.2f\n", netto + netto * mehrwertsteuer);
}

void netto(double brutto)
{
    printf("Netto vom Brutto: %.2f\n", brutto / (1 + mehrwertsteuer));
}

void output()
{
    printf("Ihre Eingabe\n");
    printf("\t<funktion> [<betrag>]\n");
    printf("Bedeutung von <funktion>: 0=Mwst. vom Netto, 1=Brutto vom Netto, 2=Netto vom Brutto, 3=Ende\n");
    printf("z. B. 0 99.95\t (für die Berechnung der Mehrwertsteuer von 99.95 netto)\n");
}

int main(void)
{
    void (*func[LEN])(double);
    func[0] = steuern; // or &steuern
    func[1] = brutto;
    func[2] = netto;

    output();
    int index;
    double val;
    scanf("%d", &index);
    if (index == 3)
        return 0;
    scanf(" %lf", &val);

    while (index != 3)
    {
        (*func[index])(val);

        printf("\n");
        output();
        scanf("%d", &index);
        if (index == 3)
            break;
        scanf(" %lf", &val);
    }
}