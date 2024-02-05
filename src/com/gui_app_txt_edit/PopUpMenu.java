package com.gui_app_txt_edit;

import commands.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpMenu extends JPopupMenu implements ActionListener {

    private JMenuItem selectAll;
    private JMenuItem copyItem;
    private JMenuItem pasteItem;
    private JMenuItem deleteItem;
    private JMenuItem cutItem;
    private TextPanel textPanel;

    public PopUpMenu(TextPanel textPanel) {
        this.textPanel = textPanel;
        initComponent();
        layoutComponent();
        activateMenu();
    }

    private void initComponent() {
        selectAll = new JMenuItem("Select all");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");
        deleteItem = new JMenuItem("Delete");
        cutItem = new JMenuItem("Cut");
    }

    private void layoutComponent() {
        add(selectAll);
        add(copyItem);
        add(cutItem);
        add(pasteItem);
        add(deleteItem);
    }

    private void activateMenu() {
        selectAll.addActionListener(this);
        copyItem.addActionListener(this);
        cutItem.addActionListener(this);
        pasteItem.addActionListener(this);
        deleteItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();
        if (source == selectAll) {
            new SelectAllCommand(textPanel).runCommand();
        } else if (source == copyItem) {
            new CopyCommand(textPanel).runCommand();
        } else if (source == cutItem) {
            new CutCommand(textPanel).runCommand();
        } else if (source == pasteItem) {
            new PasteCommand(textPanel).runCommand();
        } else if (source == deleteItem) {
            new DeleteCommand(textPanel).runCommand();
        }
    }
}
