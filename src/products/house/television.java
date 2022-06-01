package products.house;

public class television extends houseProducts
{
    private String pic_Quality;
    private int windows_Size;

    public television()
    {
        setEarmark(getEarmarkMaker()+1);
        setEarmarkMaker(getEarmarkMaker()+1);
        setCategory_model("houseProducts_television");
        this.setGuaranteeTime(calculateGuarantee());
        this.setGuaranteeValue(calculateGuaranteeValue());
    }

    public String myToString3()
    {
        return pic_Quality+"\n"+windows_Size+"\n";
    }

    public String toString2()
    {
        return "picture quality: "+pic_Quality+"\nwindows size: "+windows_Size;
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

        setPic_Quality(info[11]);
        setWindows_Size(Integer.parseInt(info[12]));

        setAddress(info[13]);
        setAddress2(info[14]);
        setDeleted_product(Boolean.parseBoolean(info[15]));
        setStar(Integer.parseInt(info[16]));

    }

    public int calculateGuarantee()
    {
        return this.windows_Size*10;
    }

    public String getPic_Quality() {
        return pic_Quality;
    }

    public int getWindows_Size() {
        return windows_Size;
    }

    public void setPic_Quality(String pic_Quality) {
        this.pic_Quality = pic_Quality;
    }

    public void setWindows_Size(int windows_Size) {
        this.windows_Size = windows_Size;
    }
}


