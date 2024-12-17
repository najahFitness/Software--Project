package healthy.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApprovingFromAdmin {
    private String status;

    // دالة لإضافة مدرب جديد بعد الموافقة
    public boolean addInstructor(String name, String phoneNumber, String yearsOfExperience, String jobDescription) {
        // التحقق إذا كان أي حقل فارغ أو null
        if (name == null || name.isEmpty() ||
                phoneNumber == null || phoneNumber.isEmpty() ||
                yearsOfExperience == null || yearsOfExperience.isEmpty() ||
                jobDescription == null || jobDescription.isEmpty()) {
            setStatus("unacceptable");  // هنا يجب التأكد من كتابة الحالة بالشكل الصحيح
            return false;
        }

        List<String> approvingData = new ArrayList<>();
        String approvingDataLine = name + ":" + phoneNumber + ":" + yearsOfExperience + ":" + jobDescription;
        approvingData.add(approvingDataLine);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/resources/programs.txt", true))) {
            // إضافة السجل إلى الملف
            for (String updatedLine : approvingData) {
                bw.write(updatedLine);
                bw.newLine(); // التأكد من إضافة سطر جديد بعد كل سجل
            }
            setStatus("Accepted");  // تعيين الحالة عند قبول المدرب
            return true;
        } catch (IOException e) {
            // طباعة معلومات الخطأ في حال حدوث استثناء أثناء الكتابة
            setStatus("unacceptable");
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
