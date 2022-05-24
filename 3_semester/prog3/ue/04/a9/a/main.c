#include <stdio.h>
void main()
{
    int a[3] = {1, 2, 3};
    int *p = a;
    printf("%a %p", p, a);
}