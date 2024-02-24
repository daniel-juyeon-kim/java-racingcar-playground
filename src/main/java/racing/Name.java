package racing;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        isValid(name);
        this.name = name;
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

    public String getName() {
        return name;
    }

    private void isValid(String name) {
        checkName(name);
    }

    private void checkName(String name) {
        if (isNameLengthValid(name) == false) {
            throw new IllegalArgumentException("자동차의 이름은 1에서 5자리 이내의 문자여야 합니다.");
        }
    }

    private boolean isNameLengthValid(String name) {
        return 0 < name.length() && name.length() <= 5;
    }
}
