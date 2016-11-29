package com.deliverydrone


import java.io.File

import com.deliverydrone.delivery.Delivery


/**
 * Objeto Main que ejecuta los domicilios.
 *
  * Created by ALEJANDRO on 26/11/2016.
  */
object Main extends App{

  /** se crea una nueva entrega **/
  val delivery = new Delivery
  /** se ejecuta la entrega **/
  delivery.executeDelivery()


}
