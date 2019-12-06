package diego.checker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VersionCheckerTddTest {

    public VersionChecker versionChecker = new VersionChecker();

    @Test
    public void check_FirstSmaller_ReturnAfter() {
        String v1 = "1.0";
        String v2 = "2.0";

        String result = versionChecker.check(v1, v2);

        assertEquals("after", result);
    }

    @Test
    public void check_FirstGreater_ReturnBefore() {
        String v1 = "3.0";
        String v2 = "2.0";

        String result = versionChecker.check(v1, v2);

        assertEquals("before", result);
    }

    @Test
    public void check_Equals_ReturnEquals() {
        String v1 = "2.0";
        String v2 = "2.0";

        String result = versionChecker.check(v1, v2);

        assertEquals("equal", result);
    }

    @Test
    public void check_FirstSmallerTwoDigits_ReturnAfter() {
        String v1 = "9.0";
        String v2 = "12.0";

        String result = versionChecker.check(v1, v2);

        assertEquals("after", result);
    }

    @Test
    public void check_FirstGreaterAndLonger_ReturnBefore() {
        String v1 = "1.0.1";
        String v2 = "1.0";

        String result = versionChecker.check(v1, v2);

        assertEquals("before", result);
    }

    @Test
    public void check_FirstGreaterAndShorter_ReturnBefore() {
        String v1 = "1.1";
        String v2 = "1.0.1";

        String result = versionChecker.check(v1, v2);

        assertEquals("before", result);
    }

    @Test
    public void check_EqualsButDifferentSize_ReturnEqual() {
        String v1 = "1.0.0";
        String v2 = "1.0";

        String result = versionChecker.check(v1, v2);

        assertEquals("equal", result);
    }
}
