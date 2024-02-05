package commands;

import com.gui_app_txt_edit.TextPanel;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class CutCommand implements Command {

    private final TextPanel textPanel;

    public CutCommand(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void runCommand() {
        String selectedText = textPanel.getSelectedText();
        if (selectedText != null) {
            StringSelection selection = new StringSelection(selectedText);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, null);
            textPanel.deleteSelectedText();
        }
    }

    @Override
    public void undoCommand() {
    }
}
