#include <stdio.h>
void foo(int[]);
int main()
{
    int a[4] = {1, 2, 3, 4};
    foo(a);
    printf("%d ", a[0]);
}
void foo(int *p)
{
    int i = 10;
    p = &i;
    printf("%d ", p[0]);
}
