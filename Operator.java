import java.util.ArrayList;
import java.util.List;
class Operator extends Person
{
  List<Integer> subjects;
  Operator(int id, String firstName, String lastName)
  {
    super(id,firstName,lastName);
    subjects = new ArrayList<Integer>();
  }
  void addSubject(Integer subject)
  {
    subjects.add(subject);
  }
}
