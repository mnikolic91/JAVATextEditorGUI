package com.gui_app_txt_edit;


import listeners.MenuBarEventsListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {

    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu encoding;

    private JMenuItem openFile;
    private JMenuItem saveAsFile;
    private JMenuItem exit;
    private JMenuItem selectAll;
    private JMenuItem copyItem;
    private JMenuItem pasteItem;
    private JMenuItem undoItem;
    private JMenuItem redoItem;
    private JMenuItem saveFile;
    private JMenuItem cutItem;
    private JMenuItem fstEncoding;
    private JMenuItem sndEncoding;

    private MenuBarEventsListener menuBarEventsListener;

    public MenuBar() {
        initComponent();
        layoutComponent();
        activateMenu();
    }

    private void activateMenu() {

        openFile.addActionListener(this);
        saveAsFile.addActionListener(this);
        exit.addActionListener(this);
        selectAll.addActionListener(this);
        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);
        undoItem.addActionListener(this);
        redoItem.addActionListener(this);
        fstEncoding.addActionListener(this);
        sndEncoding.addActionListener(this);
        saveFile.addActionListener(this);
        cutItem.addActionListener(this);




    }

    public void setMenuBarEventsListener(MenuBarEventsListener menuBarEventsListener) {
        this.menuBarEventsListener = menuBarEventsListener;
    }

    private void initComponent() {

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        encoding = new JMenu("Encoding");


        saveFile = new JMenuItem("Save");
        saveAsFile = new JMenuItem("Save as...");
        openFile = new JMenuItem("Open");
        exit = new JMenuItem("Exit");
        selectAll = new JMenuItem("Select all");
        copyItem = new JMenuItem("Copy");
        cutItem = new JMenuItem("Cut");
        pasteItem = new JMenuItem("Paste");
        undoItem = new JMenuItem("Undo");
        redoItem = new JMenuItem("Redo");
        fstEncoding = new JMenuItem("FST-ENCODING");
        sndEncoding = new JMenuItem("SND-ENCODING");


        openFile.setActionCommand("open");
        saveFile.setActionCommand("save");
        saveAsFile.setActionCommand("save_as");
        exit.setActionCommand("exit");
        selectAll.setActionCommand("select_all");
        copyItem.setActionCommand("copy");
        cutItem.setActionCommand("cut");
        pasteItem.setActionCommand("paste");
        undoItem.setActionCommand("undo");
        redoItem.setActionCommand("redo");
        fstEncoding.setActionCommand("fst_encoding");
        sndEncoding.setActionCommand("snd_encoding");

        openFile.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        saveFile.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        saveAsFile.setAccelerator(KeyStroke.getKeyStroke("ctrl shift S"));
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
        selectAll.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
        copyItem.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
        cutItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        pasteItem.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));
        undoItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
        redoItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Y"));
        fstEncoding.setAccelerator(KeyStroke.getKeyStroke("ctrl 1"));
        sndEncoding.setAccelerator(KeyStroke.getKeyStroke("ctrl 2"));

    }

    private void layoutComponent() {

        add(fileMenu);
        add(editMenu);
        add(encoding);

        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        editMenu.add(undoItem);
        editMenu.add(redoItem);
        editMenu.addSeparator();
        editMenu.add(selectAll);
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        encoding.add(fstEncoding);
        encoding.add(sndEncoding);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (menuBarEventsListener != null) {
            String command = ae.getActionCommand();
            menuBarEventsListener.menuBarEventOccurred(command);
        }
    }
}
