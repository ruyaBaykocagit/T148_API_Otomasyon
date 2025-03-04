package pojo;



public class PojoJPH {
/*
{
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
}
 */

//1- tüm variable lar private olarak olusturulur
    private String title;
    private String body;
    private int userId;
    private int id;
//2- tüm variabelar icin getter and setter olustur
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //3- tüm variableları içeren paramtreli constructur olustur

    public PojoJPH(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
//4- Default öldügü için parametresiz bir constructor ayarlanır
    public PojoJPH() {
    }
//5- Verileri yazdırma durumunda ihtiyac olursa diye toString methodu eklenir


    @Override
    public String toString() {
        return "PojoJPH{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
