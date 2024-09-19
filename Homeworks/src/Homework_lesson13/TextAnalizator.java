package Homework_lesson13;

import java.io.*;
import java.nio.file.Path;

public class TextAnalizator {
    private final Operation operation;

    public TextAnalizator(Operation operation) {
        this.operation = operation;
    }

    public void saveMaxLenghtWord(String srcPath, String saveDirectoryPath) throws Exception {

        File inputFile = new File(srcPath);
        File saveDirectory = new File(saveDirectoryPath);
        if (!inputFile.isFile() || !inputFile.canRead() || !saveDirectory.isDirectory())
            throw new Exception("Is not a file | file can't read | saveDirectoryPath is't directory");

        String text = readFile(inputFile);
        SaveData[] toSave = this.operation.execute(text);

        if (toSave == null || toSave.length == 0)
            return;

        for (SaveData save : toSave) {
            if (save.getData() == null)
                continue;
            writeFileToDirectory(save.getData(), saveDirectory, save.getName());
        }
    }


    private String readFile(File file) throws IOException {
        try (FileInputStream stream = new FileInputStream(file)) {
            return getText(stream.readAllBytes());
        }
    }

    private void writeFileToDirectory(String text, File directory, String fileName) throws IOException {
        File file = Path.of(directory.getPath(), fileName).toFile();
        if (!file.exists())
            file.createNewFile();
        try (FileOutputStream stream = new FileOutputStream(file, false)) {
            stream.write(getBytes(text));
        }

    }


    private String getText(byte[] bytes) {
        return new String(bytes);
    }

    private byte[] getBytes(String src) {
        return src.getBytes();
    }
}
