import java.util.*;
class TissueSample extends Sample
{
  String tissueOrigin;
  TissueSample(int id,int subjectId,int volume, String date, int rackId, String tissueOrigin)
  {
    super(id,subjectId,volume,date,rackId,SampleType.Tissue);
    this.tissueOrigin = tissueOrigin; 
  }
   public void printSampleData()
  {
    System.out.println("SampleType : "+type+" , Id: "+id+" , Date: "+date+" , volume "+volume+ " , Origin: "+tissueOrigin);
  }
}