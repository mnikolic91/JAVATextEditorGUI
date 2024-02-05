package commands;

import com.gui_app_txt_edit.TextPanel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoManager;

public class UndoManagerSetup {
    private TextPanel textPanel;
    private UndoManager undoManager;
    private CompoundEdit compoundEdit;

    public UndoManagerSetup(TextPanel textPanel) {
        this.textPanel = textPanel;
        this.undoManager = new UndoManager();
        this.compoundEdit = new CompoundEdit();

        setupUndoManager();
    }

    private void setupUndoManager() {
        undoManager.setLimit(30);

        ((AbstractDocument) textPanel.getTextArea().getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                compoundEdit.addEdit(new AbstractUndoableEdit() {});
                super.replace(fb, offset, length, text, attrs);
                finishEditing();
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                compoundEdit.addEdit(new AbstractUndoableEdit() {});
                super.remove(fb, offset, length);
                finishEditing();
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                compoundEdit.addEdit(new AbstractUndoableEdit() {});
                super.insertString(fb, offset, string, attr);
                finishEditing();
            }

            private void finishEditing() {
                compoundEdit.end();
                undoManager.addEdit(compoundEdit);
                compoundEdit = new CompoundEdit();
            }
        });

        textPanel.setUndoManager(undoManager);
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public UndoManager getUndoManager() {
        return undoManager;
    }
}
