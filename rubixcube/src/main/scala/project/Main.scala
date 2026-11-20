package project

import project.model.*
import project.controller.*
import project.view.*

@main def run(): Unit =
  println("for Info type: help")
  val start = Cube.solvedCube
  val controller = new Controller(List(Tui))
  Tui.update(start)
  Tui.loop(start, controller)



