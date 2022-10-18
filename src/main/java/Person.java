public class Person {
    private final String name;
    private final String surname;
    private Integer age;
    private String city;

    public Person(String name, String surname, Integer age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setAge(Integer age) {
        if (hasAge()) {
            throw new IllegalStateException("Возраст можно изменить через метод happyBirthday().");
        }
        this.age = age;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public boolean hasAge() {
        return age != null;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public boolean hasAddress() {
        return city != null;
    }

    // полузаполненный билдер для ребёнка с родительскими данными;
    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .surname(surname)
                .city(city);
    }

    @Override
    public String toString() {
        return name + " " + surname + " "
                + (hasAge() ? age : "НЕТ ДАННЫХ") + " "
                + (hasAddress() ? city : "НЕТ ДАННЫХ");
    }
}