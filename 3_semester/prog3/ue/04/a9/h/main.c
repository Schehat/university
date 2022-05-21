#include <stdio.h>
int main()
{
    int a[4] = {1, 2, 3, 4};
    int *p = a + 3;
    printf("%d %d\n", p[-2], a[*p]);
}
