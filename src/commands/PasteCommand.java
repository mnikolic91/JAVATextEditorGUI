package commands;

import com.gui_app_txt_edit.TextPanel;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class PasteCommand implements Command {

    private final TextPanel textPanel;

    public PasteCommand(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void runCommand() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable contents = clipboard.getContents(null);
            if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String text = (String) contents.getTransferData(DataFlavor.stringFlavor);
                textPanel.insertTextAtCaretPosition(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void undoCommand() {
    }
}
