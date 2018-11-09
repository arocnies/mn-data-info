package mn.datainfo

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import java.util.*

@Controller("/dataInfo")
class DataInfoController(private val dataInfoService: DataInfoService) {

    @Get("/")
    fun index(): String = "Hello World ${Date()}"

    @Get("/getInfo")
    fun getInfo(@QueryValue filename: String): HttpResponse<String> {
        val info = dataInfoService.getInfo(filename)
        return HttpResponse.ok(info).contentType(MediaType.TEXT_XML).contentLength(info.length.toLong())
    }
}