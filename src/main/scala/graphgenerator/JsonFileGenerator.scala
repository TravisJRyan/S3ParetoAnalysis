package graphgenerator

import java.io.{FileOutputStream, OutputStream}
import java.nio.file.{Path, Paths}

import org.json4s.JsonAST._
import org.json4s.JsonDSL._
import DataConstuctor.Daily

class JsonFileGenerator(jsonFileName: String) {

  def generateJson(dailies: Array[Daily], totalHostnames: Int, outputDirectory: Path): Unit = {
    val outputStream: OutputStream = getOutputStream(outputDirectory)
    outputStream.write(buildJson(dailies, totalHostnames).toString.getBytes("UTF-8"))
    outputStream.flush()
    outputStream.close()
  }

  private def getOutputStream(outputDirectory: Path) = {
    new FileOutputStream(outputDirectory.resolve(jsonFileName).toFile)
  }

  private def buildJson(dailies: Array[Daily], totalHostnames: Int): JValue = {
    ("totalHostnames" -> totalHostnames) ~
    ("dailies" -> JSet(dailies.toStream.map((daily: Daily) => {
      ("todayUniqueHostnames" -> daily.todayUniqueHostnames) ~ ("totalUniqueHostnames" -> daily.totalUniqueHostnames)
        }).toSet))
  }

}
