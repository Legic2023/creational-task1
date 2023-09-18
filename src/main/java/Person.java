import java.util.OptionalInt;

public class Person {

    private final String name; //Имя. С момента создания объекта изменить его нельзя.
    private final String surname; //Фамилия. C момента создания объекта изменить её нельзя.
    private int age = 0; //Возраст. Если 0 - информация о возрасте не указывалась.
    private String city = null; //Город.  Если null - город неизвестен.


    protected Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.city = personBuilder.city;

    }


    // Геттеры для доступа к полям класса
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }


    //  Методы класса
    boolean hasAge() {
        return (this.age != 0);
    }

    void happyBirthday() {
        if (hasAge()) {
            if (++this.age >= 100) {
                System.out.printf("В таком возрасте день рождения не празднуют: %s лет%n", this.age);
                this.age = 0;
            }
        } else {
            System.out.println("Возраст человека не задан!");
        }
    }

    boolean hasAddress() {
        return (this.city != null);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(getSurname(), getCity(), 1);
    }

    @Override
    public String toString() {
        String s1, s2;
        if (this.age == 0) {
            s1 = "не указан";
        } else {
            s1 = Integer.toString(this.age);
        }
        if (this.city == null) {
            s2 = "не указан";
        } else {
            s2 = this.city;
        }
        return String.format(
                "%s %s (возраст: %s, адрес: %s)",
                this.name, this.surname, s1, s2);

    }
}
