package com.mc10.codeassignment

/**
 * Represents the location of the ball at a instant of time
 * @param x horizontal distance from origin
 * @param y vertical distance from origin
 */
final case class Point (x: Double, y: Double)

object Point {

  /**
   * Parse from a string
   * @param x the X-corrdinae to be parsed
   * @param y the Y-corrdinae to be parsed
   * @return the new instance
   */
  @throws[DataParsingException]
  def parse (x: String, y: String): Point = {
    try {
      Point(
        x.toDouble,
        y.toDouble
      )
    } catch {
      case nfe: NumberFormatException =>
        throw new DPE(s"($x, $y)", nfe)
    }
  }
}

