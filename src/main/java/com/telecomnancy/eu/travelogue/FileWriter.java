package com.telecomnancy.eu.travelogue;

import java.io.*;

public class FileWriter {
    public static void copyFile(File file) {
        File newFile = new File("resources/pictures/" + file.getName());
        if (newFile.exists()) {
            return;
        }
        try (FileInputStream is = new FileInputStream(file); FileOutputStream os = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
