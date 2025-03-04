package pojo;

public class RestfullExpBodyPojo {
  /*  "bookingid": 24,
            "booking": {
        "firstname": "Ahmet",
                "lastname": "Bulut",
                "totalprice": 500,
                "depositpaid": false,
                "bookingdates": {
            "checkin": "2021-06-01",
                    "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"*/

    private int bookingid;
    private RestfullReqBodyPojo booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public RestfullReqBodyPojo getBooking() {
        return booking;
    }

    public void setBooking(RestfullReqBodyPojo booking) {
        this.booking = booking;
    }

    public RestfullExpBodyPojo(int bookingid, RestfullReqBodyPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public RestfullExpBodyPojo() {
    }

    @Override
    public String toString() {
        return "RestfullExpBodyPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
