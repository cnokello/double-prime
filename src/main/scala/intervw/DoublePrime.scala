package intervw

/**
 *
 * DOUBLE PRIME
 *
 * @created on 05-Dec-2014
 * @author nelson.okello
 *
 * This class generates N double prime numbers
 * The number of prime numbers N is passed as a constructor
 * argument to this class
 */
class DoublePrime(N: Int) {
  import scala.collection.mutable.ListBuffer

  /**
   *
   * PRIMALITY TEST
   *
   * @created on 05-Dec-2014
   * @author nelson.okello
   *
   * A number n is a prime number if it's 1 or 2.
   * A number n is also a prime number if it's only divisors are 1 and itself.
   * Test for divisibility uses the modulo (%) operator.
   * If n divided by any number x other than 1 and itself
   * returns 0 as the remainder, then n is not a prime number.
   * Otherwise, it's a prime number
   *
   */
  private def isPrime(n: Int): Boolean =
    if (n < 1) false
    else if (n == 1 || n == 2) true
    else if (n > 2 && n % 2 == 0) false
    else !(3 to (n - 1)).exists(x => n % x == 0)

  /**
   *
   * DOUBLE PRIMALITY TEST
   *
   * @created on 05-Dec-2014
   * @author nelson.okello
   *
   * A number n is a double prime number if it's a prime number and
   * all it's constituent digits are also prime numbers
   *
   */
  private def isDoublePrime(n: Int): Boolean = {
    if (isPrime(n)) n.toString.map(_.asDigit).toList.foreach { m => if (!isPrime(m)) return false }
    else return false
    return true
  }

  /**
   *
   * NEXT DOUBLE PRIME NUMBER
   *
   * @created on 05-Dec-2014
   * @author nelson.okello
   *
   * This method determines the next double prime number
   * that is equals to or greater than the number n
   *
   * The method calls itself recursively until the next double
   * prime number is found
   *
   * After the first call of the method, subsequent recursive calls
   * skip testing even numbers by incrementing n by 2 in each
   * subsequent call
   *
   */
  private def nextDoublePrime(n: Int): Int =
    if (isDoublePrime(n)) n
    else nextDoublePrime(n + 2)

  /**
   *
   * GET N DOUBLE PRIME NUMBERS
   *
   * @created on 05-Dec-2014
   *  @author nelson.okello
   *
   * Returns a list of double prime numbers of size N
   *
   * 1. Initialize the list to the integers 1, 2
   * 2. Set the next double prime number candidate to 3
   * 3. While the size of the list is less than the desired size N,
   * 4. Retrieve the next double prime number
   * 5. Increment the returned double prime number by 2
   *
   * Why increment the returned double prime number by
   * 2 before calling nextDoublePrimeNumber?
   * It's because a prime number plus one will always be
   * an even number.
   *
   * And if the even number is not 2,
   * then it's not a prime number and by extension not a
   *  double prime number
   *
   */
  def get: List[Int] = {
    var L: ListBuffer[Int] = new ListBuffer[Int]()
    L.append(1); L.append(2)

    var next = 3
    while (L.size < N) {
      next = nextDoublePrime(next)
      L.append(next)
      next += 2
    }

    return L.toList
  }

}

/**
 * Runs the application
 */
object DoublePrimeApp extends App {
  override def main(args: Array[String]) {
    val N = 100
    try println((new DoublePrime(N)).get)
    catch {
      case e: Exception =>
        println("N is either too large or in an incorrect format")
    }
  }

}