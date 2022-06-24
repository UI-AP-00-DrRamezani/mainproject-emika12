package saleing;

import java.time.LocalDate;
import java.util.Date;

public interface IDiscountFeature
{
    Sale addDiscount(int capacity, LocalDate localDate);
    String makeDiscountCode();
    Sale aDDDiscountNoCode(LocalDate localDate );
}
