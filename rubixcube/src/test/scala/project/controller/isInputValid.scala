package project.controller

import munit.FunSuite
import project.model.*
import project.view.*

class ControllerTest extends FunSuite:

  val controller = new Controller(List(Tui))

  test("valid moves should be accepted"):
    assert(controller.isValidMove("R"))
    assert(controller.isValidMove("U'"))
    assert(controller.isValidMove("F2"))
    assert(controller.isValidMove("L"))

  test("invalid moves should be rejected"):
    assert(!controller.isValidMove("X"))
    assert(!controller.isValidMove("R3"))
    assert(!controller.isValidMove(""))
    assert(!controller.isValidMove("RR"))

