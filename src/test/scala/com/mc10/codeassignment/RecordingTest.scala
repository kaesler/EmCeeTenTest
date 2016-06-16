package com.mc10.codeassignment

import org.scalatest.{FreeSpec, Inside, Matchers}

class RecordingTest
  extends FreeSpec
  with Matchers
  with Inside {

  "Recording.parse" - {

    "should succeed on valid data" in {
      val text =
        """
          |4776da07-75e0-45ef-b9ce-6fb83169b074|22|FEMALE
          |462374000| 0| 20
          |462374100| 10| 60
          |462374200| 20| 80
          |462374300| 40| 20
          |462374400| 50| 0
          |""".stripMargin

      inside (Recording.parse(text, POSTOP)) {
        case Recording(_, _, _) =>
      }
    }

    "should succeed on all supplied data" in {
      SuppliedData.recordingFiles
        .foreach { uri =>
          inside (Recording.parse(uri)) {
            case Recording(_, _, _) =>
          }
        }
    }
  }

}
