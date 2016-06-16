package com.mc10.codeassignment

import java.util.UUID

import scala.util.control.NonFatal

/**
 * An identifer for a patient
 * @param value the wrapped [[UUID]]
 */
final case class PatientId (value: UUID) extends AnyVal

object PatientId {

  /**
   * Parse from a string
   * @param s the string to be parsed
   * @return the new instance
   */
  @throws[DataParsingException]
  def parse(s: String): PatientId =
    try {
      PatientId(
        UUID.fromString(s))
    } catch {
      case NonFatal(ex) =>
        throw new DPE(s"expected UUID: $s", ex)
    }
}
