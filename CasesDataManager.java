import java.util.ArrayList;
import java.util.List;

class CasesDataManager
{
    private List<Cases> cases;

    CasesDataManager() {
        cases = new ArrayList<>();
        
        Cases case1 = new Cases(1, 'F', 20, "11/12/2029", "Chonburi", 0, null, "description");
        Cases case2 = new Cases(2, 'M', 23, "12/1/2030", "Bangkok", 0, null, "description");
        Cases case3 = new Cases(3, 'M', 30, "9/2/2030", "Loei", 1, null, "description");
        Cases case4 = new Cases(4, 'F', 40, "14/3/2030", "Phuket", 2, null, "description");
        Cases case5 = new Cases(5, 'F', 40, "1/4/2030", "Bangkok", 1, null, "description");
        Cases case6 = new Cases(6, 'M', 40, "4/5/2030", "Loei", 3, null, "description");
        Cases case7 = new Cases(7, 'F', 40, "14/5/2030", "Chonburi", 2, null, "description");
        Cases case8 = new Cases(8, 'M', 40, "15/5/2030", "Chiangmai", 2, null, "description");

        CasesTypeDataManager casesTypeDataManager = new CasesTypeDataManager();
        case1.setCasestype(casesTypeDataManager.getCasesType("Asia"));
        case2.setCasestype(casesTypeDataManager.getCasesType("Thailand"));
        case3.setCasestype(casesTypeDataManager.getCasesType("Thailand"));
        case4.setCasestype(casesTypeDataManager.getCasesType("Tokyo"));
        case5.setCasestype(casesTypeDataManager.getCasesType("China"));
        case6.setCasestype(casesTypeDataManager.getCasesType("Bangkok"));
        case7.setCasestype(casesTypeDataManager.getCasesType("Japan"));
        case8.setCasestype(casesTypeDataManager.getCasesType("Japan"));

        cases.add(case1);
        cases.add(case2);
        cases.add(case3);
        cases.add(case4);
        cases.add(case5);
        cases.add(case6);
        cases.add(case7);
        cases.add(case8); 
    }

    public List<Cases> getAllCases(){
        return cases;
    }

    public Cases findCases(int id){
        for(int i=0; i < cases.size(); i++){
            if(id == cases.get(i).getId())
                return cases.get(i);
        }
        return null;
    }

    public void deleteCases(int id){
        boolean found = false;
        for(int i=0; i < cases.size(); i++){
            if(id == cases.get(i).getId()){
                cases.remove(i);
                found = true;
                break;
            }
                
        }
        if(!found) System.out.println("Case not found");
    }

    public void setCasesTypeFromCases(int id, CasesType casetype){
        boolean found = false;
        for(int i=0; i < cases.size(); i++){
            if(id == cases.get(i).getId()){
                cases.get(i).setCasestype(casetype);
                found = true;
                break;
            } 
        }
        if(!found) System.out.println("Case not found");
    }

    public void deleteCaseTypeFromCases(String casestype){
        boolean found = false;
        for(int i = 0; i < cases.size(); i++)
        {
            if(casestype.toLowerCase().equals(cases.get(i).getCasestype().getName().toLowerCase()))
            {
                cases.get(i).setCasestype(null);
            }
            if(cases.get(i).getCasestype() != null){
                if(cases.get(i).getCasestype().getParent() != null)
                    if(casestype.toLowerCase().equals(cases.get(i).getCasestype().getParent().getName().toLowerCase()))
                    {
                        cases.get(i).getCasestype().setParent(null);
                    }
            }
                
        }
        if(!found) System.out.println("Case type not found");
    }

    public void editCasesTypeFromCases(String name, String rename){
        for(int i = 0; i < cases.size(); i++)
        {
            
            if(cases.get(i).getCasestype() != null){
                if(name.toLowerCase().equals(cases.get(i).getCasestype().getName().toLowerCase()))
                {
                    cases.get(i).getCasestype().setName(rename);;
                }
                if(cases.get(i).getCasestype().getParent() != null)
                    if(name.toLowerCase().equals(cases.get(i).getCasestype().getParent().getName().toLowerCase()))
                    {
                        cases.get(i).getCasestype().getParent().setName(rename);;
                    }
            }
                
        }
    }

    public void editCasesFromId(int findid, char gender, int age, String date, String infectedFoundLocation, int infectedfromid, CasesType casestype, String description)
    {
        boolean found = false;
        for(int i = 0; i < cases.size(); i++)
        {
            if(findid == cases.get(i).getId())
            {
                cases.get(i).setGender(gender);
                cases.get(i).setAge(age);
                cases.get(i).setCasestype(casestype);
                cases.get(i).setDate(date);
                cases.get(i).setInfectedFoundLocation(infectedFoundLocation);
                cases.get(i).setInfectedfromid(infectedfromid);
                cases.get(i).setDescription(description);
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Case not found!");
    }

    public void setCase(int id, char gender, int age, String date, String infectedFoundLocation, int infectedfromid, CasesType casestype, String description){
        cases.add(new Cases(id, gender, age, date, infectedFoundLocation, infectedfromid, casestype, description));
    }
}