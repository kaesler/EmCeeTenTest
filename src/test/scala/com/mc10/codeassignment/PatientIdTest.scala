// Copyright 2016 Imprivata Inc.


package com.mc10.codeassignment

import java.util.UUID

import org.scalatest.{FreeSpec, Matchers}

class PatientIdTest
  extends FreeSpec
  with Matchers {

  "SubjectId parser" - {
    "should work as expected" in {
      PatientId.parse("02afc5d1-9129-46c8-812b-63f9cf408399") should === (
        PatientId(UUID.fromString("02afc5d1-9129-46c8-812b-63f9cf408399"))
      )

      an [DPE] should be thrownBy {
        PatientId.parse("x-y-z")
      }
    }
  }
}
