public class BookManager {
    private final int MAX_SIZE = 100;
    private Book[] books = new Book[MAX_SIZE];
    private static int size;
    private Book searchedBook;

    public void add(Book book) {
        books[size++] = book;
    }
    public void remove(String isbn) {
        Book[] newBooks = new Book[MAX_SIZE];
        int count = 0;
        for (int i =0 ; i < size ; i++){
            if (!books[i].getIsbn().equals(isbn)) {
                newBooks[count] = books[i];
                count++;
            }
        }
        books = newBooks;
    }

    public Book searchByIsbn(String isbn) {
        for (int i = 0 ; i < size ; i++){
            if (books[i].getIsbn().equals(isbn))
                searchedBook = books[i];
        }
        return searchedBook;
    }

    public Book[] getList() {
        return books;
    }

}
