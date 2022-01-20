GCC_ARGS = -std=c99 -Wall -pedantic-errors
OBJ = create20.o main.o print20.o add20.o

main: $(OBJ)
	gcc $(GCC_ARGS) -o $@ $(OBJ)

%.o: %.c
	gcc $(GCC_ARGS) -c $<

main.o: create20.h int20.h print20.h
create20.o: create20.h int20.h
print20.o: print20.h int20.h
add20.o: int20.h

clean:
	rm main $(OBJ)