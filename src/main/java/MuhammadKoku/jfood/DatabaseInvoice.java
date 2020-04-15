package MuhammadKoku.jfood;

import java.util.ArrayList;
public class DatabaseInvoice
{
    // variabel yang digunakan dalam class
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId=0;

    public DatabaseInvoice() {

    }
    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;

    }

    public static int getLastId(){
        return lastId;
    }

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException {
        for(Invoice invoice : INVOICE_DATABASE) {
            if(invoice.getId() == id) {
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) throws CustomerNotFoundException {
        ArrayList<Invoice> value= new ArrayList<>();
        Customer customer = DatabaseCustomer.getCustomerById(customerId);
        for(Invoice invoiceDB1 : INVOICE_DATABASE)
        {
            if(invoiceDB1.getCustomer().getId()== customerId)
            {
                value.add(invoiceDB1);
            }
        }
        return value;

    }

    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        if (!INVOICE_DATABASE.stream().noneMatch((invoices) -> (invoices.getInvoiceStatus().equals(InvoiceStatus.Ongoing) && invoices.getCustomer().getId() == invoice.getCustomer().getId()))) {
            throw new OngoingInvoiceAlreadyExistsException(invoice);
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }





    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        for(Invoice invoice : INVOICE_DATABASE) {
            if(invoice.getId() == id && invoice.getInvoiceStatus() == InvoiceStatus.Ongoing) {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        for(Invoice invoice : INVOICE_DATABASE) {
            if(invoice.getId() == id) {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}