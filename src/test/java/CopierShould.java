import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CopierShould {

    @Test
    void call_getChar_same_times_as_setChar() {
        ArrayList<Supplier<Character>> sourceLambdas = new ArrayList<>();
        sourceLambdas.add(() -> 'a');
        sourceLambdas.add(() -> 'b');
        sourceLambdas.add(() -> '\n');
        SourceSpy source = new SourceSpy(sourceLambdas);

        ArrayList<Consumer<Character>> destinationLambdas = new ArrayList<>();
        destinationLambdas.add((Character inputCharacter) -> {});
        destinationLambdas.add((Character inputCharacter) -> {});
        destinationLambdas.add((Character inputCharacter) -> {});
        DestinationSpy destination = new DestinationSpy(destinationLambdas);

        Copier copier = new Copier(source, destination);

        copier.copy();

        assertTrue(source.verifyGetCharCalledNTimes(3));
        assertTrue(destination.verifySetCharCalledNTimes(3));
    }
}
