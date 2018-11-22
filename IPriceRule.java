package aa;

import java.util.*;

interface IPriceRule {
    boolean isMatch(OrderItem item);
    double calculatePrice(OrderItem item);
}

 



