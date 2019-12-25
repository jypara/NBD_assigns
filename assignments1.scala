import scala.annotation.tailrec

object assignments1 {
  val days = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
  val products = Map("clothes" -> 1000, "shoes" -> 500)

  def main(args: Array[String]): Unit = {
    println("Task1:")
    println(task1("a"))
    println(task1("b"))
    println(task1("c"))
    println("Task2:")
    println(task2("a", days))
    println(task2("b", days))
    println("Task3:")
    println(task3(days))
    println("Task4:")
    println(task4("a"))
    println(task4("b"))
    println(task4("c"))
    println("Task5:")
    println(task5)
    println("Task6:")
    println(task6(1 :: 2 :: 3 :: Nil))
    println("Task7")
    println(task7(-11 :: -2.4 :: 3.0 :: 20.3 :: Nil))
    println("Task8")
    task8(Tuple3(1, 300.2, "abc"))
    println("Task9")
    println(task9(-1.3 :: 2.1 :: 0.0 :: 3.4 :: 0.0 :: Nil))
    println("Task10")
    task10("shoes")
    task10("Clothes")
    task10("trouser")

  }

  def task1(t: String): String = {
    var s: String = ""
    if (t.equals("a"))
      for (day <- days)
        s += day + ", "
    else if (t.equals("b"))
      for (day <- days if day.toLowerCase.startsWith("s"))
        s += day + ", "
    else if (t.equals("c")) {
      var i: Int = 0
      while (i < 7) {
        s += days(i) + ", "
        i += 1
      }
    }
    return s.substring(0, s.length - 2)
  }

  def task2(t: String, l: List[String]): String = {
    if (t == "a") {
      if (l.tail.isEmpty)
        return l.head
      return l.head + ", " + task2("a", l.tail)
    }
    if (t == "b") {
      if (l.tail.isEmpty)
        return l.head
      return task2("a", l.tail) + ", " + l.head
    } else return ""
  }
  def task3(ll: List[String]): String = {
    @tailrec
    def task33(l: List[String],s:String): String = {
      if (l.tail.isEmpty)
        return s+l.head
      else   task33(l.tail,s+l.head + ", ")
    }
    task33(ll,"")
  }

  def task4(t: String): String = {
    var s: String = ""
    if (t.equals("a"))
      s = days.foldLeft("")(_ + _ + ", ")
    else if (t.equals("b"))
      s = days.foldRight("")(_ + ", " + _)
    else if (t.equals("c"))
      s = days.foldRight("") { (next, sum) => if (next.toLowerCase.startsWith("s")) next + ", " + sum else sum }
    return s.substring(0, s.length - 2)
  }

  def task5: Map[String, Double] = products.mapValues(_ * 0.9)

  def task6(l: List[Int]): List[Int] = l.map(_ + 1)

  def task7(l: List[Double]): List[Double] = l.filter(-5 < _).filter(_ < 12).map(_.abs)

  def task8(tuple: Tuple3[Int, Double, String]): Unit = println(tuple)

  def task9(l: List[Double]): List[Double] = {
    if (l.isEmpty) l
    else if (l.head == 0) task9(l.tail)
    else l.head :: task9(l.tail)
  }

  def task10(product: String) = {
    val price: Option[Int] = products.get(product.toLowerCase)
    println(price.getOrElse("Sorry, we do not have this product -> " + product))
    if (price.isDefined && price.get >= 1000)
      println(product + " is on sale, you will have 10% off now")
    println("#################################")
  }

}