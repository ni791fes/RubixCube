package project.view

def quit(): Unit = 
  println("bye")

def typo(arg: String): Unit = 
  println("[typo]-> " + arg + " is not a valid argument!")


def helpMenu(): Unit =
  println("Moves: F R U B L D; sufix: 2, '; quit = q")
