package project

import project.view.*
import project.model.*
import munit.FunSuite

  
class View_SetPixelTest extends FunSuite:
  test("setPixel should color the correct position"):
    val matrix = List.fill(3)(List.fill(3)("  "))

    val result = setPixel(matrix, 1, 1, Color.Red)

    assertEquals(result(1)(1), colorSquare(Color.Red))


  test("setPixel should not modify the original matrix"):
    val matrix = List.fill(3)(List.fill(3)("  "))

    val result = setPixel(matrix, 1, 1, Color.Red)

    assertEquals(matrix(1)(1), "  ")
    assertNotEquals(result, matrix)
