package kg.Robotics.dao;

public class RequestResponseParse {
    private RequestParse requestParse;
    private ResponseParse responseParse;

    public RequestResponseParse() {
    }

    public RequestResponseParse(RequestParse requestParse, ResponseParse responseParse) {
        this.requestParse = requestParse;
        this.responseParse = responseParse;
    }

    public RequestParse getRequestParse() {
        return requestParse;
    }

    public void setRequestParse(RequestParse requestParse) {
        this.requestParse = requestParse;
    }

    public ResponseParse getResponseParse() {
        return responseParse;
    }

    public void setResponseParse(ResponseParse responseParse) {
        this.responseParse = responseParse;
    }
}
