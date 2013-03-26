namespace java com.abhinavp.platform.thrift

include "core.thrift"

service UserService {

	core.TResult addUser(1:core.TUser user) ;

}