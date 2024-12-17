package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddNewProgram {



        private String status;

        public boolean addFitnessProgram(String programTitle, String duration, String difficultyLevel, String goals, String price, String schedule) {
            // التحقق إذا كان أي حقل فارغ أو null
            if (programTitle == null || programTitle.isEmpty() ||
                    duration == null || duration.isEmpty() ||
                    difficultyLevel == null || difficultyLevel.isEmpty() ||
                    goals == null || goals.isEmpty() ||
                    price == null || price.isEmpty() ||
                    schedule == null || schedule.isEmpty()) {
                setStatus("unacceptable");  // التأكد من كتابة الحالة بشكل صحيح
                return false;
            }

            List<String> approvingData = new ArrayList<>();
            String approvingDataLine = programTitle + ":" + duration + ":" + difficultyLevel + ":" + goals + ":" + price + ":" + schedule;
            approvingData.add(approvingDataLine);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/resources/ApprovingFitnessProgram.txt", true))) {
                // إضافة السجل إلى الملف
                for (String updatedLine : approvingData) {
                    bw.write(updatedLine);
                    bw.newLine(); // التأكد من إضافة سطر جديد بعد كل سجل
                }
                setStatus("Program added successfully");  // تعيين الحالة عند قبول البرنامج
                return true;
            } catch (IOException e) {
                // طباعة معلومات الخطأ في حال حدوث استثناء أثناء الكتابة
                setStatus("unacceptable");
                System.err.println("Error writing to file: " + e.getMessage());
                e.printStackTrace();
            }

            setStatus("unacceptable");
            return false;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }


