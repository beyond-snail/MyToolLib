package lib.tool.com.tool_lib.views.apptwolistview.model;

/**
 * 二级分类，相当于右侧菜单
 * Created by hanj on 14-9-25.
 */
public class SecondClassItem {
    private long id;
    private String name;

    public SecondClassItem(){

    }

    public SecondClassItem(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SecondClassItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
