public class arabicToRoman {
    public String intToRoman(int num) {
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symb = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stingB = new StringBuilder();
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                num -= val[i];
                stingB.append(symb[i]);
            }
        }
        return stingB.toString();
    }

    public static void main(String[] args) {
        arabicToRoman translation = new arabicToRoman();

        int input1 = 1994;
        String output1 = translation.intToRoman(input1);
        System.out.println("Input " + input1 + ", Output: " + output1);

    }

}
