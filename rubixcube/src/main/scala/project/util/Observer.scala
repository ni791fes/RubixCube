package project.util

import project.model.*

trait Observer:
  def update(cube: Cube): Unit

trait Observable:
  def observers: List[Observer]
  def notifyObservers(cube: Cube): Unit =
    observers.foreach(_.update(cube))
