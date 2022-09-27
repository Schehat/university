#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main(void)
{
    FILE *fp = fopen("a.txt", "r");
    char c = fgetc(fp);
    fclose(fp);
    fp = fopen("b.txt", "w");
    fputc(c, fp);
    fclose(fp);
}
