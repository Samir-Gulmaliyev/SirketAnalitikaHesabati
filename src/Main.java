import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        System.out.println(generateReport(employeeService.employeeList()));

    }

    public static String generateReport(List<Employee> employees) {
        // Tapşırıq A: Ümumi statistika
        //Ümumi işçi sayı, ümumi maaş xərci, orta maaş
        DoubleSummaryStatistics umumiStatistika = employees.stream().
                collect(Collectors.summarizingDouble(Employee::salary));
        //Ən yaşlı və ən gənc işçini(adı, yaşı) tap — Optional ilə
        //ən gənc işçi
        Optional<Employee> youngest = employees.stream().
                min(Comparator.comparing(Employee::age));
        //Ən yaşlı işçi
        Optional<Employee> oldest = employees.stream().
                max(Comparator.comparing(Employee::age));

        //------------------------------------------------

        // Tapşırıq B: Ümumi statistika
        Map<String, DepartmentSummary> departmentSummary = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    long count = list.size();
                    double averageSalary = list.stream().mapToDouble(Employee::salary).average().orElse(0);
                    String highestPaidEmployee = list.stream().max(Comparator.comparingDouble(Employee::salary))
                            .map(Employee::name).orElse("N/A");
                    return new DepartmentSummary(count, averageSalary, highestPaidEmployee);
                }
        )));

        Map<String, Double> salaryExpenses =
                employees.stream().collect(Collectors.groupingBy(Employee::department,
                        Collectors.summingDouble(Employee::salary)));

        Map.Entry<String, Double> highestExpenseDepartment = salaryExpenses.entrySet().stream()
                .max(Map.Entry.comparingByValue()).orElseThrow();

        //------------------------------------------------

        // Tapşırıq C: Skill analizi
        // Bütün skill-lər və hər skill-ə malik işçi sayı
        Map<String, Long> skillCounts = employees.stream().flatMap(employee -> employee.skills().stream().distinct()).
                collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));
        // Ən populyar 3 skill
        List<Map.Entry<String, Long>> list = skillCounts.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3).toList();
        // Hər departament üzrə bütün unikal skill-lər
        Map<String, Set<String>> departmentSkills = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors
                .flatMapping(employee -> employee.skills().stream(), Collectors.toSet())));
        // Ortaq skill-i olmayan departament cütlərini tap
        List<Map.Entry<String, Set<String>>> departments = new ArrayList<>(departmentSkills.entrySet());
        List<String> noCommonSkillPairs = IntStream.range(0, departments.size()).boxed()
                .flatMap(i -> IntStream.range(i + 1, departments.size()).mapToObj(j -> {
                            Map.Entry<String, Set<String>> department1 = departments.get(i);
                            Map.Entry<String, Set<String>> department2 = departments.get(j);
                            boolean noCommonSkill = department1.getValue().stream().noneMatch(department2.getValue()::contains);
                            if (noCommonSkill) {
                                return department1.getKey()
                                        + " - " + department2.getKey();
                            }
                            return null;
                        })
                ).filter(Objects::nonNull).toList();


        StringBuilder stringBuilder = new StringBuilder();

        // ================= A =================
        stringBuilder.append("=== A — Ümumi statistika ===\n");
        stringBuilder.append("İşçi sayı: ")
                .append(umumiStatistika.getCount()).append("\n");
        stringBuilder.append("Ümumi maaş: ")
                .append(umumiStatistika.getSum()).append("\n");
        stringBuilder.append("Orta maaş: ").append(umumiStatistika.getAverage()).append("\n");
        stringBuilder.append("Ən gənc: ").append(youngest.map(e -> e.name() + " (" + e.age() + ")").orElse("Yoxdur")).append("\n");
        stringBuilder.append("Ən yaşlı: ").append(oldest.map(e -> e.name() + " (" + e.age() + ")").orElse("Yoxdur")).append("\n");

        // ================= B =================
        stringBuilder.append("\n=== B — Departament analizi ===\n");
        departmentSummary.forEach((department, summary) -> {
            stringBuilder.append(department)
                    .append(" → İşçi: ")
                    .append(summary.employeeCount())
                    .append(", Orta maaş: ")
                    .append(summary.averageSalary())
                    .append(", Ən yüksək maaşlı: ")
                    .append(summary.highestPaidEmployee())
                    .append("\n");
        });
        stringBuilder.append("Ən yüksək maaş xərci: ")
                .append(highestExpenseDepartment.getKey())
                .append(" → ")
                .append(highestExpenseDepartment.getValue())
                .append("\n");

        // ================= C =================
        stringBuilder.append("\n=== C — Skill analizi ===\n");
        stringBuilder.append("Skill-lər:\n");
        skillCounts.forEach((skill, count) ->
                stringBuilder.append("  ")
                        .append(skill)
                        .append(" → ")
                        .append(count)
                        .append("\n")
        );

        stringBuilder.append("Top 3 skill:\n");
        list.forEach(entry ->
                stringBuilder.append("  ")
                        .append(entry.getKey())
                        .append(" → ")
                        .append(entry.getValue())
                        .append("\n")
        );
        stringBuilder.append("Ortaq skill-i olmayan departamentlər:\n");
        noCommonSkillPairs.forEach(pair ->
                stringBuilder.append("  ")
                        .append(pair)
                        .append("\n")
        );
        return stringBuilder.toString();
    }
}
