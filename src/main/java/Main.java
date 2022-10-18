public class Main {
    public static void main(String[] args) {

        // создание объекта через билдер;
        Person mom = new PersonBuilder()
                .name("Анна")
                .surname("Вольф")
                .age(31)
                .city("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .name("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        // Не хватает обязательных полей
        try {
            new PersonBuilder() // у взрослого;
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            mom.newChildBuilder() // у ребёнка;
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // Возраст недопустимый;
        try {
            new PersonBuilder()
                    .name("Ольга")
                    .surname("Вольф")
                    .age(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}