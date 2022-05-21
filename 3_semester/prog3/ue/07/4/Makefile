GCC_ARGS = -Wall -std=c99 -pedantic-errors
OBJ = liste1ende.o liste1endetest.o

program: $(OBJ)
	gcc $(GCC_ARGS) -o $@ $(OBJ)

%.o: %.c
	gcc $(GCC_ARGS) -c $<

liste1ende.o: liste1ende.h
liste1endetest.o: liste1ende.h

clean:
	rm math $(OBJ)