# Lexical-and-Syntactic-Analyzer

Lexical analyzer
This program will read the text of the source code, written in the MIO programming language (“programa.mio”), and
identify the lexical units of the language; in case a lexical unit does not belong to the language, it
will print an error message that includes the line number of the input code file where it is
found the error. The identified token sequence will be written to a text file ("program.lex"), a
token per line.

Reserved words
 PROGRAMA
 FINPROG
 SI
 ENTONCES
 SINO
 FINSI
 REPITE
 VECES
 FINREP
 IMPRIME
 LEE

Relational operators
 Bigger than (>)
 Less than (<)
 Equals to (==)
 Assignation (=)
 Comment (# at the beginning of
the line and contains up
100 characters)

Arithmetic operators
 Addition (+)
 Subtract (-)
 Multiplication (*)
 Division (/)


Syntactic analyzer.
This program will read the sequence of the token file (“program.lex”) to identify the structures
grammatical of the MIO programming language. As a result, the program will print "Build Successful"
in case you do not find syntactic errors in the code, or "Error: (type of statement that caused the error)".
Grammar:
Initial symbol: <PROG>
Rules:
<PROG>  PROGRAMA [id] <SENTS> FINPROG
<SENTS>  <SENT> <SENTS>
<SENTS>  <SENT>
<SENT>  [id] = <ELEM> [op_ar] <ELEM>
<SENT>  [id] = <ELEM>
<SENT>  SI <COMPARA> ENTONCES <SENTS> SINO <SENTS> FINSI
<SENT>  SI <COMPARA> ENTONCES <SENTS> FINSI
<SENT>  REPITE <ELEM> VECES <SENTS> FINREP
<SENT>  IMPRIME <ELEM>
<SENT>  IMPRIME [txt]
<SENT>  LEE [id]
<SENT>  # [comentario]
<ELEM>  [id]
<ELEM>  [val]
<COMPARA>  [id] [op_rel] <ELEM>
