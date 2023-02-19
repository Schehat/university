#include <stdio.h>
#include <stdlib.h>
#define MAX(x, y) x > y ? x : y;
struct knoten
{
    int wert;
    struct knoten *next;
};
typedef struct knoten knoten;

knoten *max_liste(knoten *liste1, knoten *liste2)
{
    if (liste1 == NULL || liste2 == NULL)
    {
        return NULL;
    }

    knoten *copy_head = (knoten *)malloc(sizeof(knoten));
    copy_head->wert = MAX(liste1->wert, liste2->wert);
    copy_head->next = max_liste(liste1->next, liste2->next);

    return copy_head;
}

int main(void)
{
    knoten k3 = {9, NULL};
    knoten k2 = {4, &k3};
    knoten k1 = {1, &k2};

    knoten k6 = {10, NULL};
    knoten k5 = {3, &k6};
    knoten k4 = {2, &k5};

    knoten *x = max_liste(&k1, &k4);
    printf("%d %d %d", x->wert, x->next->wert, x->next->next->wert);
}