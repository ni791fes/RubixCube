package project

import project.view.*
import project.model.*
import munit.FunSuite

class View_DrawTest extends FunSuite:
  test("drawFace should draw a face at the correct position"):
    val matrix = List.fill(5)(List.fill(5)("  "))
    val face = List.fill(3)(List.fill(3)(Color.Red))

    val result = drawFace(matrix, face, 1, 1)

    assertEquals(result(1)(1), colorSquare(Color.Red))
    assertEquals(result(3)(3), colorSquare(Color.Red))


  test("drawCubeNet should draw all six faces"):
    val result = drawCubeNet(Cube.initialCube)

    assertEquals(result(4)(1), colorSquare(Color.Green))
    assertEquals(result(4)(4), colorSquare(Color.White))
    assertEquals(result(4)(7), colorSquare(Color.Blue))
    assertEquals(result(4)(10), colorSquare(Color.Yellow))
    assertEquals(result(1)(4), colorSquare(Color.Orange))
    assertEquals(result(7)(4), colorSquare(Color.Red))
