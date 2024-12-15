import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final var server = new Server(64);

        server.addHandler("GET", "/messages", new Handler() {
            public void handle(Request request, BufferedOutputStream responseStream) {
                try {
                    String responseBody = "GET messages response";
                    responseStream.write(("HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/plain\r\n" +
                            "Content-Length: " + responseBody.length() + "\r\n" +
                            "Connection: close\r\n" +
                            "\r\n").getBytes());
                    responseStream.write(responseBody.getBytes());
                    responseStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        server.addHandler("POST", "/messages", new Handler() {
            public void handle(Request request, BufferedOutputStream responseStream) {

                try {
                    String responseBody = "POST messages response";
                    responseStream.write(("HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/plain\r\n" +
                            "Content-Length: " + responseBody.length() + "\r\n" +
                            "Connection: close\r\n" +
                            "\r\n").getBytes());
                    responseStream.write(responseBody.getBytes());
                    responseStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        server.listen(9999);
    }
}
