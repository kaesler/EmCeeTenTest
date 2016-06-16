package com.mc10.codeassignment

/**
 * Exception thrown for any data that cannot be parsed.
 * @param msg the message
 * @param cause the cause if any else null
 */
class DataParsingException(msg: String, cause: Throwable = null)
  extends Exception(msg, cause)
