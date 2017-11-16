/********************************************************************
 * Programmer:      McFadden
 * Class:           CS30S
 *
 * Assignment:      A1 Q2
 * Program Name:    A1Q2
 *
 * Description:     Will read the array outputted by other file and calculate
 *                  the frequency of all numbers, then user can request the
 *                  frequency of any number and the frequency of an array of 
 *                  values
 *
 * Input:           Data is going to be read in from out file of A1ArrayGen
 *
 * Output:          Will output the frequency of requested numbers 
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
 

public class A1Q2 {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
    
        final int rnMAX = 1000;     //constant for max size of random number array
        final int frMAX = 100;      //constant for max size of frequency array
        final int OFFSET1v0 = 1;    //constant to offest counting difference
        final int SENTINELVAL = -1; //constant for sentinel value
        final String SENTINELSTRING = "-1"; //constant for sentinel value
    
    // ********** declaration of variables **********
    
    	String strin;				// string data input from keyboard
    	String strout;				// processed info string to be output
    	String bannerOut;			// string to print banner to message dialogs
    	
    	String prompt;				// prompt for use in input dialogs
    	
    	String delim = "[ -]+";		// delimiter string for splitting input string
    	String tabSpace = "      ";	// six spaces
    	
        int[] Rn = new int[rnMAX];      //array for random numbers read in
        int [] Fr = new int[frMAX];     //array for frequency of numbers
        
        String Line[];                  //array for numbers in a line
        int Len;                        //int for length of line
        int counter = 0;                //int for number
        
        int singleN = 0;                //int for number entered for input 
    	String multiN = "";             //variable for range entered
        
        String[] tokens;                   //array for seperated value
        
        int n1, n2;                     //variables for sepereated input
        
        
    	BufferedReader fin = new BufferedReader(new FileReader("RandomNumbers.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("testOut.txt")));
    	
    // ********** Print output Banner **********
    
    	System.out.println("*******************************************");
    	System.out.println("Name:		McFadden");
    	System.out.println("Class:		CS30S");
    	System.out.println("Assignment:	A1 Q2");
    	System.out.println("*******************************************");

    	bannerOut = "*******************************************\n";
    	bannerOut += "Name:		McFadden\n";
    	bannerOut += "Class:		CS30S\n";
    	bannerOut += "Assignment:	A1 Q2\n";
    	bannerOut += "*******************************************\n\n";
    	
    	fout.println("*******************************************");
    	fout.println("Name:		McFadden");
    	fout.println("Class:		CS30S");
    	fout.println("Assignment:	A1 Q2");
    	fout.println("*******************************************");
 	    	
    // ************************ get input **********************
    strin = fin.readLine(); //priming statement
    
    while (strin != null){ //repeats untill string is null
        Line = strin.split(delim); //splits the string by its deliminator
        Len = Line.length;  //counts length of string
        
        for(int i = 0; i < Len; i++){ //for loop that reads in the random number array
            Rn[counter] = Integer.parseInt(Line[i]);  //reads numbers into array
            counter++; //adds one to the array counter
        }//end of random number read in for loop
        strin = fin.readLine(); //reads new line
    }//end of EoF while loop
    // ************************ processing ***************************
    
    
    for(int i = 0; i < rnMAX; i++){ //loop that checks fequency of numbers in rn array
    
    Fr[Rn[i]-OFFSET1v0]++; //adds one to the frequency of number in array being indexed
    
    }//end of frequency for loop
    
    
    // ************************ print output ****************************
    //runs if sentinel values are not entered
     while (singleN != SENTINELVAL || !(multiN.equals(SENTINELSTRING))){ 
        
         //asks for input
         singleN = Integer.parseInt(JOptionPane.showInputDialog
            ("Enter what number you would like to see the frequency for"
                    + "\nExample: 10"
                    + "\nIf You Would Like to Skip/End Type -1"));
         //runs if sentinel value not entered
         if (singleN != -1){
             //prints frequency
             System.out.println("The Frequency of " + singleN + 
                     " is: " + Fr[singleN - OFFSET1v0]);
         }//end of single number if
         
         //asks for range of input
         multiN = JOptionPane.showInputDialog
            ("Enter what range of numbers you would like to see the frequency for"
                    + "\nExample: 10-20"
                    + "\nIf You Would Like to Skip/End Type -1");
         //runs if sentinel value isnt entered
         if (!(multiN.equals(SENTINELSTRING))){
             tokens = multiN.split(delim); //splits string
             n1 = Integer.parseInt(tokens[0]);  //assigns first value
             n2 = Integer.parseInt(tokens[1]); //assigns second value
             for (int i = n1; i < n2; i++){ //prints frequency of each number in range
                 //prints requencyy of indexed number
                 System.out.println("The Frequency of " + i + 
                     " is: " + Fr[i - OFFSET1v0]);
             } //end of for loop
            
         }//end of multiple number if
     }//end of while loop
         
        // ******** closing message *********
        
        System.out.println("end of processing.");
        fout.format("%n%nend of processing.");
        
        // ***** close streams *****
        
        //fin.close();			// close input buffer
        fout.close();			// close output buffer
    }  // end main
}  // end class
