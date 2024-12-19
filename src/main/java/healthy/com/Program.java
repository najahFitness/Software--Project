package healthy.com;

public class Program {
    private String difficultyLevel;
    private String focusArea;

    public Program(String difficultyLevel, String focusArea) {
        this.difficultyLevel = difficultyLevel;
        this.focusArea = focusArea;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getFocusArea() {
        return focusArea;
    }

    @Override
    public String toString() {
        return "Difficulty Level: " + difficultyLevel + ", Focus Area: " + focusArea;
    }
}

