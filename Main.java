import java.io.*;
import java.util.*;
class Main {
  // Map of Operator with list of SampleID's being operated by Operator
  Map<Integer,ArrayList<Integer>> operatorSamples = new HashMap<Integer,ArrayList<Integer>>();
  // Map of RackID and Rack Objects
  Map<Integer,Rack> racksSamples = new HashMap<Integer,Rack>();
  // Map of SubjectID and Subject Objects
  Map<Integer,Subject> subjects = new HashMap<Integer,Subject>();
  // Map of OperatorID and Operator Objects
  Map<Integer,Operator> operators = new HashMap<Integer,Operator>();
  // Map of SampleID and Sample Objects of Type: Saliva
  Map<Integer,SalivaSample> salivaSamples = new HashMap<Integer,SalivaSample>();
    // Map of SampleID and Sample Objects of Type: Blood
  Map<Integer,BloodSample> bloodSamples = new HashMap<Integer,BloodSample>();
    // Map of SampleID and Sample Objects of Type: Tissue
  Map<Integer,TissueSample> tissueSamples = new HashMap<Integer,TissueSample>();

  public static void main(String[] args) 
  {
    Main myMain = new Main();
    LoadFiles loadCsvFiles = new LoadFiles();

    loadCsvFiles.loadRackFile(myMain.racksSamples);
    loadCsvFiles.loadPersonalFile(myMain.operators,myMain.subjects);
    loadCsvFiles.loadOperatorFile(myMain.operators,myMain.subjects);
    loadCsvFiles.loadSamplesFile(myMain.racksSamples,myMain.bloodSamples,myMain.tissueSamples,myMain.salivaSamples,myMain.operatorSamples,myMain.subjects);

System.out.println("------------------------------------------");    
System.out.println("List of Subjects : ID, FirstName, LastName");
System.out.println("------------------------------------------");
for (Integer key: myMain.subjects.keySet()) {
        myMain.subjects.get(key).printPersonDetails();
    }

System.out.println("------------------------------------------");
System.out.println("Blood Samples in Sorted Order");
System.out.println("------------------------------------------");
    ArrayList<BloodSample> bloodSamplesList = new ArrayList<BloodSample>(myMain.bloodSamples.values());
     Collections.sort(bloodSamplesList, new SortSampleByDate());
      for(int i = 0; i < bloodSamplesList.size(); i++) {   
        bloodSamplesList.get(i).printSampleData();
      }  
System.out.println("------------------------------------------");      
System.out.println("Tissue Samples in Sorted Order");
System.out.println("------------------------------------------");
        ArrayList<TissueSample> tissueSamplesList = new ArrayList<TissueSample>(myMain.tissueSamples.values());
     Collections.sort(tissueSamplesList, new SortSampleByDate());
      for(int i = 0; i < tissueSamplesList.size(); i++) {   
        tissueSamplesList.get(i).printSampleData();
      }

System.out.println("------------------------------------------");      
System.out.println("Saliva Samples in Sorted Order");
System.out.println("------------------------------------------");
          ArrayList<SalivaSample> salivaSamplesList = new ArrayList<SalivaSample>(myMain.salivaSamples.values());
     Collections.sort(salivaSamplesList, new SortSampleByDate());
      for(int i = 0; i < salivaSamplesList.size(); i++) {   
        salivaSamplesList.get(i).printSampleData();
      }
System.out.println("------------------------------------------");      
System.out.println("List of all Samples in Sorted Order By Volume:");
System.out.println("------------------------------------------");
List<Sample> samplelist = new ArrayList<Sample>();
samplelist.addAll(bloodSamplesList);
samplelist.addAll(tissueSamplesList);
samplelist.addAll(salivaSamplesList);
Collections.sort(samplelist, new SortSampleByVolume());
for(int i = 0; i < samplelist.size(); i++) {   
        samplelist.get(i).printSampleData();
      }
System.out.println("------------------------------------------");      
System.out.println("List of all Samples of Saliva Type with OperatorId 4:");
System.out.println("------------------------------------------");
 List<Integer> SampleListAll = myMain.operatorSamples.get(Integer.parseInt("4"));
 // Get list of all Samples being operated by Operator with Id = 4
 // If it is of type Saliva : Print its details.
for(int i=0;i<SampleListAll.size();i++){
  if(myMain.salivaSamples.containsKey(SampleListAll.get(i)))
  {
  myMain.salivaSamples.get(SampleListAll.get(i)).printSampleData();
  }
} 
System.out.println("------------------------------------------");
System.out.println("Operator Responsible for processing sample 14");
System.out.println("------------------------------------------");
myMain.printOperatorOfSample(14);
System.out.println("------------------------------------------");
System.out.println("List of Racks with Minimum Temperature");
System.out.println("------------------------------------------");
for (Integer key: myMain.racksSamples.keySet()) {
        myMain.racksSamples.get(key).printRackDetails();
    }
System.out.println("Note**** If Blood sample is stored in Rack, Minimum temperature will be 5 else it will be 10.****");
System.out.println("------------------------------------------");     
}

// To print the Operator of passed Sample-ID
void printOperatorOfSample(int sampleId)
{
  Long startTime = System.currentTimeMillis();
if(salivaSamples.containsKey(sampleId))
{
    int subjectSample = salivaSamples.get(sampleId).getSubjectOfSample();
    int operatorSample = subjects.get(subjectSample).getOperator();
    operators.get(operatorSample).printPersonDetails();
}
if(tissueSamples.containsKey(sampleId))
{
    int subjectSample = tissueSamples.get(sampleId).getSubjectOfSample();
    int operatorSample = subjects.get(subjectSample).getOperator();
    operators.get(operatorSample).printPersonDetails();
}
if(bloodSamples.containsKey(sampleId))
{
    int subjectSample = bloodSamples.get(sampleId).getSubjectOfSample();
    int operatorSample = subjects.get(subjectSample).getOperator();
    operators.get(operatorSample).printPersonDetails();
}
Long endTime = System.currentTimeMillis();
      System.out.println("Execution Time (Milliseconds) : "+(endTime-startTime));
}
}