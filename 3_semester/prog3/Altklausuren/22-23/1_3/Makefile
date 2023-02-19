GCC_ARGS = -std=c99 -Wall -pedantic-errors
OBJ = main.o buch.o

main: $(OBJ)
	gcc $(GCC_ARGS) -o $@ $(OBJ)

%.o: %.c
	gcc $(GCC_ARGS) -c $<

main.o: buch.h

clean:
	rm main $(OBJ)