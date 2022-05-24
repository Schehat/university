PARAM = -std=c++14 -Wall -pedantic-errors
OBJ = Person.o Baby.o main.o 

main: $(OBJ)
	g++ $(PARAM) -o $@ $^

%.o: %.cpp
	g++ $(PARAM) -c $<

Person.o: Person.h
main.o: Person.h Baby.h
Baby.o: Person.h

clean:
	rm main $(OBJ)