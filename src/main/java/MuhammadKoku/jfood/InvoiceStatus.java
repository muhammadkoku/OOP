package MuhammadKoku.jfood;
/**
 * Enumeration class InvoiceStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"),
    Finished("Finished"),
    Canceled("Cancelled");

    String status;

    InvoiceStatus(String status){
        this.status=status;
    }

    @Override
    public String toString(){
        return status;
    }
    
   
}
