package graphics.user.admin;

import account.making.userAccount;

public class show
{
    private userAccount user;
    private String string;
    private String ID;
    private String earmark;
    public show(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;//showing the part we want it to be shown(which is different in different situations
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEarmark() {
        return earmark;
    }

    public void setEarmark(String earmark) {
        this.earmark = earmark;
    }

    public userAccount getUser() {
        return user;
    }

    public void setUser(userAccount user) {
        this.user = user;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}