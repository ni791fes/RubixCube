import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class CalculatorSpec extends AnyWordSpec with Matchers {

  "A Calculator" should {

    "add two positive numbers correctly" in {
      val calculator = new Calculator()

      calculator.add(2, 3) shouldBe 5
    }

    "add negative numbers correctly" in {
      val calculator = new Calculator()

      calculator.add(-2, -3) shouldBe -5
    }

    "return zero when adding zero and zero" in {
      val calculator = new Calculator()

      calculator.add(0, 0) shouldBe 0
    }
  }
}
