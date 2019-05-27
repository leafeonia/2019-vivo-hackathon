package advertisingspaceforrent.demo.vo;

public class CategoryVO {

    private Integer id;
    private String name;
    private Integer languageId;
    private Integer isFinish;

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

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getFinish() {
        return isFinish;
    }

    public void setFinish(Integer finish) {
        isFinish = finish;
    }
}
