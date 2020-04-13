public class PriceCalculator implements Runnable {
    private Invoice invoice;        //variabel privat untuk faktur, diambil dari kelas Invoice

    /**
     * Constructor untuk kelas PriceCalculator
     * @param invoice Faktur yang ingin dihitung total harganya
     */
    public PriceCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Method untuk menjalankan perhitungan harga total dari faktur
     */
    @Override
    public void run() {
        System.out.println("Calculating Invoice ID: " + invoice.getId());
        invoice.setTotalPrice();
        System.out.println("Finish calculating Invoice ID: " + invoice.getId());
    }
}