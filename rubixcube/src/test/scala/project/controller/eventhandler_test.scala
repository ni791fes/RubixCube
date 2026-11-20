package project.controller

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import project.model.*
import project.util.*

class ControllerSpec extends AnyWordSpec with Matchers:

  // fake observer that records every cube it receives
  class TestObserver extends Observer:
    var received: List[Cube] = Nil
    def update(cube: Cube): Unit = received = received :+ cube

  "A Controller" when {

    "checking a sequence" should {
      val controller = Controller(Nil)

      "accept valid sequences" in {
        controller.isValidSequence("R U R' U'") shouldBe true
        controller.isValidSequence("F2") shouldBe true
        controller.isValidSequence("  R   U  ") shouldBe true
      }
      "reject invalid sequences" in {
        controller.isValidSequence("") shouldBe false
        controller.isValidSequence("R X") shouldBe false
        controller.isValidSequence("R U3") shouldBe false
      }
    }

    "handling a move" should {
      val observer = TestObserver()
      val controller = Controller(List(observer))
      val result = controller.handleMove(Cube.solvedCube, "R")

      "return the moved cube" in {
        result shouldBe Cube.solvedCube.applyMove(Move.fromString("R"))
      }
      "notify observers with the new cube" in {
        observer.received shouldBe List(result)
      }
    }

    "scrambling" should {
      "apply a given sequence" in {
        val controller = Controller(Nil)
        val expected = Cube.solvedCube
          .applyMove(Move.fromString("R"))
          .applyMove(Move.fromString("U"))
        controller.scramble(SequenceScramble("R U")) shouldBe expected
      }
      "notify observers" in {
        val observer = TestObserver()
        val controller = Controller(List(observer))
        val result = controller.scramble(RandomScramble)
        observer.received shouldBe List(result)
      }
    }

    "resetting" should {
      val observer = TestObserver()
      val controller = Controller(List(observer))
      val result = controller.reset()

      "return the solved cube" in {
        result shouldBe Cube.solvedCube
      }
      "notify observers" in {
        observer.received shouldBe List(Cube.solvedCube)
      }
    }
  }
