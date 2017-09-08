package pktest.data.auto;

import java.util.List;

import pktest.data.Address;
import pktest.data.Person;

import org.apache.cayenne.CayenneDataObject;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.query.Ordering;
import org.apache.cayenne.query.SelectQuery;

import org.apache.cayenne.exp.Property;

/**
 * Class _Person was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Person extends CayenneDataObject {

    public static final String ENTITY_NAME = "Person";

    public static final Property<java.lang.String> NAME = Property.create( "name", java.lang.String.class );
    public static final Property<pktest.data.Address> ADDRESSES = Property.create( "addresses", pktest.data.Address.class );
    public static final Property<pktest.data.Address> LATEST_ADDRESS = Property.create( "latestAddress", pktest.data.Address.class );

    public static final String ID_PK_COLUMN = "id";

	public static Person createPerson(ObjectContext oc
	) {
		Person result = new Person();
		oc.registerNewObject(result);
		return result;
	}
	
    public void setName(String name) {
        writeProperty("name", name);
    }
    public String name() {
        return (String)readProperty("name");
    }

    public void addToAddresses(Address obj) {
        addToManyTarget("addresses", obj, true);
    }
    public void removeFromAddresses(Address obj) {
        removeToManyTarget("addresses", obj, true);
    }
    public Address createAddressesRelationship() {
    	Address obj = getObjectContext().newObject(Address.class);
        addToManyTarget("addresses", obj, true);
        return obj;
    }
    public void deleteAddressesRelationship(Address obj) {
        removeToManyTarget("addresses", obj, true);
        getObjectContext().deleteObject(obj);
    }
    @SuppressWarnings("unchecked")
    public List<Address> addresses() {
        return (List<Address>)readProperty("addresses");
    }
    
    public List<Address> addresses(Expression expression) {
		return expression.filterObjects(addresses());
	}


    public void setLatestAddress(Address latestAddress) {
        setToOneTarget("latestAddress", latestAddress, true);
    }
    public Address createLatestAddressRelationship() {
        Address obj = getObjectContext().newObject(Address.class);
        setToOneTarget("latestAddress", obj, true);
        return obj;
    }

    public Address latestAddress() {
        return (Address)readProperty("latestAddress");
    }



	@SuppressWarnings("unchecked")
	public static java.util.List<Person> fetchAll( ObjectContext oc ) {
		SelectQuery<Person> q = new SelectQuery<>( Person.class );
  		return oc.performQuery( q );
 	}
 	
	@SuppressWarnings("unchecked")
 	public static java.util.List<Person> fetch( ObjectContext oc, Expression expression ) {
  		SelectQuery<Person> q = new SelectQuery<>( Person.class, expression );
  		return oc.performQuery( q );
 	}

	@SuppressWarnings("unchecked")
 	public static java.util.List<Person> fetch( ObjectContext oc, Expression expression, java.util.List<Ordering> orderings ) {
  		SelectQuery<Person> q = new SelectQuery<>( Person.class, expression );

  		if ( orderings != null ) {
   			for( Ordering ordering : orderings ) {
    			q.addOrdering( ordering );
   			}
  		}

  		return oc.performQuery( q );
 	}
 	
 	@SuppressWarnings("unchecked")
 	public static java.util.List<Person> fetchAll( ObjectContext oc, java.util.List<Ordering> orderings ) {
  		SelectQuery<Person> q = new SelectQuery<>( Person.class);

  		if ( orderings != null ) {
   			for( Ordering ordering : orderings ) {
    			q.addOrdering( ordering );
   			}
  		}

  		return oc.performQuery( q );
 	}
 	
 	
	public static Person fetchOne(ObjectContext oc, Expression expression) {
		java.util.List<Person> objects = fetch(oc, expression);
		Person obj;
		int count = objects.size();
		if (count == 0) {
			obj = null;
		} else if (count == 1) {
			obj = objects.get(0);
		} else {
			throw new IllegalStateException("There was more than one Person that matched the qualifier '" + expression + "'.");
		}
		return obj;
	}
}