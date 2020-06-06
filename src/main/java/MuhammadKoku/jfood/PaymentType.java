package MuhammadKoku.jfood;

public enum PaymentType
{
    Cashless("Cashless"),
    Cash("Cash");

    private String payment;
    PaymentType(String payment)
    {
        this.payment = payment;
    }

    public String toString()
    {
        return this.payment;
    }

}
