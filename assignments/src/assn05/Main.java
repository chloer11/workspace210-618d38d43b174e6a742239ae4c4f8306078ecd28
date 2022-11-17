package assn05;


public class Main {

    public static void main(String[] args) {
        /*
        Part 1 - Write some tests to convince yourself that your code for Part 1 is working
         */






       /*
        Part 2 - Write some tests to convince yourself that your code for Part 2 is working
         */





        /*
        Part 3
         */
        MinBinHeapER transfer = new MinBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }

    }

    public static void fillER(MinBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }
    
    public static double[] compareRuntimes() {
    	// Array which you will populate as part of Part 4
    	double[] results = new double[4];
    	
        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);
        double initialT = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            simplePQ.dequeue();
        }
        double timeTaken = System.nanoTime();
        results[0] = timeTaken - initialT;
        results[1] = (timeTaken - initialT)/100000;
        //double results = start - end;
        // Code for (1) Here
        //System.nanoTime()
        MinBinHeapER binHeap = new MinBinHeapER();
        fillER(binHeap);
        double initialT2 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            binHeap.dequeue();
        }
        double timeTaken2 = System.nanoTime();
        //double results = start2 - end2;
        // Code for (2) Here
        results[2] = timeTaken2 - initialT2;
        results[3] = (timeTaken2 - initialT2)/100000;
        return results;
    }


}



