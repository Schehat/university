#include <stdio.h>
#include <stdbool.h> 

int main() {
    int b = false;

    for(int i = 0; i < 100 && !b; i++) {
        if (i*i - 3 > 90) {
            printf("%d", i);
            b = true;
            printf("\n%s", "does make work?");
        }
    }

    return 0;
}