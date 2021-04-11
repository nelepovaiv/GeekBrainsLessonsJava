import ru.geekbrains.nelepovaiv.homework.Employee;

public class HomeWorkApp {


       /*
        1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
        2. Конструктор класса должен заполнять эти поля при создании объекта.
        3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
        4. Создать массив из 5 сотрудников.
            Пример:
            Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
            persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
            persArray[1] = new Person(...);
            ...
            persArray[4] = new Person(...);
        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
     */


    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Petrov Ivan","Developer","petrovi@mail.com","+7-999-123-45-67",100000,23);
        employees[1] = new Employee("Sidorov Petya","Developer","sidorovp@mail.com","+7-999-123-45-67",150000,43);
        employees[2] = new Employee("Smirnova Svetlana","Developer","smirnovas@mail.com","+7-999-123-45-67",120000,30);
        employees[3] = new Employee("Nelepova Inna","Tester","nelepovai@mail.com","+7-999-123-45-67",100000,25);
        employees[4] = new Employee("Matroskin Kot","Release manager","matroskink@mail.com","+7-999-123-45-67",100000,44);

        for (Employee oneEmployee : employees) {
            if (oneEmployee.getAge()>40) {
                System.out.println(oneEmployee.toString());
            }
        }
    }
}

