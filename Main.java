import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            String html = "<!DOCTYPE html>"
                    + "<html><head><meta charset=\"UTF-8\"><title>Docker確認課題</title></head>"
                    + "<body><h1>GitHubとDockerの確認課題</h1>"
                    + "<p>Javaプログラムから表示しています</p>"
                    + "<p>2回目のコミットで追加しました</p></body></html>";
            byte[] response = html.getBytes("UTF-8");
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.length);
            exchange.getResponseBody().write(response);
            exchange.close();
        });
        server.start();
        System.out.println("Server started on port 8080");
    }
}