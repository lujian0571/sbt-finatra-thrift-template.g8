namespace java $organization;format="normalize"$.$name;format="normalize"$.thriftjava
#@namespace scala $organization;format="normalize"$.$name;format="normalize"$.thriftscala
namespace rb Ping

include "finatra-thrift/finatra_thrift_exceptions.thrift"

service $name;format="Camel"$Service {

	/**
	 * Respond with 'pong'
	 */
	 string ping() throws (
	 	1: finatra_thrift_exceptions.ClientError clientError,
    	2: finatra_thrift_exceptions.ServerError serverError
	 )
}
