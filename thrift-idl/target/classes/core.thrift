namespace java com.abhinavp.platform.thrift

enum TUserStatus {
	INACTIVE=0,
	ACTIVE=1
}


struct TUser {
    1: optional string account,
    2: optional string emailId,
    3: optional string firstName,
    4: optional string lastName,
    5: optional string password,
    6: optional bool isSuperUser,
    7: optional bool active,
    8: optional list<string> services
}

struct TResult{
	1: required TUserStatus status,
	2: optional list<string> errorList 
}