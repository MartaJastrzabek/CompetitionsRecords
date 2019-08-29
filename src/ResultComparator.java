import java.util.Comparator;

public class ResultComparator implements Comparator<Competitor> {


    @Override
    public int compare(Competitor c1, Competitor c2) {
        if(c1 == null && c2 == null)
            return 0;
        if(c1 == null && c2 != null)
            return -1;
        if(c1 != null && c2 == null)
            return 1;

        if(c1.getResult() > c2.getResult())
            return 1;
        else if (c1.getResult() == c2.getResult())
            return 0;
        else
            return -1;
    }
}
