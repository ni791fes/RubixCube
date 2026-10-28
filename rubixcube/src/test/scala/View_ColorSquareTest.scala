package project

import project.view.*
import project.model.*
import munit.FunSuite


class View_ColorSquareTest extends FunSuite:

  test("colorSquare should return the correct color codes"):
    assertEquals(colorSquare(Color.White), "\u001b[48;5;15m  \u001b[0m")
    assertEquals(colorSquare(Color.Yellow), "\u001b[48;5;226m  \u001b[0m")
    assertEquals(colorSquare(Color.Green), "\u001b[48;5;46m  \u001b[0m")
    assertEquals(colorSquare(Color.Blue), "\u001b[48;5;21m  \u001b[0m")
    assertEquals(colorSquare(Color.Red), "\u001b[48;5;196m  \u001b[0m")
    assertEquals(colorSquare(Color.Orange), "\u001b[48;5;208m  \u001b[0m")

