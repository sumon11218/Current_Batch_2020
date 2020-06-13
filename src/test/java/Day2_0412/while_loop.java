package Day2_0412;

public class while_loop {


    public static void main(String[] args) {

        String[] states = new String[5];
        states[0] = "New York";
        states[1] = "California";
        states[2] = "Ohio";
        states[3] = "Arizona";
        states[4] = "Nevada";

        //while loop is more of broken down into statements
        //if the argument is true/false then perform some action
        int i = 0;
        while(i < states.length){
            //print all value for states
            System.out.println("My state is " + states[i]);

            i = i + 1;//incrementation and you put this at the end of your statements
        }//end of while loop


    }//end of main method





}//end of java class
