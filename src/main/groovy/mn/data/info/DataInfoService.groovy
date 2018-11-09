package mn.data.info

import joms.oms.DataInfo

import javax.inject.Singleton

@Singleton
class DataInfoService
{
	String getInfo( String filename )
	{
		return DataInfo.readInfo( filename )
	}
}