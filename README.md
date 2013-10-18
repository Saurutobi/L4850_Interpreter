L4850_Interpreter
=================

Creating an AST for the L4850 programming Language

this readme is just a copy and paste from the specification pdf that we recieved from class. 
This branch will not impliment all features, but by the end of our project the master branch should
meet the specifications to an 'A' level

L4850: A Dynamically Typed Language for Instruction
L4850 is a programming language designed for practice interpretation. L4850 is a simple
dynamically typed language that contains elements of functional, object-oriented and im-
perative paradigms. L4850 is intended to be simple enough to interpret in a single semester
by any student willing to put in some eort. Each feature included in the language was
added specically to help students learn about the meaning of programs written in dierent
paradigms. The goal of this project is to help student understand what it means to express
something in a language by writing an operational semantics (fancy words for interpreter).
In the process, I hope that you will understand object-oriented design better and also learn
about functional programming.
1 L4850 Syntax
1.1 Lexical Properties of L4850
1. In L4850, blanks are signicant.
2. In L4850, all keywords are reserved; that is, the programmer cannot use an L4850
keyword as the name of a variable. The valid keywords are:
hASSIGNi ! assign
hCONDi ! cond
hDEFCLASSi ! defclass
hDEFUNCi ! defunc
hELSEi ! else
hFALSEi ! false
hFIi ! fi
hFUNCi ! func
hIFi ! if
hLOADi ! load
hMETHODi ! method
hNEWi ! new
hTHENi ! then
hTOi ! to
hTRUEi ! true
hVARSi ! vars
hWITHi ! with
(Note that L4850 is case sensitive, that is, the variable X diers from x. Thus, cond is
a keyword, but COND can be a variable name.)
1
3. The following special characters have meanings in an L4850 program.
hANDi ! &&
hCOMMAi ! ,
hDIVIDEi ! /
hDOTi ! .
hEQUALi ! ==
hGREATERi ! >
hGREATEREQUALi ! >=
hINVOKEi ! ->
hLBi ! f
hLBKi ! [
hLESSi ! <
hLESSEQUALi ! <=
hLPi ! (
hMINUSi ! -
hMULTIPLYi ! *
hNOTi ! !
hNOTEQUALi ! !=
hORi ! ||
hPLUSi ! +
hRBi ! g
hRBKi ! ]
hRPi ! )
4. Comments are delimited by a //. All characters following the //on the same line are
part of the comment.
5. Identiers are written with upper and lowercase letters and are dened as follows:
hALPHAi ! a j b j c j    j z j A j B j    j Z
hDIGITi ! 0 j 1 j 2 j    j 9
hIDENTIFIERi ! hLETTERi (hLETTERi j hDIGITi )
6. Constants are dened as follows:
hPOSITIVEi ! 1 j 2 j 3 j ::: j 9
hINTNUMi ! hPOSITIVEi hDIGITi j 0
hEXPONENTi ! ( e j E ) ( + j - )? ( hDIGITi )+
hFLOATNUMi ! hINTNUMi ( hDOTi ( hDIGITi )+
( hEXPONENTi )? j hEXPONENTi )
hSTRINGi ! 0 (  [ 0 ] ) 0
1.2 Context-free Grammar
The following grammar describes the context-free syntax of L4850:
2
program ! ( functionDef
j classDef
j expression
j loadFile )+
functionDef ! hDEFUNCi hIDi hLPi ( idList )? hRPi expressionList
idList ! hIDi ( hCOMMAi hIDi )
classDef ! hDEFCLASSi hIDi hLBi ( classVars )? ( methods )? hRBi
classVars ! hVARSi idList
methods ! ( hMETHODi hIDi hLPi ( idList )? hRPi expressionList )+
loadFile ! hLOADi hSTRINGi
expressionList ! hLBi ( expression )+ hRBi
expression ! compExpr ( logOp compExpr )
j hNOTi compExpr
logOp ! hORi j hANDi
compExpr ! addExpr ( compOp addExpr )
compOp ! hEQUALi j hNOTEQUALi j hLESSi j hLESSEQUALi
j hGREATERi j hGREATEREQUALi
addExpr ! mulExpr ( addOp mulExpr )
addOp ! hPLUSi j hMINUSi
mulExpr ! factor ( mulOp factor )
mulOp ! hMULTIPLYi j hDIVIDEi
3
factor ! operand ( call )?
operand ! varRef j constant j newExpr j ifExpr
j funcExpr j assignExpr j condExpr
j withExpr j hLPi expression hRPi
call ! hINVOKEi hLPi ( paramList )? hRPi
paramList ! expression ( hCOMMAi expression)
varRef ! hIDi ( hDOTi hIDi )?
constant ! hINTUMi j hFLOATNUMi j list j hSTRINGi
j hTRUEi j hFALSEi
list ! hLBKi constantList hRBKi
constantList ! constant ( hCOMMAi constant )
newExpr ! hNEWi hIDi
ifExpr ! hIFi expression hTHENi expression hELSEi expression hFIi
funcExpr ! hFUNCi hLP i ( idList )? h RPi expressionList
assignExpr ! hASSIGNi expression hTOi hIDi
condExpr ! hCONDi condClauses
condClauses ! ( hLBi expression expression hRBi )+
withExpr ! hWITHi hLPi variableDefs hRPi expressionList
variableDefs ! ( hLBKi hIDi expression hRBKi )
4
2 L4850 Notes
2.1 Function Declarations
The semantics of function denition cause the variable to be added to the environment with
a closure as a value.
Example:
defunc even (n) {
if (n == 0) then
true
else
odd->(n - 1)
fi
}
defunc odd(n) {
if (n == 0) then
false
else
even->(n - 1)
fi
}
In the above program, the variables even and odd are added to the environment with closures
for values. The value of a function denition is a closure.
2.2 Assignment Expressions
A variable is given a new value using an assign expression.
assign 2+3 to x
In the previous expression, x is given the value 5 and 5 is the return value of the entire
assign expression.
2.3 If Expression
If the rst expression in an if is true, then the expression in the then-part is evaluated and
returned. Otherwise the expression in the else-part is evaluated and returned.
if x == 5 then 5 else 4 fi
The value returned by this expression is 5.
5
2.4 Cond Expression
The cond expression is a concise format for a sequence of if-then-else-if expressions.
For example,
if x == 5 then
5+2
else
if x == 6 then
5+3
else
if x == 7 then
5+4
else
5+5
fi
fi
fi
can equivalently be expressed as
cond
{x == 5 5+2}
{x == 6 5+3}
{x == 7 5+4}
{true 5+5}
2.5 With Expressions
Variables are given scope in L4850 using a with expression. For example,
with ([x 5]) {
x + 10
}
gives scope to the variable x in the body of the with expression and gives it an initial value
of 5. The expression evaluation returns the value 10.
2.6 Function Invocation
A function invocation is done with the -> operator. Thus, the expression even->(n-1) in
the previous declaration of odd calls the function even with the value of n-1 as an argument.
L4850 also denes the language-supported functions in Table 1.
6
Function Prototype Parameter Types Description
first->(L) L a list Return the rst element of a
L
rest->(L) L a list Return a list contain all ele-
ments of L except the rst
insert->(e,L) e any value Insert e onto the front of L
L a list
list->(e,...) e,... one or more values create a list containing all
parameters
empty?->(L) L a list Return true i L is an empty
list
pair?->(L) L a list true i L is a non-empty list
list?->(L) L a list Return true i L is a list
equal?->(L1,L2) L1,L2 lists Return true i L1 and L2 are
equivalent lists
length->(L) L a list Return the length of Lt
number?->(e) e any value Return true i e is a number
exit->() exit the interpreter
Table 1: L4850 Language-supported Functions
2.7 Function Expression
L4850 supports rst-class functions. Thus, functions are values just as numbers are values.
The expression
func (x) { x + 2 }
declares a nameless function that adds 2 to its argument. A function expression can be put
anywhere in a program that any other expression can be put. Thus, it can be asssigned to
a variable in an assignment expression or called in an invocation as in
(func (x) { x + 2 })->(3)
which returns the value 5.
2.8 Expressions
L4850 arithmetic expressions compute simple values of type integer or 
oat For both integer
and 
oating point numbers, arithmetic and comparison are dened.
7
Coercion: If an expression contains operands of only one type, evaluation is straight
forward. When an operand contains mixed types, the situation is more complex. If an
arithmetic expression has an integer operand and a 
oat operand, the integer operand should
be converted to a 
oat before the operation is performed.
Relational and logic operators always produce a boolean. To perform a comparison
between an integer and a 
oat, the integer is converted to a 
oat. Logic operators are only
dened on boolean values. In addition, boolean values may not be used in relational and
arithmetic operators.
Operator Precedence Operator precedences in L4850 are specied in the table below.
Multiplication and division have the highest priority, && and || have the lowest.
Operator Precedence
*, / 5
+, - 4
<, <=, =, >=, >, != 3
! 2
&&, || 1
Precedence has already been encoded in the grammar in Section 1.2.
2.9 Classes and Objects
L4850 supports simple classes without inheritance. Classes may contain instance variables
and methods. All variables have private access and all methods have public access. The
code below denes a class with one instance variable and getter and setter methods for that
variable.
defclass test {
vars x
method setX(n) { assign n to x }
method getX() { x }
}
To instantiate an object, the new operator is used. In the expression
assign new test to t
a new instance of test is assigned to the variable t. Methods are accessed using the .
operator and invoked using the -> operator. As an example, the following code returns the
value 0.
8
defunc f (x) {
assign new test to t
t.setX->(x)
t.getX->()
}
f->(0)
9
