#ifndef BUCH_H
#define BUCH_H
typedef struct
{
    int nr;
    int ausgeliehen;
} buch;
extern buch erzeuge(int nr);
extern void ausleihen(buch *buch);
#endif