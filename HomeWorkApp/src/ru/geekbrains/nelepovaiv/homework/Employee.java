package ru.geekbrains.nelepovaiv.homework;

public class Employee {

    //ФИО
    private String fio;
    //Должность
    private String job;
    //Email
    private String email;
    //Телефон
    private String phone;
    //Зарплата
    private Integer salary;
    //Возраст
    private Integer age;

    public Employee(String fio, String job, String email, String phone, Integer salary, Integer age) {
        this.fio = fio;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Eployee{" +
                "fio='" + fio + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
