package com.deliverydrone.delivery

import com.deliverydrone.common._
import com.deliverydrone.exception.CustomException


/**
  * Clase que define las funciones de una entrega.
  *
  * Created by ALEJANDRO on 27/11/2016.
  */
class Delivery extends DeliveryDefinitions {

  /**
    * Funcion que ejecuta una entrega segun las rutas igresadas en el archivo in.txt y escribe un
    * informe de las entregas en el archivo out.txt
    */
  def executeDelivery() = {
    val deliveryList = deliveryRoute
    if(deliveryList.size > 3) throw new CustomException("no se pueden realizar mas de 3 pedidos")
    else {
      val drone = createDrone()
      val finalLocations = deliverys(drone,deliveryList,Nil)
      val locations = finalLocations._3.reverse
      writeResource(locations)
    }


  }

  /**
    * Funcion que retorna la lista con la localizacion de las entregas y el drone con la lozalizacion final
    */
  def deliverys(drone: Drone, deliveryList:List[List[Move]], listLocations:List[String]):(Drone,List[List[Move]],List[String]) = {

    deliveryList match {

      case Nil => (drone,Nil,listLocations)
      case listMove::moves =>
        val droneMove = deliveryDrone(drone,listMove)
        deliverys(droneMove,moves,List(droneMove.getLocation()):::listLocations)

    }

  }

  /**
    * Funcion auxiliar que actualiza la posicion del drone segun  una lista de movimientos
    * que conrresponden a las ordenes que se le definieron.
    */
  private def deliveryDrone(drone: Drone, deliveryList: List[Move]): Drone = {
    def moveDeliveryDrone(drone: Drone, delivery: List[Move]): (Drone, List[Move]) = {

      delivery match {

        case Nil => (drone, Nil)
        case move :: moves =>
          move match {
            case Avance =>
              moveDeliveryDrone(drone.avance, moves)
            case Left =>
              moveDeliveryDrone(drone.left, moves)
            case Right =>
              moveDeliveryDrone(drone.right, moves)
          }
      }
    }
     moveDeliveryDrone(drone, deliveryList)._1
  }



}