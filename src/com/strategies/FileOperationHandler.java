package com.strategies;

import com.gui_app_txt_edit.TextPanel;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperationHandler {

    private TextPanel textPanel;
    private File currentFile;

    public FileOperationHandler(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    public void saveFile() {
        if (currentFile == null) {
            String userHome = System.getProperty("user.home");
            if (userHome == null) {
                System.err.println("Error: Unable to access the user's home directory.");
                return;
            }

            Path documentsPath = Paths.get(userHome, "Documents");

            if (!Files.exists(documentsPath)) {
                System.err.println("Error: The Documents directory does not exist.");
                return;
            }

            File file = new File(documentsPath.toFile(), "untitled.txt");
            int count = 0;
            while (file.exists()) {
                count++;
                file = new File(documentsPath.toFile(), "untitled_" + count + ".txt");
            }
            currentFile = file;
        }

        SaveStrategy saveStrategy = new ImplementSaveStrategy();
        saveStrategy.save(currentFile, textPanel.getText());
    }


    public void saveFileAs() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            saveFile();
        }
    }

    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            LoadStrategy loadStrategy = new ImplementLoadStrategy();
            String data = loadStrategy.load(fileToLoad);
            textPanel.setText(data);
        }
    }

}
