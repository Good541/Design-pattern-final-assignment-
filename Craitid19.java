import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Craitid19{
    static CasesTypeDataManager casesTypeDataManager;
    static CasesDataManager casesDataManager;

    public static void main(String[] args) {
        casesTypeDataManager = new CasesTypeDataManager();
        casesDataManager = new CasesDataManager();
        printAllCases();
        System.out.println("-------------------------------------------");
        printAllCasesType();
        System.out.println("-------------------------------------------");
        renameCasesTypeFromCases(1, "Thailan");
        printAllCases();
        System.out.println("-------------------------------------------");
        renameCasesTypeFromCases(8, "Asia");
        printAllCases();
        System.out.println("-------------------------------------------");
        System.out.println("Find all relation from 1");
        findFromInfectedFromId(1, true);
        System.out.println("-------------------------------------------");
        findCasesFromCasesType("Asia", true);
        System.out.println("-------------------------------------------");
        findCasesFromCasesType("Thailand", true);
        System.out.println("-------------------------------------------");
        editCasesType("Thailand", "xxxxxxxx");
        printAllCases();
        System.out.println("-------------------------------------------");
        casesTypeDataManager.setCasesType("Korea", "Asia");
        printAllCasesType();
        System.out.println("-------------------------------------------");
        casesTypeDataManager.setCasesType("Europe", null);
        printAllCasesType();
        System.out.println("-------------------------------------------");
        editCases(8, 'F', 24, "23/5/2030", "Chonburi", 7, "Europe", "description");
        printAllCases();
        System.out.println("-------------------------------------------");
        System.out.println("Find all relation from 2");
        findFromInfectedFromId(2, true);
        System.out.println("-------------------------------------------");
        editCasesType("xxxxxxxx", "Thailand");
        printAllCases();
        boolean exit = false;
        while(!exit)
        {
            System.out.println("-------------------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.println("Select menu");
            System.out.println("1. Print all cases");
            System.out.println("2. Print all cases type");
            System.out.println("3. Show all infected case from id");
            System.out.println("4. Show all child from cases type");
            System.out.println("5. Edit case");
            System.out.println("6. Edit case type");
            System.out.println("7. Add case");
            System.out.println("8. Add case type");
            System.out.println("99. Exit");
            System.out.print("Enter menu: ");
            int menu = sc.nextInt();
            switch(menu){
                case 1:
                printAllCases();
                break;

                case 2:
                printAllCasesType();
                break;

                case 3:
                System.out.print("Enter id: ");
                int id = sc.nextInt();
                System.out.print("Do you want to find child? y/n: ");
                String childid = sc.next();
                boolean findchild = false;
                if(childid.toLowerCase().equals("y")) findchild = true;  
                else if(childid.toLowerCase().equals("n")) findchild = false;
                findFromInfectedFromId(id, findchild);
                break;

                case 4:
                System.out.print("Enter case type name: ");
                String name = sc.next();
                System.out.print("Do you want to find child? y/n: ");
                String childname = sc.next();
                boolean findchildname = false;
                if(childname.toLowerCase().equals("y")) findchildname = true;  
                else if(childname.toLowerCase().equals("n")) findchildname = false;
                findCasesFromCasesType(name, findchildname);
                break;

                case 5:
                System.out.print("Enter id: ");
                int findid = sc.nextInt();
                System.out.print("Enter new gender (F/M): ");
                String gender = sc.next();
                System.out.print("Enter new age: ");
                int age = sc.nextInt();
                System.out.print("Enter new date: ");
                String date = sc.next();
                System.out.print("Enter new location: ");
                String infectedFoundLocation = sc.next();
                System.out.print("Enter new infected from id (If remove, type \"0\"): ");
                int infectedfromid = sc.nextInt();
                System.out.print("Enter new case type name (If remove, type \"null\"): ");
                String casetypename = sc.next();
                System.out.print("Enter new description: ");
                String description = sc.next();
                if(infectedfromid == 0) infectedfromid = 0;
                if(casetypename.equals("null")) casetypename = null;
                editCases(findid, gender.charAt(0), age, date, infectedFoundLocation, infectedfromid, casetypename, description);
                break;

                case 6:
                System.out.print("Enter case type name: ");
                String casetype = sc.next();
                System.out.print("Enter parent name (If remove, type \"null\"): ");
                String parent = sc.next();
                if(parent.equals("null")) parent = null;
                casesTypeDataManager.setCasesType(casetype, parent);
                break;

                case 7:
                System.out.print("Enter id: ");
                int addid = sc.nextInt();
                System.out.print("Enter new gender (F/M): ");
                String addgender = sc.next();
                System.out.print("Enter new age: ");
                int addage = sc.nextInt();
                System.out.print("Enter new date: ");
                String adddate = sc.next();
                System.out.print("Enter new location: ");
                String addinfectedFoundLocation = sc.next();
                System.out.print("Enter new infected from id (If don't have, type \"0\"): ");
                int addinfectedfromid = sc.nextInt();
                System.out.print("Enter new case type name (If don't have, type \"null\"): ");
                String addcasestype = sc.next();
                System.out.print("Enter new description: ");
                String adddescription = sc.next();
                if(addinfectedfromid == 0) addinfectedfromid = 0;
                if(addcasestype.equals("null")) addcasestype = null;
                addCase(addid, addgender.charAt(0), addage, adddate, addinfectedFoundLocation, addinfectedfromid, addcasestype, adddescription);
                break;

                case 8:
                System.out.print("Enter case type name: ");
                String addcasetype = sc.next();
                System.out.print("Enter parent name (If remove, type \"null\"): ");
                String addparent = sc.next();
                if(addparent.equals("null")) parent = null;
                casesTypeDataManager.editCasesType(addcasetype, addparent);
                break;

                case 99:
                exit = true;
                break;
            }
        }
    }

    public static void printAllCases()
    {
        for(int i = 0; i < casesDataManager.getAllCases().size(); i++)
        {
            String casetypetemp = "";
            String parentcasetypetemp = "";
            if(casesDataManager.getAllCases().get(i).getCasestype() == null){
                casetypetemp = "no case type";
            }
            else if(casesDataManager.getAllCases().get(i).getCasestype().getParent() == null){
                casetypetemp = casesDataManager.getAllCases().get(i).getCasestype().getName();
                parentcasetypetemp = "no case type";

            }   
            else 
            {
                casetypetemp = casesDataManager.getAllCases().get(i).getCasestype().getName();
                parentcasetypetemp = casesDataManager.getAllCases().get(i).getCasestype().getParent().getName();
            }

            System.out.println("id: "+casesDataManager.getAllCases().get(i).getId()+
            "   Gender: "+casesDataManager.getAllCases().get(i).getGender()+
            "   Age: "+casesDataManager.getAllCases().get(i).getAge()+
            "   Infected found location: "+casesDataManager.getAllCases().get(i).getInfectedFoundLocation()+
            "   Date: "+casesDataManager.getAllCases().get(i).getDate()+
            "   Infected from id: "+casesDataManager.getAllCases().get(i).getInfectedfromid()+
            "   Parent case type: "+parentcasetypetemp+
            "   Case Type: "+casetypetemp+
            "   Description: "+casesDataManager.getAllCases().get(i).getDescription());
        }
    }

    public static void printAllCasesType(){

        for(int i = 0; i < casesTypeDataManager.getAllCasesType().size(); i++)
        {
            String parent = "";
            if(casesTypeDataManager.getAllCasesType().get(i).getParent() == null) parent = "no case type";
            else parent = casesTypeDataManager.getAllCasesType().get(i).getParent().getName();
            System.out.println(casesTypeDataManager.getAllCasesType().get(i).getName()+"    Parent: "+parent);
        }
    }

    public static void renameCasesTypeFromCases(int id, String casestype){
        System.out.println("Rename case type name "+casestype+" from "+id);
        if(casesTypeDataManager.findCasesType(casestype) != null){
            casesDataManager.setCasesTypeFromCases(id, casesTypeDataManager.findCasesType(casestype));
        }
        else System.out.println("Case type not found!");
            
    }

    public static void findFromInfectedFromId(int id, boolean findchild){
        //System.out.println("Find all relation from "+id);
        for (Cases casefor : casesDataManager.getAllCases()) {
            if(casefor.getInfectedfromid() == id){
                System.out.println(id+" --> "+casefor.getId());
                String casetypetemp = "";
                if(casefor.getCasestype() == null)
                    casetypetemp = "no case type";
                else casetypetemp = casefor.getCasestype().getName();
                System.out.println("id: "+casefor.getId()+
                "   Gender: "+casefor.getGender()+
                "   Age: "+casefor.getAge()+
                "   Infected found location: "+casefor.getInfectedFoundLocation()+
                "   Date: "+casefor.getDate()+
                "   Infected from id: "+casefor.getInfectedfromid()+
                "   Case Type: "+casetypetemp+
                "   Description: "+casefor.getDescription());
                if(findchild)
                    findFromInfectedFromId(casefor.getId(), true);
            }
        }   
    }

    public static void findCasesFromCasesType(String name, boolean findchild){
        System.out.println("Find all relation from "+name);
        boolean found = false;
        for(CasesType casetype: casesTypeDataManager.getAllCasesType())
        {
            if(casetype.getName().toLowerCase().equals(name.toLowerCase()))
            {
                for (Cases casefor : casesDataManager.getAllCases()) 
                {
                    if(casefor.getCasestype().getName().toLowerCase().equals(name.toLowerCase()))
                    {
                        //System.out.println(name+" --> "+casefor.getId());
                        String casetypetemp = "";
                        if(casefor.getCasestype() == null)
                            casetypetemp = "no case type";
                        else casetypetemp = casefor.getCasestype().getName();
                        System.out.println("id: "+casefor.getId()+
                        "   Gender: "+casefor.getGender()+
                        "   Age: "+casefor.getAge()+
                        "   Infected found location: "+casefor.getInfectedFoundLocation()+
                        "   Date: "+casefor.getDate()+
                        "   Infected from id: "+casefor.getInfectedfromid()+
                        "   Case Type: "+casetypetemp+
                        "   Description: "+casefor.getDescription());
                    }
                }
                found = true;
                break;
            }
        }
        if(!found)
            System.out.println("Case type not found!");
        else if (findchild) findChildCasesFromCasesType(name);
    }

    public static void findChildCasesFromCasesType(String name){
        //System.out.println("Find all relation from "+name);
        List<CasesType> casesTypestemp = new ArrayList<>();
        for(CasesType casetype: casesTypeDataManager.getAllCasesType())
        {
            if(casetype.getParent() != null)
                if(casetype.getParent().getName().toLowerCase().equals(name.toLowerCase()))
                {
                    for (Cases casefor : casesDataManager.getAllCases()) 
                    {
                        if(casefor.getCasestype().getParent() != null)
                            if(casefor.getCasestype().getParent().getName().toLowerCase().equals(name.toLowerCase()))
                            {
                                //System.out.println(name+" --> "+casefor.getId());
                                String casetypetemp = "";
                                if(casefor.getCasestype() == null)
                                    casetypetemp = "no case type";
                                else casetypetemp = casefor.getCasestype().getName();
                                System.out.println("id: "+casefor.getId()+
                                "   Gender: "+casefor.getGender()+
                                "   Age: "+casefor.getAge()+
                                "   Infected found location: "+casefor.getInfectedFoundLocation()+
                                "   Date: "+casefor.getDate()+
                                "   Infected from id: "+casefor.getInfectedfromid()+
                                "   Case Type: "+casetypetemp+
                                "   Description: "+casefor.getDescription());
                                if(casesTypestemp.size() == 0) casesTypestemp.add(casefor.getCasestype());
                                else
                                {
                                    boolean have = false;
                                    for (CasesType casestypetemp : casesTypestemp) {
                                        if(casestypetemp.getName().equals(casefor.getCasestype().getName()))
                                        {
                                            have = true;
                                        }
                                    }
                                    if(!have) casesTypestemp.add(casefor.getCasestype());
                                }
                            }
                    }
                    break;
                }
        }
        if (casesTypestemp.size() > 0) 
        {
            for (CasesType casestypetemp : casesTypestemp) {
                findChildCasesFromCasesType(casestypetemp.getName());
            }
        }
    }

    public static void deleteCaseType(String name){
        casesTypeDataManager.deleteCasesType(name);
        casesDataManager.deleteCaseTypeFromCases(name);
    }

    public static void editCasesType(String name, String rename){
        System.out.println("Change "+name+" to "+rename);
        casesTypeDataManager.editCasesType(name, rename);
        casesDataManager.editCasesTypeFromCases(name, rename);
    }

    public static void editCases(int findid, char gender, int age, String date, String infectedFoundLocation, int infectedfromid, String casetypename, String description)
    {
        CasesType casestype = casesTypeDataManager.getCasesType(casetypename);
        if(casestype != null){
            casesDataManager.editCasesFromId(findid, gender, age, date, infectedFoundLocation, infectedfromid, casestype, description);
            System.out.println("Edit ID "+findid+" successful");
        }
        else System.out.println("Invalid data, please try again");
    }

    public static void addCase(int id, char gender, int age, String date, String infectedFoundLocation, int infectedfromid, String casesname, String description){
        CasesType casestype = casesTypeDataManager.findCasesType(casesname);
        if(casestype != null){
            System.out.println("Add case successful");
            casesDataManager.setCase(id, gender, age, date, infectedFoundLocation, infectedfromid, casestype, description);
        }
        else if(casesname == null){
            System.out.println("Add case successful");
            casesDataManager.setCase(id, gender, age, date, infectedFoundLocation, infectedfromid, null, description);
        }
        else System.out.println("Case type not found!");
    }
}