package com.buntunova1.buntunovanotebook;

/**
 * Created by sello on 2016/08/21. For creating the note data structure
 */
public class Note {
    private String message, title;
    private long noteId, dateCreatedMilli;
    private Category category;

    public enum Category{PERSONAL, TECHNICAL, QUOTE, FINANCE}

    public Note(String message, String title, Category category){

        this.message = message;
        this.title = title;
        this.category = category;
        noteId = 0;
        dateCreatedMilli=0;
    }

    public Note(String message, String title, Category category, long noteId, long dateCreatedMilli){

        this.message = message;
        this.title = title;
        this.category = category;
        this.noteId = noteId;
        this.dateCreatedMilli= dateCreatedMilli;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public long getDateCreatedMilli() {
        return dateCreatedMilli;
    }

    public long getNoteId() {
        return noteId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "message='" + message + '\'' +
                ", title='" + title + '\'' +
                ", noteId=" + noteId +
                ", dateCreatedMilli=" + dateCreatedMilli +
                ", category=" + category +
                '}';
    }

    public int getAssociatedDrawable(){
        return categoryToDrawable(category);
    }

    public static int categoryToDrawable(Category noteCategory){

        switch(noteCategory){
            case PERSONAL:
                return R.drawable.p;
            case TECHNICAL:
                return R.drawable.t;
            case QUOTE:
                return R.drawable.q;
            case FINANCE:
                return R.drawable.f;
        }

        return R.drawable.p;
    }
}
