package com.romcooo;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {

            URL url = new URL("http://ptsv2.com/t/fc5x4-1578057119/post?param1=123");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

//            connection.setRequestMethod("GET");

            connection.setReadTimeout(30000);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setRequestProperty("Content-Type", "application/json");

            String parameters = "{value:1}";
            connection.setRequestProperty("Content-Length", Integer.toString(parameters.getBytes().length));

            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setDoInput(true);

            DataOutputStream output = new DataOutputStream(connection.getOutputStream());
            output.writeBytes(parameters);
//            output.writeUTF(parameters);
            output.flush();
            output.close();

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading page.");
                return;
            }

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = inputStream.readLine()) != null) {
                System.out.println(line);
            }

            inputStream.close();


//            URLConnection urlConnection = url.openConnection();
//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(
//                            urlConnection.getInputStream()
//                    )
//            );
//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//
//            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> valueList = entry.getValue();
//                System.out.println("---key: " + key);
//                for (String headerValue : valueList) {
//                    System.out.println("value: " + headerValue);
//                }
//            }
//
//            inputStream.close();

//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(
//                            url.openStream()
//                    )
//            );
//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();


//            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");

//            URI baseUri = new URI("http://username:password@myserver.com:5000");
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
//            URI uri3 = new URI("/stores/locations?zip=12345");
//
//            URI resolvedUri1 = baseUri.resolve(uri1);
//            URL url1 = resolvedUri1.toURL();
//            URI resolvedUri2 = baseUri.resolve(uri2);
//            URL url2 = resolvedUri2.toURL();
//            URI resolvedUri3 = baseUri.resolve(uri3);
//            URL url3 = resolvedUri3.toURL();
//
//            System.out.println("URL = " + url1);
//            System.out.println("URL = " + url2);
//            System.out.println("URL = " + url3);


//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());

//        } catch (URISyntaxException e) {
//            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
