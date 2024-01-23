public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String desc;

    static {
        StringBuilder SB = new StringBuilder();
        for (int i = 0 ; i < 40 ; i++){
            if (i == 20)
                SB.append("도서목록");
            SB.append("*");
        }
        System.out.println(SB);
    }
    public Book(){};
    public Book(String isbn, String title, String author, String publisher, int price, String desc) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.desc = desc;
    }
    public String toString(){
        return isbn + "\t| " + title + "\t\t| " + title + "\t| " + publisher +
                "\t\t| " + price + "\t| " + desc;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getIsbn() {return isbn;}
    public void setIsbn(String isbn) {this.isbn = isbn;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public String getPublisher() {return publisher;}
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}
    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}
}
