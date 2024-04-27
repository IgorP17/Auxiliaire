package builder_pattern;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int startTime;
    private final int endTime;
    private final String department;

    private Employee(String firstName, String lastName, int startTime, int endTime, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{\n" +
                "\tfirstName='" + firstName + '\'' +
                ",\n\tlastName='" + lastName + '\'' +
                ",\n\tstartTime=" + startTime +
                ",\n\tendTime=" + endTime +
                ",\n\tdepartment='" + department + '\'' + "\n" +
                '}';
    }


    // Here, we're defining the Builder as a static inner class.

    public static class Builder {

        private String firstName;
        private String lastName;
        private int startTime;
        private int endTime;
        private String department;

        public Builder name(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder startTime(int startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(int endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(firstName, lastName, startTime, endTime, department);
        }
    }
}
