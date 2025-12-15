class Movie {
    String title;
    String director;
    int year;

    Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " (" + year + ") - Dir: " + director;
    }
}


