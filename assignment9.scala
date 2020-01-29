object assignment9 {
  def main(args: Array[String]): Unit = {
    println("Task1:")
    val task1: Task1[String] = new Task1("Hello")
    task1.applyFunction(a => a + a)
    println(task1.getContent)

    println("Task2:")
    var no: No = new No()
    println(no.isInstanceOf[Maybe[_]])
    var yes: Yes[String] = new Yes("a")
    println(yes.isInstanceOf[Maybe[_]])

    println("Task3:")
    val task3no: Task3[No] = new Task3[No](new No())
    task3no.applyFunction(a => a)
    println(task3no.getContent)
    val task3yes: Task3[Yes[String]] = new Task3[Yes[String]](new Yes("Hello"))
    task3yes.applyFunction(a => new Yes(a.getContent + a.getContent))
    println(task3yes.getContent.getContent)

    println("Task4:")
    val task4no: Task4[No] = new Task4[No](new No())
    println(task4no.getOrElse)
    val task4yes: Task4[Yes[String]] = new Task4[Yes[String]](new Yes("Hello"))
    println(task4yes.getOrElse)

  }
}
class Task1[A](c: A) {
  private var _c: A = c
  def getContent: A = _c
  def applyFunction(f: A => A): A =
  {
    _c = f(_c)
    return _c
  }
}

trait Maybe[A]
class No extends Maybe[Nothing]
class Yes[A](value: A) extends Maybe[A] {
  private var v: A = value
  def getContent: A = v
}

class Task3[A](c: A) {
  private var _c: A = c
  def getContent: A = _c

  def applyFunction(f: A => A): A =
  {
    if (f(_c).isInstanceOf[No])
      return _cF
    else if (f(_c).isInstanceOf[Yes[_]]) {
      _c = f(_c).asInstanceOf[A]
      return _c
    } else
      return null.asInstanceOf[A];
  }
}

class Task4[A](c: A) {
  private var _c: A = c
  def getContent: A = _c
  def getOrElse[B]: B =
  {
    if (_c.isInstanceOf[No])
      return "This is class NO with no content".asInstanceOf[B]
    else if (_c.isInstanceOf[Yes[_]])
      return _c.asInstanceOf[Yes[A]].getContent.asInstanceOf[B]
    else
      return null.asInstanceOf[B];
  }
}