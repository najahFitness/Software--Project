package healthy.com;

import java.util.ArrayList;
import java.util.List;

public class ProgramManagement {

    private final List<String> programs;
    private List<String> filteredPrograms;

    public ProgramManagement() {
        programs = new ArrayList<>();
        filteredPrograms = new ArrayList<>();

        // Dummy programs
        programs.add("Beginner:Intro to Weight Loss:Weight loss:Monday 6 PM");
        programs.add("Intermediate:Strength Bootcamp:Muscle building:Wednesday 7 PM");
        programs.add("Advanced:Advanced Yoga Program:Flexibility:Friday 8 AM");
        programs.add("Beginner:Beginner Fitness Plan:General fitness:Saturday 9 AM");
    }

    public void filterPrograms(String difficultyLevel, String focusArea) {
        filteredPrograms = new ArrayList<>();
        for (String program : programs) {
            String[] details = program.split(":");
            if (details[0].equalsIgnoreCase(difficultyLevel) && details[2].equalsIgnoreCase(focusArea)) {
                filteredPrograms.add(program);
            }
        }
    }

    public String enrollInProgram(String programTitle) {
        for (String program : filteredPrograms) {
            if (program.contains(programTitle)) {
                return "Enrollment successful";
            }
        }
        return "Program not found";
    }

    public String confirmEnrollment(String programTitle) {
        for (String program : programs) {
            if (program.contains(programTitle)) {
                return "Enrollment successful";
            }
        }
        return "Enrollment failed: Program not found";
    }
}
