public class Task {
    private String title;
    private int steps;
    private int priority;
    private int dateDue;
    private String note;
    private Date createdDate;
    private String groupName;
    public Task(String title, int priority, int dateDue, String note, Date createdDate, int steps,String groupName) {
        this.title = title;
        this.priority = priority;
        this.dateDue = dateDue;
        this.note = note;
        this.createdDate = createdDate;
        this.steps = steps;
        this.groupName=groupName;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDateDue() {
        return dateDue;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setDateDue(int dateDue) {
        this.dateDue = dateDue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", steps=" + steps +
                ", priority=" + priority +
                ", dateDue=" + dateDue +
                ", note='" + note + '\'' +
                ", createdDate=" + createdDate.toString() +
                '}';
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

