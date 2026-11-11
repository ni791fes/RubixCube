package project

import munit.FunSuite
import project.model.*

class InitialCubeTest extends FunSuite:

  test("initial cube should have six faces"):
    assertEquals(Cube.initialCube.w.length, 3)
    assertEquals(Cube.initialCube.y.length, 3)
    assertEquals(Cube.initialCube.g.length, 3)
    assertEquals(Cube.initialCube.b.length, 3)
    assertEquals(Cube.initialCube.r.length, 3)
    assertEquals(Cube.initialCube.o.length, 3)

  test("every face should have three columns per row"):
    val faces = List(
      Cube.initialCube.w,
      Cube.initialCube.y,
      Cube.initialCube.g,
      Cube.initialCube.b,
      Cube.initialCube.r,
      Cube.initialCube.o
    )

    faces.foreach { face =>
      face.foreach { row =>
        assertEquals(row.length, 3)
      }
    }

