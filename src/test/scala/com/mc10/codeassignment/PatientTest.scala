// Copyright 2016 Imprivata Inc.


package com.mc10.codeassignment

import java.util.UUID

import org.scalatest.{FreeSpec, Matchers}

class PatientTest
  extends FreeSpec
  with Matchers {

  "Subject.parse" - {
    "should succeed when appropriate" in {
      Patient.parse("02afc5d1-9129-46c8-812b-63f9cf408399|33|female") shouldEqual
        Patient(
          PatientId(UUID.fromString("02afc5d1-9129-46c8-812b-63f9cf408399")),
          33,
          Female
        )
    }
  }
}
