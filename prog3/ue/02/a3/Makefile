GCC_ARGS = -std=c99 -Wall -pedantic-errors
OBJ = math.o summe.o differenz.o input.o

math: $(OBJ)
	gcc $(GCC_ARGS) -o $@ $(OBJ)

%.o: %.c
	gcc $(GCC_ARGS) -c $<

math.o: summe.h differenz.h

summe.o: input.h

differenz.o: input.h

clean:
	rm math $(OBJ)
