package ex0;

import java.io.Serializable;
/* Ex3_Member
implements Serializable : ����ȭ ����� �Ǵ� ��ü���� ����!
*/
public class Ex3_Member implements Serializable{
    private String id;
    /*transient : ����ȭ���� ���ܵ� */
    transient private String pwd;
    private String name;
    private int age,pay;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }
    
}
