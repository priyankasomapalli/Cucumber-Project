package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void init() {
		System.out.println("At the before method");
	}

	@After
	public void exit() {
		System.out.println("At the after method");
	}

}
