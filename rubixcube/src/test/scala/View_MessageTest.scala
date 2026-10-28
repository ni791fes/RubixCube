package project.view

import munit.FunSuite
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class View_MessagesTest extends FunSuite:

  test("quit should print bye"):
    val output = new ByteArrayOutputStream()

    Console.withOut(new PrintStream(output)):
      quit()

    assertEquals(output.toString.trim, "bye")

  test("typo should print the invalid argument"):
    val output = new ByteArrayOutputStream()

    Console.withOut(new PrintStream(output)):
      typo("X")

    assertEquals(
      output.toString.trim,
      "[typo]-> X is not a valid argument!"
    )

  test("helpMenu should print the available moves"):
    val output = new ByteArrayOutputStream()

    Console.withOut(new PrintStream(output)):
      helpMenu()

    assert(output.toString.contains("Moves:"))
    assert(output.toString.contains("F R U B L D"))
