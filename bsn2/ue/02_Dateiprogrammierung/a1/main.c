#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main(void)
{
    int fd = open("test.txt", O_RDONLY);
    // new line important due to terminal line buffered
    printf("%d\n", fd);
    // alternative if not line buffered e.g. file then this
    // fflush(STDOUT_FILENO)
    sleep(60);
}