package products.outfit;

public class shoes extends outfit
{
    private int size;
    private ShoesModel model;

    public shoes()
    {
        setEarmark(getEarmarkMaker()+1);
        setEarmarkMaker(getEarmarkMaker()+1);
        setCategory_model("outfit_shoes");
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

        setSize(Integer.parseInt(info[9]));
        setModel(ShoesModel.valueOf(info[10]));

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

    @Override
    public double discountAmount() {
        return 0.45;
    }

    @Override
    public double discountAmount2() {
        return 0.22;
    }

    @Override
    public String partOfDiscountCode() {
        return "sho";
    }

    public int getSize() {
        return size;
    }

    public ShoesModel getModel() {
        return model;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setModel(ShoesModel model) {
        this.model = model;
    }
}
