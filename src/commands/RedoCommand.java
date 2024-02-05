package commands;

import com.gui_app_txt_edit.TextPanel;

public class RedoCommand implements Command {
    private TextPanel textPanel;

    public RedoCommand(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void runCommand() {
        if (textPanel.getUndoManager().canRedo()) {
            textPanel.getUndoManager().redo();
        }
    }

    @Override
    public void undoCommand() {
    }
}
