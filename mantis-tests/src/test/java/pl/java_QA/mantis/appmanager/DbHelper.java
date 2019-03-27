package pl.java_QA.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.java_QA.mantis.model.UserData;
import pl.java_QA.mantis.model.Users;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(ApplicationManager applicationManager)
  {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();

    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

  }
  public Users users ()
  {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from UserData").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }
}
