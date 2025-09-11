import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiPostExample {

    private static final String TARGET_URL = "https://reqres.in/api/users";

    public static void main(String[] args) {
        try {
            // 전송할 JSON 데이터
            String jsonRequest = "{ \"name\": \"Kim\", \"job\": \"Developer\" }";

            // POST 요청 & 응답 수신
            String response = sendPostRequest(TARGET_URL, jsonRequest);

            System.out.println("📌 서버 응답 JSON:");
            System.out.println(response);

        } catch (IOException e) {
            System.out.println("❌ API 요청 실패: " + e.getMessage());
        }
    }

    private static String sendPostRequest(String targetUrl, String jsonInput) throws IOException {
        URL url = new URL(targetUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // POST 요청 설정
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        // JSON 데이터 쓰기
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // 응답 읽기
        int responseCode = conn.getResponseCode();
        InputStream is = (responseCode >= 200 && responseCode < 300)
                ? conn.getInputStream() : conn.getErrorStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line.trim());
        }
        br.close();

        conn.disconnect();

        return response.toString();
    }
}
