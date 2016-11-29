package com.deliverydrone

import java.io.{BufferedWriter, File, FileWriter, InputStream}

/**
  * Objeto con funcionalidades genericas.
  *
  * Created by ALEJANDRO on 26/11/2016.
  */
package object common {


  /**
    * Funcion que retorna el contenido del archivo in.txt.
    */
  def getResource():List[String] = {

    val source : InputStream = getClass.getResourceAsStream("/in.txt")
    val lines =  scala.io.Source.fromInputStream( source ).getLines.toList
    lines

  }


  /**
    * Funcion que escribe el archivo out.txt.
    * @param resourceText
    */
  def writeResource(resourceText:List[String]) = {

    val classesDir = new File(getClass.getResource(".").toURI)
    val projectDir = classesDir.getParentFile.getParentFile.getParentFile.getParentFile.getParentFile.getParentFile.getPath
    val resourcesPath = projectDir+"/src/main/resources/"
    val file  = new File(resourcesPath+"out.txt")
    val bw = new  BufferedWriter(new FileWriter(file))
    bw.write(getTemplateReport)
    resourceText.map{text =>bw.newLine();bw.write(text)}
    bw.close()
    println("--- reporte generado ---")

  }

  def getTemplateReport = "== Reporte de entregas =="


}
