package mn.data.info

import groovy.transform.CompileStatic
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.Micronaut
import joms.oms.Init

@CompileStatic
class Application implements ApplicationEventListener<StartupEvent>
{
	@Override
	void onApplicationEvent( StartupEvent event )
	{
		Init.instance().initialize()
	}
	
	static void main( String[] args )
	{
		Micronaut.run( Application )
	}
}