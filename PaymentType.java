

public enum PaymentType
{
    Cashless("Cashless"),
    Cash("Cash");
    
    private String typePayment;
    
    PaymentType(String typePayment){
        this.typePayment = typePayment;
    }
    
    private String typePayment(){
        return typePayment;
    }
    
   
}
