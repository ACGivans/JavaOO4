/**
   Name: Andrew Givans
   Date: 4/12/2016

  
                     Description: Apartment DDC
                     
      The purpose of this class is to contain the instance variables 
    with their mutators and accessors as well as a default constructor 
    to create each instance of a Home object. It also contains 
    validators for the instance variables and special purpose methods.
      
**/

public class Apartment extends Home{

   private double rent;
   private String parking;
   private double rentersInsurance;
   private static int numApartments;
   
   //Purpose: The purpose of this specific constructor is to create
   //         an Apartment object
   //Parameters: bedRooms, bathRooms
   //Return type: None
   public Apartment(int bedRooms, int bathRooms){
      super(bedRooms, bathRooms);
      numApartments++;
   }
   
   //Purpose: The purpose of these get methods are to get the value requested
   //Parameters: None
   //Return type: varies - double, String, int
   public double getRent(){return this.rent;}
   public String getParking(){return this.parking;}
   public double getRentersInsurance(){return this.rentersInsurance;}
   public static int getNumApartments(){return numApartments;}
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: rent
   //Return type: void
   public boolean setRent(double rent){
      if (rent < 400 || rent > 1000){
         return false;
      }
      else{
         this.rent = rent;
         return true;
      }
   
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: parking
   //Return type: void
   public boolean setParking(String parking){
      if (parking.equalsIgnoreCase("Yes") || parking.equalsIgnoreCase("No")){
         this.parking = parking;
         return true;
      }
      else{
         return false;
      }
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: rentersInsurance
   //Return type: void
   public boolean setRentersInsurance(double rentersInsurance){
      if (rentersInsurance < 50){
         return false;
      }
      else{
         this.rent = rent;
         return true;
      }
   
   }
   
   //Purpose: The purpose of this method is to calculate the monthly cost
   //Parameters: None
   //Return type: double
   public double calculateMonthlyCost(){
      double monthlyCost = (this.getRent() + this.getRentersInsurance());
      return monthlyCost;
   }

   //Purpose: The purpose of this toString method is return a string representation of the object
   //Parameters: None
   //Return type: String
   public String toString() {
      return "Apartment\n"
         + "\nTotal Monthly Cost: " + String.format("$%.2f", this.calculateMonthlyCost())
         + "\nParking available? " + this.getParking()
         + "\nRenters insurance: " + this.getRentersInsurance() +
         super.toString();
   }
}