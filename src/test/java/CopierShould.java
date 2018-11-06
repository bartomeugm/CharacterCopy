import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CopierShould {

    @Test
    void copy_the_chars_in_the_same_order() {
        ArrayList<Supplier<Character>> lambdas = new ArrayList<>();
        lambdas.add(() -> 'a');
        lambdas.add(() -> 'b');
        lambdas.add(() -> '\n');
        SourceStub source = new SourceStub(lambdas);
        DestinationSpy destination = new DestinationSpy(lambdas);

        Copier copier = new Copier(source, destination);

        copier.copy();

        assertTrue(destination.verifyOrder(new char[]{'a', 'b', '\n'}));
    }
}
