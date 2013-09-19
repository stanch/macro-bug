package bug

class BugSpec extends org.scalatest.FlatSpec {
  Bug.test(3 :: Nil)
}