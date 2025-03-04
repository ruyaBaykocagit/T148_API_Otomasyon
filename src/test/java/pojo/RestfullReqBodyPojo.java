package pojo;

public class RestfullReqBodyPojo {
    /*
    "bookingid": 24,
    "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
     */

    // private yap variableları
    private String firstname;
    private String lastname;
    private int totalprice;
    private String additionalneeds;
    private boolean depositpaid;
    private RestfullBookingDatesPojo bookingdates;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public RestfullBookingDatesPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(RestfullBookingDatesPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public RestfullReqBodyPojo(String firstname, String lastname, int totalprice, String additionalneeds, boolean depositpaid, RestfullBookingDatesPojo bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.additionalneeds = additionalneeds;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }

    public RestfullReqBodyPojo() {
    }

    @Override
    public String toString() {
        return "RestfullReqBodyPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", additionalneeds='" + additionalneeds + '\'' +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                '}';
    }
}
