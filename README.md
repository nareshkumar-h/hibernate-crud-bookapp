## Implement DAO methods using Hibernate


# Step 1: Create persistence.xml file ( resources/META-INF folder )
```
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
             http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
	version="2.1">

	<persistence-unit name="BOOKAPP_PU">
		<description>
            Persistence unit for BookApp
        </description>

		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

		<properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />

			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3307/book_db" />

			<property name="javax.persistence.jdbc.user" value="root" />

			<property name="javax.persistence.jdbc.password" value="root" />

			<property name="hibernate.show_sql" value="true" />

			<property name="hibernate.id.new_generator_mappings" value="false" />
		</properties>

	</persistence-unit>

</persistence>
```

# Step 2: Create HibernateUtil 
* Get EntityManagerFactory object by giving persistent unitName
```
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEntityManagerFactory() {

		String PERSISTENT_UNIT_NAME = "BOOKAPP_PU";
		emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
		return emf;
	}

	public static void close() {
		if (emf != null) {
			emf.close();
		}
	}
}
```

# Step 3: Write DAO methods using Hibernate APIs

## Insert
```
public void save(User user) {
		EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(user);
		tx.commit();
		em.close();
		HibernateUtil.close();
	}
  ```
  
  ## Update
  ```
  em.merge(user);
  ```
  
  ## Delete
  ```
  em.remove(user) (or)
  em.remove(em.contains(user) ? user : em.merge(user));
  ```
  
  ## Select Queries ( which returns multiple rows )
  ```
  List<User> userList = em.createQuery("select u from User u", User.class).getResultList();
  ```
  
  ## Select Queries ( with parameters )
  ```
  TypedQuery<User> query = em.createQuery("select u from User u where email =:email and password =:password", User.class);
	query.setParameter("email", email);
	query.setParameter("password", password);
	User user = query.getSingleResult();
  ```
  
