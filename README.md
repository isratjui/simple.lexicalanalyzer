# simple.lexicalanalyzer

Problem Description:
A simple lexical analyzer that will build a symbol table from given stream of chars.
For simplicity, input file will be a C program without headers and methods

Identifying all the numerical values, identifiers, keywords, math operators, logical operators and others [distinct].

See the example for more details.

Input:
int a, b, c;
float d, e;
a = b = 5;
c = 6;
if ( a > b)
{
	c = a - b;
	e = d - 2.0;
}
else
{
	d = e + 6.0;
	b = a + c;
}

Output:
Keywords: int, float, if, else
Identifiers: a, b, c, d, e
Math Operators: +, -, =
Logical Operators: >
Numerical Values: 5, 6, 2.0, 6.0
Others: , ; ( ) { }
