package cdu.zch.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int id;
    private int comicId;
    private int userId;
    private User reviewer;
    private int otherId;
    private User reviewerTo;
    private String comment;
    private String time;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comicId=" + comicId +
                ", userId=" + userId +
                ", reviewer=" + reviewer +
                ", otherId=" + otherId +
                ", reviewerTo=" + reviewerTo +
                ", comment='" + comment + '\'' +
                ", time=" + time +
                '}';
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Comment(int id, int comicId, int userId, User reviewer, int otherId, User reviewerTo, String comment, String time) {
        this.id = id;
        this.comicId = comicId;
        this.userId = userId;
        this.reviewer = reviewer;
        this.otherId = otherId;
        this.reviewerTo = reviewerTo;
        this.comment = comment;
        this.time = time;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public int getOtherId() {
        return otherId;
    }

    public void setOtherId(int otherId) {
        this.otherId = otherId;
    }

    public User getReviewerTo() {
        return reviewerTo;
    }

    public void setReviewerTo(User reviewerTo) {
        this.reviewerTo = reviewerTo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
