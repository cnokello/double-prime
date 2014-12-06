## DOUBLE PRIME NUMBERS README

**Background**: 

This program generates N double prime numbers. A double prime number is defined as 
a prime number whose constituting digits  are also prime numbers.

*Example*:
  
	> 5 is prime and it's made up of the number 5 which is prime. Therefore, it's doubly prime
	
	> 13 is prime and it's made up of the numbers 1 which is prime and 3 which is also prime. Therefore, it's doubly prime.

*Counter example*: 

	> 19 is prime.  1 is prime but 9 isn't since it's divisible by 3. Therefore, 19 is not doubly prime. 



*What is the smallest prime number?*

Original definitions of prime numbers included 1. However, recent definitions states that prime numbers begin at 2. 
A look at [Wikipedia definition of prime numbers] (http://en.wikipedia.org/wiki/Prime_number) attests to this. Also, 
[a paper published in the Journal of Integer Sequences] (https://cs.uwaterloo.ca/journals/JIS/VOL15/Caldwell1/cald5.pdf) 
tries to explain why the smallest prime number is not 1. 

However, instructions for this assignment adheres to the original definition of prime numbers which includes 1.
 Therefore, the program treats 1 as a valid prime number.
 

 
**The algorithm**

* Total Number of Double Prime Numbers to generate, N
* Double Prime Numbers generated so far, initialized to P = [1, 2,]
* Next Double Prime Number Candidate, D = 3
* While Size of P is less than N
	* If D is Double Prime Number
		* Append D to the List, P
		* Assign the new Double Prime Number to D and then Increment D by 2
	

		
**Implementation**

I've split the implementation of the algorithm into the following class methods:
* isPrime: Tests if a given number n is a prime number.
* IsDoublePrime: Tests if a given number *n* is a double prime number.
* nextDoublePrime: Generates the next double prime number, given a candidate double prime number *n*.
* get: Retrieves all the *N* double prime numbers. 


I've implemented this algorithm in both Scala and Python. For the Python source code, look into the *python* directory. 
Both Scala and Python are the same exact implementation line by line, almost.
	

	
**Sample output for N = 100:**
		
	> 1, 2, 3, 5, 7, 11, 13, 17, 23, 31, 37, 53, 71, 73, 113, 127, 131, 137, 151, 157, 173, 211, 223,
		 227, 233, 251, 257, 271, 277, 311, 313, 317, 331, 337, 353, 373, 521, 523, 557, 571, 577, 727, 
		 733, 751, 757, 773, 1117, 1123, 1151, 1153, 1171, 1213, 1217, 1223, 1231, 1237, 1277, 1321, 
		 1327, 1373, 1511, 1523, 1531, 1553, 1571, 1721, 1723, 1733, 1753, 1777, 2111, 2113, 2131, 2137, 
		 2153, 2213, 2221, 2237, 2251, 2273, 2311, 2333, 2351, 2357, 2371, 2377, 2521, 2531, 2551, 2557, 
		 2711, 2713, 2731, 2753, 2777, 3121, 3137, 3217, 3221, 3251
 
 
**Running the Scala solution**

Software requirements:
* Git latest stable version. [Installation Guide](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* JDK version 1.7 or 1.8. [Installation Guide](https://docs.oracle.com/javase/7/docs/webnotes/install/)
* Scala version 2.10.4 or later. [Installation Guide](http://scala-lang.org/download/install.html)
* sbt version 0.13. [Installation Guide](http://www.scala-sbt.org/0.13/tutorial/Setup.html)
	
Compile and run:

To run the solution, run the following command from within the project directory:
	
	> sbt clean compile run
	

**Running the Python solution**

Software Requirements:
* Git latest stable version. [Installation Guide](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* Python version 3.4. [Installation Guide](https://docs.python.org/3/using/index.html)

To run the solution, run the following command:
	
	> python /path/to/DoublePrime.py
	
Replace '/path/to/DoublePrime.py' with the actual path to the 'DoublePrime.py' source file.
