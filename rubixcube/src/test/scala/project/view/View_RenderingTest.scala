package project.view

import munit.FunSuite
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import project.view.*
import project.model.*

class View_RenderingTest extends FunSuite:
  test("render should print the cube"):
    val output = new ByteArrayOutputStream()

    Console.withOut(new PrintStream(output)):
      render(Cube.initialCube)

    assert(output.toString.contains("\u001b[48;5;15m"))
    assert(output.toString.contains("\u001b[48;5;226m"))
    assert(output.toString.contains("\u001b[48;5;46m"))
    assert(output.toString.contains("\u001b[48;5;21m"))
    assert(output.toString.contains("\u001b[48;5;196m"))
    assert(output.toString.contains("\u001b[48;5;208m"))

  test("printMatrix should print every row"):
    val output = new ByteArrayOutputStream()

    Console.withOut(new PrintStream(output)):
      printMatrix(List(
        List("A", "B"),
        List("C", "D")
      ))

    assertEquals(output.toString, "AB\nCD\n")
