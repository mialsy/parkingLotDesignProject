# Parking Lot Project README
<h5>Designed a parking lot that can park different size of vehicles.
<h6><i>This parking lot only support basic function, park and exit. 
It does not support modification of the spot once created (i.e. you cannot add new spot to the existing parking lot). 
</i></h6>
</h5>

<p> Designed following classes:
    <li> public class ParkingLot, 
    <li> private class Spot (represnt the parking spot in the parking lot), 
    <li> public abstract class Vehicle, 
    <li> public class Car extends Vehicle, 
    <li> public class Truck extends Vehicle, 
    <li> public class Bus extends Vehicle.</li></p>
   
<p> 
The relationship between the classes are as below:
    <li> Car isA Vehicle
    <li> Truck isA Vehicle
    <li> Bus isA Vehicle
    <li> Spot hasA Vehicle
    <li> ParkingLot hasA list of Spot</li> </p>

<p>
Also designed an enum to indicate the size of the vehicle and the max capacity of the spot.
    <li>Vehicle size (COMPACT, MIDSIZE, LARGE)</li></p>

<p>
ParkingLot has the following methods:
      <li>isFull
      <li>findSpotById
      <li>park(Vehicle)
      <li>park(Vehicle, Spot)
      <li>exit(Vehicle)
      <li>exit(Vehicle, int)</li></p>
<p>  
Spot has the following methods:
    <li> getId 
    <li> getMaxCapacity
    <li> getCurrentVehicle
    <li> isEmpty
    <li> fit
    <li> park
    <li> leave </li> </p>
