object assignments2 {
  val days = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
  val products = Map("clothes" -> 1000, "shoes" -> 500)
  def main(args: Array[String]): Unit = {
    println("Task1:")
    println(task1("monday"))
    println(task1("saturday"))
    println(task1("8th day"))
    println("Task2:")
    val b: BankAccount = new BankAccount()
    b.currentBalance
    b.deposits(20.3)
    b.currentBalance
    b.withdraw(10)
    b.currentBalance
    new BankAccount(1000).currentBalance
    println("Task3:")
    val peter: PersonTask3 = new PersonTask3("Peter", "Wang")
    peter.greeting(new PersonTask3("Luke", "Skywalker"))
    peter.greeting(new PersonTask3("David", "Beckham"))
    peter.greeting(new PersonTask3("Michael", "Jackson"))
    println("Task4:")
    println(task4(x => x * x, 2))
    println("Task5:")
    object p1 extends PersonTask5("Luke", "Skywalker") with Employee
    p1.salary_(1000)
    p1.taxToPay
    object p2 extends PersonTask5("Luke", "Skywalker") with Student
    p2.taxToPay
    object p3 extends PersonTask5("Luke", "Skywalker") with Teacher
    p3.salary_(1000)
    p3.taxToPay
    object p4 extends PersonTask5("Luke", "Skywalker") with Employee with Student
    p4.salary_(1000)
    p4.taxToPay
    object p5 extends PersonTask5("Luke", "Skywalker") with Student with Employee
    p5.salary_(1000)
    p5.taxToPay
  }
  def task1(day: String): String = day match {
    case d if days.map(_.toLowerCase()).filter(!_.startsWith("s")).contains(d.toLowerCase()) => return "work"
    case d if days.map(_.toLowerCase()).filter(_.startsWith("s")).contains(d.toLowerCase()) => return "weekends"
    case _ => return "no such day"
  }

  def task4(f: Int => Int, a: Int): Int = f(f(f(a)))

}

class BankAccount(private var balance: Double) {

  def this() { this(0) }

  def deposits(amount: Double): Unit = {
    if (amount > 0) balance = balance + amount
    else throw new Exception("wrong amount input")
  }

  def withdraw(amount: Double): Unit = {
    if (0 < amount && amount <= balance) {
      balance = balance - amount
    } else throw new Exception("wrong amount input")
  }

  def currentBalance: Unit = println("Your current balance is: " + balance)
}

case class PersonTask3(var firstName: String, var lastName: String) {
  def greeting(person: PersonTask3): Unit = person match {
    case PersonTask3("David", _) => println("Hi! David")
    case PersonTask3(_, "Luke") => println("Hi! Mr. Luke")
    case PersonTask3(fn, ln)     => println(s"Hello! $fn $ln")
  }
}

abstract class PersonTask5(private var firstName: String, private var lastName: String) {
  def taxToPay: Unit
}
trait Employee extends PersonTask5 {
  private var sal: Double = _
  def salary = sal
  def salary_(s: Double): Unit = sal = s
  override def taxToPay: Unit = println("Your tax to pay is: " + sal * 0.2)
}
trait Student extends PersonTask5 {
  override def taxToPay: Unit = println("Your tax to pay is: 0")
}
trait Teacher extends Employee {
  override def taxToPay: Unit = println("Your tax to pay is: " + salary * 0.1)
}

