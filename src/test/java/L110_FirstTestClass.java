import org.testng.Assert;
import org.testng.annotations.Test;

public class L110_FirstTestClass {


    // method under testing
    public static boolean isPhone(String text) {
        String regex = "(?:\\+38)? ?(?:0\\d{2}|\\(0\\d{2}\\)) ?\\d{2}(?:\\d{3}|\\d[- ]\\d{2}[- ]|[ -]\\d{2}[ -]\\d)\\d{2}";
        return text.matches(regex);
    }

    // TC01
    @Test
    public static void test1_isPhone() {

        // Test data
        String testData = "0975156900";

        boolean result = isPhone(testData);
        // Expected result
        Assert.assertTrue(result, "TC01. Result: failed ");

    }


    // testcase 2
    @Test
    public static void test2_isPhone() {

        String testData = "asdaddasds";

        boolean result = isPhone(testData);

        Assert.assertFalse(result, "Test 2 failed result");
    }

    // testcase 3
    @Test
    public static void test3_isPhone() {

        String testData = "";

        boolean result = isPhone(testData);

        Assert.assertFalse(result, "Test 3 failed result");

    }

    // testcase 4
    @Test
    public static void test4_isPhone() {

        String testData = "<!№%:,,..;,.;()";

        boolean result = isPhone(testData);

        Assert.assertFalse(result, "Test 4 failed result");

    }

    @Test //
    public static void test5_isPhone() {

        String testData = "1";

        boolean result = isPhone(testData);

        Assert.assertFalse(result, "Test 5 failed result");

    }

    @Test
    public static void test6_isPhone() {

        String testData = "<999999999999999999999999999";

        boolean result = isPhone(testData);

        Assert.assertFalse(result, "Test 6 failed result");

    }

    @Test
    public static void test7_isPhone() {

        String testData = "(097)5156900";

        boolean result = isPhone(testData);

        Assert.assertTrue(result, "Test 7 failed result");

    }

    @Test
    public static void test8_isPhone() {

        String testData = "+38(097)5156900";

        boolean result = isPhone(testData);

        Assert.assertTrue(result, "Test 8 failed result");

    }




}