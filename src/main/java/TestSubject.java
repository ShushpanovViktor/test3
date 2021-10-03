import java.util.UUID;

public class TestSubject {

    private String id = UUID.randomUUID().toString();
    private int ordinal;

    public TestSubject(int ordinal)
    {
        this.ordinal=ordinal;
    }
    public String getId() {
        return id;
    }
    public int getOrdinal(){
        return ordinal;
    }
    public void setOrdinal(int ordinal)
    {
        this.ordinal=ordinal;
    }
}