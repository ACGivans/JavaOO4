/**
   Name: Andrew Givans
   Date: 4/12/2016

  
            Description: homeOptions Implementation class
     
      The purpose of this class is to allow the user to add various 
    housing options. The options are to rent an apartment, buy a 
    Town House or buy a house. Various options will be entered, 
    and they differ for each object, which is why there are objects 
    that extend other objects. The options for all objects are how 
    many bathrooms and bedrooms there are. The options for an 
    apartment are how much rent will be, and whether or not there 
    will be parking. The options for a townhouse and a house are 
    the monthly mortgage rate, tax rate, and insurance costs. For 
    single-family homes, there will be a monthly association fee 
    as well as the size of the lot in acres. After each object is 
    entered, the credentials are displayed. When the user indicates 
    they are finished, a summary report is printed.
   
**/

import javax.swing.JOptionPane;
public class homeOptions{
   public static void main(String[] args){
   
      final int MAX_NUM_HOMES = 18;
      
      Home[] homes = new Home[MAX_NUM_HOMES];
      Home oneHome;
      
      do{
           oneHome = addHome();
           
           populateHome(oneHome);
           
           homes[Home.getNumHomes()-1] = oneHome;
           
                 
      if (MAX_NUM_HOMES == Home.getNumHomes()){
         JOptionPane.showMessageDialog(null, "The maximum number of homes has been entered");
      }
           
      JOptionPane.showMessageDialog(null, homes[Home.getNumHomes()-1].toString());
      }while(JOptionPane.showConfirmDialog(null, "Add another home?") == JOptionPane.YES_OPTION);

      printSummaryReport(homes);
   
   }
   
   public static void printSummaryReport(Home[] homes){
      String Output ="Total number of housing options: " + Home.getNumHomes() +
                      "\nTotal number of apartments: " + Apartment.getNumApartments() +
                      "\nTotal number of townhouses: " + Townhouse.getNumTownHouses() +
                      "\nTotal number of houses: " + House.getNumHouses() +
                      "\nAverage Lot Size: " + calculateAverageLotSize(homes) +
                      "\nCheapest Monthly Cost: " + calculateCheapestMonthlyCost(homes);	
      
      JOptionPane.showMessageDialog(null, Output);
   }
   
   //Purpose: To calculate the average lot size   
   //Parameters: homes
   //Return type: double
   public static double calculateAverageLotSize(Home[] homes){
      int totalLotSize= 0;
      int averageLotSize = 0;
      
      for (int x=0; x < Home.getNumHomes(); x++){
      
         if (homes[x] instanceof House) {		
            totalLotSize+= ((House)homes[x]).getLotSize();	
         }
      }
      
      if(House.getNumHouses()>0){
      averageLotSize = (totalLotSize / House.getNumHouses()) ;
      }
      
      return averageLotSize;
   }
   
   //Purpose: To calculate the cheapest monthly cost  
   //Parameters: homes
   //Return type: double
   public static double calculateCheapestMonthlyCost(Home[] homes){
   
   double cheapestMonthly = 1000000;
   
   for (int x=0; x < Home.getNumHomes(); x++){ 
      if (homes[x].calculateMonthlyCost() < cheapestMonthly){		
         cheapestMonthly = homes[x].calculateMonthlyCost();		
      }
   }
   
   return cheapestMonthly;
      
   }
   
   //Purpose: To create a home object 
   //Parameters: none
   //Return type: Home
   public static Home addHome(){
      Home aHome;
      
      int homeType = Integer.parseInt(JOptionPane.showInputDialog(null, "What type of home are you entering?\n(1) Apartment\n(2) Townhouse \n(3) House"));

      int bedRooms = Integer.parseInt(JOptionPane.showInputDialog(null,"How many bedrooms?"));
      int bathRooms = Integer.parseInt(JOptionPane.showInputDialog(null,"How many bathrooms?"));

      switch (homeType) {
         case 1:
            aHome = new Apartment(bedRooms, bathRooms);
            break;

         case 2:
            aHome = new Townhouse(bedRooms, bathRooms);  
            break;

         case 3:
            aHome = new House(bedRooms, bathRooms);    
            break;
            
         default:
            aHome = null;
            break;
      }
      
      return aHome;
   }
   
   //Purpose: To populate a home object based on its specific class extension
   //Parameters: aHome
   //Return type: void
   public static void populateHome(Home aHome){
   
         if (aHome instanceof Apartment) {
         boolean rentSet = false;         
         do {
            try {
               rentSet = ((Apartment)aHome).setRent(Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly rent amount: ")));
            }
            catch (NumberFormatException e) {} 
         if (!rentSet) {
              JOptionPane.showMessageDialog(null, "Please enter an amount between $400 and $1000");
            }               
         } while (!rentSet); 
 
         boolean parkingSet = false;
         do {
               parkingSet = ((Apartment)aHome).setParking(JOptionPane.showInputDialog("Is parking available?"));
            if (!parkingSet) {
              JOptionPane.showMessageDialog(null, "Please enter 'Yes' or 'No'");
            }               
         } while (!parkingSet);
         
         boolean rentersInsuranceSet = false;         
         do {
            try {
               rentersInsuranceSet = ((Apartment)aHome).setRentersInsurance(Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly renters insurance amount: ")));
            }
            catch (NumberFormatException e) {} 
         if (!rentersInsuranceSet) {
              JOptionPane.showMessageDialog(null, "Please enter an amount above 50");
            }               
         } while (!rentersInsuranceSet); 

      }

     if (aHome instanceof House) {
         boolean associationFeeSet = false;
         do {
            try {
               associationFeeSet = ((House)aHome).setAssociationFee(Double.parseDouble(JOptionPane.showInputDialog("Enter the weekly association fee: ")));
            }
            catch (NumberFormatException e) {}
            if (!associationFeeSet) {
               JOptionPane.showMessageDialog(null, "Please enter a number above 0");
            }               
         } while (!associationFeeSet);
         
         boolean lotSizeSet = false;
         do {
            try {
               lotSizeSet = ((House)aHome).setLotSize(Integer.parseInt(JOptionPane.showInputDialog("Enter the lot size: ")));
            }
            catch (NumberFormatException e) {}
            if (!lotSizeSet) {
               JOptionPane.showMessageDialog(null, "Please enter a number above 0");
            }               
         } while (!lotSizeSet);
      }
            
     if (aHome instanceof Townhouse || aHome instanceof House) {
         boolean mortgageSet = false;
         do {
            try {
               mortgageSet = ((Townhouse)aHome).setMortgage(Double.parseDouble(JOptionPane.showInputDialog("Enter the mortgage amount: ")));
            }
            catch (NumberFormatException e) {}
            if (!mortgageSet) {
              JOptionPane.showMessageDialog(null, "Please enter a value between $800 and $3000");
            }               
         } while (!mortgageSet);                             

         boolean taxSet = false;
         do {
         try {
               taxSet = ((Townhouse)aHome).setTax(Double.parseDouble(JOptionPane.showInputDialog("Enter the tax rate: ")));
            }
            catch (NumberFormatException e) {}
            if (!taxSet) {
              JOptionPane.showMessageDialog(null, "Please enter a number less than $1800");
            }               
         } while (!taxSet); 
         
         boolean insuranceSet = false;
         do {
         try {
               insuranceSet = ((Townhouse)aHome).setInsurance(Double.parseDouble(JOptionPane.showInputDialog("Enter the insurance rate: ")));
            }
            catch (NumberFormatException e) {}
            if (!insuranceSet) {
              JOptionPane.showMessageDialog(null, "Please enter a value between $200 and $1500");
            }               
         } while (!insuranceSet); 
      } 
   }
}























