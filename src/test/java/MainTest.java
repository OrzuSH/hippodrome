import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class MainTest {
    @Test
    @Timeout(value = 22)
    @Disabled
    void mainTest() throws Exception {
        Main.main(new String[0]);
    }
}
