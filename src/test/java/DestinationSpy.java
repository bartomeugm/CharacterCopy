import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Supplier;

public class DestinationSpy implements IDestination {

    private int calledNTimes;
    private ArrayList<Supplier<Character>> lambdas;
    private ArrayList<Character> characters;

    public DestinationSpy(ArrayList<Supplier<Character>> lambdas) {
        this.calledNTimes = 0;
        this.lambdas = lambdas;
        this.characters = new ArrayList<>();
    }

    @Override
    public void setChar(char character) {
        characters.add(lambdas.get(calledNTimes++).get());
    }

    public Boolean verifySetCharCalledNTimes(int i) {
        return calledNTimes == i;
    }

    public Boolean verifyOrder(String expectedString) {
        String actualString = "";
        Iterator it = characters.iterator();
        while (it.hasNext()) actualString += it.next();
        return expectedString.equals(actualString);
    }
}
