package decorator;

import java.util.stream.Collectors;

public class SND_ENCODING extends EncoderDecorator {

    public SND_ENCODING(TextInterface textInterface) {
        super(textInterface);
    }

    @Override
    public void encode() {
        String currentText = textInterface.getText();
        String encodedText = currentText.chars()
                .mapToObj(c -> (char) c)
                .map(c -> c == ' ' ? c : (char) (c - 1))
                .map(String::valueOf)
                .collect(Collectors.joining());
        textInterface.setText(encodedText);
    }

    @Override
    public String getText() {
        return textInterface.getText();
    }

    @Override
    public void setText(String text) {
        textInterface.setText(text);
    }
}


