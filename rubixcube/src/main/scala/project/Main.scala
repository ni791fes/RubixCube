package project

import project.model.*
import project.controller.*
import project.view.*
import project.logic.*

@main def run(): Unit =
  println("Cube in Progress...")
  println("for Info type: help")
  val initialCube = Cube(
    List(List(Color.White, Color.White, Color.White), List(Color.White, Color.White, Color.White), List(Color.White, Color.White, Color.White)),
    List(List(Color.Yellow, Color.Yellow, Color.Yellow), List(Color.Yellow, Color.Yellow, Color.Yellow), List(Color.Yellow, Color.Yellow, Color.Yellow)),
    List(List(Color.Green, Color.Green, Color.Green), List(Color.Green, Color.Green, Color.Green), List(Color.Green, Color.Green, Color.Green)),
    List(List(Color.Blue, Color.Blue, Color.Blue), List(Color.Blue, Color.Blue, Color.Blue), List(Color.Blue, Color.Blue, Color.Blue)),
    List(List(Color.Red, Color.Red, Color.Red), List(Color.Red, Color.Red, Color.Red), List(Color.Red, Color.Red, Color.Red)),
    List(List(Color.Orange, Color.Orange, Color.Orange), List(Color.Orange, Color.Orange, Color.Orange), List(Color.Orange, Color.Orange, Color.Orange))
  )
  loop(initialCube)


def loop(cube: Cube): Unit =
  val input = scala.io.StdIn.readLine("next Move:  ").trim
  input match
    case "q" =>
      quit()
    case "help" =>
      helpMenu()
      loop(cube)
    case move if move.matches("[FRUBLD](2|')?") => 
      val newCube = handleMove(cube, move)
      render(newCube)
      loop(newCube)
    case _ => 
      typo(input)
      loop(cube)
