package com.strategies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImplementSaveStrategy implements SaveStrategy {
    @Override
    public void save(File file, String content) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
