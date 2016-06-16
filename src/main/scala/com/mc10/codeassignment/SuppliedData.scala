package com.mc10.codeassignment

import java.net.URI

import scalax.file.Path

object SuppliedData {

  def recordingFiles: List[URI] = {
    val url = this.getClass.getClassLoader.getResource("data")
    val dataDir = Path(url.toURI).get

    (dataDir ** "RECORDING*.txt")
      .toList
      .map (_.toURI)
  }
}
