fun main(){

    var vehicle1 = Bicycle("Suzuki", "SV650")
    println(vehicle1)
    println(vehicle1.travel(4.0))

    var vehicle2 = Car("Toyota", "Camry",5,"FYV453")
    println(vehicle2)
    println(vehicle2.travel(600.00))

    var vehicle3 = Motorboat("","",21, "GYUB43",10.0)
    println(vehicle3)
    println(vehicle3.travel(10.0))

    if (vehicle3.numberOfPassengers > 20){
        throw IllegalArgumentException("Boats with that can hold more than 20 people are not classified as Motorboats, please use the Yacht or Ship class instead.")
    }
}

abstract class Vehicle(
    var type: String,
    var make:String,
    var model: String,
    var numberOfPassengers: Int,
){
    override fun toString(): String {
        return "The Type of the Vehicle is $type, has a Make of $make, Model of $model, and carry $numberOfPassengers amount of passengers."
    }
    abstract fun travel(distance: Double)
}

class Bicycle(
    make: String,
    model: String
) : Vehicle(
    "Bike",
    make,
    model,
    1,
){
    override fun travel(distance: Double) {
        if (distance < 1.0) {
            println("That's easy")
        }
        else if (distance in 1.0..10.0){
            println("That'll take a while")
        }
        else{ distance < 10.0
            println("I can't go that far on a bike")
        }
    }
}

abstract class RegisteredVehicle(
    type: String,
    make: String,
    model: String,
    numberOfPassengers: Int,
    var registration: String
) : Vehicle(
    type,
    make,
    model,
    numberOfPassengers,
) {
    override fun toString(): String {
        return "${super.toString()} The registration of the vehicle is $registration"

    }
}
class Car(
    make: String,
    model: String,
    numberOfPassengers: Int,
    registration: String,
): RegisteredVehicle(
    "Car",
    make,
    model,
    numberOfPassengers,
    registration,
) {
    override fun travel(distance: Double) {
        if (distance < 10.0) {
            println("Be back in a few")
        } else if (distance in 10.0..50.0) {
            println("See you later today")
        } else if (distance in 50.0..200.0) {
            println("See you next week")
        } else if (distance in 200.0..1000.0) {
            println("See you in a few months")
        } else {
            distance > 1000.0
            println("See you when I see you")
        }
    }
}

class Motorboat(
    make: String,
    model: String,
    numberOfPassengers: Int,
    registration: String,
    var topNauticalSpeed: Double,
) : RegisteredVehicle(
    "Boat",
    make,
    model,
    numberOfPassengers,
    registration,
){
    override fun toString(): String {
        return "${super.toString()} The top nautical speed is $topNauticalSpeed"
    }

    override fun travel(distance: Double) {
        if (distance > 2.0){
            println("Be back in a few")
        }else if(distance in 2.0..10.0){
            println ("See you later")
        }else{
            distance > 10.0
            println("I probably shouldn't go out that far without a bigger boat")
        }
    }

}
