public class Copier {
    private final IDestination destination;
    private ISource source;

    public Copier(ISource source, IDestination destination) {
        this.source = source;
        this.destination = destination;
    }

    public void copy() {
        Character currentCharacter = 0;
        while (!currentCharacter.equals('\n')) {
            currentCharacter = source.getChar();
            destination.setChar(currentCharacter);
        }
    }
}
