
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patient implements Serializable {
    // defining the fields of a patient
    private int id;
    private String name;
    private int age;
    private String gender;
    private Doctor doctor;
    private List<MedicalRecord> records;
    

    // default constructor
    public Patient(){};

    public Patient(int id, String name, int age, String gender, List<MedicalRecord> records) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.records = (records != null) ? records : new ArrayList<>();
        this.doctor = null;
    }


    //   setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    


    // getter methods
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getGender() {
        return this.gender;
    }
    

    public Doctor getDoctor() {
        return this.doctor;
    }

    public List<MedicalRecord> getRecords() {
        return records;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patient{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append(", doctor=").append(doctor);
        sb.append(", records=").append(records);
        sb.append('}');
        return sb.toString();
    }


    // method to add patient medical record
    public void addMedicalRecord(int recordId, String diagnosis, String prescription) {
        MedicalRecord newRecord = new MedicalRecord(diagnosis, this, prescription, recordId);
        records.add(newRecord);

        System.out.println("New record added successfully");
    }
     
    // method to view medical history
    public void viewMedicalHistory() {
        if (records.isEmpty()) {
            System.out.println("No diagnosis found");
        } else {
            System.out.println("Medical History of "+ this.name + " with ID " + this.id);

            for (MedicalRecord record : records) {
                System.out.println(record);
            }
        }
    }
    
    
}
