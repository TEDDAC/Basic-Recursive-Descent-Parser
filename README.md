# Basic Arithmetic Recursive Descent Parser

Based on [Recursive Descent Parsing](https://www.youtube.com/watch?v=SToUyjAsaFk) by [hpp3](https://www.youtube.com/watch?v=SToUyjAsaFk).

I created this parser to learn about the Recursive Descent Parser algorithm.

## Lexing and Parsing

Lexing is done before parsing.

## Grammar

This parser is based on the following Context-Free Grammar.

```
E -> T + E | T - E | T
T -> F* T | F / T | F
F -> Integer

Integer -> /[0-9+]/
```