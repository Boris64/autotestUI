package Objects;

public class Menu {
    private String name;
    private Boolean shouldOkBePresent;
    private long timeout;

    public Menu(String name, Boolean shouldOkBePresent, long timeout) {
        this.name = name;
        this.shouldOkBePresent = shouldOkBePresent;
        this.timeout = timeout;
    }

    public Menu(String name, Boolean shouldOkBePresent) {
        this.name = name;
        this.shouldOkBePresent = shouldOkBePresent;
        this.timeout = 20000;
    }

    public Menu(String name) {
        this.name = name;
        this.shouldOkBePresent = false;
        this.timeout = 20000;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getShouldOkBePresent() {
        return shouldOkBePresent;
    }

    public void setShouldOkBePresent(Boolean shouldOkBePresent) {
        this.shouldOkBePresent = shouldOkBePresent;
    }
}
