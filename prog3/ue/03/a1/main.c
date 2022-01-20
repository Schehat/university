#include <stdio.h>

int main(void)
{
    // %zu format specifier for size_t
    printf("char: %zu\n", sizeof(char));
    printf("pointer: %zu\n", sizeof(char *));
    printf("string: %zu\n", sizeof("hello"));
    printf("int: %zu\n", sizeof(1));
    printf("short int: %zu\n", sizeof(short int));
    printf("long int: %zu\n", sizeof(long int));
    printf("float: %zu\n", sizeof(float));
    printf("double: %zu\n", sizeof(double));
    printf("long double: %zu\n", sizeof(long double));
    return 0;
}