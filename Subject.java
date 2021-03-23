import java.util.ArrayList;
import java.util.List;

class Subject extends Person
{
  int operatorId;
  Subject(int id, String firstName, String lastName)
  {
    super(id,firstName,lastName);
  }
  void setOperator(int operatorId)
  {
    this.operatorId = operatorId;
  }
  int getOperator()
  {
    return this.operatorId;
  }

}