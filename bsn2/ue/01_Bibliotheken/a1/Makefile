<<<<<<< HEAD
# Bedeutung der Compiler−Optionen
# −c : kompiliert Quellen ohne Binder
# −Wall : a l l e Warnungen anzeigen
# −ansi : ANSI C Standard pruefen
# −fPIC: positionsunabhaengiger Code, noetig zum Erstellen von shared libraries 
# −g : Standard Debug−Informationen hinzufuegen
# .a: archive 

GCC_ARGS = -g -std=c99 -Wall -pedantic-errors -fPIC

# ar: Werkzeug zum Erstellen von Bibliotheken 
# r: replace or add
# c: keine Nachricht auf STDERR schreiben
# s: object−file index in das Archiv schreiben. Damit die Bibliothek gegliedert ist und einzelne .o-Dateien angesprochen werden können 
AROPTS = rcs

default: testprog_s libaddnumber.a libaddnumber.so

testprog_s: testprog.o libaddnumber.a
	gcc $(GCC_ARGS) -static -L testprog.c -o testprog_s -laddnumber

# testprog_d: testprog.o libaddnumber.so
# 	gcc $(GCC_ARGS) -o $@ -L. -laddnumber 

file1.o: file1.c file1.h
	gcc $(GCC_ARGS) -c $<

file2.o: file2.c file2.h
	gcc $(GCC_ARGS) -c $<

testprog.o: testprog.c file1.h file2.o
	gcc $(GCC_ARGS) -c testprog.c

libaddnumber.a: file1.o file2.o
	ar $(rcs) my_library.a file1.o file2.o

# libaddnumber.so: file1.o file2.o
# 	gcc $(GCC_ARGS) -shared -o $@ file1.o file2.o

clean:
=======
GCC_ARGS = -g -std=c99 -Wall -pedantic-errors

default: file1.o file2.o my_library

file1.o: file1.c file1.h
	gcc $(GCC_ARGS) -c $<

file2.o: file2.c file2.h
	gcc $(GCC_ARGS) -c $<

my_library: file1.o file2.o
	ar rcs my_library.a file1.o file2.o

clean:
>>>>>>> 2d9e4322f853d07aff91b5ffe196acaed53f5f41
	rm file1.o file2.o