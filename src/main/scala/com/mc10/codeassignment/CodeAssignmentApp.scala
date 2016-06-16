package com.mc10.codeassignment

object CodeAssignmentApp extends App {

  val recordings = SuppliedData.recordingFiles
    .map (Recording.parse)

  // 1) Print the average lateral distance all patients pre and post operation
  // threw the ball.
  {
    val totalDistances = recordings
      .map(_.distance)
        .sum
    val result = totalDistances / recordings.size
    println(s"(1) Average distance: $result")
  }

  // 2) Print which patient threw the ball the shortest lateral distance and
  // whether that patient was pre or post op.
  {
    val rec = recordings
      .reduce { (rec1, rec2) =>
        if (rec1.distance <= rec2.distance) rec1
        else rec2
      }
    println(s"(2) Patient ${rec.patient.id.value.toString} ${rec.opPhase} threw the shortest with ${rec.distance}")
  }

  // 3) Print which patient threw the ball the longest lateral distance and
  // whether that patient was pre or post op.
  {
    val rec = recordings
      .reduce { (rec1, rec2) =>
        if (rec1.distance > rec2.distance) rec1
        else rec2
      }
    println(s"(3) Patient ${rec.patient.id.value.toString} ${rec.opPhase} threw the longest with ${rec.distance}")
  }

  // 4) Print which male patient threw the ball the highest.
  {
    val rec = recordings
      .filter(_.patient.gender == Male)
      .reduce { (rec1, rec2) =>
        if (rec1.height > rec2.height) rec1
        else rec2
      }
    println(s"(4) Male patient ${rec.patient.id.value.toString} threw the ball the highest")
  }

  // 5) Print which female patient threw the ball the highest.
  {
    val rec = recordings
      .filter(_.patient.gender == Female)
      .reduce { (rec1, rec2) =>
        if (rec1.height > rec2.height) rec1
        else rec2
      }
    println(s"(5) Female patient ${rec.patient.id.value.toString} threw the ball the highest")
  }

  // 6) Print (one list) all post op patients sorted ascending by age and
  // lateral throwing distance.
  {
    val lines = recordings
      .filter(_.opPhase == POSTOP)
      .sortBy { rec => (rec.patient.age, rec.distance) }
      .map { rec =>
        s"${rec.patient.id.value} ${rec.patient.age} ${rec.distance}"
      }
    println(s"(6) Post op by age and throw:\n${lines.mkString("  ", "\n  ", "")}")

  }
  // 7) Print the patient with the largest absolute difference in their lateral
  // throwing distance.
  {
    def minMaxDelta(distances: List[Double]): Double = {
      distances.max - distances.min
    }

    val pair = recordings
      .map { rec =>
        // Pairs (id, distance)
        (rec.patient.id, rec.distance)
      }
      .groupBy(_._1)
      // Pairs (id, distances)
      .map { case (id, (pairs)) =>
        (
          id,
          pairs.map(_._2)
          )
      }
      // Pairs (id, maxDelta)
      .map { case (id, distances) =>
        (id, minMaxDelta(distances))
      }
      // Reduce to the pair wth the biggest delta
      .reduce { (pair1, pair2) =>
        if (pair1._2 >= pair2._2) pair1
        else pair2
      }

    println(s"(7) Patient ${pair._1.value } had the largest difference of ${pair._2}")
  }
}

