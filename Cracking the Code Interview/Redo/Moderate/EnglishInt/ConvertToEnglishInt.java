package Redo.Moderate.EnglishInt;

import java.util.LinkedList;

public class ConvertToEnglishInt {
    String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven"
                        , "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] ten = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] bigs = {"", "Thousand", "Million", "Billion"};
    String hundred = "Hundred";
    String negative = "Negative";

    private String convert(int num) {
        if (num == 0) return smalls[0];
        else if (num < 0) return negative + " " + convert(-1 * num);

        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }

            num /= 1000;
            chunkCount++;
        }

        return listToString(parts);
    }

    private String convertChunk(int num) {
        LinkedList<String> parts = new LinkedList<>();

        if (num >= 100) {
            parts.addLast(smalls[num / 100]);
            parts.addLast(hundred);
            num %= 100;
        }

        if (num >= 10 && num <= 19) {
            parts.addLast(smalls[num]);
        } else if (num >= 20) {
            parts.addLast(ten[num / 10]);
            num %= 10;
        }

        if (num >= 1 && num < 10) {
            parts.addLast(smalls[num]);
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
