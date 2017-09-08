package pktest;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;

import pktest.data.Address;
import pktest.data.Person;

public class Main {

	public static void main( String[] args ) {
		ServerRuntime serverRuntime = ServerRuntime
				.builder()
				.addConfig( "cayenne-pktest.xml" )
				.build();

		ObjectContext oc = serverRuntime.newContext();

		Person person = oc.newObject( Person.class );
		person.setName( "Hugi" );

		Address address = oc.newObject( Address.class );
		address.setName( "Hugi's Address" );
		person.addToAddresses( address );
		person.setLatestAddress( address );

		oc.commitChanges();
	}
}