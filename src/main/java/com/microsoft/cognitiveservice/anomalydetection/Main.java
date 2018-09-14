package com.microsoft.cognitiveservice.anomalydetection;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {
    // **********************************************
    // *** Update or verify the following values. ***
    // **********************************************

    // Replace the subscriptionKey string value with your valid subscription key.
    public static final String subscriptionKey = "<Subscription Key>";

    // Choose which anomaly detection way you want to use and change the uriBase's second part
    public static final String rootUrl = "https://cognitiveusw2ppe.azure-api.net/anomalyfinder/v2.0";
    public static final String lastDetect = "/timeseries/last/detect";
    public static final String entireDetect = "/timeseries/entire/detect";
    public static final String uriBase = rootUrl + lastDetect;

    public static void main(String[] args) {
        final String content = "{\n" +
                "  \"Series\": [\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-01-01T00:00:00Z\",\n" +
                "      \"Value\": 826.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-02-01T00:00:00Z\",\n" +
                "      \"Value\": 799.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-03-01T00:00:00Z\",\n" +
                "      \"Value\": 890.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-04-01T00:00:00Z\",\n" +
                "      \"Value\": 900.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-05-01T00:00:00Z\",\n" +
                "      \"Value\": 961.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-06-01T00:00:00Z\",\n" +
                "      \"Value\": 935.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-07-01T00:00:00Z\",\n" +
                "      \"Value\": 894.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-08-01T00:00:00Z\",\n" +
                "      \"Value\": 855.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-09-01T00:00:00Z\",\n" +
                "      \"Value\": 809.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-10-01T00:00:00Z\",\n" +
                "      \"Value\": 810.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-11-01T00:00:00Z\",\n" +
                "      \"Value\": 766.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1972-12-01T00:00:00Z\",\n" +
                "      \"Value\": 805.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-01-01T00:00:00Z\",\n" +
                "      \"Value\": 821.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-02-01T00:00:00Z\",\n" +
                "      \"Value\": 773.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-03-01T00:00:00Z\",\n" +
                "      \"Value\": 883.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-04-01T00:00:00Z\",\n" +
                "      \"Value\": 898.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-05-01T00:00:00Z\",\n" +
                "      \"Value\": 957.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-06-01T00:00:00Z\",\n" +
                "      \"Value\": 924.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-07-01T00:00:00Z\",\n" +
                "      \"Value\": 881.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-08-01T00:00:00Z\",\n" +
                "      \"Value\": 837.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-09-01T00:00:00Z\",\n" +
                "      \"Value\": 784.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-10-01T00:00:00Z\",\n" +
                "      \"Value\": 791.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-11-01T00:00:00Z\",\n" +
                "      \"Value\": 760.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1973-12-01T00:00:00Z\",\n" +
                "      \"Value\": 802.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-01-01T00:00:00Z\",\n" +
                "      \"Value\": 828.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-02-01T00:00:00Z\",\n" +
                "      \"Value\": 1030.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-03-01T00:00:00Z\",\n" +
                "      \"Value\": 889.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-04-01T00:00:00Z\",\n" +
                "      \"Value\": 902.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-05-01T00:00:00Z\",\n" +
                "      \"Value\": 969.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-06-01T00:00:00Z\",\n" +
                "      \"Value\": 947.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-07-01T00:00:00Z\",\n" +
                "      \"Value\": 908.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-08-01T00:00:00Z\",\n" +
                "      \"Value\": 867.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-09-01T00:00:00Z\",\n" +
                "      \"Value\": 815.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-10-01T00:00:00Z\",\n" +
                "      \"Value\": 812.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-11-01T00:00:00Z\",\n" +
                "      \"Value\": 773.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1974-12-01T00:00:00Z\",\n" +
                "      \"Value\": 813.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-01-01T00:00:00Z\",\n" +
                "      \"Value\": 834.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-02-01T00:00:00Z\",\n" +
                "      \"Value\": 782.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-03-01T00:00:00Z\",\n" +
                "      \"Value\": 892.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-04-01T00:00:00Z\",\n" +
                "      \"Value\": 903.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-05-01T00:00:00Z\",\n" +
                "      \"Value\": 966.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-06-01T00:00:00Z\",\n" +
                "      \"Value\": 937.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-07-01T00:00:00Z\",\n" +
                "      \"Value\": 896.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-08-01T00:00:00Z\",\n" +
                "      \"Value\": 858.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-09-01T00:00:00Z\",\n" +
                "      \"Value\": 817.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-10-01T00:00:00Z\",\n" +
                "      \"Value\": 827.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-11-01T00:00:00Z\",\n" +
                "      \"Value\": 797.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"Timestamp\": \"1975-12-01T00:00:00Z\",\n" +
                "      \"Value\": 843.0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"MaxAnomalyRatio\": 0.25,\n" +
                "  \"Sensitivity\": 95,\n" +
                "  \"Granularity\": \"monthly\"\n" +
                "}";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(uriBase);

        // Request headers.
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

        try {
            StringEntity params = new StringEntity(content);
            request.setEntity(params);

            CloseableHttpResponse response = client.execute(request);
            try {
                HttpEntity respEntity = response.getEntity();
                if (respEntity != null) {
                    System.out.println("----------");
                    System.out.println(response.getStatusLine());
                    System.out.println("Response content is :\n");
                    System.out.println(EntityUtils.toString(respEntity, "utf-8"));
                    System.out.println("----------");
                }
            } catch (Exception respEx) {
                respEx.printStackTrace();
            } finally {
                response.close();
            }

        } catch (Exception ex) {
            System.err.println("Exception on Anomaly Detection: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (Exception e) {
                System.err.println("Exception on closing HttpClient: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
