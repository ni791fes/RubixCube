package project

import project.model.*
import project.controller.*
import project.view.*
import project.logic.*


@main def run(): Unit =
  println("Cube in Progress...")
  println("for Info type: help")
  loop(Cube.initialCube)


def loop(cube: Cube): Unit =
  val input = scala.io.StdIn.readLine("next Move:  ").trim
  input match
    case "q" =>
      quit()
    case "help" =>
      helpMenu()
      loop(cube)
    case move if isValidMove(input) => 
      val newCube = handleMove(cube, move)
      render(newCube)
      loop(newCube)
    case _ => 
      typo(input)
      loop(cube)



