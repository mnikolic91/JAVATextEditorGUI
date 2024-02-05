package com.strategies;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ImplementLoadStrategy implements LoadStrategy {
    @Override
    public String load(File file) {
        try {
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}