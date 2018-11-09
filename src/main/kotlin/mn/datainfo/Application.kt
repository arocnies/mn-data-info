package mn.datainfo

import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.Micronaut
import joms.oms.Init

object Application : ApplicationEventListener<StartupEvent> {
    override fun onApplicationEvent(event: StartupEvent?) {
        Init.instance().initialize()
    }
}

fun main(args: Array<String>) {
    Micronaut.run(Application::class.java)
}