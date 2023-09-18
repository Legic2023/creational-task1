public class PersonBuilder implements PersonBuilderInterface {

    protected String name; //Имя. С момента создания объекта изменить его нельзя.
    protected String surname; //Фамилия. C момента создания объекта изменить её нельзя.
    protected int age = 0; //Возраст. Если 0 - информация о возрасте не указывалась.
    protected String city = null; //Город.  Если null - город неизвестен.


    protected PersonBuilder() {
        this.name = null;
        this.surname = null;

    }

    protected PersonBuilder(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    protected PersonBuilder(String surname, String city, int age) {
        this.surname = surname;
        this.city = city;
        this.age = age;
    }


    @Override
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        int i = 0;

// Возраст недопустимый
        try {
            if (age > 0 && age < 100) {
                i = age;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Ошибка. Возраст выходит за рамки допустимого (0... 100)");
        }

        this.age = i;
        return this;
    }

    @Override
    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    @Override
    public Person build() {
        Person person = null;
// Не хватает обязательных полей
        try {
            if (this.name == null || this.surname == null) {
                throw new IllegalStateException();
            } else {
                person = new Person(this);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.println("Ошибка. Не заданы обязательные поля: \"Имя\" или \"Фамилия\"");
        }
        return person;
    }
}
