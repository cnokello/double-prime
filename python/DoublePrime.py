'''
DOUBLE PRIME

Created on 06-Dec-2014
@author: nelson.okello

This class generates N double prime numbers
The number of prime numbers N is passed as a constructor
argument to this class
'''

import math

class DoublePrime(object):


    def __init__(self, N: int):
        self.N = N

    '''
    
    PRIMALITY TEST
   
    @created on 06-Dec-2014
    @author nelson.okello
   
    A number n is a prime number if it's 1 or 2.
    A number n is also a prime number if it's only divisors are 1 and itself.
    Test for divisibility uses the modulo (%) operator.
    If n divided by any number x other than 1 and itself
    returns 0 as the remainder, then n is not a prime number.
    Otherwise, it's a prime number
    
    '''        
    def isPrime(self, n: int):
        if n < 1: return False 
        elif (n == 1 or n == 2): return True
        elif (n > 2 and n % 2 == 0): return False
        return all(n % i for i in range(3, int(math.sqrt(n)) + 1, 2))    
    
    '''
    
    DOUBLE PRIMALITY TEST
   
    @created on 06-Dec-2014
    @author nelson.okello
   
    A number n is a double prime number if it's a prime number and
    all it's constituent digits are also prime numbers
    
    '''
    def isDoublePrime(self, n: int):
        if self.isPrime(n):
            for m in str(n):
                if not self.isPrime(int(m)): return False
        else: return False
        return True
    
    '''
    
    NEXT DOUBLE PRIME NUMBER
   
    @created on 06-Dec-2014
    @author nelson.okello
   
    This method determines the next double prime number
    that is equals to or greater than the number n
   
    The method calls itself recursively until the next double
    prime number is found
   
    After the first call of the method, subsequent recursive calls
    skip testing even numbers by incrementing n by 2 in each
    subsequent call
    
    '''
    def nextDoublePrime(self, n: int):
        if self.isDoublePrime(n): return n
        else: return self.nextDoublePrime(n + 2)
        
    '''
    GET N DOUBLE PRIME NUMBERS
   
    @created on 06-Dec-2014
     @author nelson.okello
   
    Returns a list of double prime numbers of size N
   
    1. Initialize the list to the integers 1, 2
    2. Set the next double prime number candidate to 3
    3. While the size of the list is less than the desired size N,
    4. Retrieve the next double prime number
    5. Increment the returned double prime number by 2
   
    Why increment the returned double prime number by
    2 before calling nextDoublePrimeNumber?
    It's because a prime number plus one will always be
    an even number.
   
    And if the even number is not 2,
    then it's not a prime number and by extension not a
    double prime number
    
    '''        
    def get(self):
        L = [1, 2]
        nc = 3
        while len(L) < self.N:
            nc = self.nextDoublePrime(nc)
            L.append(nc)
            nc += 2
        return L
    
## 
## Run the application
## N refers to the number of double prime numbers 
## to generate
N = 100
try:
    dblPrime = DoublePrime(N)
    print(list(dblPrime.get()))
except: 
    print("N is too large or is in an incorrect format.")