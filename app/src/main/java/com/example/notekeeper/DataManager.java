package com.example.notekeeper;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager ourInstance = null;

    private List<CourseInfo> mCourses = new ArrayList<>();
    private List<NoteInfo> mNotes = new ArrayList<>();

    public static DataManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeCourses();
            ourInstance.initializeExampleNotes();
        }
        return ourInstance;
    }

    public String getCurrentUserName() {
        return "S Hashim";
    }

    public String getCurrentUserEmail() {
        return "sHashim@ibm.com";
    }

    public List<NoteInfo> getNotes() {
        return mNotes;
    }

    public int createNewNote() {
        NoteInfo note = new NoteInfo(null, null, null);
        mNotes.add(note);
        return mNotes.size() - 1;
    }

    public int findNote(NoteInfo note) {
        for(int index = 0; index < mNotes.size(); index++) {
            if(note.equals(mNotes.get(index)))
                return index;
        }

        return -1;
    }

    public void removeNote(int index) {
        mNotes.remove(index);
    }

    public List<CourseInfo> getCourses() {
        return mCourses;
    }

    public CourseInfo getCourse(String id) {
        for (CourseInfo course : mCourses) {
            if (id.equals(course.getCourseId()))
                return course;
        }
        return null;
    }

    public List<NoteInfo> getNotes(CourseInfo course) {
        ArrayList<NoteInfo> notes = new ArrayList<>();
        for(NoteInfo note:mNotes) {
            if(course.equals(note.getCourse()))
                notes.add(note);
        }
        return notes;
    }

    public int getNoteCount(CourseInfo course) {
        int count = 0;
        for(NoteInfo note:mNotes) {
            if(course.equals(note.getCourse()))
                count++;
        }
        return count;
    }

    private DataManager() {
    }

    private void initializeCourses() {
        mCourses.add(initializeCourse1());
        mCourses.add(initializeCourse2());
        mCourses.add(initializeCourse3());
        mCourses.add(initializeCourse4());
    }

    public void initializeExampleNotes() {
        final DataManager dm = getInstance();

        CourseInfo course = dm.getCourse("semester_one");
        course.getModule("semester_one_m01").setComplete(true);
        course.getModule("semester_one_m02").setComplete(true);
        course.getModule("semester_one_m03").setComplete(true);
        mNotes.add(new NoteInfo(course, "DEC - Event Programming",
                "Wow, event help us make powerful apps"));

        course = dm.getCourse("semester_two");
        course.getModule("semester_two_m01").setComplete(true);
        course.getModule("semester_two_m02").setComplete(true);
        mNotes.add(new NoteInfo(course, "DEC - Database Concepts",
                "Noting like storing and retrieving data!"));
        mNotes.add(new NoteInfo(course, "DEC - Design patterns",
                "Did someone say singleton."));

        course = dm.getCourse("semester_three");
        course.getModule("semester_three_m01").setComplete(true);
        course.getModule("semester_three_m02").setComplete(true);
        course.getModule("semester_three_m03").setComplete(true);
        course.getModule("semester_three_m04").setComplete(true);
        course.getModule("semester_three_m05").setComplete(true);
        course.getModule("semester_three_m06").setComplete(true);
        course.getModule("semester_three_m07").setComplete(true);
        mNotes.add(new NoteInfo(course, "DEC - IOS Development",
                "Apple is just .... apple."));
        mNotes.add(new NoteInfo(course, "DEC - Android Dev",
                "Mirmohommed's class is the best"));

        course = dm.getCourse("semester_four");
        course.getModule("semester_four_m01").setComplete(true);
        course.getModule("semester_four_m02").setComplete(true);
        course.getModule("semester_four_m03").setComplete(true);
        mNotes.add(new NoteInfo(course, "DEC - Database Concepts II",
                "Stored Procedures are the way to go"));
        mNotes.add(new NoteInfo(course, "DEC - Object orinted programming",
                "Noting like learning about the pillers of c++"));
    }

    private CourseInfo initializeCourse1() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("semester_one_m01", "Week 1"));
        modules.add(new ModuleInfo("semester_one_m02", "Week 2"));
        modules.add(new ModuleInfo("semester_one_m03", "Week 3"));
        modules.add(new ModuleInfo("semester_one_m04", "Week 4"));
        modules.add(new ModuleInfo("semester_one_m05", "Week 5"));

        return new CourseInfo("semester_one", "Semester One", modules);
    }

    private CourseInfo initializeCourse2() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("semester_two_m01", "Week 1"));
        modules.add(new ModuleInfo("semester_two_m02", "Week 2"));
        modules.add(new ModuleInfo("semester_two_m03", "Week 3"));
        modules.add(new ModuleInfo("semester_two_m04", "Week 4"));

        return new CourseInfo("semester_two", "Semester Two", modules);
    }

    private CourseInfo initializeCourse3() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("semester_three_m01", "Week 1"));
        modules.add(new ModuleInfo("semester_three_m02", "Week 2"));
        modules.add(new ModuleInfo("semester_three_m03", "Week 3"));
        modules.add(new ModuleInfo("semester_three_m04", "Week 4"));
        modules.add(new ModuleInfo("semester_three_m05", "Week 5"));
        modules.add(new ModuleInfo("semester_three_m06", "Week 6"));
        modules.add(new ModuleInfo("semester_three_m07", "Week 7"));
        modules.add(new ModuleInfo("semester_three_m08", "Week 8"));
        modules.add(new ModuleInfo("semester_three_m09", "Week 9"));
        modules.add(new ModuleInfo("semester_three_m10", "Week 10"));
        modules.add(new ModuleInfo("semester_three_m11", "Week 11"));
        modules.add(new ModuleInfo("semester_three_m12", "Week 12"));
        modules.add(new ModuleInfo("semester_three_m13", "Week 13"));

        return new CourseInfo("semester_three", "Semester Three", modules);
    }

    private CourseInfo initializeCourse4() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("semester_four_m01", "Week 1"));
        modules.add(new ModuleInfo("semester_four_m02", "Week 2"));
        modules.add(new ModuleInfo("semester_four_m03", "Week 3"));
        modules.add(new ModuleInfo("semester_four_m04", "Week 4"));
        modules.add(new ModuleInfo("semester_four_m05", "Week 5"));
        modules.add(new ModuleInfo("semester_four_m06", "Week 6"));
        modules.add(new ModuleInfo("semester_four_m07", "Week 7"));
        modules.add(new ModuleInfo("semester_four_m08", "Week 8"));
        modules.add(new ModuleInfo("semester_four_m09", "Week 9"));
        modules.add(new ModuleInfo("semester_four_m10", "Week 10"));

        return new CourseInfo("semester_four", "Semester Four", modules);
    }

}
