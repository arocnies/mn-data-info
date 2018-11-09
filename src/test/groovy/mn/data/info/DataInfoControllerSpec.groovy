package mn.data.info

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class DataInfoControllerSpec extends Specification
{
	
	@Shared
	@AutoCleanup
	EmbeddedServer embeddedServer = ApplicationContext.run( EmbeddedServer )
	@Shared
	@AutoCleanup
	RxHttpClient client = embeddedServer.applicationContext.createBean( RxHttpClient, embeddedServer.getURL() )
	
	
	void "test getInfo"()
	{
		given:
		String filename = '/data/celtic/staged/004/03MAR22074047-M2AS_R2C2-000000042261_01_P001.NTF'
		String response = client.retrieve( "/dataInfo/getInfo?filename=${ filename }" ).blockingFirst()
		
		println response
		
		def f = new XmlSlurper().parseText( response ).dataSets.RasterDataSet.fileObjects.RasterFile.name.text()
		
		expect:
		f == filename
		
	}
}
