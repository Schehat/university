#include <stdio.h>
#include <unistd.h>

int main(void)
{
    FILE *input = fopen("test_input.txt", "r");
    FILE *output = fopen("test_output.txt", "w");
    char zeichen[1];
    fgets(zeichen, 1, input);
    while (zeichen != EOF)
    {
        printf("%d", fputs(zeichen, output));
        if (fputs(zeichen, output) == EOF)
        {
            printf("%s", "Ein Fehler ist beim Schreiben aufgetreten");
            return -1;
        }
        fgets(zeichen, 1, input);
    }
    fclose(input);
    fclose(output);
    return 0;
}
