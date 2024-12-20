package healthy.com;

import java.util.HashMap;
import java.util.Map;

public class ProgramMonitor {
//test
    private Map<String, String> programStatistics;
    private Map<String, String> reports;
    private Map<String, String> programStatuses;

    public ProgramMonitor() {
        programStatistics = new HashMap<>();
        reports = new HashMap<>();
        programStatuses = new HashMap<>();


        programStatistics.put("Yoga for Beginners", "high enrollment, with $5000 revenue and 85% attendance.");
        programStatistics.put("Zumba Express", "completed. Average client progress is 90% goal achievement.");
        programStatistics.put("Strength Training", "steady enrollment, with $3500 revenue and 75% attendance.");
        programStatistics.put("Pilates Plus", "completed. Average client progress is 95% goal achievement.");

        reports.put("Revenue and Attendance", "Revenue: $5000, Attendance: 85%");
        reports.put("Client Progress", "Average progress: 90%");

        programStatuses.put("Active", "currently active.");
        programStatuses.put("Completed", "completed.");
    }

    public String getProgramStatistics(String programName) {
        if (programStatistics.containsKey(programName)) {
            return "The " + programName + " program has " + programStatistics.get(programName);
        }
        return "Program not found.";
    }

    public String generateReport(String reportType) {
        return reports.getOrDefault(reportType, "Report type not found.");
    }

    public String trackProgramStatus(String programStatus, String programName) {
        if (programStatuses.containsKey(programStatus) && programStatistics.containsKey(programName)) {

            if (programStatus.equals("Active")) {
                return "The " + programName + " program has " + programStatistics.get(programName);
            } else {
                return "The " + programName + " program is " + programStatuses.get(programStatus) + " Average client progress is " + programStatistics.get(programName).split("client progress is ")[1];
            }
        }
        return "Program status or statistics not found.";
    }
}

//test