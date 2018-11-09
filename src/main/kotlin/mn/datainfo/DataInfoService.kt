package mn.datainfo

import javax.inject.Singleton
import joms.oms.DataInfo

@Singleton
class DataInfoService {
    fun getInfo(filename: String): String = DataInfo.readInfo(filename)
}