package bug

import scala.language.experimental.macros
import scala.reflect.macros.Context

class Test {
  def meth(a: Int) {}
}

object Bug {
  def test(code: Any) = macro testImpl
  def testImpl(c: Context)(code: c.Expr[Any]): c.Expr[Test] = {
    import c.universe._
    c.Expr[Test](q"new bug.Test { override def meth(a: Int) { $code } }")
  }
}