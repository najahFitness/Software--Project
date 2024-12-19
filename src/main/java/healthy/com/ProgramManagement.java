package healthy.com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramManagement {
    private ConsoleDisplay console;
    private List<Program> programs;

    public ProgramManagement(ConsoleDisplay console) {
        this.console = console;
        this.programs = new ArrayList<>();
        initializePrograms();
    }

    private void initializePrograms() {
        programs.add(new Program("Beginner", "Weight Loss"));
        programs.add(new Program("Advanced", "Muscle Building"));
        programs.add(new Program("Intermediate", "Flexibility"));
        programs.add(new Program("Beginner", "Cardio"));
    }

    public void displayMenu() {
        console.displayMessage("Program Exploration Menu:");
        console.displayMessage("1. Filter Programs by Difficulty Level");
        console.displayMessage("2. Filter Programs by Focus Area");
        console.displayMessage("3. View Program Schedule");
        console.displayMessage("4. Go Back");
    }

    public void filterPrograms(String criteria, String value) {
        List<Program> filteredPrograms = programs.stream()
                .filter(p -> {
                    if (criteria.equalsIgnoreCase("Difficulty Level")) {
                        return p.getDifficultyLevel().equalsIgnoreCase(value);
                    } else if (criteria.equalsIgnoreCase("Focus Area")) {
                        return p.getFocusArea().equalsIgnoreCase(value);
                    }
                    return false;
                })
                .collect(Collectors.toList());

        if (filteredPrograms.isEmpty()) {
            console.displayMessage("No programs found matching " + value);
        } else {
            console.displayMessage("Programs matching " + value + ":");
            filteredPrograms.forEach(p -> console.displayMessage(p.toString()));
        }
    }

    public void viewProgramSchedule() {
        console.displayMessage("Displaying program schedule...");
        console.displayMessage("1. Beginner: Monday & Wednesday, 5 PM");
        console.displayMessage("2. Advanced: Tuesday & Thursday, 6 PM");
        console.displayMessage("3. Weight Loss: Friday, 7 PM");
    }
}


