package Dec192022;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Codes {


    static List<Employee1> employeeList = new ArrayList<Employee1>();
    static DecimalFormat df = new DecimalFormat("###.###");

    public static void main(String[] args) {

        employeeList.add(new Employee1(111, "Jiya Brein", 32, "Female", null, 2011, 25000.0));
        employeeList.add(new Employee1(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee1(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee1(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee1(155, "Nima Roy", 27, "Female", null, 2013, 22700.0));
        employeeList.add(new Employee1(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee1(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee1(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee1(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee1(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee1(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee1(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee1(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee1(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee1(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee1(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee1(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        // Query 1 : How many male and female employees are there in the organization?
        method1();
        System.out.println("\n");
        // Query 2 : Print the name of all departments in the organization?
        method2();
        System.out.println("\n");
        // Query 3 : What is the average age of male and female employees?
        method3();
        System.out.println("\n");
        // Query 4 : Get the details of highest paid employee in the organization?
        method4();
        System.out.println("\n");
        // Query 5 : Get the names of all employees who have joined after 2015?
        method5();
        System.out.println("\n");
        // Query 6 : Count the number of employees in each department?
        method6();
        System.out.println("\n");
        // Query 7 : What is the average salary of each department?
        method7();
        System.out.println("\n");
        // Query 8 : Get the details of youngest male employee in the product
        // development department?
        method8();
        System.out.println("\n");
        // Query 9 : Who has the most working experience in the organization?
        method9();
        System.out.println("\n");
        // Query 10 : How many male and female employees are there in the sales and
        // marketing team?
        method10();
        System.out.println("\n");
        // Query 11 : What is the average salary of male and female employees?
        method11();
        System.out.println("\n");
        // Query 12 : List down the names of all employees in each department?
        method12();
        System.out.println("\n");
        // Query 13 : What is the average salary and total salary of the whole
        // organization?
        method13();
        System.out.println("\n");
        // Query 14 : Separate the employees who are younger or equal to 25 years from
        // those employees who are older than 25 years.
        method14();
        System.out.println("\n");
        // Query 15 : Who is the oldest employee in the organization? What is his age
        // and which department he belongs to?
        method15();
        System.out.println("\n");
        method16();
        System.out.println("\n");

    }

    private static void method15() {
        // Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Employee1 employee1 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(emp->emp.getAge()))).get();
        System.out.printf("Oldest Employee having name %s , department %s , age %s ",employee1.getName(),employee1.getDepartment(),employee1.getAge());
    }

    private static void method14() {
        // Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        System.out.println("Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years");
        Map<Boolean, List<Employee1>> booleanListMap = employeeList.stream().collect(Collectors.partitioningBy(employee1 -> employee1.getAge()>25));
        booleanListMap.entrySet().forEach(emp->{
            System.out.println(emp.getKey() + " --- "+emp.getValue().stream().map(empItr->{
                return empItr.getName()+"-"+empItr.getAge();
            }).collect(Collectors.joining(" -> ")));
        });
    }

    private static void method13() {
        //Query 13 : What is the average salary and total salary of the whole organization?
        double averageSalary = employeeList.stream().mapToDouble(emp->emp.getSalary().doubleValue()).average().getAsDouble();
        double totalsalary = employeeList.stream().mapToDouble(emp->emp.getSalary().doubleValue()).sum();
        System.out.println("Total Sum :"+totalsalary +", Total Average :"+ averageSalary);
    }

    private static void method12() {
        // Query 12 : List down the names of all employees in each department?
        System.out.println("The names of all employees in each department ");
        Map<String,List<Employee1>> mapEmployeeToDept = employeeList.stream().filter(emp->emp.getDepartment()!=null).collect(Collectors.groupingBy(Employee1::getDepartment));
        mapEmployeeToDept.entrySet().forEach(itr->{
            String nameForDept = itr.getValue().stream().map(Employee1::getName).collect(Collectors.joining(","));
            System.out.println(itr.getKey() + " - " +nameForDept);
        });
    }

    private static void method11() {
        //Query 11 : What is the average salary of male and female employees?
        Map<String, Double> collect = employeeList.stream().collect(Collectors.groupingBy(Employee1::getGender,Collectors.averagingDouble(emp->emp.getSalary().doubleValue())));
        System.out.println("The average salary of male and female employees: "+ collect);
    }

    private static void method10() {
        //Query 10 : How many male and female employees are there in the sales and marketing team?  Sales And Marketing
        Map<String, Long> CountOfMaleAndFemale = employeeList.stream().filter(emp -> "Sales And Marketing".equalsIgnoreCase(emp.getDepartment())).collect(Collectors.groupingBy(Employee1::getGender, Collectors.counting()));
        System.out.println("Male and female employees are there in the sales and marketing team :"+ CountOfMaleAndFemale);
    }

    private static void method9() {
        //Query 9 : Who has the most working experience in the organization?
        Stream<Employee1> employee1Stream = employeeList.stream().sorted(Comparator.comparing(Employee1::getYearOfJoining, Comparator.nullsFirst(Comparator.naturalOrder())));
        System.out.println("Who has the most working experience in the organization? -" + employee1Stream.findFirst().get().getName());
    }

    private static void method8() {
       // Query 8 : Get the details of youngest male employee in the product development department?
        Optional<Employee1> employee1 = employeeList.stream().filter(emp -> "product development".equalsIgnoreCase(emp.getDepartment())).sorted(Comparator.comparing(Employee1::getAge)).findFirst();
        System.out.println("Youngest male employee  : "+employee1.orElseThrow(()->new RuntimeException("Galat Entry")));
        String mediaType = "Test123";
        String elementType = "Test34567";
        //System.out.println("No HttpMessageWriter for \"" + mediaType + "(((((\" and \"" + elementType + "\"");
    }
    private static void method16() {
        /**
         * To handle the NUll scenario.
         * Let us use the two parameter overload of the comparing method.
         * We pass a key extractor that extracts the Department and pass a null-friendly comparator to compare the Department.
         * If the date is null, the null-friendly comparator returned by nullsFirst or nullsLast handles it.
         */
        //employeeList.sort(Comparator.comparing(Employee1::getDepartment,Comparator.nullsFirst(Comparator.naturalOrder())));

        //employeeList.sort(Comparator.comparing(Employee1::getDepartment,Comparator.nullsLast(Comparator.naturalOrder())));

        employeeList.sort(Comparator.comparing(Employee1::getDepartment,Comparator.nullsFirst(Comparator.reverseOrder())).thenComparing(Comparator.comparing(Employee1::getYearOfJoining)));


        /*      When first Sort in Asc Order of Department and then Sort in Des order of year
        employeeList.sort(Comparator.comparing(Employee1::getDepartment).thenComparing(Comparator.comparing(Employee1::getYearOfJoining).reversed()));*/

        /*      When first Sort in Dec Order of year and then Sort in Asc order of Department
        employeeList.sort(Comparator.comparing(Employee1::getYearOfJoining).reversed().thenComparing(Comparator.comparing(Employee1::getDepartment)));  */

        //List<Employee1> employee1List = employeeList.stream().sorted(Comparator.nullsFirst(Comparator.comparing(Employee1::getDepartment))).collect(Collectors.toList());
        System.out.println("Print in Sorted Order of Department in ASC and Year of Joining in Descending order ");
        employeeList.stream().forEach(emp -> {
            System.out.println(emp.getName() + " - " + emp.getDepartment() + " - " + emp.getSalary() + " - " + emp.getYearOfJoining());
        });

    }
    private static void method7() {
        // Query 7 : What is the average salary of all department?
        // Map<String, Double> collect = employeeList.stream().collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.averagingDouble(emp->emp.getSalary().doubleValue())));
        System.out.println("Query 7 : What is the average salary of all department?");
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream().filter(employee1 -> employee1.getDepartment() != null).collect(Collectors.summarizingDouble(emp -> emp.getSalary().doubleValue()));
        System.out.println("Average salary of all department: " + df.format(doubleSummaryStatistics.getAverage()));
    }

    private static void method6() {
        // Query 6 : Count the number of employees in each department?
        Map<String, Long> mapGenderToCount = employeeList.stream().filter(employee1 -> employee1.getDepartment() != null).collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.counting()));
        System.out.println("Query 6 : Count the number of employees in each department?");
        mapGenderToCount.entrySet().stream().forEach(keyValue -> System.out.println(keyValue.getKey() + " - " + keyValue.getValue()));
    }

    private static void method5() {
        // Query 5 : Get the names of all employees who have joined after 2015?
        System.out.println("Query 5 : Get the names of all employees who have joined after 2015?");
        employeeList.stream().filter(employee1 -> {
            return employee1.getYearOfJoining() > 2015;
        }).forEach(emp -> System.out.println(emp.getName() + ":" + emp.getYearOfJoining()));
    }

    private static void method4() {
        // Query 4 : Get the details of highest paid employee in the organization?
        System.out.println("Query 4 : Get the details of highest paid employee in the organization?");
        System.out.println("Using MaxBy");
        employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(emp -> emp.getSalary().doubleValue()))).ifPresent(employee -> System.out.println("Name :" + employee.getName() + ", Salary : " + employee.getSalary()));
        System.out.println("Using Sort");
        employeeList.stream().sorted(Comparator.comparing(Employee1::getSalary).reversed()).findFirst().ifPresent(employee -> System.out.println("Name :" + employee.getName() + ", Salary : " + employee.getSalary()));
    }

    private static void method3() {
        // Query 3 : What is the average age of male and female employees?
        Map<String, Double> collect = employeeList.stream().collect(Collectors.groupingBy(Employee1::getGender, Collectors.averagingInt(Employee1::getAge)));
        System.out.println("Query 3 : What is the average age of male and female employees?");
        collect.entrySet().stream().forEach(keyValue -> System.out.println(keyValue.getKey() + " - " + df.format(keyValue.getValue())));
    }

    private static void method2() {
        //Query 2 : Print the name of all departments in the organization?
        System.out.println("Query 2 : Print the name of all departments in the organization?");
        System.out.println("Using Set");
        employeeList.stream().map(Employee1::getDepartment).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("Using Distinct");
        employeeList.stream().map(Employee1::getDepartment).distinct().forEach(System.out::println);
    }

    private static void method1() {
        Map<String, Long> mapGenderToCount = employeeList.stream().collect(Collectors.groupingBy(Employee1::getGender, Collectors.counting()));
        System.out.println("Query 1 : How many male and female employees are there in the organization?");
        mapGenderToCount.entrySet().stream().forEach(keyValue -> System.out.println(keyValue.getKey() + " - " + keyValue.getValue()));
    }


}

class Employee1 {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    BigDecimal salary;

    public Employee1(int id, String name, int age, String gender, String department, int yearOfJoining, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = new BigDecimal(String.valueOf(salary));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : " + department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
    }
}