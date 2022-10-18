public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String city;

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder age(Integer age) {
        this.age = age;
        return this;
    }

    public PersonBuilder city(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null && surname == null) {
            throw new IllegalStateException("ИМЯ И ФАМИЛИЯ ОБЯЗАТЕЛЬНЫ!");
        } else if (name == null) {
            throw new IllegalStateException("ИМЯ ОБЯЗАТЕЛЬНО!");
        } else if (surname == null) {
            throw new IllegalStateException("ФАМИЛИЯ ОБЯЗАТЕЛЬНА!");
        }

        if (age != null && age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным числом!");
        }
        return new Person(name, surname, age, city);
    }
}