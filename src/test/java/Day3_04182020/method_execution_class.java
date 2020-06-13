package Day3_04182020;

public class method_execution_class {


    public static void main(String[] args) {

        //call the method to be executed
        custom_methods.voidAdd(100,200);

        //call the return add method
        int myNewRult = custom_methods.returnAdd(200,300);
        //add the value with the result below
        System.out.println("new result is " + (myNewRult-25));

    }//end of main

}//end of java class
