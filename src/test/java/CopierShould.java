import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CopierShould {

    @Test
    void call_getChar_same_times_as_setChar() {
        ArrayList<Supplier<Character>> sourceLambdas = new ArrayList<>();
        sourceLambdas.add(() -> 'a');
        sourceLambdas.add(() -> 'b');
        sourceLambdas.add(() -> '\n');
        SourceStub source = new SourceStub(sourceLambdas);

        ArrayList<Supplier<Character>> destinationLambdas = new ArrayList<>();
        destinationLambdas.add(() -> 'a');
        destinationLambdas.add(() -> 'b');
        destinationLambdas.add(() -> '\n');
        DestinationSpy destination = new DestinationSpy(destinationLambdas);

        Copier copier = new Copier(source, destination);

        copier.copy();

        assertTrue(destination.verifySetCharCalledNTimes(3));
        assertTrue(destination.verifyOrder("ab\n"));
    }
}
