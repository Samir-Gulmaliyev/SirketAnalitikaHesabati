import java.time.LocalDate;
import java.util.List;

record Employee(
        String name,
        String department,
        double salary,
        int age,
        List<String> skills,
        LocalDate hireDate,
        String managerName // null ola bilər (rəhbər üçün)
) {}