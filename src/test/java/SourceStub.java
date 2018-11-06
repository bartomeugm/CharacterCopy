import java.util.ArrayList;
import java.util.function.Supplier;

public class SourceStub implements ISource {
    ArrayList<Supplier<Character>> lambdas;
    private Integer calledNTimes;

    public SourceStub(ArrayList<Supplier<Character>> lambdas) {
        this.lambdas = lambdas;
        this.calledNTimes = 0;
    }

    @Override
    public char getChar() {
        return lambdas.get(calledNTimes++).get();
    }
}
