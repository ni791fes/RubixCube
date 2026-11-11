package project.view

import project.model.*
import project.view.*
import project.controller.*


def loop(cube: Cube, controller: Controller): Unit =
  val input = scala.io.StdIn.readLine("next Move:  ").trim
  input match
    case "q" =>
      quit()
    case "help" =>
      helpMenu()
      loop(cube, controller)
    case move if controller.isValidMove(input) => 
      val newCube = controller.handleMove(cube, move)
      render(newCube)
      loop(newCube, controller)
    case _ => 
      typo(input)
      loop(cube, controller)
