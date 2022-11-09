package com.firstcoding.firstapp.member;

// Beans : 모든 변수는 private, 기본생성자가 있어야 하고, getter/setter
// DTO, VO(Value object; getter만 가짐)
public class Member {
    private String id;
    private String pw;
    private String name;

    public Member() {
    }

    // makeList jsp 할 때 만든 생성자
    public Member(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 나중에 만든 메소드
    public String getInfo(){
        return this.id + "(" + this.name + ")";
    }


    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
