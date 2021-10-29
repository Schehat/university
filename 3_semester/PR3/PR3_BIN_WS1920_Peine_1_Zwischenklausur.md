##  1 ankreuzen kann das in die .h oder muss das in die .c Datei - 3p

1. typedef struct ss;
2. struct s ss;
3. struct s;
4. struct s { int x; int y; }
5. struct s \*ss

## 2 foo Programmieren - 9p

Quersumme char2toInt

schhreibe eine funktion foo die die quersumme ausrechnet

```
int char2int(char c) {
    return c - '0';
}

int main(void) {
    char zahl[] = "3254712874217846";
    int querSumme = 0;
    char *cursor = zahl;
    while(cursor != '\0'){
        foo(_________, _______);
    }
}
```

## 3a Point 2D - 12,5p

schreibe ein lauffähiges program das folgenden code korrekt ausführt! erzeuge soll eine *Wertübergabe* machen Spiegeln soll "via pointer" funktionieren

spiegelung.c

```
int main(){
    ________ = erzeuge(5, 2);    
    spiegeln(_______);
    printf("(%d,%d)", p.x, p.y); // soll (-5,2) sein
    return 0;
}
```

Schreibe punkt.h und punkt.c

* punkt.h
* punkt.c

## 3b

deinen code in seinem code ergänzen

## 3c schreibe zu 3a & 3b ein makefile

## 4 Ankreuzen ob wahr oder Falsch - 3p

```
void foo(){
    int local;
    int *p = (int*) malloc(sizeof(int)); 
}
```

* liegen \*p und local werte nebeneinander im Stack
* rekursive Funktion, kann man anhand des Quelltextes ablesen wie groß der Stack wird.
* kann der Speicher des Programms voll laufen wenn man wiederholt foo aufruft
* p zeigt auf einen Speicherblock im heap

## 5 welche Adresse ist matrix[1] - 1,5p

start Adresse von der Matrix ist 7000 sizeof(int) ist 4

```
int matrix[10][3]
```

welche Adresse ist matrix[1]

matrix[1] nicht verwechseln mit matrix[1][0]