package project.model

import project.model.*

enum Turn(val times: Int):
  case Clockwise        extends Turn(1)
  case Double           extends Turn(2)
  case CounterClockwise extends Turn(3)

case class Move(face: Face, turn: Turn)

object Move:
  // Factory Method: string → Move
  def fromString(input: String): Move =
    val face = Face.valueOf(input.head.toString)
    val turn = input.drop(1) match
      case "'" => Turn.CounterClockwise
      case "2" => Turn.Double
      case _   => Turn.Clockwise
    Move(face, turn)
