import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class FileHandler {

    // ✅ Save a list of doctors to a text file
    public static void saveDoctors(String filename, List<Doctor> doctors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.getId() + ", " + doctor.getName() + ", " + doctor.getSpecialization());
                writer.newLine();

                // ✅ Save assigned patients
                for (Patient patient : doctor.getPatients()) {
                    writer.write("  Patient: " + patient.getId());
                    writer.newLine();
                }
            }
            System.out.println(filename + " saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving " + filename + ": " + e.getMessage());
        }
    }

    // ✅ Save a list of patients with their medical records
    public static void savePatients(String filename, List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Patient patient : patients) {
                writer.write(patient.getId() + ", " + patient.getName() + ", " + patient.getAge() + ", " + patient.getGender());
                writer.newLine();
    
                // ✅ Save associated medical records
                for (MedicalRecord record : patient.getRecords()) {
                    writer.write("  Record: " + record.getRecordId() + ", " + record.getDiagnosis() + ", " + record.getPrescription());
                    writer.newLine();
                }
            }
            System.out.println(filename + " saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving " + filename + ": " + e.getMessage());
        }
    }
    

    // ✅ Load doctors from a text file
    public static List<Doctor> loadDoctors(String filename, List<Patient> patients) {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            Doctor currentDoctor = null;

            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("  Patient:")) {
                    String[] parts = line.split(", ");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String specialization = parts[2];
                    currentDoctor = new Doctor(id, name, specialization);
                    doctors.add(currentDoctor);
                } else if (currentDoctor != null) {
                    int patientId = Integer.parseInt(line.replace("  Patient: ", ""));
                    for (Patient patient : patients) {
                        if (patient.getId() == patientId) {
                            currentDoctor.addPatient(patient);
                            break;
                        }
                    }
                }
            }
            System.out.println(filename + " loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading " + filename + ": " + e.getMessage());
        }
        return doctors;
    }

    // ✅ Load patients along with their medical records
    public static List<Patient> loadPatients(String filename) {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            Patient currentPatient = null;
    
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("  Record:")) {
                    String[] parts = line.split(", ");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String gender = parts[3];
    
                    currentPatient = new Patient(id, name, age, gender, new ArrayList<>());
                    patients.add(currentPatient);
                } else if (currentPatient != null) {
                    String[] recordParts = line.replace("  Record: ", "").split(", ");
                    int recordId = Integer.parseInt(recordParts[0]);
                    String diagnosis = recordParts[1];
                    String prescription = recordParts[2];
    
                    currentPatient.addMedicalRecord(recordId, diagnosis, prescription);
                }
            }
            System.out.println(filename + " loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading " + filename + ": " + e.getMessage());
        }
        return patients;
    }    
}
