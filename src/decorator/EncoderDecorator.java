package decorator;

public abstract class EncoderDecorator implements TextInterface {

        protected TextInterface textInterface;

        public EncoderDecorator(TextInterface textInterface) {
            this.textInterface = textInterface;
        }

        public abstract void encode();

}