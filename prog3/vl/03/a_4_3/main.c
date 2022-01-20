#include <stdio.h>

int main(void) {
    int arr[10][10];

    for (int i = 1; i < 10; i++) {
        arr[0][i] = i;
        arr[i][0] = i;
    }

    for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 10; j++) {
            arr[i][j] = arr[i][0] * arr[0][j];
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }
    return 0;
}