package com.mc10.codeassignment

/**
 * Datum captured as ball is thrownn
 * @param time time of the datum
 * @param location 2-D location of the ball
 */
final case class BallDatum (
    time: Timestamp,
    location: Point
) extends Ordered[BallDatum] {

  /** @inheritdoc */
  override def compare(that: BallDatum): Int =
    this.time.compare(that.time)
}

object BallDatum extends LineParsing {

  /**
   * Parse from a string
   * @param line the string to be parsed
   * @return the new instance
   */
  @throws[DataParsingException]
  def parse(line: String): BallDatum = {
    val fields = toFields(line)
    if (fields.length != 3)
      throw new DPE(s"expected 3 fields and found ${fields.length}: $line")
    else {
      BallDatum(
        Timestamp.parse(fields(0)),
        Point.parse(fields(1), fields(2))
      )
    }
  }
}
