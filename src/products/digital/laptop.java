package products.digital;

public class laptop extends digitalProduct
{
    private String processor_Model;
    private boolean for_Gaming;

    public laptop()
    {
        setEarmark(getEarmarkMaker()+1);
        setEarmarkMaker(getEarmarkMaker()+1);
        setCategory_model("digitalProduct_laptop");
    }

    @Override
    public String myToString3()
    {
        return processor_Model+"\n"+for_Gaming+"\n";
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

        setRam_space(Integer.parseInt(info[7]));
        setMemory(Integer.parseInt(info[8]));
        setOperating_System(info[9]);
        setResolution(info[10]);
        setGuaranteeTime(Integer.parseInt(info[11]));
        setGuaranteeValue(Double.valueOf(info[12]));

        setProcessor_Model(info[13]);
        setFor_Gaming(Boolean.parseBoolean(info[14]));
        setAddress(info[15]);
        setAddress2(info[16]);
        setDeleted_product(Boolean.parseBoolean(info[17]));
        setStar(Integer.parseInt(info[18]));
    }

    @Override
    public double discountAmount() {
        return 0.3;
    }

    @Override
    public double discountAmount2() {
        return 0.2;
    }

    @Override
    public String partOfDiscountCode() {
        return "lap";
    }

    public String getProcessor_Model() {
        return processor_Model;
    }

    public boolean getFor_Gaming() {
        return for_Gaming;
    }

    public void setProcessor_Model(String processor_Model) {
        this.processor_Model = processor_Model;
    }

    public void setFor_Gaming(boolean for_Gaming) {
        this.for_Gaming = for_Gaming;
    }
}


