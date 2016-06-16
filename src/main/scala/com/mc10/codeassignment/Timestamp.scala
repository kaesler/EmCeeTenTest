package com.mc10.codeassignment

/**
 * Represents the time at which a ball location datum was captured.
 *
 * @param millis milliseconds from some start time
 */
case class Timestamp(millis: Long)
  extends AnyVal
  with Ordered[Timestamp] {

  /** @inheritdoc */
  override def compare(that: Timestamp): Int =
    this.millis.compareTo(that.millis)
}

object Timestamp {

  /**
   * Parse from a string
   * @param s the string to be parsed
   * @return the new instance
   */
  @throws[DataParsingException]
  def parse(s: String): Timestamp =
    try {
      Timestamp(s.toLong)
    } catch {
      case nfe: NumberFormatException =>
        throw new DPE(s, nfe)
    }
}


