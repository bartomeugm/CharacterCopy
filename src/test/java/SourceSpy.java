import java.util.ArrayList;
import java.util.function.Supplier;

public class SourceSpy implements ISource {
    ArrayList<Supplier<Character>> lambdas;
    private Integer calledNTimes;

    public SourceSpy(ArrayList<Supplier<Character>> lambdas) {
        this.lambdas = lambdas;
        this.calledNTimes = 0;
    }

    public Boolean verifyGetCharCalledNTimes(Integer n) {
        return calledNTimes == n;
    }

    @Override
    public char getChar() {
        return lambdas.get(calledNTimes++).get();
    }
}
