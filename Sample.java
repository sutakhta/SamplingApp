import java.util.*;
class Sample
{
  int id;
  int volume;
  String date;
  int rackId;
  SampleType type;
  int subjectId;
  Sample(int id,int subjectId,int volume, String date, int rackId,SampleType type)
  {
    this.id = id;
    this.volume = volume;
    this.date = date;
    this.rackId = rackId;
    this.type = type;
    this.subjectId = subjectId;
  }
 public void printSampleData()
  {
    System.out.println("SampleType : "+type+" , Id: "+id+" , Date: "+date+" , volume "+volume);
  }
 public int getSubjectOfSample()
  {
    return this.subjectId;
  }

}