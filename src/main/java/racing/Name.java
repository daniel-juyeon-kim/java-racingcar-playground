package racing;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        isValid(name);
        this.name = name;
    }

    private void isValid(String name) {
        boolean condition = 0 < name.length() && name.length() <= 5;
        if (condition) {
            throw new IllegalArgumentException("자동차의 이름은 0에서 5자리 이내의 문자여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
