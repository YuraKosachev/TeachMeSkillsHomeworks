package Homework_lesson11;

public class HomeWorkLesson11 {
    public static void main(String[] args) {
        int stringCount = 3;
        String[] source = getStrings(stringCount, "Enter string");

        //Task1
        task1Run(source);

        //Task2
        task2Run(source);

        //Task3
        task3Run(source);

        //Task4
        task4Run(source);

        //Task5
        task5Run();

        //Task *
        checkPalindrome();
    }

    private static void checkPalindrome() {
        String text = Input.in("Enter words to palindrome check:");
        int wordNumber = Input.inToInt("Enter number of word to check");

        Palindrome palindrome = new Palindrome(text);
        try {
            String result = palindrome.isPalindrome(wordNumber)
                    ? "Yes word is palindrome"
                    : "No, the choosen word isn't palindrome";

            Input.out(result, true);
        } catch (Exception ex) {
            Input.out(ex.getMessage(), true);
        }
    }


    private static void task1Run(String[] source) {
        String result = StringOperation.getMaxMinInfo(source);
        Input.out(result, true);
    }

    private static void task2Run(String[] source) {
        String[] strings = StringOperation.sortByLength(source);
        Input.out(String.join("\n", strings), true);
    }

    private static void task3Run(String[] source) {
        String result = StringOperation.lessAvg(source);
        Input.out(result, true);
    }

    private static void task4Run(String[] source) {
        String result = StringOperation.getDifferentWord(source);
        if (result == null)
            result = "Word with different char not found";
        Input.out(result, true);
    }

    private static void task5Run() {
        String text = Input.in("Enter word to set char dublicate");
        Input.out(StringOperation.doubleChar(text), true);
    }

    private static String[] getStrings(int count, String message) {
        String[] inStrings = new String[count];
        for (int i = 0; i < inStrings.length; i++)
            inStrings[i] = Input.in(message + " " + i);

        return inStrings;
    }
}
