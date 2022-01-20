#include <stdio.h>
#include "qinit.h"

int main(void)
{
    int arr[12];
    int arr_size = sizeof(arr) / sizeof(0);
    qinit(arr, arr_size);
    return 0;
}