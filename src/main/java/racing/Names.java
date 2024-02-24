package racing;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Names {

    private List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public Names(String names) {
        isValid(names);
        this.names = createNameList(splitNames(names));
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

    public List<Name> getNames() {
        return names;
    }

    public String toStringify() {
        List<String> nameList = new LinkedList<>();
        for (Name name : names) {
            nameList.add(name.getName());
        }
        return String.join(",", nameList);
    }

    private String[] splitNames(String names) {
        return names.split(",");
    }

    private void isValid(String names) {
        String [] splitNames = splitNames(names);

        if (isNamesEmpty(names) || isNameAmountIsZero(splitNames)) {
            throw new IllegalArgumentException("한 개 이상의 자동차 이름을 입력하세요.");
        }
    }

    private boolean isNamesEmpty(String names) {
        return names.isEmpty();
    }

    private static boolean isNameAmountIsZero(String[] names) {
        return 0 == names.length;
    }

    private List<Name> createNameList(String[] stringNames) {
        List<Name> names = new LinkedList<>();
        for (String name : stringNames) {
            names.add(new Name(name));
        }
        return names;
    }
}
