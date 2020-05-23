import java.util.ArrayList;
import java.util.List;

class CasesType
{
    private String name;
    private CasesType parent;    
    private List<Cases> cases;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CasesType getParent() {
        return parent;
    }

    public void setParent(CasesType parent) {
        this.parent = parent;
    }

    public List<Cases> getCases() {
        return cases;
    }

    public void setCases(List<Cases> cases) {
        this.cases = cases;
    }

    public CasesType(String name) {
        this.name = name;
        this.parent = null;
        this.cases = new ArrayList<>();
    }
}