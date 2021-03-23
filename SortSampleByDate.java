import java.util.*;
class SortSampleByDate implements Comparator<Sample>
{
    // Used for sorting in ascending order of date
      public int compare(Sample a, Sample b)
    {
        return a.date.compareTo(b.date);
    }
}