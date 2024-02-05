package com.gui_app_txt_edit;

import com.strategies.FileOperationHandler;
import commands.*;
import decorator.*;
import listeners.MenuBarEventsListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;

public class MainFrame extends JFrame {

    private MenuBar menuBar;
    private TextPanel textPanel;
    private final PopUpMenu popUpMenu;
    private FileOperationHandler fileOperationHandler;
    private UndoManager undoManager;

    private Command copyCommand;
    private Command cutCommand;
    private Command pasteCommand;
    private Command selectAllCommand;
    private Command undoCommand;
    private Command redoCommand;

    private TextInterface plainText;
    private EncoderDecorator encoderDecorator;



    public MainFrame() {
        super("Text Editor!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 580);
        setLocationRelativeTo(null);
        setResizable(false);

        textPanel = new TextPanel();
        popUpMenu = new PopUpMenu(textPanel);
        fileOperationHandler = new FileOperationHandler(textPanel);
        undoManager = new UndoManager();
        textPanel.setUndoManager(undoManager);
        plainText = new PlainText(textPanel.getText());


        copyCommand = new CopyCommand(textPanel);
        cutCommand = new CutCommand(textPanel);
        pasteCommand = new PasteCommand(textPanel);
        selectAllCommand = new SelectAllCommand(textPanel);
        undoCommand = new UndoCommand(textPanel);
        redoCommand = new RedoCommand(textPanel);

        initComponent();
        layoutComponent();
        activateMainFrame();

        setVisible(true);
    }

    private void activateMainFrame() {
        menuBar.setMenuBarEventsListener(new MenuBarEventsListener() {
            @Override
            public void menuBarEventOccurred(String command) {
                switch (command) {
                    case "open":
                        fileOperationHandler.openFile();
                        break;
                    case "save":
                        fileOperationHandler.saveFile();
                        break;
                    case "save_as":
                        fileOperationHandler.saveFileAs();
                        break;
                    case "exit":
                        System.exit(0);
                        break;
                    case "select_all":
                        selectAllCommand.runCommand();
                        break;
                    case "copy":
                        copyCommand.runCommand();
                        break;
                    case "paste":
                        pasteCommand.runCommand();
                        break;
                    case "cut":
                        cutCommand.runCommand();
                        break;
                    case "undo":
                        undoCommand.runCommand();
                        break;
                    case "redo":
                        redoCommand.runCommand();
                        break;
                    case "fst_encoding":
                        encoderDecorator = new FST_ENCODING(plainText);
                        encoderDecorator.setText(textPanel.getText());
                        encoderDecorator.encode();
                        textPanel.setText(encoderDecorator.getText());
                        break;
                    case "snd_encoding":
                        encoderDecorator = new SND_ENCODING(plainText);
                        encoderDecorator.setText(textPanel.getText());
                        encoderDecorator.encode();
                        textPanel.setText(encoderDecorator.getText());
                        break;
                }
            }
        });
    }


    private void layoutComponent() {
        setJMenuBar(menuBar);
        add(textPanel, BorderLayout.CENTER);
    }

    private void initComponent() {
        menuBar = new MenuBar();
    }
}
