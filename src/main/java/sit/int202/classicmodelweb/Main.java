package sit.int202.classicmodelweb;

import at.favre.lib.crypto.bcrypt.BCrypt;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.entities.Employee;
import sit.int202.classicmodelweb.repositories.CustomerRepository;
import sit.int202.classicmodelweb.repositories.ProductRepository;

public class Main {
    public static void main(String[] args) {
        String password = "12345";

        String password2 = "123456";

        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByName("Jean King");



        String bcryptHashString = BCrypt.withDefaults().hashToString(12,
                password.toCharArray());

        customer.setPassword(bcryptHashString);
        customerRepository.update(customer);

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);

        System.out.println(result);

//        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), "xkpe0340w2ola");
//        System.out.println(result.toString());
//        System.out.println(result.validFormat);
//        System.out.println(result.verified);

//        ProductRepository prouductRepository = new ProductRepository();
//        System.out.println(prouductRepository.findAll(1, 5));
//        System.out.println("Total items: "+ prouductRepository.countAll());
//        OfficeRepository officeRepository = new OfficeRepository();
//        Office office = officeRepository.find("1");
//        office.setCity("Vientiane");
//        officeRepository.update(office);
//        officeRepository.delete("11");
//        for(Employee e : office.getEmployeeList()) {
//            System.out.println(e);
//        }
//         Office newOffice = new Office();
//         newOffice.setId("10");
//         newOffice.setCity("Hanoi");
//         newOffice.setCountry("TH");
//         newOffice.setAddressLine1(office.getAddressLine1());
//         newOffice.setAddressLine2(office.getAddressLine2());
//         newOffice.setPhone(office.getPhone());
//         newOffice.setPostalCode(office.getPostalCode());
//         newOffice.setTerritory(office.getTerritory());
//         //officeRepository.save(newOffice);
//
//        for(Office o : officeRepository.findAll()) {
//            System.out.println(o.getId() + ": " + o.getCity());
//            System.out.println("-----------------------");
//            if (o.getEmployeeList() != null) {
//                o.getEmployeeList().forEach(employee -> {
//                    printEmp(employee);
//                });
//                System.out.println("\n");
//            }
//        }
//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        System.out.println("-------------------------------------");
//        employeeRepository.findByDescription("pa").forEach(employee -> {
//            printEmp(employee);
//        });
    }
    private static void printEmp(Employee e) {
        System.out.printf("%7d %-10s %-15s %-20s %s\n", e.getId(), e.getFirstName(),
                e.getLastName(), e.getJobTitle(), e.getEmail());
    }
}
