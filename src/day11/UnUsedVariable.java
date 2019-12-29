package day11;

public class UnUsedVariable {
    public static void main(String[] args) {
        int variable1 = 1;
        int variable2 = 2;
        int unUsedVariable = 0;
        int sum;
        sum = someKindOfMethod(variable1, variable2, unUsedVariable);
        System.out.println(sum);
        System.out.println(sum == 3 ? "Success":"Failure");
    }

    private static int someKindOfMethod(int variable1, int variable2, int unUsedVariable) {
        return  variable1 + variable2;
    }
}
