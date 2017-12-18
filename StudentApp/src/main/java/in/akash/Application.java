package in.akash;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.wicketstuff.javaee.injection.JavaEEComponentInjector;

public class Application extends WebApplication {
		
	@Override
	public Class<? extends Page> getHomePage() {
		return RegisterStudent.class;
	}

	@Override
	public void init() {
		super.init();
		getComponentInstantiationListeners().add(new JavaEEComponentInjector(this));
	}

}
