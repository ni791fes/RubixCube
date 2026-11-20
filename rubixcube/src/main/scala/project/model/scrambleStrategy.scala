package project.model

import scala.util.Random
import project.model.*

trait ScrambleStrategy:
  def scramble(cube: Cube): Cube

object RandomScramble extends ScrambleStrategy:
  private val moves = List("U", "U'", "U2", "D", "D'", "D2", "F", "F'", "F2",
                           "B", "B'", "B2", "L", "L'", "L2", "R", "R'", "R2")

  def scramble(cube: Cube): Cube =
    List.fill(20)(moves(Random.nextInt(moves.length)))
      .foldLeft(cube)((c, m) => c.applyMove(Move.fromString(m)))

case class SequenceScramble(sequence: String) extends ScrambleStrategy:
  def scramble(cube: Cube): Cube =
    sequence.split(" ").filter(_.nonEmpty)
      .foldLeft(cube)((c, m) => c.applyMove(Move.fromString(m)))
