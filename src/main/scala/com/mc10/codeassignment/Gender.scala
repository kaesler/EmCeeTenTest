package com.mc10.codeassignment

sealed trait Gender
object Gender {

  /**
   * Parse from a string
   * @param s the string to be parsed
   * @return the new instance
   */
  @throws[DataParsingException]
  def parse(s: String): Gender = {
    if (s.toLowerCase == "male") Male
    else if (s.toLowerCase == "female") Female
    else throw new DataParsingException(s)
  }
}

case object Male extends Gender
case object Female extends Gender
