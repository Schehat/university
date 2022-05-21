gcc_args = -Wall -std=c99 -pedantic-errors
obj = a_4_2.o qinit.o

a_4_2: $(obj)
	gcc $(gcc_args) -o $@ $(obj)

%.o: %.c
	gcc $(gcc_args) -c $<

a_4_2.c.o: qinit.h

clean:
	rm a_4_2 $(obj)