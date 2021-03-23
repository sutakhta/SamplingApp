import java.util.*;
class SortSampleByVolume implements Comparator<Sample>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Sample a, Sample b)
    {
        return a.volume - b.volume;
    }
}