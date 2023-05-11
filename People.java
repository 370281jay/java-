public class People {
    private String name;
    private String phone;
    private String address;
    private String email;


//创建一个新的通讯人对象
    public People(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    //创建空的通讯人对象
    public People(){

    }
//封装方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
