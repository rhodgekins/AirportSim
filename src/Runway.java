
public class Runway {

    private Aircraft[] ac;

    public Runway()
    {
        ac = new Aircraft[1];
    }

    public void addAircraft(Aircraft ac)
    {
        this.ac[0] = ac;
    }

    public String getAircraft()
    {
        if (!isEmpty())
        {
            return ac[0].toString() + ac[0].getName();
        }
        return "";
    }

    public void removeAircraft()
    {
        this.ac[0] = null;
    }

    public boolean isEmpty()
    {
        return ac[0] == null;
    }

    public void process()
    {
        if (!isEmpty())
        {
            ac[0].countdown();
            if (ac[0].getCount() == 0)
            {
                removeAircraft();
            }
        }
    }
}
