import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

public class CopierShould {

    @Test
    void call_getChar_same_times_as_setChar() {
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
