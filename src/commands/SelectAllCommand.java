package commands;

import com.gui_app_txt_edit.TextPanel;

public class SelectAllCommand implements Command {

    private final TextPanel textPanel;

    public SelectAllCommand(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void runCommand() {
        textPanel.selectAllText();
    }

    @Override
    public void undoCommand() {
        textPanel.deselectAllText();
    }
}
