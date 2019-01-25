package nl.bsoft.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XpayToPayDAdapter implements PayD {
    private static final Logger logger = LoggerFactory.getLogger(XpayToPayDAdapter.class);

    private final Xpay xpay;
    private String custCardNo;
    private String cardOwnerName;
    private String cardExpMonthDate;
    private Integer cVVNo;
    private Double totalAmount;

    public XpayToPayDAdapter(Xpay xpay) {
        this.xpay = xpay;
        setProp();
    }

    @Override
    public String getCustCardNo() {
        return custCardNo;
    }

    @Override
    public void setCustCardNo(String custCardNo) {
        this.custCardNo = custCardNo;
        this.xpay.setCreditCardNo(custCardNo);
    }

    @Override
    public String getCardOwnerName() {
        return cardOwnerName;
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
        this.xpay.setCustomerName(cardOwnerName);
    }

    @Override
    public String getCardExpMonthDate() {
        return cardExpMonthDate;
    }

    @Override
    public void setCardExpMonthDate(String cardExpMonthDate) {
        this.cardExpMonthDate = cardExpMonthDate;

        String[] elements = cardExpMonthDate.split("/");
        String month = elements[0];
        String year = elements[1];

        this.xpay.setCardExpMonth(month);
        this.xpay.setCardExpYear(year);
    }

    @Override
    public Integer getCVVNo() {
        return cVVNo;
    }

    @Override
    public void setCVVNo(Integer cVVNo) {
        this.cVVNo = cVVNo;
        this.xpay.setCardCVVNo(cVVNo.shortValue());
    }

    @Override
    public Double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        this.xpay.setAmount(totalAmount);
    }

    private void setProp() {
        setCardOwnerName(this.xpay.getCustomerName());
        setCustCardNo(this.xpay.getCreditCardNo());
        setCardExpMonthDate(this.xpay.getCardExpMonth() + "/" + this.xpay.getCardExpYear());
        setCVVNo(this.xpay.getCardCVVNo().intValue());
        setTotalAmount(this.xpay.getAmount());
    }
}
