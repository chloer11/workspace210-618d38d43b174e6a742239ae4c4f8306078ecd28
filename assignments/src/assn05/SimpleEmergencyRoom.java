package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    // TODO: dequeue
    public Patient dequeue() //{return null;}
    {
        if (patients.size() == 0){
            return null;
        }
        else {
            Patient value = patients.get(0);
            for (int i = 0; i < patients.size() - 1; ++i) {
                if (patients.get(i).getPriority().compareTo(value.getPriority()) < 0) {
                    value = patients.get(i);
                }
            }
                    patients.remove(value);
                    return value;
                }
            }


    public <V, P > void addPatient (V value, P priority){
                Patient patient = new Patient(value, (Integer) priority);
                patients.add(patient);
            }

    public <V > void addPatient (V value){
                Patient patient = new Patient(value);
                patients.add(patient);
            }

    public List getPatients () {
                return patients;
            }

    public int size () {
                return patients.size();
            }

        }