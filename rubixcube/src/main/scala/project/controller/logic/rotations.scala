
package project.controller.logic

import project.model.*


def rotateClockwise(face: List[List[Color]]): List[List[Color]] =
  face.transpose.map(_.reverse)

def rotateCounterClockwise(face: List[List[Color]]): List[List[Color]] =
  face.transpose.reverse

def rotationD(cube: Cube): Cube =
  val blueBar = cube.b.map(_.last)
  val orangeBar = cube.o.head
  val greenBar = cube.g.map(_.head)
  val redBar = cube.r.last

  cube.copy(
    y = rotateClockwise(cube.y),

    r = cube.r.updated(2, greenBar),
    g = cube.g.zip(orangeBar.reverse).map((row, color) => row.updated(0, color)),
    o = cube.o.updated(0, blueBar),
    b = cube.b.zip(redBar.reverse).map((row, color) => row.updated(2, color))
  )

def rotationU(cube: Cube): Cube =
  val blueBar = cube.b.map(_.head)
  val redBar = cube.r.head
  val greenBar = cube.g.map(_.last)
  val orangeBar = cube.o.last

  cube.copy(
    w = rotateClockwise(cube.w),

    r = cube.r.updated(0, blueBar.reverse),
    g = cube.g.zip(redBar).map((row, color) => row.updated(2, color)),
    o = cube.o.updated(2, greenBar.reverse),
    b = cube.b.zip(orangeBar).map((row, color) => row.updated(0, color))
  )



def rotationB(cube: Cube): Cube =
  val whiteBar = cube.w.map(_.last)
  val yellowBar = cube.y.map(_.head)
  val redBar = cube.r.map(_.last)
  val orangeBar = cube.o.map(_.last)

  cube.copy(
    b = rotateClockwise(cube.b),

    w = cube.w.zip(redBar).map((row, color) => row.updated(2, color)),
    o = cube.o.zip(whiteBar).map((row, color) => row.updated(2, color)),
    r = cube.r.zip(yellowBar.reverse).map((row, color) => row.updated(2, color)),
    y = cube.y.zip(orangeBar.reverse).map((row, color) => row.updated(0, color))
  )


def rotationF(cube: Cube): Cube =
  val whiteBar = cube.w.map(_.head)
  val redBar = cube.r.map(_.head)
  val orangeBar = cube.o.map(_.head)
  val yellowBar = cube.y.map(_.last)

  cube.copy(
    g = rotateClockwise(cube.g),

    w = cube.w.zip(redBar).map((row, color) => row.updated(0, color)),
    o = cube.o.zip(whiteBar).map((row, color) => row.updated(0, color)),
    r = cube.r.zip(yellowBar.reverse).map((row, color) => row.updated(0, color)),
    y = cube.y.zip(orangeBar.reverse).map((row, color) => row.updated(2, color))
  )

def rotationL(cube: Cube): Cube =
  return cube


def rotationR(cube: Cube): Cube =
  return cube
