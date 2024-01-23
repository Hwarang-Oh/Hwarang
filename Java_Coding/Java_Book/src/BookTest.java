public class BookTest {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();

        Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr",
                15000, "Java 기본 문법");
        Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr",
                25000, "Java 응용");
        Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr",
                30000, "SW 모델링");

        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
        bookManager.add(b1);
        bookManager.add(b2);
        bookManager.add(b3);

        System.out.println(bookManager.searchByIsbn("21424").toString());
        bookManager.remove("21424");

        for (Book eachBook : bookManager.getList()) {
            if (eachBook != null)
                System.out.println(eachBook.toString());
        }
    }
}
