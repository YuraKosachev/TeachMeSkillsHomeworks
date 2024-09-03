package Homework_lesson11;

public class Palindrome {
    private final String[] words;

    public Palindrome(String source) {
        this.words = this.cleanAndSplitString(source);
    }
    private String[] cleanAndSplitString(String source){
        StringBuilder builder = new StringBuilder();
        boolean hasWhiteSpace = false;
        char[] chars = source.trim().toCharArray();
        for(int i = 0; i < chars.length; i++){

            if(Character.isWhitespace(chars[i]) && hasWhiteSpace){
                continue;
            }
            hasWhiteSpace = Character.isWhitespace(chars[i]);
            builder.append(chars[i]);
        }

        return builder.toString().split(" ");
    }
    public boolean isPalindrome(int wordNumber) throws Exception {
        int index = wordNumber - 1;
        if(wordNumber > this.words.length  || wordNumber < 1)
            throw new Exception("Word with number "+ wordNumber+ " not found!");

        char[] chars = this.words[index].toLowerCase().toCharArray();
        for(int i = 0, j = chars.length - 1; i < j; i++, j--){
            if(chars[i] != chars[j])
                return false;
        }
        return true;
    }


}
