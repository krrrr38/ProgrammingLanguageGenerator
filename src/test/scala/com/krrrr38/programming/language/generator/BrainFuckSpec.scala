package com.krrrr38.programming.language.generator

import org.scalatest.{Matchers, FlatSpec}

class BrainFuckSpec extends FlatSpec with Matchers{

  val fixture = new {
    val parser = Factory.create(
      List("+"),
      List("-"),
      List(">"),
      List("<"),
      List("."),
      List(",")
     )
  }

  "BrainFuck Parser" should "parse each simple word" in {
    fixture.parser.parse("+").get.head shouldBe a [Inc]
    fixture.parser.parse("-").get.head shouldBe a [Dec]
    fixture.parser.parse(">").get.head shouldBe a [Next]
    fixture.parser.parse("<").get.head shouldBe a [Prev]
    fixture.parser.parse(".").get.head shouldBe a [Put]
    fixture.parser.parse(",").get.head shouldBe a [Get]
  }
}
