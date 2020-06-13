package Day4_04192020;

public class split_command {

    public static void main(String[] args) {


        //create a string message first and store it as a single string variable
        String message = "Welcome to_Selenium Automation class";


        //i want to only print the keyword 'Selenium' from my message variable
        //we need to define String array variable in order to split the message
        String[] arrayResult = message.split(" ");
        //print the result
        //System.out.println("My final message is " + arrayResult[1]);

        String[] array2 = arrayResult[1].split("_");
        System.out.println("My new message is " + array2[1]);

        //you want to print out to & class
        System.out.println("My first keyword is " + array2[0] + " my second keyword is " + arrayResult[3]);



    }//end of main method

}//end of java class
