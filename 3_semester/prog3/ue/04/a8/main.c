#include <stdio.h>
#include <time.h>

int main(void)
{
    time_t arr[] = {645703200,
                    49888800};

    printf("%s", ctime(&arr[0]));
    printf("%s", ctime(&arr[1]));

    return 0;
}
