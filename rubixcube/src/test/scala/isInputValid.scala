package project

import project.controller.*
import munit.FunSuite

class ControllerTest extends FunSuite:

  test("valid moves should be accepted"):
    assert(isValidMove("R"))
    assert(isValidMove("U'"))
    assert(isValidMove("F2"))

  test("invalid moves should be rejected"):
    assert(!isValidMove("X"))
    assert(!isValidMove("R3"))
    assert(!isValidMove(""))
