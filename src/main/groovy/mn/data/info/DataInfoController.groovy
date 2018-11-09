package mn.data.info

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.reactivex.Single

import javax.inject.Inject

@Controller( "/dataInfo" )
class DataInfoController
{
	
	@Inject
	DataInfoService dataInfoService
	
	@Get( "/getInfo" )
	Single<HttpResponse<String>> getInfo( @QueryValue String filename )
	{
		String info = dataInfoService.getInfo( filename )
		
		return Single.just( HttpResponse.ok( info ).contentType( MediaType.TEXT_XML ).contentLength( info.size() ) )
	}
}