package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

import com.stc.base.Base;

public class Hooks extends Base {
    public Hooks() throws IOException {
    }

    @Before
    public void runsBeforeAnyScenario(){
        launchBrowser();

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
