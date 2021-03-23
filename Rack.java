import java.util.*;
class Rack
{
  int id;
  int row;
  int column;
  int capacity;
  int minimumTemp;
  Map<RackLocation,Sample> rackOfSamples;
  Rack(int id, int row, int column)
  {
    this.id = id;
    this.row = row;
    this.column = column;
    this.capacity = this.row*this.column;
    this.minimumTemp = 10;
    rackOfSamples = new HashMap<RackLocation,Sample>();
  }
  public void addSampleToRack(Sample sample,int row, int column)
  {
    if((row<=this.row && row>0) && (column<=this.column && column>0))
    {
      RackLocation racklocation = new RackLocation(row,column);
      if(!rackOfSamples.containsKey(racklocation))
      {
        rackOfSamples.put(racklocation,sample);
      }
    }
  }
  public Sample getSampleFromRack(int rackId, int row, int column)
  {
    if((row<=this.row && row>0) && (column<=this.column && column>0))
    {
      RackLocation racklocation = new RackLocation(row,column);
      if(rackOfSamples.containsKey(racklocation))
      {
        return rackOfSamples.get(racklocation);
      }
    }
    return null;
  }
  public void setMinimumTemperature(int temp)
  {
    this.minimumTemp = temp;
  }
  public void printRackDetails()
  {
    System.out.println(" id "+id+" , TotalCapacity "+capacity+ " , Required Minimum Storage Temperature "+minimumTemp);
  }
  
}