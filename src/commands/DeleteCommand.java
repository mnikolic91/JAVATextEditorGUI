package commands;

import com.gui_app_txt_edit.TextPanel;

public class DeleteCommand implements Command {
    private TextPanel textPanel;
    private String deletedText;
    private int position;

    public DeleteCommand(TextPanel textPanel) {
        this.textPanel = textPanel;
        this.position = textPanel.getSelectionStart();
        this.deletedText = textPanel.getSelectedText();
    }

    @Override
    public void runCommand() {
        textPanel.deleteSelectedText();
    }

    @Override
    public void undoCommand() {
        textPanel.insertTextAtCaretPosition(deletedText);
    }
}
