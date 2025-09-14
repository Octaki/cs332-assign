package recfun
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def braket(list: List[Char], count: Int): Boolean = {
      if (list.isEmpty) {
        if (count == 0) true
        else false
      }
      else {
        val head = list.head
        if (head == '(') braket(list.tail, count+1)
        else if (head == ')') {
          if (count == 0) false
          else braket(list.tail, count-1)
        }
        else braket(list.tail, count)
      }
    }
    braket(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) 0
    else {
      var method = 0
      val coin = coins.head
      var i = 0
      while (money >= coin * i) {
        if (money == coin * i) method += 1
        else method += countChange(money - coin * i, coins.tail)
        i += 1
      }
      method
    }
  }
}
