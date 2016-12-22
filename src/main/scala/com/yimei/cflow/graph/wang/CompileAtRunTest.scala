package com.yimei.cflow.graph.wang


abstract class Plant

case class Rose() extends Plant

abstract class Greenhouse {
  def getPlant(): Plant
}

case class GreenhouseFactory(content: String) {

  import reflect.runtime.currentMirror
  import tools.reflect.ToolBox

  val toolbox = currentMirror.mkToolBox()

  val tree = toolbox.parse(content)
  val compiledCode = toolbox.compile(tree)

  def make(): Greenhouse = compiledCode().asInstanceOf[Greenhouse]
}

object Main {
  def main(args: Array[String]) {
    val greenhouseFactory = GreenhouseFactory(
      """
        |import com.yimei.cflow.graph.wang._
        |new Greenhouse {
        |  override def getPlant(): Plant = new Rose()
        |}
      """.stripMargin)

    val greenhouse = greenhouseFactory.make()
    val p = greenhouse.getPlant()

    println(p)
  }
}

