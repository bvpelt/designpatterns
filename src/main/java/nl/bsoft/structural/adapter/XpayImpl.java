package nl.bsoft.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XpayImpl implements Xpay {
    private static final Logger logger = LoggerFactory.getLogger(Xpay.class);

    private String creditCardNo;
    private String customerName;
    private String cardExpMonth;
    private String cardExpYear;
    private Short cardCVVNo;
    private Double amount;

    @Override
    public String getCreditCardNo() {
        return creditCardNo;
    }

    @Override
    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String getCardExpMonth() {
        return cardExpMonth;
    }

    @Override
    public void setCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }

    @Override
    public String getCardExpYear() {
        return cardExpYear;
    }

    @Override
    public void setCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
    }

    @Override
    public Short getCardCVVNo() {
        return cardCVVNo;
    }

    @Override
    public void setCardCVVNo(Short cardCVVNo) {
        this.cardCVVNo = cardCVVNo;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("CreditcardNumber: ");
        sb.append(this.creditCardNo);
        sb.append(" CustomerName: ");
        sb.append(this.customerName);
        sb.append(" Card expiry month: ");
        sb.append(this.cardExpMonth);
        sb.append(" Card expiry year: ");
        sb.append(this.cardExpYear);
        sb.append(" Card CVVNO: ");
        sb.append(this.cardCVVNo);
        sb.append(" Amount: ");
        sb.append(this.amount);

        return sb.toString();

    }
}
