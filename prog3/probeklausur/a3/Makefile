main: main.o punkt.o
	gcc -o $@ $^
%.o: %.c
	gcc -c $<
main.o: punkt.h
clean:
	rm main main.o punkt.o