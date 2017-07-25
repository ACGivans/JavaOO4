/**
   Name: Andrew Givans
   Date: 4/12/2016

  
                     Description: Home DDC
                     
      The purpose of this class is to contain the instance variables 
    with their mutators and accessors as well as a default constructor 
    to create each instance of a Home object. It also contains 
    validators for the instance variables and special purpose methods. It 
    is an abstract class that will be the baseline for TownHouse, Apartment,
    and House classes. 
      
**/

public abstract class Home{

   private int bedRooms;
   private int bathRooms;
   private static int numHomes = 0;
   
   //Purpose: The purpose of this specific constructor is to create
   //         a Home object
   //Parameters: bedRooms, bathRooms
   //Return type: None
   public Home(int bedRooms, int bathRooms){
      this.bedRooms = bedRooms;
      this.bathRooms = bathRooms;
      numHomes++;
   }
   
   //Purpose: The purpose of these get methods are to get the value requested
   //Parameters: None
   //Return type: int
   public int getBedRooms(){return this.bedRooms;}
   public int getBathRooms(){return this.bathRooms;}
   public static int getNumHomes(){return numHomes;}
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: bedRooms
   //Return type: void
   public boolean setBedRooms(int bedRooms){
      if(bedRooms < 1 || bedRooms > 5){
         return false;
      }
      else{
         this.bedRooms = bedRooms;
         return true;
      }
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: bathRooms
   //Return type: void
   public boolean setBathRooms(int bathRooms){
           if(bedRooms < 1 || bedRooms > 4){
         return false;
      }
      else{
         this.bathRooms = bathRooms;
         return true;
      }
   }
   
   //Purpose: The purpose of this abstract method is to calculate the monthly cost
   //Parameters: None
   //Return type: double
   public abstract double calculateMonthlyCost();
   
   //Purpose: The purpose of this toString method is return a string representation of the object
   //Parameters: None
   //Return type: String
   public String toString(){
      return "\nNumber of bedrooms: " + this.getBedRooms() + 
             "\nNumber of bathrooms: " + this.getBathRooms();
   }
   
}