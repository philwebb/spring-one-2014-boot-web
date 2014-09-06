package springone;

import org.apache.catalina.Context;
import org.apache.catalina.Valve;
import org.apache.catalina.valves.RemoteIpValve;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.stereotype.Component;

@Component
public class RemoteValveCustomizer implements TomcatContextCustomizer {

	@Override
	public void customize(Context context) {
		for (Valve valve : context.getPipeline().getValves()) {
			if (valve instanceof RemoteIpValve) {
				((RemoteIpValve) valve).setInternalProxies(null);
			}
		}
	}

}
