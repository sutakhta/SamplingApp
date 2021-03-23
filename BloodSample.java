import java.util.*;

class BloodSample extends Sample
{
  String bloodType;
  BloodSample(int id,int subjectId,int volume, String date, int rackId, String bloodType)
  {
    super(id,subjectId,volume,date,rackId,SampleType.Blood);
    this.bloodType = bloodType; 
  }
    public void printSampleData()
  {
    System.out.println("SampleType : "+type+" Id: "+id+" , Date: "+date+"  , volume "+volume+ " , BloodType: "+bloodType);
  }
}