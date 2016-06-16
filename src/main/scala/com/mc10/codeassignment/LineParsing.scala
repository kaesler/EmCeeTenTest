package com.mc10.codeassignment

/**
 * Mixin for splitting datafile text lines into fields.
 */
trait LineParsing {

  private val separators = Array(',', ';', '|')

  /**
   * Splits a line of text into fields, ane removes leading and
   * trailing spaces
   * @param line the text to be parsed
   * @return the fields of the line
   */
  def toFields(line: String): Array[String] =
    line.split(separators)
    .map { _.dropWhile(_ == ' ') }
    .map { field => field.reverse.dropWhile(_ == ' ').reverse }
}
object LineParsing extends LineParsing
