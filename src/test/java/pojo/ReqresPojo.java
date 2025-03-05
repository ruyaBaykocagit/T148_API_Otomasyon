package pojo;

public class ReqresPojo {

    /*
    "name": "John Doe",
                 "job": "Manager"
     */

    private String name;
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReqresPojo(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public ReqresPojo() {
    }

    @Override
    public String toString() {
        return "ReqresPojo{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
