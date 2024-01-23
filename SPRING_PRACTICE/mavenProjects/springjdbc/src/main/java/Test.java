import dao.EmployeeDao;
import model.Employee;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        System.out.println("hello before");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
       /* Resource resource=new ClassPathResource("config.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        Student st=(Student)factory.getBean("studentbean");
        st.displayInfo();*/

        /*Student st=(Student) ctx.getBean("studentbean");
        st.displayInfo();*/



        EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");


        int status1=dao.saveEmployee(new Employee(101,"Amit",35000));
        System.out.println("status1=> "+status1);
        int status2=dao.saveEmployee(new Employee(102,"sonoo",40000));
        System.out.println("status2=> "+status2);
        int status3=dao.saveEmployee(new Employee(103,"raghav",35000));
        System.out.println("status3=> "+status3);
        int status4=dao.saveEmployee(new Employee(104,"ram",38000));
        System.out.println("status4=> "+status4);

         /*int status=dao.updateEmployee(new Employee(102,"Sonoo",15000));
            System.out.println(status);*/

        /*Employee e=new Employee();
        e.setId(102);
        int status=dao.deleteEmployee(e);
        System.out.println(status);*/
    }
}
