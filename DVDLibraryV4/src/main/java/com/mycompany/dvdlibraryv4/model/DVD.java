package com.mycompany.dvdlibraryv4.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class DVD {

    public DVD() {

    }

    private int id;

    @NotEmpty(message = "You must supply a value for title.")
    @Length(max = 50, message = "First Name must be no more than 50 characters in length.")
    private String title;
    @NotEmpty(message = "You must supply a value for release date.")
    @Length(max = 10, message = "First Name must be no more than 50 characters in length.")
    private String releaseDate;
    @NotEmpty(message = "You must supply a value for the MPAA rating.")
    @Length(max = 10, message = "First Name must be no more than 50 characters in length.")
    private String mpaaRating;
    
    @NotEmpty(message = "You must supply a value for the director.")
    @Length(max = 50, message = "First Name must be no more than 50 characters in length.")
    private String director;

    @NotEmpty(message = "You must supply a value for the studio.")
    @Length(max = 50, message = "First Name must be no more than 50 characters in length.")
    private String studio;

    private String note;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.releaseDate);
        hash = 37 * hash + Objects.hashCode(this.mpaaRating);
        hash = 37 * hash + Objects.hashCode(this.director);
        hash = 37 * hash + Objects.hashCode(this.studio);
        hash = 37 * hash + Objects.hashCode(this.note);
        return hash;
    }

    @Override
    public String toString() {
        return "DVD{" + "id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", mpaaRating=" + mpaaRating + ", director=" + director + ", studio=" + studio + ", note=" + note + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
