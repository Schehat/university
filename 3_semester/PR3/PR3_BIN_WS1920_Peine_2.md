# Programmieren 3 Peine WiSe 19/20 - 22.01.2020

## 1 Was ist eine Java Objectreverenz in c++ am ähnlichtens (1 Punkt)

ein kreuz

1. Referenz auf den Heap
2. Referenz auf ein Objekt
3. -- zeiger? --
4. -- ka --

## 2 Stackframe aufschreiben bei /*stop*/  (7/8 Punkte)
```c++
typedef struct {
	int n; 
	char c;
} data;

void foo(data *dp, data d1) {
	char v;
	dp--;
	v=dp->c;
	d1.n=5;
	/*stop*/
}

int main(void) {
	data d[] = {{1, 'a'}, {3,'b'}};
	char v = 'A';
	foo(d+1, d[1]);
	return 0;
}
```

## 3 Welche ausgabe macht das Programm Code-Trace ()

```c++
using namespace std;
class A{
public: 
	int data; 
	int id; 
	static int counter;
	A() {
		data = 0;
		id = counter++;
	}
	A(const A& other) {
		data = other.data;
		id = counter++;
	}
};
int A::counter{0};

void foo(A& a1, A a2) {
	++a1.data;
	++a2.data
	cout << a1.data << a1.id << a2.data << a2.id << endl;
}

int main(void) {
    A x, y;
    foo(x, y);
    foo(x, y);
    return 0;
}
```
| Zeitpunkt                                                        | Wert von x.data bzw. a1.data | Wert von x.id bzw. a1.id | Wert von y.data bzw. a2.data | Wert von y.id bzw. a2.id |
|------------------------------------------------------------------|------------------------------|--------------------------|------------------------------|--------------------------|
| Nach Konstruktion von x und y                                    | 0                            | 0                        | 0                            | 1                        |
| Nach Eintritt in foo (direkt hinter { )                          |                              |                          |                              |                          |
| Vor Rückkehr aus foo (direkt vor } ) (entspricht 1. Ausgabe)     |                              |                          |                              |                          |
| Nach 2ter Eintritt in foo (direkt hinter { )                     |                              |                          |                              |                          |
| Vor 2te Rückkehr aus foo (direkt vor } ) (entspricht 2. Ausgabe) |                              |                          |                              |                          |


## 4 Was ist zu erwarten? (4 Punkte)

mehrere Antwortmöglichkeiten

```c++
const Objekt& func() {
	Objekt neu;
	return neu;
}
```

1. Compilerfehler, wegen const
2. ?
3. ?
4. Kein Compilerfehler, unerwartetes Verhalten (richtig)
5. Laufzeitfehler



## 5 Vererbung (21 Punkte)

krass geschriebener text
- tiefe Kopie Konstrutor 
	- mit inital liste
- Destrutor (name freigeben)
- keine weiteren methoden
- baby darf nur als param alter = 0 sonst muss invalid_exception aus <exception> geworfen werden
- ort gegeben kann nicht geändert werden und zeiger übergeben


```c++
int main(){
	Ort hannover {"Hannover", 10 , 10};
	Ort hamburg {"Hamburg", 10 , 10}; 

	Person p = {&hannover, &hamburg, 10, "John doe"};
	Baby b = {&hamburg, &hannover, "Ann-Christin"};

	p.setAlter(26);
	b.setAlter(3); // soll fehler werfen

	cout << b.getName() << endl;
	return 0;
}
```

### die beiden h datein wurden mit einem text beschrieben
#### Person.h
```c++
class Person {
private:
	int alter;
	std::string name;
	Ort* wohnort;
	Ort* geburtsort;

public:
	Person(Ort* geb, Ort* wohn, int alter, std::string name);
	virtual ~Person();
	virtual void setAlter(int);
	const std::string getName() const;
}
```

#### Baby.h
```c++
class Baby : public Person {
	Baby(Ort* geb, Ort* wohn, std::string name);

	virtual void setAlter(int) override;
}
```



## 6 Operatoren überladen (13 Punkte)

schreiben Sie den
- copy Konstrutor (tiefe kopie)
- operator =
- operator == (breite laenge wie auch die *zeichenkette*(inhalt) vom namen sollen gleich sein)

vermeiden Sie Redudanz und keine weitern methoden
- wenn kein name gegebn dann ist es ein nullptr


### Ort.h
```c++
class Ort {
private:
	int leange;
	int breite;
	std::string* name;
public:
	// hier der code
}
```
```c++
int main() {
	Ort o1 {"Hannover", 10 , 10};
	Ort o2 {"Hamburg", 10 , 10}; 
}
```


## 7 Mehrfachvererbung (6 Punkte) Java / c++

### Was ist in Java möglich wie in C++? (ankreuzen)
1. kann Attribute definieren
2. kann Methodendefinieren
3. kann Methodendeklaieren
4. kann prototypenmethoden schreiben
5. ?

### Was ist in C++ möglich? (ankreuzen)

1. Mehrere Objekte extende
2. exceptions definieren
3. attribute definieren

### Wie kann man ambiguous Verhalten erzeugen (class.x soll ambiguous sein) 

so wenig code wie möglich schreiben

```c++
class A { /*leere klasse */}
A a;
a.x = 1;
```