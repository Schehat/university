#include <stdio.h>

void tausche_intPtr(int **i, int **j)
{
    int *a = *i; // Warnung bei a**

    *i = *j;
    *j = a;
}

void tausche_int(int *i, int *j)
{
    int a = *i;
    *i = *j;
    *j = a;
}
int main(void)
{
    int i = 1;
    int j = 2;
    printf("i = %d, j = %d\n", i, j); /* Gibt 1 und 2 aus */
    tausche_int(&i, &j);
    printf("i = %d, j = %d\n", i, j); /* Gibt 2 und 1 aus */

    int *ptri = &i;
    int *ptrj = &j;

    printf("ptri = %p, ptrj = %p\n", ptri, ptrj);
    tausche_intPtr(&ptri, &ptrj);
    printf("ptri = %p, ptrj = %p\n", ptri, ptrj);
    return 0;
}
