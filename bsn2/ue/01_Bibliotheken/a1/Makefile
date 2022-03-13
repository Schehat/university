GCC_ARGS = -g -std=c99 -Wall -pedantic-errors

default: file1.o file2.o my_library

file1.o: file1.c file1.h
	gcc $(GCC_ARGS) -c $<

file2.o: file2.c file2.h
	gcc $(GCC_ARGS) -c $<

my_library: file1.o file2.o
	ar rcs my_library.a file1.o file2.o

clean:
	rm file1.o file2.o