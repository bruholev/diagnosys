package kg.Robotics.dao;

public class RequestResponseDyagnosys {
    private RequestDyagnosys requestDyagnosys;
    private ResponseDyagnosys responseDyagnosys;

    public RequestResponseDyagnosys() {
    }

    public RequestResponseDyagnosys(RequestDyagnosys requestDyagnosys, ResponseDyagnosys responseDyagnosys) {
        this.requestDyagnosys = requestDyagnosys;
        this.responseDyagnosys = responseDyagnosys;
    }

    public RequestDyagnosys getRequestDyagnosys() {
        return requestDyagnosys;
    }

    public void setRequestDyagnosys(RequestDyagnosys requestDyagnosys) {
        this.requestDyagnosys = requestDyagnosys;
    }

    public ResponseDyagnosys getResponseDyagnosys() {
        return responseDyagnosys;
    }

    public void setResponseDyagnosys(ResponseDyagnosys responseDyagnosys) {
        this.responseDyagnosys = responseDyagnosys;
    }
}
