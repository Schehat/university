#include <stdio.h>
#include <string.h>
#define N_NUMBERS 10

struct intStruct
{
    char number[N_NUMBERS];
};

int main(void)
{
    struct intStruct myStruct = {"0000000000"};
    strcpy(myStruct.number, "234");
    printf("%s", myStruct.number);
    return 0;
}