#include <iostream>
#define SIZE 5

using namespace std;

int *createArray(int n)
{
    int *arr{new int[n]};
    return arr;
}

void releaseArray(int *&arr)
{
    delete[] arr;
    arr = nullptr;
}

/**
void free0(char **p)
{
    free(*p);
    *p = NULL;
}
*/

int main(void)
{
    int *arr{createArray(SIZE)};

    // not suitable, no begin and end function
    // for (auto &elem : arr)
    // {
    //     elem = 1;
    // }

    for (int i = 0; i < SIZE; i++)
    {
        arr[i] = i;
        cout << arr[i] << endl;
    }

    releaseArray(arr);

    return 0;
}