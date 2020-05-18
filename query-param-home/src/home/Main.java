package home;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU");
		EntityManager em = emf.createEntityManager();

		
		Employee e1 = new Employee("THAW", 21, 200000, "STAFF");
		Employee e2 = new Employee("HTUN", 44, 300000, "HR");
		Employee e3 = new Employee("AUNG", 22, 500000, "HR");
		Employee e4 = new Employee("DAVE", 22, 500000, "HR");
		Employee e5 = new Employee("JOHN", 22, 500000, "HR");
		
		
		
		
		em.getTransaction().begin();
		
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.persist(e5);

		
		
		em.getTransaction().commit();
		
		
//		TypedQuery<Employee> query= em.createQuery(
//				"select e from Employee e where e.department='HR'",Employee.class);
//		
//		
//		List<Employee> emplist = query.getResultList();
//	
		
		em.createQuery(
				"select e from Employee e where e.department = 'HR'",
				Employee.class
				).getResultList()
					.forEach(e ->{
					System.out.println("NAME: " +e.getName());
					System.out.println("DEPAR: "+e.getDepartment());
					System.out.println();
				});
		
		
		
		em.close();
		emf.close();
		
		util.JPAUtil.checkData("select * from employee");
		
		
	}

}
