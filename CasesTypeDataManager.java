import java.util.ArrayList;
import java.util.List;

class CasesTypeDataManager
{
    private List<CasesType> casesType;

    CasesTypeDataManager() {
        casesType = new ArrayList<>();
        CasesType asia = new CasesType("Asia");
        CasesType thailand = new CasesType("Thailand");
        CasesType bangkok = new CasesType("Bangkok");
        CasesType china = new CasesType("China");
        CasesType japan = new CasesType("Japan");
        CasesType tokyo = new CasesType("Tokyo");

        bangkok.setParent(thailand);
        tokyo.setParent(japan);

        thailand.setParent(asia);
        china.setParent(asia);
        japan.setParent(asia);

        casesType.add(asia);
        casesType.add(thailand);
        casesType.add(bangkok);
        casesType.add(china);
        casesType.add(japan);
        casesType.add(tokyo);
    }

    public void printAllCasesType(){
        
    }

    public List<CasesType> getAllCasesType(){
        return casesType;
    }

    public CasesType getCasesType(String casetype){
        //CasesType casestype = findCasesType(casetype);
        if(findCasesType(casetype) == null)
        {
            System.out.println("Case type not found!");
            return null;
        }
        else return findCasesType(casetype);
    }

    public void setCasesType(String casetype, String parent){
        if(findCasesType(casetype) == null)
        {
            CasesType casestype = new CasesType(casetype);
            if(parent != null)
            {
                boolean found = false;
                for (CasesType casesType2 : casesType) {
                    if(casesType2.getName().toLowerCase().equals(parent.toLowerCase())){
                        casestype.setParent(casesType2);
                        casesType.add(casestype);
                        found = true;
                        System.out.println("Case type "+casetype+" added");
                        break;
                    }     
                }
                if(!found) System.out.println("Parent not found please try again!");
            }
            else casesType.add(casestype);
        }
        else System.out.println("Already have!");
    }

    public CasesType findCasesType(String casetype){
        for(int i=0; i < casesType.size(); i++){
            if(casetype.toLowerCase().equals(casesType.get(i).getName().toLowerCase()))
                return casesType.get(i);
        }
        return null;
    }

    public void deleteCasesType(String casetype){
        boolean found = false;
        for (int i = 0; i < casesType.size(); i++) {
            if(casesType.get(i).getName().toLowerCase().equals(casetype.toLowerCase()))
            {
                casesType.remove(i);
                for (int j = 0; j < casesType.size(); j++) {
                    if(casesType.get(j).getParent() != null)
                        if(casesType.get(j).getParent().getName().toLowerCase().equals(casetype.toLowerCase())){
                            casesType.get(j).setParent(null);
                        }
                }
                    
                break;
            }
        }
        if(!found) System.out.println("Case type not found");
    }

    public void editCasesType(String name, String rename){
        boolean found = false;
        for (int i = 0; i < casesType.size(); i++) {
            if(casesType.get(i).getName().toLowerCase().equals(name.toLowerCase()))
            {
                casesType.get(i).setName(rename);
                for (int j = 0; j < casesType.size(); j++) {
                    if(casesType.get(j).getParent() != null)
                        if(casesType.get(j).getParent().getName().toLowerCase().equals(name.toLowerCase())){
                            casesType.get(j).getParent().setName(rename);;
                        }
                }
                found = true;    
                break;
            }
        }
        if(!found) System.out.println("Case type not found!");
    }
}