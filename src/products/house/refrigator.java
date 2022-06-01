package products.house;

public class refrigator extends houseProducts
{
    private double storage;
    private String model;
    private boolean having_Freezer;


    public refrigator()
    {
        setEarmark(getEarmarkMaker()+1);
        setEarmarkMaker(getEarmarkMaker()+1);
        setCategory_model("houseProducts_refrigator");
    }

    public String myToString3()
    {
        return storage+"\n"+model+"\n"+having_Freezer+"\n";
    }


    @Override
    public void readingFromFile(String[] info) {
        setName(info[0]);
        setBrand(info[1]);
        setPrice(Integer.parseInt(info[2]));
        setInStock(Integer.parseInt(info[3]));
        setEarmark(Integer.parseInt(info[4]));
        setCategory_model(info[5]);
        setInfo(info[6]);

        setEnergy_Usage(Integer.parseInt(info[7]));
        setGarentie(Boolean.parseBoolean(info[8]));
        setGuaranteeTime(Integer.parseInt(info[9]));
        setGuaranteeValue(Double.parseDouble(info[10]));

        setStorage(Double.parseDouble(info[11]));
        setModel(info[12]);
        setHaving_Freezer(Boolean.parseBoolean(info[13]));

        setAddress(info[14]);
        setAddress2(info[15]);
        setDeleted_product(Boolean.parseBoolean(info[16]));
        setStar(Integer.parseInt(info[17]));
    }

    public void guaranteeCalculation()
    {
        if (getGarentie()==false)
        {
            this.setGuaranteeTime(0);
            this.setGuaranteeValue(0.0);
            return;
        }
        this.setGuaranteeTime(calculateGuarantee());
        this.setGuaranteeValue(calculateGuaranteeValue());
    }

    @Override
    public int calculateGuarantee()
    {
        return (int)(storage*10);
    }


    public String toString2()
    {
        return "storage: "+storage+"\nmodel: "+model+"\nhaving freezer: "+having_Freezer;
    }

    public double getStorage() {
        return storage;
    }

    public String getModel() {
        return model;
    }

    public boolean isHaving_Freezer() {
        return having_Freezer;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHaving_Freezer(boolean having_Freezer) {
        this.having_Freezer = having_Freezer;
    }
}