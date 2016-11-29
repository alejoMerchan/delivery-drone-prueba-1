package com.deliverydrone.exception

/**
 * Clase que define las tipoes de exceptiond e la aplicacion.
 * Created by abelmeos on 2016/11/28.
 */

case class CustomException(message: String = "", cause: Throwable = null) extends Exception(message, cause)