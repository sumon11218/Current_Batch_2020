package Day2_0412;

public class Dynamic_Array {


    public static void main(String[] args) {


        //declare String dynamic array variables
        String[] locations, countries;
        //declare integer dynamic array variables
        int[] number, houseAddress;


        //define the dynamic array with the length(size) of that variable
        countries = new String[6];
        countries[0] = "USA";
        countries[1] = "Canada";
        countries[2] = "Russia";
        countries[3] = "Bangladesh";
        countries[4] = "India";
        countries[5] = "China";

        System.out.println("my first country is " + countries[0] + " my last country is " + countries[5]);

        //define the int dynamic array
        number = new int[5];
        number[0] = 1;
        number[1] = 2;

    }//end of main method


}//end of java class
