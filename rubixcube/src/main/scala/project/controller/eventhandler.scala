package project.controller

import project.model.*
import project.view.*

class Controller:

  def handleMove(cube: Cube, move: String): Cube = 
    println("no handling implemented yet!")
    return cube



  def isValidMove(input: String): Boolean =
    input.matches("[FRUBLD](2|')?")




