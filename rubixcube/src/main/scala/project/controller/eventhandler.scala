package project.controller

import project.model.*
import project.view.*
import project.controller.logic.*
import project.util.*

class Controller(val observers: List[Observer]) extends Observable:

  def handleMove(cube: Cube, input: String): Cube = 
    val newCube = cube.applyMove(Move.fromString(input))
    notifyObservers(newCube)
    newCube

  def isValidMove(input: String): Boolean =
    input.matches("[FRUBLD](2|')?")

  def isValidSequence(sequence: String): Boolean =
    val moves = sequence.split(" ").filter(_.nonEmpty)
    moves.nonEmpty && moves.forall(isValidMove)

  def scramble(strategy: ScrambleStrategy): Cube =
    val newCube = strategy.scramble(Cube.solvedCube)
    notifyObservers(newCube)
    newCube

  def reset(): Cube =
    val newCube = Cube.scrambledCube
    notifyObservers(newCube)
    newCube




