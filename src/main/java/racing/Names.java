package racing;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Names {

    List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public Names(String[] names) {
        this.names = createNameList(names);
    }

    private List<Name> createNameList(String[] stringNames) {
        List<Name> names = new LinkedList<>();
        for (String name : stringNames) {
            names.add(new Name(name));
        }
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

}
