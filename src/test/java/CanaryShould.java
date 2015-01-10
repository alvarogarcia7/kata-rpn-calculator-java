import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by alvaro on 10/01/15.
 */
public class CanaryShould {
	
	@Test
	public void work_as_a_canary() {
		assertThat(true, is(true));
	}
}
