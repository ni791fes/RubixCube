package project

import project.model.*
import project.controller.*
import project.view.*

@main def run(): Unit =
  println("Cube in Progress...")
  println("for Info type: help")
  val controller = new Controller
  loop(Cube.initialCube, controller)



