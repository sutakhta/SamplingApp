import java.util.*;

class Person
{
  int id;
  String firstName;
  String lastName;
    
  Person(int id,String firstName,String lastName)
  {
    this.id = id;
    this.firstName=firstName;
    this.lastName = lastName;
  }
  
  void printPersonDetails()
  {
    System.out.println("ID : "+this.id+ " , Name : "+this.firstName+ " "+this.lastName);
  }
}