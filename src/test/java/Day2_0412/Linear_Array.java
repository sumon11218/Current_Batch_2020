package Day2_0412;

public class Linear_Array {

    public static void main(String[] args) {

        //declare the empty string array variables first
        String[] locations, countries, places;
        //declare the empty int array variables first
        int[] number, houseAddress;

        //define the String array variables
        locations = new String[]{"Sixflag","Disney","Beach"};
        countries = new String[]{"Bangladesh","USA","Canada","India"};

        //define the int array variables
        number = new int[]{1,2,3,4};
        houseAddress = new int[]{222,333,444,555};

        //print the last value from locations variable
        System.out.println("My last two locations are " + locations[1] + " and " + locations[2] + " is in array indexes " + number[0] + " " + number[1]);


    }//end of main method


}//end of java class
