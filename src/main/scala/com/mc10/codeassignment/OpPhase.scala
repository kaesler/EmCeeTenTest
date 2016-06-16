package com.mc10.codeassignment

sealed trait OpPhase
object OpPhase {

  /**
   * Parse from a string
   * @param s the string to be parsed
   * @return the new instance
   */
  @throws[DataParsingException]
  def parse(s: String) =
    if (s.toLowerCase == "preop") PREOP
    else if (s.toLowerCase == "postop") POSTOP
    else throw new DPE(s)
}
case object PREOP extends OpPhase
case object POSTOP extends OpPhase


