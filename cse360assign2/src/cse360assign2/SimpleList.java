package cse360assign2;
import java.math.*;
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
    private int size;
    /**
     * Default Constructor for SimpleList
     */
    public SimpleList() {
		list = new int[10];
		size = 10;
		count = 0;
	}
    
    /**add adds an integer to the beginning of the list
     * @param number is the number being added to the array
     * if the list is full, the size of the array is increased 50%
     */
    public void add(int number){
        if(count == size){          //if list is full place integer in index 
        	int copy[];
        	copy = list;
        	size = (int) Math.floor(size * 1.5);
            list = new int[size];  //incrase size of array
            for(int index = 1; index <= count; index++) {
            	list[index] = copy[index-1];
            }
            list[0] = number;
            count++;
        }else{
        	
        	for(int index = count-1; index >= 0; index--){
        		list[index + 1] = list[index];
        	}
            list[0] = number;
            count++;
        }
    }
    /**
     * Remove target integer from the list; if more than 25% of array is empty,
     * size of array is decreased
     * @param target is the integer to be removed 
     */
    public void remove(int target){
        for(int index = 0; index < count; index++){ //find integer
            if(target == list[index]){
                for(int innerIndex = index; innerIndex < count-1; innerIndex++){
                    list[innerIndex] = list[innerIndex+1]; //remove integer
                }
                count--;
                int emptySpaces = size - count;
                int twentyFive = Math.floorDiv(size,4);
                if(emptySpaces > twentyFive && size > 1) { //reduces size of array
                	int copy[];
                	copy = list;
                	size = (int) Math.floor(size * .75);
                	list = new int[size];
                	for(int copyIndex =0; copyIndex < count; copyIndex++) {
                		list[copyIndex] = copy[copyIndex];
                	}
                }
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
     * size() returns the maximum size of the array as an int
     * @return size as an int
     */
    public int size() {
    	return size;
    }
    /**
     * toString method for SimpleList
     * @return output is a String of the array separated by spaces 
     */
    public String toString(){
        String output = "";
        if(count > 0) {
        	for(int index = 0; index < count-1; index++){
                output += list[index] + " ";
            }
            output  += list[count-1];
        }else {
        	output = "Array is empty";
        }
        
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

