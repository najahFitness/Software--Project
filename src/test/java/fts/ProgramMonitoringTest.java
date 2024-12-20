package fts;

import healthy.com.ProgramMonitor;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

public class ProgramMonitoringTest {

    private ProgramMonitor programMonitor;
    private String displayedResult;
    private String currentProgramName;

    @Given("the admin is logged into the system to monitor program performance")
    public void the_admin_is_logged_into_the_system_to_monitor_program_performance() {
        programMonitor = new ProgramMonitor();
        System.out.println("Admin is logged into the system.");
    }

    @When("the admin views the statistics for the most popular programs by enrollment {string}")
    public void the_admin_views_the_statistics_for_the_most_popular_programs_by_enrollment(String programName) {
        currentProgramName = programName;
        displayedResult = programMonitor.getProgramStatistics(programName);
        System.out.println("Viewing statistics for program: " + programName);
    }

    @When("the admin generates a report on {string} for the program")
    public void the_admin_generates_a_report_on_for_the_program(String reportType) {
        String report = programMonitor.generateReport(reportType);
        System.out.println("Report generated on: " + report);
    }

    @When("the admin tracks the status of the program as {string}")
    public void the_admin_tracks_the_status_of_the_program_as(String programStatus) {
        displayedResult = programMonitor.trackProgramStatus(programStatus, currentProgramName);
        System.out.println("Tracking program status as: " + programStatus);
    }

    @Then("the system should display {string} for the selected program")
    public void the_system_should_display_for_the_selected_program(String expectedResult) {
        assertEquals(expectedResult, displayedResult);
        System.out.println("Test passed. Displayed result matches expected result: " + expectedResult);
    }
}