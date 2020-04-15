package MuhammadKoku.jfood;

public class SellerNotFoundException extends Exception {
    private int seller_error;           //variabel privat untuk ID penjual yang error

    /**
     * Constructor untuk kelas Seller Exception
     * @param seller_input ID penjual yang error
     */
    public SellerNotFoundException(int seller_input) {
        super("Seller ID: ");
        this.seller_error = seller_input;
    }

    /**
     * Method untuk mengirimkan pesan apabila terjadi exception
     * @return super.getMessage() pesan yang dikirimkan
     */
    @Override
    public String getMessage() {
        return super.getMessage() + seller_error + " not found";
    }
}