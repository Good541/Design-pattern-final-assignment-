class Cases
{
    private int id;
    private char gender;
    private int age;
    private String date;
    private String infectedFoundLocation;
    private int infectedfromid;
    private CasesType casestype;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInfectedFoundLocation() {
        return infectedFoundLocation;
    }

    public void setInfectedFoundLocation(String infectedFoundLocation) {
        this.infectedFoundLocation = infectedFoundLocation;
    }

    public int getInfectedfromid() {
        return infectedfromid;
    }

    public void setInfectedfromid(int infectedfromid) {
        this.infectedfromid = infectedfromid;
    }

    public CasesType getCasestype() {
        return casestype;
    }

    public void setCasestype(CasesType casestype) {
        this.casestype = casestype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Cases(int id, char gender, int age, String date, String infectedFoundLocation, int infectedfromid,
            CasesType casestype, String description) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.infectedFoundLocation = infectedFoundLocation;
        this.infectedfromid = infectedfromid;
        this.casestype = casestype;
        this.description = description;
    }

    
}