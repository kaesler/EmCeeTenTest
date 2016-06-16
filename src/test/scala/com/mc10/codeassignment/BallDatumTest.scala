// Copyright 2016 Imprivata Inc.


package com.mc10.codeassignment

import org.scalatest.{FreeSpec, Matchers}

class BallDatumTest
  extends FreeSpec
  with Matchers {

  "BallDatum.parse" - {
    "should succeed on valid input" in {
      BallDatum.parse("462374100, 20, 55   ") shouldEqual
        BallDatum(
          Timestamp(462374100),
          Point(20, 55)
        )
    }
  }
}
