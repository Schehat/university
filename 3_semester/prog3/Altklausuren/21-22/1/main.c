#include <stdio.h>
#include <stdlib.h>

struct Knoten
{
    int value;
    struct Knoten *next;
};

typedef struct Knoten Knoten;

Knoten *copyRecursive(Knoten *head)
{
    if (head == NULL)
        return NULL;

    Knoten *copy_head = (Knoten *)malloc(sizeof(Knoten));
    copy_head->value = head->value;
    copy_head->next = copyRecursive(head->next);
    return copy_head;
}

Knoten *copyIterative(Knoten *head)
{
    if (head == NULL)
        return NULL;

    Knoten *copy_head = (Knoten *)malloc(sizeof(Knoten));
    Knoten *copy_curr = copy_head;
    copy_curr->value = head->value;
    while (head->next != NULL)
    {
        copy_curr->next = (Knoten *)malloc(sizeof(Knoten));
        copy_curr = copy_curr->next;
        head = head->next;
        copy_curr->value = head->value;
    }
    copy_curr->next = NULL;
    return copy_head;
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

    Knoten *c1 = copyRecursive(&s1);
    Knoten *laufzeiger = c1;
    while (laufzeiger != NULL)
    {
        printf("%d\n", laufzeiger->value);
        laufzeiger = laufzeiger->next;
    }
}