package com.mc10.codeassignment

/**
 * Represents a patient.
 * @param id identifier
 * @param age age in years
 * @param gender the [[Gender]]
 */
final case class Patient(
    id: PatientId,
    age: Int,
    gender: Gender
)

object Patient extends LineParsing {

  /**
   * Parse from a string
   * @param line the string to be parsed
   * @return the new instance
   */
  @throws[DataParsingException]
  def parse(line: String): Patient = {
    val fields = toFields(line)
    if (fields.length != 3) {
      throw new DPE(s"expected 3 fields in: $line")
    } else {
      Patient(
        PatientId.parse(fields(0)),
        try { fields(1).toInt }
        catch {
          case nfe: NumberFormatException =>
            throw new DPE(fields(2), nfe)
        },
        Gender.parse(fields(2))
      )
    }
  }
}
