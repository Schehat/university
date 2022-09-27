#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>

int main(void)
{
    char filename[] = "bsn2.txt";
    int fd = open(filename, O_RDWR);
    char text[] = "bsn2";
    int byteWritten = write(fd, text, strlen(text));
    close(fd);
    return 0;
}
