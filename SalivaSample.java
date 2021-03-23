
class SalivaSample extends Sample
{
  SalivaSample(int id,int subjectId,int volume, String date, int rackId)
  {
    super(id,subjectId,volume,date,rackId,SampleType.Saliva);
  }
  public void printSampleData()
  {
    System.out.println("SampleType : "+type+" , Id: "+id+" , Date: "+date+" , volume "+volume);
  }
}