#include <stdio.h>
#include <stdlib.h>

struct Knoten
{
    int value;
    struct Knoten *next;
};

typedef struct Knoten Knoten;

Knoten *copy(Knoten *head)
{
    if (head == NULL)
        return NULL;

    Knoten *laufzeiger = head;
    Knoten *c_laufzeiger = (Knoten *)malloc(sizeof(Knoten));
    Knoten *save_head = c_laufzeiger;

    c_laufzeiger->value = head->value;

    while (laufzeiger != NULL)
    {
        printf("%d\n", laufzeiger->value);

        c_laufzeiger->next = (Knoten *)malloc(sizeof(Knoten));
        c_laufzeiger->next->value = laufzeiger->value;
        c_laufzeiger->next->next = laufzeiger->next;

        c_laufzeiger = c_laufzeiger->next;

        laufzeiger = laufzeiger->next;
    }
    return save_head;
}

int main(void)
{
    Knoten s1 = {1, NULL};
    Knoten s2 = {2, NULL};
    Knoten s3 = {3, NULL};
    Knoten s4 = {4, NULL};

    s1.next = &s2;
    s2.next = &s3;
    s3.next = &s4;

    Knoten *c1 = copy(&s1);
    Knoten *laufzeiger = c1;
    while (laufzeiger != NULL)
    {
        printf("%d\n", laufzeiger->value);
        laufzeiger = laufzeiger->next;
    }
}