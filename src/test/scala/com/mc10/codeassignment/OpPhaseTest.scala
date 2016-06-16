package com.mc10.codeassignment

import org.scalatest.{FreeSpec, Matchers}

class OpPhaseTest
  extends FreeSpec
  with Matchers {

  "OpPhase parser" - {
    "should succeed on valid values" in {
      OpPhase.parse("preOP") shouldEqual(PREOP)
      OpPhase.parse("PoStOp") shouldEqual(POSTOP)
    }
    "should throw on invalid values" in {
      an [DPE] should be thrownBy OpPhase.parse("xxx")
    }
  }

}
