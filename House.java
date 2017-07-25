/**
   Name: Andrew Givans
   Date: 4/12/2016

  
                     Description: House DDC
                     
      The purpose of this class is to contain the instance variables 
    with their mutators and accessors as well as a default constructor 
    to create each instance of a Home object. It also contains 
    validators for the instance variables and special purpose methods.
      
**/

public class House extends Townhouse{

   private double associationFee;
   private int lotSize;
   private static int numHouses;
   
   //Purpose: The purpose of this specific constructor is to create
   //         a House object
   //Parameters: bedRooms, bathRooms
   //Return type: None
   public House(int bedRooms, int bathRooms){
      super(bedRooms, bathRooms);
      numHouses++;
   }
   
   //Purpose: The purpose of these get methods are to get the value requested
   //Parameters: None
   //Return type: varies - double, int, int
   public double getAssociationFee(){return this.associationFee;} 
   public int getLotSize(){return this.lotSize;}
   public static int getNumHouses(){return numHouses;}
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: associationFee
   //Return type: void
   public boolean setAssociationFee(double associationFee){
      if (associationFee < 0){
         return false;
      }
      else{
         this.associationFee = associationFee;
         return true;
      }
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: lotSize
   //Return type: void
   public boolean setLotSize(int lotSize){
      if (lotSize < 0){
         return false;
      }
      else{
         this.lotSize = lotSize;
         return true;
      }
   }
   
   //Purpose: The purpose of this method is to calculate the monthly cost
   //Parameters: None
   //Return type: double
   public double calculateMonthlyCost(){
      double monthlyCost = (this.getMortgage() + this.getTax() + this.getInsurance() + this.getAssociationFee());
      return monthlyCost;
   }

   //Purpose: The purpose of this toString method is return a string representation of the object
   //Parameters: None
   //Return type: String
   public String toString() {
      return "House\n"
         + "\nTotal Monthly Cost: " + String.format("$%.2f", this.calculateMonthlyCost())
         + "\nMortgage: " + this.getMortgage()
         + "\nTax: " + this.getTax()
         + "\nInsurance: " + this.getInsurance()
         + "\nAssociation Fee: " + this.getAssociationFee()
         + "\nLot Size: " + this.getLotSize()
         + super.toString();
   }

      

}