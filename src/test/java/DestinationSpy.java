import java.util.ArrayList;
import java.util.function.Consumer;

public class DestinationSpy implements IDestination {

    private int calledNTimes;
    private ArrayList<Consumer<Character>> lambdas;

    public DestinationSpy(ArrayList<Consumer<Character>> lambdas) {
        this.calledNTimes = 0;
        this.lambdas = lambdas;
    }

    @Override
    public void setChar(char character) {
        lambdas.get(calledNTimes++).accept(character);
    }

    public Boolean verifySetCharCalledNTimes(int i) {
        return calledNTimes == i;
    }
}
