
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Doctor implements Serializable {
    //   defining the fields
    private int id;
    private String name;
    private String specialization;
    private List<Patient> patients;

    // default constructor
    public Doctor(){};

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.setDoctor(this);  // Ensure bidirectional link
            System.out.println("Patient " + patient.getName() + " assigned to Dr. " + name);
        } else {
            System.out.println("Patient " + patient.getName() + " is already assigned to Dr. " + name);
        }
    }


    // getter method
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public List<Patient> getPatients() { return patients; }

    public void viewAssignedPatients() {
        System.out.println("Patients under Dr. " + name + ":");
        if (patients.isEmpty()) {
            System.out.println("No patients assigned.");
        } else {
            for (Patient patient : patients) {
                System.out.println("- " + patient.getName() + " (ID: " + patient.getId() + ")");
            }
        }
    }

    public void addMedicalRecord(int patientId, String diagnosis, String prescription, int recordId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId && patient.getDoctor() != null && patient.getDoctor().getId() == this.id) {
                patient.addMedicalRecord(recordId, diagnosis, prescription);
                return;
            }
        }
        System.out.println("Patient not found or not assigned to Dr. " + name);
    }
}
