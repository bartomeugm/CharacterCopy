import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

public class CopierShould {

    @Test
    void copy_the_characters() {
        ISource source = Mockito.mock(ISource.class);
        IDestination destination = Mockito.mock(IDestination.class);
        when(source.getChar()).thenReturn('a', 'b', '\n');

        Copier copier = new Copier(source, destination);
        copier.copy();

        InOrder order = inOrder(destination);
        order.verify(destination).setChar('a');
        order.verify(destination).setChar('b');
        order.verify(destination).setChar('\n');
    }
}
