#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main(void)
{
    char filename[] = "bsn2.txt";
    int fd = open(filename, O_RDWR);
    printf("%d", fd);
    close(fd);
    return 0;
}
