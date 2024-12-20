package healthy.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteProgram {
    private String status;






        public boolean deleteFitnessProgram(String programTitle) {

            if (programTitle == null || programTitle.isEmpty()) {
                setStatus("You must provide the program title to delete");
                return false;
            }

            File file = new File("src/test/resources/ApprovingFitnessProgram.txt");
            List<String> fileContent = new ArrayList<>();
            boolean programFound = false;

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = br.readLine()) != null) {
                    if (line.startsWith(programTitle + ":")) {
                        programFound = true;
                    } else {
                        fileContent.add(line);
                    }
                }


                if (programFound) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                        for (String contentLine : fileContent) {
                            bw.write(contentLine);
                            bw.newLine();
                        }
                    }
                    setStatus("Program deleted successfully");
                    return true;
                } else {
                    setStatus("You must provide the program title to delete");
                    return false;
                }

            } catch (IOException e) {

                setStatus("You must provide the program title to delete");
                e.printStackTrace();
            }

            setStatus("You must provide the program title to delete");
            return false;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }


