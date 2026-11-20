package project.model

import project.model.*
import project.controller.logic.*

enum Color:
  case Red, Orange, White, Yellow, Blue, Green

enum Face:
  case D, U, B, F, L, R

case class Cube(
  w: List[List[Color]],
  y: List[List[Color]],
  g: List[List[Color]],
  b: List[List[Color]],
  r: List[List[Color]],
  o: List[List[Color]]):
  def applyMove(move: Move): Cube =
   (1 to move.turn.times).foldLeft(this)((c, _) => c.rotate(move.face))

  private def rotate(face: Face): Cube = face match
    case Face.U => rotationU(this)
    case Face.D => rotationD(this)
    case Face.F => rotationF(this)
    case Face.B => rotationB(this)
    case Face.L => rotationL(this)
    case Face.R => rotationR(this)

object Cube:


  val solvedCube = Cube(
    List.fill(3)(List.fill(3)(Color.White)),
    List.fill(3)(List.fill(3)(Color.Yellow)),
    List.fill(3)(List.fill(3)(Color.Green)),
    List.fill(3)(List.fill(3)(Color.Blue)),
    List.fill(3)(List.fill(3)(Color.Red)),
    List.fill(3)(List.fill(3)(Color.Orange))
  )
  val scrambledCube = Cube(
    w = List(
      List(Color.Red, Color.Blue, Color.Green),
      List(Color.Yellow, Color.White, Color.Orange),
      List(Color.Green, Color.Red, Color.Blue)
    ),
    y = List(
      List(Color.Blue, Color.Orange, Color.Red),
      List(Color.Green, Color.Yellow, Color.White),
      List(Color.Orange, Color.Blue, Color.Green)
    ),
    g = List(
      List(Color.Yellow, Color.Red, Color.Blue),
      List(Color.Orange, Color.Green, Color.White),
      List(Color.Blue, Color.Yellow, Color.Red)
    ),
    b = List(
      List(Color.Green, Color.White, Color.Orange),
      List(Color.Red, Color.Blue, Color.Yellow),
      List(Color.White, Color.Orange, Color.Green)
    ),
    r = List(
      List(Color.Orange, Color.Green, Color.Yellow),
      List(Color.Blue, Color.Red, Color.White),
      List(Color.Yellow, Color.Orange, Color.Blue)
    ),
    o = List(
      List(Color.White, Color.Yellow, Color.Red),
      List(Color.Green, Color.Orange, Color.Blue),
      List(Color.Red, Color.White, Color.Yellow)
    )
  )



