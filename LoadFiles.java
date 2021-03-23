import java.io.*;
import java.util.*;

class LoadFiles {
  public void loadRackFile(Map<Integer, Rack> racksSamples) {
    try {
      Long startTime = System.currentTimeMillis();
      Scanner sc = new Scanner(new File("CsvFiles/racks.csv"));
      if (sc.hasNext()) {
        sc.next();
        System.out.println("Loading Racks.csv.....");
      }
      while (sc.hasNext()) {
        String Rowvalue = sc.next();
        String[] values = Rowvalue.split(",");
        int id = Integer.parseInt(values[0]);
        int row = Integer.parseInt(values[1]);
        int column = Integer.parseInt(values[2]);
        Rack newRack = new Rack(id, row, column);
        racksSamples.put(id, newRack);
      }
      Long endTime = System.currentTimeMillis();
      System.out.println("Execution Time (Milliseconds) : "+(endTime-startTime));
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }

  public void loadPersonalFile(Map<Integer, Operator> operators, Map<Integer, Subject> subjects) {
    try {
      Long startTime = System.currentTimeMillis();
      Scanner sc = new Scanner(new File("CsvFiles/personal.csv"));
      if (sc.hasNext()) {
        sc.next();
        System.out.println("Loading personal.csv.....");
      }
      while (sc.hasNext()) {
        String Rowvalue = sc.next();
        String[] values = Rowvalue.split(",");
        int id = Integer.parseInt(values[0]);
        String firstName = values[1];
        String lastName = values[2];
        String isOperator = values[3];
        if (isOperator.equals("true")) {
          Operator newOperator = new Operator(id, firstName, lastName);
          operators.put(id, newOperator);
        } else {
          Subject newSubject = new Subject(id, firstName, lastName);
          subjects.put(id, newSubject);
        }
      }
       Long endTime = System.currentTimeMillis();
      System.out.println("Execution Time (Milliseconds) : "+(endTime-startTime));
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }

  public void loadOperatorFile(Map<Integer, Operator> operators, Map<Integer, Subject> subjects) {
    try {
      Long startTime = System.currentTimeMillis();
      Scanner sc = new Scanner(new File("CsvFiles/operators.csv"));
      if (sc.hasNext()) {
        sc.next();
        System.out.println("Loading operators.csv.....");
      }
      while (sc.hasNext()) {
        String Rowvalue = sc.next();
        String[] values = Rowvalue.split(",");
        int subjectId = Integer.parseInt(values[0]);
        int operatorId = Integer.parseInt(values[1]);
        if (operators.containsKey(Integer.parseInt(values[1]))) {
          operators.get(operatorId).addSubject(subjectId);
          subjects.get(subjectId).setOperator(operatorId);
        }
      }
       Long endTime = System.currentTimeMillis();
      System.out.println("Execution Time (Milliseconds) : "+(endTime-startTime));
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }

  public void loadSamplesFile(Map<Integer, Rack> racksSamples, Map<Integer, BloodSample> bloodSamples,
      Map<Integer, TissueSample> tissueSamples, Map<Integer, SalivaSample> salivaSamples,
      Map<Integer, ArrayList<Integer>> operatorSamples, Map<Integer, Subject> subjects) {
    try {
      Long startTime = System.currentTimeMillis();
      Scanner sc = new Scanner(new File("CsvFiles/samples.csv"));
      if (sc.hasNext()) {
        sc.next();
        System.out.println("Loading samples.csv.....");
      }
      while (sc.hasNext()) {
        String Rowvalue = sc.next();

        String[] values = Rowvalue.split(",");
        int sampleId = Integer.parseInt(values[0]);
        String sampleType = values[1];
        int volume = Integer.parseInt(values[2]);
        String date = values[3];
        int subject_id = Integer.parseInt(values[4]);
        int rack_id = Integer.parseInt(values[5]);
        int row = Integer.parseInt(values[6]);
        int column = Integer.parseInt(values[7]);
        if (sampleType.equals("blood")) {
          String blood_type = values[8];
          Rack rack1 = racksSamples.get(rack_id);
          // Setting the Minimum Temperature to 5 in case of Blood Sample
          // Default Minimum temperature is 10 for all the other samples.
          rack1.setMinimumTemperature(Integer.parseInt("5"));
          BloodSample newBloodSample = new BloodSample(sampleId, subject_id, volume, date, rack_id, blood_type);
          rack1.addSampleToRack((Sample) newBloodSample, row, column);
          bloodSamples.put(sampleId, newBloodSample);
        } else if (sampleType.equals("tissue")) {
          String tissue_origin = values[9];
          Rack rack1 = racksSamples.get(rack_id);
          TissueSample newTissueSample = new TissueSample(sampleId, subject_id, volume, date, rack_id, tissue_origin);
          rack1.addSampleToRack((Sample) newTissueSample, row, column);
          tissueSamples.put(sampleId, newTissueSample);
        } else if (sampleType.equals("saliva")) {
          Rack rack1 = racksSamples.get(Integer.parseInt(values[5]));
          SalivaSample newSalivaSample = new SalivaSample(sampleId, subject_id, volume, date, rack_id);
          rack1.addSampleToRack((Sample) newSalivaSample, row, column);
          salivaSamples.put(sampleId, newSalivaSample);
        }
        int operatorValue = subjects.get(subject_id).getOperator();
        if (operatorSamples.containsKey(operatorValue)) {
          ArrayList<Integer> sampleListNew = operatorSamples.get(operatorValue);
          sampleListNew.add(sampleId);
          operatorSamples.put(operatorValue, sampleListNew);
        } else {
          ArrayList<Integer> sampleListNew = new ArrayList<Integer>();
          sampleListNew.add(sampleId);
          operatorSamples.put(operatorValue, sampleListNew);
        }
      }
       Long endTime = System.currentTimeMillis();
      System.out.println("Execution Time (Milliseconds) : "+(endTime-startTime));
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }
}