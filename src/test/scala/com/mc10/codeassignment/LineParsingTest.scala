// Copyright 2016 Imprivata Inc.


package com.mc10.codeassignment

import org.scalatest.{FreeSpec, Matchers}

class LineParsingTest
  extends FreeSpec with Matchers {

  val lp = LineParsing
  "LineParsing" - {
    "should work" in {
      lp.toFields("").size should === (1)
      lp.toFields("       ").size should === (1)
      lp.toFields(" a      ") should === (Array("a"))
      lp.toFields("a|b").size should === (2)
      lp.toFields("a, b").size should === (2)
      lp.toFields("a, b  |c").size should === (3)
    }
  }
}
