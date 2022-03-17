# Bedeutung der Compiler−Optionen
# −c : kompiliert Quellen ohne Binder
# −Wall : a l l e Warnungen anzeigen
# −ansi : ANSI C Standard pruefen
# −fPIC: positionsunabhaengiger Code, noetig zum Erstellen von shared libraries 
# −g : Standard Debug−Informationen hinzufuegen

GCC_ARGS = -g -std=c99 -Wall -pedantic-errors -fPIC

# ar: Werkzeug zum Erstellen von Bibliotheken 
# r: replace or add
# c: keine Nachricht auf STDERR schreiben
# s: object−file index in das Archiv schreiben. Damit die Bibliothek gegliedert ist und einzelne .o-Dateien angesprochen werden können 
AROPTS = rcs

default: testprog_s testprog_d

file1.o: file1.c file1.h
	gcc $(GCC_ARGS) -c $<

file2.o: file2.c file2.h
	gcc $(GCC_ARGS) -c $<

# statisch verlinkte Bibliothek bauen
libaddnumber_s.a: file1.o file2.o
	ar $(AROPTS) libaddnumber_s.a file1.o file2.o

# dynamisch verlinkte Bibliothek bauen
libaddnumber_d.so: file1.o file2.o
	gcc $(GCC_ARGS) -shared -o libaddnumber_d.so file1.o file2.o

# statische verlinkte test_prog
testprog_s: testprog.c file1.h file2.h libaddnumber_s.a
	gcc $(GCC_ARGS) --static -L. testprog.c -o testprog_s -laddnumber_s

# dynamisch verlinkte test_prog
testprog_d: testprog.c file1.h file2.h libaddnumber_d.so
	gcc $(GCC_ARGS) -L. testprog.c -o testprog_d -laddnumber_d

# testprog.o: testprog.c file1.h file2.o
# 	gcc $(GCC_ARGS) -c testprog.c

clean:
	rm *.o && rm *.a && rm *.so