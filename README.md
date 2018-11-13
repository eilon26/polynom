# polynom  
Information on the project:
On this project the aim is to build an object that represent polynom.
The class Polynom let the user to do some function on the Polynom object ("a*x^b+…+c*x^d") such as add, multiply, substract , Derivative, value at x, equals, iszero, toString, copy, find the root, find the area. 
The class of Polynom implement the interface Polynom_able that inclue most of it functions except from value at x that the interface Polynom_able extend from the interface cont_function.
The class polynom build from arraylist that each node is a monom (a*x^b).
The class monom implement the interface function that include function value at x additionally the class include the function derivative, add, multiply and toString.
additionally in the project we use the class Monom_Comperator that implement from the interface Comparator in order to sort the monoms in the Polynom from the one with the most little power to the one with the biggest power. 

Attention: the class Polynom has constructor that could get String that represent polynom like "a*x^b+…+c*x^d" when space between the letters is not allowed the parameter a is double and the parameter b is positive int. 
if there is monomial without the signs '*' and '^' it is illegal 
after the sign '^' it is illegal to put any sign except a number (not '+' or '-') 
between the monoms "+-" or "-+" are allows but now more than that.
authers: Yitzchak Maimon, Eilon Tsadok.

