# Lexical-and-Syntactic-Analyzer

# Lexical analyzer
This program will read the text of the source code, written in the MIO programming language (“programa.mio”), and
identify the lexical units of the language; in case a lexical unit does not belong to the language, it
will print an error message that includes the line number of the input code file where it is
found the error. The identified token sequence will be written to a text file ("program.lex"), a
token per line.

>>Reserved words
<ul>
  <li>PROGRAMA </li>
  <li> FINPROG </li>
  <li> SI </li>
  <li> ENTONCES </li>
  <li> SINO </li>
  <li> FINSI </li>
  <li> REPITE </li>
  <li> VECES </li>
  <li> FINREP </li>
  <li> IMPRIME </li>
  <li> LEE </li>
</ul>

>>Relational operators
<ul>
  <li> Bigger than (>) </li>
  <li> Less than (<) </li>
  <li> Equals to (==) </li>
  <li> Assignation (=) </li>
  <li> Comment (# at the beginning of
the line and contains up
100 characters) </li>
</ul>

>>Arithmetic operators
<ul>
  <li> Addition (+) </li>
  <li> Subtract (-) </li>
  <li> Multiplication (*) </li>
  <li> Division (/) </li>
</ul>

# Syntactic analyzer.
This program will read the sequence of the token file (“program.lex”) to identify the structures
grammatical of the MIO programming language. As a result, the program will print "Build Successful"
in case you do not find syntactic errors in the code, or "Error: (type of statement that caused the error)".
Grammar:
Initial symbol: <PROG>
Rules:
<ul>
  <li> < PROG >  PROGRAMA [id] < SENTS > FINPROG </li>
  <li> < SENTS >  < SENT > < SENTS > </li>
  <li> < SENTS >  < SENT > </li>
  <li> < SENT >  [id] = < ELEM > [op_ar] < ELEM > </li>
  <li> < SENT >  [id] = < ELEM > </li>
  <li> < SENT >  SI < COMPARA > ENTONCES < SENTS > SINO < SENTS > FINSI </li>
  <li> < SENT >  SI < COMPARA > ENTONCES < SENTS > FINSI </li>
  <li> < SENT >  REPITE < ELEM > VECES < SENTS > FINREP </li>
  <li> < SENT >  IMPRIME < ELEM > </li>
  <li> < SENT >  IMPRIME [txt] </li>
  <li> < SENT >  LEE [id] </li>
  <li> < SENT >  # [comentario] </li>
  <li> < ELEM >  [id] </li>
  <li> < ELEM >  [val] </li>
  <li> < COMPARA > [id] [op_rel] < ELEM > </li>
</ul>
