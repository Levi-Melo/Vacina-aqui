public class Teste {

    private static int[] ad(){
        int[] vacinForAgeRange = new int[10];
        for (int i=0;i<10;i++){
            vacinForAgeRange[i] = i;
        }
        return vacinForAgeRange;
    }
    public static void main(String[] args) {
        int[] intArray = ad();
        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }

    }
}