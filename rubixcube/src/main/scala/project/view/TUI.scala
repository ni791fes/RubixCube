package project.view

import project.model.*
import project.view.*
import project.controller.*
import project.util.*


object Tui extends Observer:

  def update(cube: Cube): Unit = render(cube)
  
  def loop(cube: Cube, controller: Controller): Unit =
    val input = scala.io.StdIn.readLine("next Move:  ").trim
    input match
      case "q" =>
        quit()
      case "help" =>
        helpMenu()
        loop(cube, controller)
      case "reset" => 
        loop(controller.reset(), controller)
      case "scramble" =>
        loop(controller.scramble(RandomScramble), controller)
      case s if s.startsWith("scramble ") && controller.isValidSequence(s.drop(9)) =>
        loop(controller.scramble(SequenceScramble(s.drop(9))), controller)
      case move if controller.isValidMove(input) => 
        val newCube = controller.handleMove(cube, move)
        loop(newCube, controller)
      case _ => 
        typo(input)
        loop(cube, controller)
