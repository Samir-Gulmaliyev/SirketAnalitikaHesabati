import java.time.LocalDate;
import java.util.List;

public class EmployeeService {

    public final List<Employee> employees;

    public EmployeeService() {
        this.employees = List.of(
                new Employee("Ali", "Engineering", 8500, 28,
                        List.of("Java", "Spring Boot", "SQL", "Docker"),
                        LocalDate.of(2020, 3, 15), "Kamran"),

                new Employee(
                        "Kamran", "Engineering", 15000,
                        41, List.of("Java", "AWS", "Docker", "Kubernetes", "SQL"),
                        LocalDate.of(2016, 7, 10), null
                ),

                new Employee(
                        "Leyla", "Engineering", 11000,
                        34, List.of("Java", "Python", "AWS"),
                        LocalDate.of(2019, 1, 21), "Kamran"
                ),

                new Employee(
                        "Murad", "Engineering", 7200,
                        27, List.of("Java", "React", "SQL"),
                        LocalDate.of(2022, 5, 3), "Kamran"
                ),

                new Employee(
                        "Nigar", "Engineering", 9800,
                        31, List.of("Python", "AWS", "Docker", "SQL"),
                        LocalDate.of(2021, 9, 12), "Kamran"
                ),

                new Employee(
                        "Elvin", "Engineering", 6200,
                        25, List.of("Java", "Docker", "SQL"),
                        LocalDate.of(2023, 2, 18), "Kamran"
                ),

                new Employee(
                        "Rauf", "Sales", 6500,
                        38, List.of("Sales", "Negotiation", "Excel"),
                        LocalDate.of(2018, 4, 25), "Aysel"
                ),

                new Employee(
                        "Aysel", "Sales", 12500,
                        45, List.of("Sales", "Negotiation", "Leadership", "Excel"),
                        LocalDate.of(2015, 6, 8), null
                ),

                new Employee(
                        "Tural", "Sales", 4800,
                        26, List.of("Sales", "Negotiation", "Excel"),
                        LocalDate.of(2022, 11, 14), "Aysel"
                ),

                new Employee(
                        "Gunay", "Sales", 7300,
                        33, List.of("Sales", "CRM", "Negotiation", "Excel"),
                        LocalDate.of(2019, 8, 19), "Aysel"
                ),

                new Employee(
                        "Orkhan", "Sales", 9100,
                        40, List.of("Sales", "Negotiation", "Leadership"),
                        LocalDate.of(2017, 3, 6), "Aysel"
                ),

                new Employee(
                        "Sabina", "HR", 5800,
                        30, List.of("Excel", "Recruitment", "Communication"),
                        LocalDate.of(2021, 2, 11), "Rashad"
                ),

                new Employee(
                        "Rashad", "HR", 10500,
                        43, List.of("Recruitment", "Leadership", "Excel", "Communication"),
                        LocalDate.of(2016, 10, 5), null
                ),

                new Employee(
                        "Lala", "HR", 6700,
                        28, List.of("Recruitment", "Excel", "Communication"),
                        LocalDate.of(2023, 1, 9), "Rashad"
                ),

                new Employee(
                        "Farid", "HR", 8200,
                        36, List.of("Recruitment", "Negotiation", "Excel"),
                        LocalDate.of(2018, 12, 17), "Rashad"
                ),

                new Employee(
                        "Zahra", "Marketing", 7600,
                        32, List.of("Marketing", "SEO", "Excel", "Communication"),
                        LocalDate.of(2020, 6, 22), "Samir"
                ),

                new Employee(
                        "Samir", "Marketing", 14000,
                        47, List.of("Marketing", "Leadership", "SEO", "Analytics"),
                        LocalDate.of(2014, 9, 1), null
                ),

                new Employee(
                        "Amin", "Marketing", 5400,
                        24, List.of("Marketing", "SEO", "Social Media"),
                        LocalDate.of(2024, 1, 15), "Samir"
                ),

                new Employee(
                        "Aynur", "Marketing", 8900,
                        35, List.of("Marketing", "Analytics", "Excel", "SEO"),
                        LocalDate.of(2019, 4, 29), "Samir"
                ),

                new Employee(
                        "Kamila", "Marketing", 6800,
                        29, List.of("Marketing", "Communication", "Social Media"),
                        LocalDate.of(2022, 7, 13), "Samir"
                ),

                new Employee(
                        "Vusal", "Finance", 9500,
                        39, List.of("Excel", "Accounting", "SQL", "Analytics"),
                        LocalDate.of(2017, 11, 20), "Ilham"
                ),

                new Employee(
                        "Ilham", "Finance", 16000,
                        52, List.of("Finance", "Leadership", "Excel", "Accounting", "Analytics"),
                        LocalDate.of(2014, 2, 3), null
                ),

                new Employee(
                        "Namiq", "Finance", 6200,
                        27, List.of("Excel", "Accounting", "SQL"),
                        LocalDate.of(2023, 5, 27), "Ilham"
                ),

                new Employee(
                        "Aydan", "Finance", 7800,
                        34, List.of("Finance", "Excel", "Analytics"),
                        LocalDate.of(2020, 10, 16), "Ilham"
                ),

                new Employee(
                        "Emin", "Finance", 11200,
                        44, List.of("Finance", "Accounting", "Leadership", "Excel"),
                        LocalDate.of(2018, 6, 30), "Ilham"
                ),

                new Employee(
                        "Sevda", "Engineering", 18000,
                        55, List.of("Java", "AWS", "Kubernetes", "Docker", "Leadership"),
                        LocalDate.of(2014, 5, 12), null
                )
        );
    }

    public List<Employee> employeeList() {
        return this.employees;
    }
}
