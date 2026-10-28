package project.model

enum Color:
  case Red, Orange, White, Yellow, Blue, Green

case class Cube(
  w: List[List[Color]],
  y: List[List[Color]],
  g: List[List[Color]],
  b: List[List[Color]],
  r: List[List[Color]],
  o: List[List[Color]]
)


object Cube:

  val initialCube = Cube(
    List.fill(3)(List.fill(3)(Color.White)),
    List.fill(3)(List.fill(3)(Color.Yellow)),
    List.fill(3)(List.fill(3)(Color.Green)),
    List.fill(3)(List.fill(3)(Color.Blue)),
    List.fill(3)(List.fill(3)(Color.Red)),
    List.fill(3)(List.fill(3)(Color.Orange))
  )



