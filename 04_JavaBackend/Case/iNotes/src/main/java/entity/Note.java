package entity;

public class Note {
    private int id;
    private int typeId;
    private String title;
    private String content;

    public Note() {

    }

    public Note(String title) {

    }

    public Note(int typeId, String title, String content) {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public boolean save(){
        return false;
    }

    public boolean delete(){
        return false;
    }
}
