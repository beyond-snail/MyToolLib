package lib.tool.com.tool_lib.views.apptwolistview.model;

import java.util.List;

/**
 * 一级分类，相当于左侧菜单
 * Created by hanj on 14-9-25.
 */
public class FirstClassItem {
    private long id;
    private String name;
    private String url;
    private List<SecondClassItem> secondList;

    public FirstClassItem(){

    }

    public FirstClassItem(long id, String name, String url, List<SecondClassItem> secondList) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.secondList = secondList;
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
    
    

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<SecondClassItem> getSecondList() {
        return secondList;
    }

    public void setSecondList(List<SecondClassItem> secondList) {
        this.secondList = secondList;
    }

	@Override
	public String toString() {
		return "FirstClassItem [id=" + id + ", name=" + name + ", url=" + url + ", secondList=" + secondList + "]";
	}

    
}
