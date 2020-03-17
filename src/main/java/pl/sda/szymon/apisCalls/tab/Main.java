package pl.sda.szymon.apisCalls.tab;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    public static void main(String[] args) {

        String komenda;
        Scanner scan = new Scanner(System.in);
        System.out.println("Wybierz tabelę");

        komenda = scan.nextLine();

     /*  switch (komenda) {
            case "A":
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                   List<TableAa> response = objectMapper.readValue(new File("AAA.json"),
                           new TypeReference<List<TableAa>>() {
                           }
                   );
                    response.forEach(System.out::println);
                } catch (
                        IOException e) {
                    e.printStackTrace();

                }
        break;
*/
        switch (komenda) {
            case "A":

                HttpRequest requestA = HttpRequest.newBuilder().GET()
                        .uri(URI.create("http://api.nbp.pl/api/exchangerates/tables/a/?format=json"))
                        .build();
                try {

                    HttpResponse<String> resp = httpClient.send(requestA, HttpResponse.BodyHandlers.ofString());


                    String responseBody = resp.body();

                    ObjectMapper mapper = new ObjectMapper();

                    List<TableAa> kursWalut = mapper.readValue(
                            responseBody, new TypeReference<List<TableAa>>() {
                            }
                    );

                    kursWalut.forEach(System.out::println);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}