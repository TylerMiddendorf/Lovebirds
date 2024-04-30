/*
 * This class contains the preferences for a user and will be used by the
 * matchmaking system. 
 * 
 * Preferences: preferred gender, preferred sexuality, minimum / maximum height, 
 * minimum / maximum weight, minimum / maximum age
 */

public class Preferences {

   private String preferredGender;
   private int minHeight;
   private int maxHeight;
   private int minWeight;
   private int maxWeight;
   private int minAge;
   private int maxAge;

   
   public Preferences() {
      
   }

   //replace parameters with dictionary where if the values don't exist they are set with a default value
   public Preferences(String gender, int minHeight, int maxHeight, int minWeight, int maxWeight, int minAge, int maxAge){
    this.preferredGender = gender;
    this.minHeight = minHeight;
    this.maxHeight = maxHeight;
    this.minWeight = minHeight;
    this.maxWeight = maxWeight;
    this.minAge = minAge;
    this.maxAge = maxAge;
   }

   public void setPreferredGender(String gender) {
    this.preferredGender = gender;
   }

   public String getPreferredGender() {
    return preferredGender;
   }

   public void setMinHeight(int height) {
    this.minHeight = height;
   }

   public int getMinHeight() {
    return minHeight;
   }

   public void setMaxHeight(int height) {
    this.maxHeight = height;
   }

   public int getMaxHeight() {
    return maxHeight;
   }

   public void setMinWeight(int weight) {
    this.minWeight = weight;
   }

   public int getMinWeight() {
    return minWeight;
   }

   public void setMaxWeight(int weight) {
    this.maxWeight = weight;
   }

   public int getMaxWeight() {
    return maxWeight;
   }

   public void setMinAge(int age) {
    this.minAge = age;
   }

   public int getMinAge() {
    return minAge;
   }

   public void setMaxAge(int age){
    this.maxAge = age;
   }

   public int getMaxAge() {
    return maxAge;
   }
    
}
