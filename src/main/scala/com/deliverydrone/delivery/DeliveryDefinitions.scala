package com.deliverydrone.delivery

import com.deliverydrone.common._
import com.deliverydrone.drone.DroneController

/**
  *
  * Trait que define las funciones generales para las entregas.
  *
  * Created by ALEJANDRO on 27/11/2016.
  */
trait DeliveryDefinitions extends DroneController{

  private lazy val deliveryRouteResource = getResource()
  private lazy val deliveryRoutes = deliveryRouteResource.map(route => route.toList)


  /**
    * Funcion que tranforma las rutas de un resource para que el drone las comprenda.
    */
  def transformeDeliveryRoute () ={

   deliveryRoutes.map{
      routes => routes.map{
        move => move match {

          case 'A' => Avance
          case 'I' => Left
          case 'D' => Right

        }
      }
    }


  }
  lazy  val  deliveryRoute = transformeDeliveryRoute()


}
