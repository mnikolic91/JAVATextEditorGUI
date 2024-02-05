package commands;

import com.gui_app_txt_edit.TextPanel;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class CopyCommand implements Command {

    private final TextPanel textPanel;

    public CopyCommand(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void runCommand() {
        String textToCopy = textPanel.getSelectedText();
        if (textToCopy != null) {
            StringSelection selection = new StringSelection(textToCopy);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, null);
        }
    }

    @Override
    public void undoCommand() {
    }
}
