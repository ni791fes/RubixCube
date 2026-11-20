package project.controller.logic

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import project.model.*

// Pixel tests for every rotation.
// Net layout:
//        O
//    G   W   B   Y
//        R
// Every face is stored as rows (top -> bottom), columns (left -> right)
// exactly as it appears in the net.
//
// Each map says: pixel (face, row, col) AFTER the move
// gets its color from pixel (face, row, col) BEFORE the move.
// Pixels not listed must stay unchanged.
class RotationPixelSpec extends AnyWordSpec with Matchers:

  type Pos = (Char, Int, Int)

  def get(cube: Cube, pos: Pos): Color =
    val (face, row, col) = pos
    val grid = face match
      case 'w' => cube.w
      case 'o' => cube.o
      case 'r' => cube.r
      case 'g' => cube.g
      case 'b' => cube.b
      case 'y' => cube.y
    grid(row)(col)

  val allPositions: List[Pos] =
    for
      face <- List('w', 'o', 'r', 'g', 'b', 'y')
      row  <- List(0, 1, 2)
      col  <- List(0, 1, 2)
    yield (face, row, col)

  def applySeq(cube: Cube, moves: String): Cube =
    moves.split(" ").filter(_.nonEmpty)
      .foldLeft(cube)((c, m) => c.applyMove(Move.fromString(m)))

  // several different start cubes, because there are only 6 colors
  // and a wrong pixel could match by accident on a single cube
  val startCubes: List[Cube] = List(
    Cube.solvedCube,
    applySeq(Cube.solvedCube, "U L2 B D' L U2 B'"),
    applySeq(Cube.solvedCube, "L D B2 U' L' D2"),
    applySeq(Cube.solvedCube, "B' U D L2 B U' L")
  )

  def checkRotation(rotation: Cube => Cube, expected: Map[Pos, Pos]): Unit =
    startCubes.foreach { before =>
      val after = rotation(before)
      allPositions.foreach { pos =>
        val source = expected.getOrElse(pos, pos)
        withClue(s"pixel $pos should come from $source: ") {
          get(after, pos) shouldBe get(before, source)
        }
      }
    }

  val expectedU: Map[Pos, Pos] = Map(
    ('b',0,0) -> ('o',2,0), ('b',1,0) -> ('o',2,1), ('b',2,0) -> ('o',2,2),
    ('g',0,2) -> ('r',0,0), ('g',1,2) -> ('r',0,1), ('g',2,2) -> ('r',0,2),
    ('o',2,0) -> ('g',2,2), ('o',2,1) -> ('g',1,2), ('o',2,2) -> ('g',0,2),
    ('r',0,0) -> ('b',2,0), ('r',0,1) -> ('b',1,0), ('r',0,2) -> ('b',0,0),
    ('w',0,0) -> ('w',2,0), ('w',0,1) -> ('w',1,0), ('w',0,2) -> ('w',0,0),
    ('w',1,0) -> ('w',2,1), ('w',1,2) -> ('w',0,1), ('w',2,0) -> ('w',2,2),
    ('w',2,1) -> ('w',1,2), ('w',2,2) -> ('w',0,2)
  )

  val expectedD: Map[Pos, Pos] = Map(
    ('b',0,2) -> ('r',2,2), ('b',1,2) -> ('r',2,1), ('b',2,2) -> ('r',2,0),
    ('g',0,0) -> ('o',0,2), ('g',1,0) -> ('o',0,1), ('g',2,0) -> ('o',0,0),
    ('o',0,0) -> ('b',0,2), ('o',0,1) -> ('b',1,2), ('o',0,2) -> ('b',2,2),
    ('r',2,0) -> ('g',0,0), ('r',2,1) -> ('g',1,0), ('r',2,2) -> ('g',2,0),
    ('y',0,0) -> ('y',2,0), ('y',0,1) -> ('y',1,0), ('y',0,2) -> ('y',0,0),
    ('y',1,0) -> ('y',2,1), ('y',1,2) -> ('y',0,1), ('y',2,0) -> ('y',2,2),
    ('y',2,1) -> ('y',1,2), ('y',2,2) -> ('y',0,2)
  )

  val expectedF: Map[Pos, Pos] = Map(
    ('g',0,0) -> ('g',2,0), ('g',0,1) -> ('g',1,0), ('g',0,2) -> ('g',0,0),
    ('g',1,0) -> ('g',2,1), ('g',1,2) -> ('g',0,1), ('g',2,0) -> ('g',2,2),
    ('g',2,1) -> ('g',1,2), ('g',2,2) -> ('g',0,2), ('o',0,0) -> ('y',2,2),
    ('o',1,0) -> ('y',1,2), ('o',2,0) -> ('y',0,2), ('r',0,0) -> ('w',0,0),
    ('r',1,0) -> ('w',1,0), ('r',2,0) -> ('w',2,0), ('w',0,0) -> ('o',0,0),
    ('w',1,0) -> ('o',1,0), ('w',2,0) -> ('o',2,0), ('y',0,2) -> ('r',2,0),
    ('y',1,2) -> ('r',1,0), ('y',2,2) -> ('r',0,0)
  )

  val expectedB: Map[Pos, Pos] = Map(
    ('b',0,0) -> ('b',2,0), ('b',0,1) -> ('b',1,0), ('b',0,2) -> ('b',0,0),
    ('b',1,0) -> ('b',2,1), ('b',1,2) -> ('b',0,1), ('b',2,0) -> ('b',2,2),
    ('b',2,1) -> ('b',1,2), ('b',2,2) -> ('b',0,2), ('o',0,2) -> ('w',0,2),
    ('o',1,2) -> ('w',1,2), ('o',2,2) -> ('w',2,2), ('r',0,2) -> ('y',2,0),
    ('r',1,2) -> ('y',1,0), ('r',2,2) -> ('y',0,0), ('w',0,2) -> ('r',0,2),
    ('w',1,2) -> ('r',1,2), ('w',2,2) -> ('r',2,2), ('y',0,0) -> ('o',2,2),
    ('y',1,0) -> ('o',1,2), ('y',2,0) -> ('o',0,2)
  )

  val expectedL: Map[Pos, Pos] = Map(
    ('b',0,0) -> ('y',0,0), ('b',0,1) -> ('y',0,1), ('b',0,2) -> ('y',0,2),
    ('g',0,0) -> ('w',0,0), ('g',0,1) -> ('w',0,1), ('g',0,2) -> ('w',0,2),
    ('o',0,0) -> ('o',2,0), ('o',0,1) -> ('o',1,0), ('o',0,2) -> ('o',0,0),
    ('o',1,0) -> ('o',2,1), ('o',1,2) -> ('o',0,1), ('o',2,0) -> ('o',2,2),
    ('o',2,1) -> ('o',1,2), ('o',2,2) -> ('o',0,2), ('w',0,0) -> ('b',0,0),
    ('w',0,1) -> ('b',0,1), ('w',0,2) -> ('b',0,2), ('y',0,0) -> ('g',0,0),
    ('y',0,1) -> ('g',0,1), ('y',0,2) -> ('g',0,2)
  )

  val expectedR: Map[Pos, Pos] = Map(
    ('b',2,0) -> ('w',2,0), ('b',2,1) -> ('w',2,1), ('b',2,2) -> ('w',2,2),
    ('g',2,0) -> ('y',2,0), ('g',2,1) -> ('y',2,1), ('g',2,2) -> ('y',2,2),
    ('r',0,0) -> ('r',2,0), ('r',0,1) -> ('r',1,0), ('r',0,2) -> ('r',0,0),
    ('r',1,0) -> ('r',2,1), ('r',1,2) -> ('r',0,1), ('r',2,0) -> ('r',2,2),
    ('r',2,1) -> ('r',1,2), ('r',2,2) -> ('r',0,2), ('w',2,0) -> ('g',2,0),
    ('w',2,1) -> ('g',2,1), ('w',2,2) -> ('g',2,2), ('y',2,0) -> ('b',2,0),
    ('y',2,1) -> ('b',2,1), ('y',2,2) -> ('b',2,2)
  )

  "rotationU (white)" should {
    "move every pixel to the right place" in { checkRotation(rotationU, expectedU) }
  }
  "rotationD (yellow)" should {
    "move every pixel to the right place" in { checkRotation(rotationD, expectedD) }
  }
  "rotationF (green)" should {
    "move every pixel to the right place" in { checkRotation(rotationF, expectedF) }
  }
  "rotationB (blue)" should {
    "move every pixel to the right place" in { checkRotation(rotationB, expectedB) }
  }
  "rotationL (orange)" should {
    "move every pixel to the right place" in { checkRotation(rotationL, expectedL) }
  }
  "rotationR (red)" should {
    "move every pixel to the right place" in { checkRotation(rotationR, expectedR) }
  }
