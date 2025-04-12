public class Book {
    private String name;
    private int pages;
    private String author;
    private boolean isRented;

    public Book(String name, int pages, String author, boolean isRented) {
        this.name = name;
        this.pages = pages;
        this.author = author;
        this.isRented = isRented;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setStatus(boolean isRented) {
        this.isRented = isRented;
    }

    public boolean getStatus() {
        return isRented;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.getName());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Number of Pages: " + this.getPages());
        System.out.println("Status: " + this.getStatus());
    }
    
}

