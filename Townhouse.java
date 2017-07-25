/**
   Name: Andrew Givans
   Date: 4/12/2016

  
                     Description: Townhouse DDC
                     
      The purpose of this class is to contain the instance variables 
    with their mutators and accessors as well as a default constructor 
    to create each instance of a Home object. It also contains 
    validators for the instance variables and special purpose methods.
      
**/

public class Townhouse extends Home{

   private double mortgage;
   private double tax;
   private double insurance;
   private static int numTownHouses;
   
   //Purpose: The purpose of this specific constructor is to create
   //         a Townhouse object
   //Parameters: bedRooms, bathRooms
   //Return type: None
   public Townhouse(int bedRooms, int bathRooms){
      super(bedRooms, bathRooms);
      numTownHouses++;
   }
   
   //Purpose: The purpose of these get methods are to get the value requested
   //Parameters: None
   //Return type: varies - double, int
   public double getMortgage(){return this.mortgage;}
   public double getTax(){return this.tax;}
   public double getInsurance(){return this.insurance;}
   public static int getNumTownHouses(){return numTownHouses;}
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: mortgage
   //Return type: void
   public boolean setMortgage(double mortgage){
      if (mortgage < 800 || mortgage > 3000){
         return false;
      }
      else{
         this.mortgage = mortgage;
         return true;
      }
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: tax
   //Return type: void
   public boolean setTax(double tax){
      if (tax > 1800){
         return false;
      }
      else{
         this.tax = tax;
         return true;
      }
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: insurance
   //Return type: void
   public boolean setInsurance(double insurance){
      if (insurance < 200 || insurance > 1500){
         return false;
      }
      else{
         this.insurance = insurance;
         return true;
      }
   }
   
   //Purpose: The purpose of this method is to calculate the monthly cost
   //Parameters: None
   //Return type: double
   public double calculateMonthlyCost(){
      double monthlyCost = (this.getMortgage() + this.getTax() + this.getInsurance());
      return monthlyCost;
   }

   //Purpose: The purpose of this toString method is return a string representation of the object
   //Parameters: None
   //Return type: String
   public String toString() {
      return "\n\nTownhouse\n"
         + "\nTotal Monthly Cost: " + String.format("$%.2f", this.calculateMonthlyCost())
         + "\nMortgage: " + this.getMortgage()
         + "\nTax: " + this.getTax()
         + "\nInsurance: " + this.getInsurance()
         + super.toString();
   }

}