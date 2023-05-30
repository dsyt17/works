package pkg1lr;
 
class Serial implements Comparable<Serial> {
    private String title;
    private String director;
    private String genre;
    private String type;
    private int year;
 
      
    Serial(String title, String director, String genre, String type, int year) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.type = type;
        this.year = year;

    }
 
    int getYear() {
        return year;
    }
 
    String getTitle() {
        return title;
    }
 
    @Override
    public String toString() {
        return "Название: " + title + ", Режиссер: " + director +
                ", Жанр: " + genre + ", Тип: " + type + ", Год: " + year + "\n";
    }
 
    @Override
    public int compareTo(Serial Serial) {
        return year - Serial.getYear();
       
    }
}
