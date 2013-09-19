macro-bug
=========

```scala
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
```
```scala
class BugSpec extends org.scalatest.FlatSpec {
  Bug.test(3 :: Nil)
}
```
```
sbt test
```

BAM!

tl;dr:

`symbol value x$1 does not exist in bug.BugSpec.<init>`
```scala
scala> q"3 :: Nil"
res0: reflect.runtime.universe.Block =
{
  <synthetic> val x$1 = 3;
  Nil.$colon$colon(x$1)
}
```

UPD
===

Use `${c.resetAllAttrs(code.tree)}`.
