package com.mc10.codeassignment

import java.net.URI

import scala.collection.SortedSet
import scala.io.Source

/**
 * The recorded data for a singe throw.
 * @param patient the [[Patient]]
 * @param opPhase the [[OpPhase]]
 * @param ballData the collection of [[BallDatum]] values
 */
final case class Recording(
    patient: Patient,
    opPhase: OpPhase,
    ballData: SortedSet[BallDatum]
) {
  require(ballData.size >= 2)
  require(ballData.exists(_.location.y == 0))

  /**
   * @return the location where the bal landed
   */
  def landing: Point = ballData
    .find(_.location.y == 0.0)
    .get
    .location

  /**
   * @return the distance thrown
   */
  def distance: Double = landing.x

  /**
   * @return the maximum height the ball reached
   */
  def height: Double = ballData
    .map (_.location.y)
    .max
}

object Recording {

  /**
   * Parse from a string referenced by URI.
   * @param uri the URI for the text to be parsed
   * @return the new instance
   */
  @throws[DataParsingException]
  def parse(uri: URI): Recording = {

    val text = Source.fromFile(uri, "UTF-8").mkString
    val phase = inferOpPhase(uri).get
    parse(text, phase)
  }

  /**
   * Parse from a string referenced by URI.
   * @param text the text to be parsed
   * @param phase the [[OpPhase]]
   * @return the new instance
   */
  @throws[DataParsingException]
  def parse(text: String, phase: OpPhase): Recording = {
    val lines = text.split(System.lineSeparator)
      .filterNot(_.isEmpty)

    val subject = Patient.parse(lines.head)
    parse(lines.tail, subject, phase)
  }

  private def parse(
      lines: Array[String],
      subject: Patient,
      phase: OpPhase): Recording = {

    val ballData = lines.map (BallDatum.parse)
    Recording(
      subject,
      phase,
      SortedSet(ballData:_*)
    )
  }

  private def inferOpPhase(uri: URI): Option[OpPhase] = {
    if (uri.getPath.contains("PREOP.txt")) Some(PREOP)
    else if (uri.getPath.contains("POSTOP.txt")) Some(POSTOP)
    else None
  }
}
