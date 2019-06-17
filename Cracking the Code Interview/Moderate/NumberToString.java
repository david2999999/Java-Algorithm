package Moderate;

import java.util.LinkedList;

public class NumberToString {
    String[] smalls = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] bigs = {"", "Thousand", "Million", "Billion"};
    String hundred = "Hundred";
    String negative = "Negative";

    private String convert(int num) {
        if ( num == 0) return smalls[0];
        else if (num < 0) {
            return negative + " " + convert(-1 * num);
        }

        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                parts.addFirst(convertChunk(num % 1000) + " " + bigs[chunkCount]);
            }

            num /= 1000;
            chunkCount++;
        }

        return listToString(parts);

    }


    private String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<>();

        if (number >= 100) {
            parts.addLast(smalls[number / 100]);
            parts.addLast(hundred);
            number %= 100;
        }

        if (number >= 10 && number <= 19) {
            parts.addLast(smalls[number]);
        } else if (number >= 20) {
            parts.addLast(tens[number / 10]);
            number %= 10;
        }

        if (number <= 9 && number >= 1) {
            parts.addLast(smalls[number]);
        }

        return listToString(parts);
    }

    private String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();

        while (parts.size() > 1) {
            sb.append(parts.pop());
            sb.append(" ");
        }

        sb.append(parts.pop());
        return sb.toString();
    }
}
