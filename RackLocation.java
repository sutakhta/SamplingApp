import java.util.*;
class RackLocation
{
  int row;
  int column;
  RackLocation(int row, int column)
  {
    this.row = row;
    this.column = column;
  }
  @Override
public boolean equals(Object o) {
    if (o == this)
        return true;
    if (!(o instanceof RackLocation))
        return false;
    RackLocation other = (RackLocation) o;
    return (other.row == this.row) && (other.column == this.column);
}
@Override
public int hashCode() {
    return row * 31 + column;
}
}