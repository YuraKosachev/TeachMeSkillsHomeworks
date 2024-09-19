package Homework_lesson13;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberDocumentOperation implements Operation {
    @Override
    public SaveData[] execute(String text) {
        if (text == null || text.trim().isEmpty())
            return null;

        List<SaveData> resultList = new ArrayList<>();
        StringBuilder correct = new StringBuilder();
        StringBuilder incorrect = new StringBuilder();

        String[] numbers = text.split("\r\n");

        for (String number : numbers) {

            number = number.trim();

            ValidationResult validationResult = validation(number);
            if (!validationResult.getValid()) {
                incorrect.append(number + " reason: " + validationResult.getReasons() + "\r\n");
                continue;
            }
            correct.append(number + "\r\n");
        }

        if (!correct.isEmpty()) {
            resultList.add(new SaveData("correct_document_numbers.txt", correct.toString()));
        }

        if (!incorrect.isEmpty()) {
            resultList.add(new SaveData("incorrect_document_numbers.txt", incorrect.toString()));
        }

        return resultList.toArray(new SaveData[resultList.size()]);
    }

    private ValidationResult validation(String number) {
        ValidationResult result = new ValidationResult();

        if (number.length() != 15) {
            result.setValid(false);
            result.setReasons("The length of the document is incorrect");
        }
        if (!(number.startsWith("docnum") || number.startsWith("contract"))) {
            result.setValid(false);
            result.setReasons("The document number does not start with contract or docnum");
        }

        if (number.length() == 15 && !number.matches("^[a-zA-Z0-9]{15}$")) {
            result.setValid(false);
            result.setReasons("The document number content is not only alphanumeric values");
        }

        return result;
    }
}
