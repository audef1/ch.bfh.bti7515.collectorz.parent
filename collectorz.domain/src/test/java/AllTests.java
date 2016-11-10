import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ch.bfh.bti7515.collectorz.gamecollector.model.*;

@RunWith(Suite.class)
@SuiteClasses({ CreateIT.class, ReadIT.class, UpdateIT.class, DeleteIT.class})
public class AllTests {

}
