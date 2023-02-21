PARAM = -std=c++14 -Wall -pedantic-errors
OBJ = Person.o Buch.o Lehrbuch.o main.o

main: $(OBJ)
	g++ $(PARAM) -o $@ $^

%.o: %.cpp
	g++ $(PARAM) -c $<

main.o: Person.h Buch.h Lehrbuch.h
Person.o: Person.h
Buch.o: Buch.h Person.h
Lehrbuch.o: Buch.h Person.h Lehrbuch.h

clean:
	rm main $(OBJ)