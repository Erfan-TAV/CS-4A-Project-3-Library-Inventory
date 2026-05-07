package items;

public class Movie extends Item{
    private String title;
    private String director;
    private String[] mainActors;

    Movie() {
        super();
        this.title = "";
        this.director = "";
        this.mainActors = new String[0];
    }
    Movie(String name, String description, int id,  String title, String director, String[] mainActors) {
        super(name, description, id);
        this.title = title;
        this.director = director;
        this.mainActors = mainActors;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getMainActors() {
        return mainActors;
    }
    public void setMainActors(String[] mainActors) {
        this.mainActors = mainActors;
    }

    @Override
    public String toString() {
        String actorsList = String.join(", ", mainActors);
        return super.toString() +
                "\nTitle: " + title +
                "\nDirector: " + director +
                "\nMain Actors: " + actorsList;
    }
}