#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main(void)
{
    (fork() && fork()) || fork();
    printf("%s\n", "bsn2");
    return 0;
}