package Lab1_WorkingWithAbstraction.P03students;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[] args) {

        String command = args[0];
        String name = args[1];
        if (command.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!repo.containsKey(name)) {
                Student student = new Student(name, age, grade);
                repo.put(name, student);
            }
        } else if (command.equals("Show")) {
            if (repo.containsKey(name)) {
                Student student = repo.get(name);
                StringBuilder builder = new StringBuilder();
                builder.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

                if (student.getGrade() >= 5.00) {
                    builder.append(" Excellent student.");
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    builder.append(" Average student.");
                } else {
                    builder.append(" Very nice person.");
                }

                System.out.println(builder.toString());
            }
        }
    }
}
