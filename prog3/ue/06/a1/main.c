#include <stdio.h>
#include <string.h>
int main(void)
{
    char text[] = "HALLO WELT!"; /* lokal im main-Stackframe */
    printf("main(): text= %s\n", text);
    printf("main(): Adressbereich= %p-%p\n", (void *)text, (void *)&text[strlen(text)]);
    sub();
    printf("main(): text= %s\n", text);
    printf("main(): Adressbereich= %p-%p\n", (void *)text, (void *)&text[strlen(text)]);
    printf("Ende main\n");
    return 0;
}
struct S
{
    char c[64];
};
int sub(struct S s)
{
    int k;
    printf("\nAdresse s: %p & k: %p\n\n", (void *)&s.c, (void *)&k);
    for (k = 63; k >= 0; k--)
    {
        printf("sub(): %3d (%p): %02X %c\n",
               k, s.c + k, (unsigned char)s.c[k], s.c[k]);
    }
    strcpy(s.c, "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed di");
    return 0;
}