package com.mc10.codeassignment

import org.scalatest
import org.scalatest.{FreeSpec, Matchers}

class GenderTest
  extends FreeSpec
  with Matchers {

  "Gender parser" - {
    "should succeed on valid values" in {
      Gender.parse("mALe") shouldEqual(Male)
      Gender.parse("feMaLe") shouldEqual(Female)
    }
    "should throw on invalid values" in {
      an [DPE] should be thrownBy Gender.parse("mouse")
    }
  }

}
