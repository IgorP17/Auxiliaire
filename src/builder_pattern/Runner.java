package builder_pattern;

public class Runner {
    public static void main(String[] args) {
        Employee.Builder builder =
                new Employee.Builder()
                        .name("NAME 1")
                        .lastName("LAST NAME")
                        .startTime(17)
                        .endTime(20)
                        .department("BUYA");

        Employee employee = builder.build();

        System.out.println(employee);
    }
}
