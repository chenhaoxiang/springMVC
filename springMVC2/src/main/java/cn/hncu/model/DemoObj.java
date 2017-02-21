package cn.hncu.model;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2017/2/20.
 * Time: 下午 8:59.
 * Explain:此类用于演示获取request对象参数和返回此对象到response
 */
public class DemoObj {
    private Long id;
    private String name;

    public DemoObj() {
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
