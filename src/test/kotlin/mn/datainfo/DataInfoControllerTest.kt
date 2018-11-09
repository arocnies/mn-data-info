package mn.datainfo

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class DataInfoControllerTest : Spek({

    val embeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
    val client = embeddedServer.applicationContext.createBean(RxHttpClient::class.java, embeddedServer.url)

    describe("/dataInfo") {
        describe("request with filename") {
            val filename = "/data/celtic/staged/004/03MAR22074047-M2AS_R2C2-000000042261_01_P001.NTF"
            val response = client.retrieve("/dataInfo/getInfo?filename=$filename")

            it("returns OK") {
                println(response)
            }
        }
    }

    afterGroup {
        client.close()
    }
})
