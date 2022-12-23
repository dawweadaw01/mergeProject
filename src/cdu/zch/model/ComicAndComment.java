package cdu.zch.model;

import java.util.List;

public class ComicAndComment {
    private Comic comic;
    private List<Comment> comments;

    public ComicAndComment() {
    }

    @Override
    public String toString() {
        return "ComicAndComment{" +
                "comic=" + comic +
                ", comments=" + comments +
                '}';
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public ComicAndComment(Comic comic, List<Comment> comments) {
        this.comic = comic;
        this.comments = comments;
    }
}
