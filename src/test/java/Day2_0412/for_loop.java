package Day2_0412;

public class for_loop {


    public static void main(String[] args) {

        String[] states = new String[5];
        states[0] = "New York";
        states[1] = "California";
        states[2] = "Ohio";
        states[3] = "Arizona";
        states[4] = "Nevada";


        //print all the states from 0 to last value in sequence
        //i++ each time is adding +1 to i
        //i represents your initial/starting point of your index
        for(int i = 0; i < states.length; i++){
            System.out.println("My state is " + states[i]);
        }//end of for loop



    }//end of main method



}//end of java class
