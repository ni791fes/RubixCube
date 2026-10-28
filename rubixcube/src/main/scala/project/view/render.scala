package project.view

import project.model.*


//Screen empty
val emptyScreen = List.fill(11)(List.fill(14)("  "))

//main render funktion
def render(cube: Cube): Unit = 
  println("\n")
  val updatedMatrix = drawCubeNet(cube)
  printMatrix(updatedMatrix)
  println("\n")


//Faces in den Screen ein zeichnen
def drawCubeNet(cube: Cube): List[List[String]] = 
  val matrix0 = drawFace(emptyScreen, cube.g, 4, 1)
  val matrix1 = drawFace(matrix0, cube.w, 4, 4)
  val matrix2 = drawFace(matrix1, cube.b, 4, 7)
  val matrix3 = drawFace(matrix2, cube.y, 4, 10)
  val matrix4 = drawFace(matrix3, cube.o, 1, 4)
  drawFace(matrix4, cube.r, 7, 4)




//Funkion um ein ganzes Face an eine Position zu zeichnen
def drawFace(
  matrix: List[List[String]],
  face: List[List[Color]],
  originRow: Int,
  originCol: Int
): List[List[String]] =

  face.zipWithIndex.foldLeft(matrix) { (currentMatrix, rowWithIndex) =>
    val (row, rowIndex) = rowWithIndex

    row.zipWithIndex.foldLeft(currentMatrix) { (currentMatrix, colorWithIndex) =>
      val (color, colIndex) = colorWithIndex

      setPixel(
        currentMatrix,
        originRow + rowIndex,
        originCol + colIndex,
        color
      )
    }
  }



//gefärbten Pixel erstellen
def colorSquare(color: Color): String =
  val code = color match
    case Color.White  => 15 
    case Color.Yellow => 226
    case Color.Green  => 46
    case Color.Blue   => 21
    case Color.Red    => 196 
    case Color.Orange => 208

  s"\u001b[48;5;${code}m  \u001b[0m"


//einzelnen Pixel zeichnen
def setPixel(
  matrix: List[List[String]],
  row: Int,
  col: Int,
  color: Color
): List[List[String]] =

  matrix.updated(
    row,
    matrix(row).updated(col, colorSquare(color))
  )

//zeichnen eines screens im Terminal
def printMatrix(matrix: List[List[String]]): Unit =
  matrix.foreach(row => println(row.mkString))




