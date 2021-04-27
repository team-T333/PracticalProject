
public class book {

    Integer id;  //book的id

    String name; //book名字


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public book() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
