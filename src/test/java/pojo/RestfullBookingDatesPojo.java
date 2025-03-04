package pojo;

public class RestfullBookingDatesPojo {
    /*
    "bookingdates": {
        "checkin": "2021-06-01",
                "checkout": "2021-06-10"

     */
    //1 tum variablelar private olarak olusturulur
    private String checkin;
    private String checkout;
    //2 bu variablelar için getter setter methodları olsuturulur
    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    // 3- parametreli constructor olustur


    public RestfullBookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
    //4- parametresiz constructor olustur

    public RestfullBookingDatesPojo() {
    }

    //5- toString methodu uygula

    @Override
    public String toString() {
        return "RestfullBookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}

