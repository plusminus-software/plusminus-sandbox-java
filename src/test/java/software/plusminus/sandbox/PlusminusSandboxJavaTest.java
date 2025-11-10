package software.plusminus.sandbox;

import org.junit.jupiter.api.Test;

import static software.plusminus.check.Checks.check;

class PlusminusSandboxJavaTest {

    @Test
    void add() {
        int result = new PlusminusSandboxJava().add(1, 2);
        check(result).is(3);
    }
}