#include <stdio.h>

int main(void) {
    int a;

    do {
        printf("%s", "Bitte positive ganze Zahl eingeben: ");
        scanf("%d", &a);
    } while (a <= 0);

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (i == 0) {
                printf("%s", " ");
            }

            printf("%d", i*10+10);

            if ((i*10 + 10) % a == 0) {
                printf("%s", "# ");
            } else {
                printf("%s", " ");
            }
        }
    }   
}