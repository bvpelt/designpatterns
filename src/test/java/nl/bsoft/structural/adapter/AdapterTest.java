package nl.bsoft.structural.adapter;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdapterTest {
    private static final Logger logger = LoggerFactory.getLogger(AdapterTest.class);

    @Rule
    public TestName name = new TestName();

    @Test
    public void testAdapter() {
        logger.info("Start test: {}", name.getMethodName());
        Xpay xpay = createXpay("4789565874102365", "Max Warner", "09", "25", (short) 235, 2565.23);

        String orgValue = xpay.toString();
        logger.info("Original value: {}", orgValue);
        PayD payD = new XpayToPayDAdapter(xpay);

        Assert.assertEquals(xpay.getCustomerName(), payD.getCardOwnerName());
        Assert.assertEquals(xpay.getCreditCardNo(), payD.getCustCardNo());
        Assert.assertEquals(xpay.getCardExpMonth() + "/" + xpay.getCardExpYear(), payD.getCardExpMonthDate());
        Assert.assertEquals((Integer) xpay.getCardCVVNo().intValue(), payD.getCVVNo());
        Assert.assertEquals(xpay.getAmount(), payD.getTotalAmount());

        String newValue = xpay.toString();
        logger.info("New      value: {}", newValue);
        Assert.assertEquals(orgValue, newValue);
        logger.info("End   test: {}", name.getMethodName());
    }

    private Xpay createXpay(String creditCardNo, String customerName, String cardExpMonth, String cardExpYear, Short cardCVVNo, Double amount) {
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo(creditCardNo);
        xpay.setCustomerName(customerName);
        xpay.setCardExpMonth(cardExpMonth);
        xpay.setCardExpYear(cardExpYear);
        xpay.setCardCVVNo(cardCVVNo);
        xpay.setAmount(amount);

        return xpay;
    }
}
