package day11;

public class InAppropriateUseOfIf {
    public static void main(String[] args) {
        //when you want for all conditions to pass
        boolean condition1 = true;
        boolean condition2 = true;
        boolean condition3 = false;

        if(condition1){
            System.out.println("Success");
        }
        if(condition2){
            System.out.println("Success");
        }
        if(condition3){
            System.out.println("Success");
        } else {
            System.out.println("Failure!");
        }

        // correct
//        boolean condition1 = true;
//        boolean condition2 = true;
//        boolean condition3 = true;
//
//        if(condition1 && condition2 && condition3){
//            System.out.println("Success");
//        } else {
//            System.out.println("Failure!");
//        }


    }
}
