package cse360assign2;
/**
 * 
 * NAME: JOSHEP NGUYEN
 * CLASS ID: 170
 * Assignment 1
 * This file contains the class for the Simple List and its methods
 */



/**
 * This class creates an array of integers with basic operations 
 * such as search,add remove
 * 
 */
public class SimpleList {
    private int list[];
    private int count;
    /**
     * Constructor for SimpleList
     */
    public SimpleList() {
		list = new int[10];
		count = 0;
	}
    /**add adds an integer to the list
     * @param number is the number being added to the array
     */
    public void add(int number){
        if(count == 10){          //if list is full place integer in index 9
            list[9] = number;
        }else{
            list[count] = number;
            count++;
        }
    }
    /**
     * Remove target integer from the list;
     * @param target is the integer to be removed 
     */
    public void remove(int target){
        for(int index = 0; index <= count; index++){ //find integer
            if(target == list[index]){
                for(int innerIndex = index; innerIndex <= count; innerIndex++){
                    list[innerIndex] = list[innerIndex+1]; //remove integer
                }
                count--;
            }
        }
    }
    /**
     * count() returns count of SimpleList as an intger
     * @return count as an int
     */
    public int count(){
        return count;
    }
    /**
     * toString method for SimpleList
     * @return output is a String of the array separated by spaces 
     */
    public String toString(){
        String output = "";
        for(int index = 0; index < count-1; index++){
            output += list[index] + " ";
        }
        output  += list[count-1];
        return output;
    }
    /**
     * search finds the index of the input integer
     * @param target is the integer to look for
     * @return location is the index of the integer if it is found
     * it will return -1 if it was not found
     */
    public int search(int target){
        int location = -1;
        for(int index = count-1; index >= 0;index--){ 
            if(list[index] == target){
                location = index;
            }
        }
        return location;
    }


}

