package project

import project.view.*
import project.model.*
import munit.FunSuite

class View_EmptyScreenTest extends FunSuite:

  test("emptyScreen should have 11 rows and 14 columns"):
    assertEquals(emptyScreen.length, 11)
    assert(emptyScreen.forall(_.length == 14))
    assert(emptyScreen.flatten.forall(_ == "  "))
 
