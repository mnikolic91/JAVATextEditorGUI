package com.gui_app_txt_edit;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextPanel extends JPanel {

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private UndoManager undoManager;

    public TextPanel() {
        initComponent();
        layoutComponent();
        activatePopupMenu();
    }

    private void initComponent() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        undoManager = new UndoManager();
        textArea.setPreferredSize(new Dimension(680, 560));
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Monospace", Font.PLAIN, 14));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setUndoManager(undoManager);
    }

    private void layoutComponent() {
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public Element getTextArea() {
        return textArea.getDocument().getDefaultRootElement();
    }

    public int getSelectionStart() {
        return textArea.getSelectionStart();
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String data) {
        textArea.setText(data);
    }

    public String getSelectedText() {
        return textArea.getSelectedText();
    }

    public void deleteSelectedText() {
        textArea.replaceSelection("");
    }

    public void insertTextAtCaretPosition(String text) {
        textArea.insert(text, textArea.getCaretPosition());
    }

    public void selectAllText() {
        textArea.selectAll();
    }

    public void deselectAllText() {
        textArea.select(0, 0);
    }

    public void setUndoManager(UndoManager undoManager) {
        this.undoManager = undoManager;
        textArea.getDocument().addUndoableEditListener(undoManager);
    }

    public UndoableEdit getUndoManager() {
        return undoManager;
    }

    private void activatePopupMenu() {
        textArea.setComponentPopupMenu(new PopUpMenu(this));
    }

}