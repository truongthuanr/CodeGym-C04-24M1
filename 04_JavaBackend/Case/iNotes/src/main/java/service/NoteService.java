package service;

import entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteService implements IService<Note> {

    private List<Note> notes = new ArrayList<Note>();

    public NoteService(){

    }

    @Override
    public List<Note> getAll() {
        return List.of();
    }

    @Override
    public void add(Note note) {
        notes.add(note);

    }

    @Override
    public void update(int id,Note note) {
        int index = findIndexById(id);
        notes.set(index,note);

    }

    @Override
    public void delete(Note note) {

    }

    @Override
    public Note getById(int id) {
        return notes.get(this.findIndexById(id));
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < notes.size(); i++) {
            if(notes.get(i).getId()==id){
                return i;
            }
        }
        return 0;
    }
}
