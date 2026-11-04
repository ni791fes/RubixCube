package project.controller

import project.model.*
import project.view.*


def handleMove(cube: Cube, move: String): Cube = 
  println("no handling implemented yet!")
  return cube



def isValidMove(input: String): Boolean =
  input.matches("[FRUBLD](2|')?")



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



