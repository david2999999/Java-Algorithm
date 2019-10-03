package Moderate;

import java.util.LinkedList;

// given any integer, print an englush phrase that desiscribe the integer
// for example: one thousand, four hundred twenty three
public class EnglishInt {
    // we need to convert an integer into chunks of 3 digits
    // for example if we have 19,323,984
    // it will be convert(19) + " million " + convert(323) + " thousand " + convert(984)

    String[] smalls = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    String[] bigs = {
            "", "Thousand", "Million", "Billion"
    };

    String hundred = "Hundred";
    String negative = "Negative";

    public String convert(int num) {
        if (num == 0) {
            return smalls[0];   // return "Zero"
        } else if (num < 0) {
            // append negative to the front of the string and convert the positive value
            return negative + " " + convert(-1 * num);
        }

        LinkedList<String> parts = new LinkedList<>();  // list to keep hold of all the strings
        int chunkCount = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                // convert the lowest place first
                // for example, -> 13,992,123,152. The 152 will be converted first
                String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);  // adding the chunk to the beginning of the list
            }

            // shift the chunk
            num /= 1000; // for example 13,992,123,152 -> 13,992,123
            chunkCount++;   // incrementing the chunkCount
        }

        return listToString(parts); // complete the conversion to string
    }

    // convert numbers that are less than 1000
    private String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<>();  // contains all of the parts of the string

        // if the number is greater than 100.
        // for example, if the number is 923
        if (number >= 100) {
            parts.addLast(smalls[number / 100]); // add "Nine" to the last place
            parts.addLast(hundred); // add "Hundred" to the last place
            number %= 100;  // number = number % 100.   The remainder after dividing by 100, number is now 23
        }

        // if currently, the number is 23
        if (number >= 10 && number <= 19) {
            parts.addLast(smalls[number]);
        } else if (number >= 20) {  // this part will execute
            parts.addLast(tens[number / 10]);   // add "Two" to the end of the list
            number %= 10;   // number = number % 10.    23 % 10 = 3, number is now 3
        }

        // add the last ones place value
        if (number >= 1 && number <= 9) {
            parts.addLast(smalls[number]);
        }

        // converting the list to a string
        return listToString(parts);
    }

    private String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();

        // while there are still elements in the list
        while (parts.size() > 1) {
            sb.append(parts.pop()); // add each part of the linkedlist
            sb.append(" ");
        }

        sb.append(parts.pop());
        return sb.toString();
    }
}















