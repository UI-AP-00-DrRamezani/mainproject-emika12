package products.outfit;

public class dressing extends outfit
{
    private String size;
    private DressModel model;


    public dressing()
    {
        setEarmark(getEarmarkMaker()+1);
        setEarmarkMaker(getEarmarkMaker()+1);
        setCategory_model("outfit_dressing");
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

        setMade_In(info[7]);
        setMaterial(info[8]);

        setSize(info[9]);
        setModel(DressModel.valueOf(info[10]));

        setAddress(info[11]);
        setAddress2(info[12]);
        setDeleted_product(Boolean.parseBoolean(info[13]));
        setStar(Integer.parseInt(info[14]));
    }

    public String myToString3()
    {
        return size+"\n"+model+"\n";
    }

    public String toString2()
    {
        return "made in: "+getMade_In()+"\nmaterial: "+getMaterial()+"\nsize: "+size+"\nmodel: "+model;
    }


    //---------------------------------------
    @Override
    public double discountAmount() {
        return 0.5;
    }

    @Override
    public double discountAmount2() {
        return 0.4;
    }

    @Override
    public String partOfDiscountCode() {
        return "dre";
    }

    public String getSize() {
        return size;
    }

    public DressModel getModel() {
        return model;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setModel(DressModel model) {
        this.model = model;
    }
}
