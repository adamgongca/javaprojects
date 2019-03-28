package net.adamdog.form2njp;


public class Dataconnection {
    private String hostName;
    private String jdbcPort;
    private String sidName;
    private String servicesName;
    private String userName;
    private String password;
    private String jdbcStr;

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setJdbcPort(String jdbcPort) {
        this.jdbcPort = jdbcPort;
    }

    public String getJdbcPort() {
        return jdbcPort;
    }

    public void setSidName(String sidName) {
        this.sidName = sidName;
    }

    public String getSidName() {
        return sidName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setJdbcStr(String jdbcStr) {
        this.jdbcStr = jdbcStr;
    }

    public String getJdbcStr() {
        return jdbcStr;
    }
}
