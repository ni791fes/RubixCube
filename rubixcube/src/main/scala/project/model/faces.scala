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



