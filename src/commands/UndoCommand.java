package commands;

import com.gui_app_txt_edit.TextPanel;

public class UndoCommand implements Command {
    private TextPanel textPanel;

    public UndoCommand(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void runCommand() {
        if (textPanel.getUndoManager().canUndo()) {
            textPanel.getUndoManager().undo();
        }
    }

    @Override
    public void undoCommand() {
    }
}
