package pktest;

import java.util.UUID;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;

import pktest.data.Address;
import pktest.data.Person;

public class Main {

	public static void main( String[] args ) {
		ServerRuntime serverRuntime = ServerRuntime
				.builder()
				.addConfig( "cayenne-pktest.xml" )
				.jdbcDriver( "org.h2.Driver" )
				.url( "jdbc:h2:mem:" + UUID.randomUUID().toString() )
				.build();

		ObjectContext oc = serverRuntime.newContext();

		Person newPerson = oc.newObject( Person.class );
		Address newAddress = oc.newObject( Address.class );
		newPerson.addToAddresses( newAddress );
		newPerson.setLatestAddress( newAddress );

		oc.commitChanges();
	}
}