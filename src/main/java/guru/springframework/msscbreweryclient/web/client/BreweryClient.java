package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.brewery",ignoreInvalidFields = false)

public class BreweryClient {
     public final String BEER_PATH_V1="/api/v1/beer/";
     private String   apihost = "http://localhost:8080";

     private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){

        System.out.println("Path----->"+apihost+BEER_PATH_V1+uuid.toString());

        return restTemplate.getForObject(apihost+BEER_PATH_V1+uuid.toString(),BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto)
    {
        return  restTemplate.postForLocation(apihost+BEER_PATH_V1,beerDto);
    }

//    private void setApihost(String apihost){
//        this.apihost=apihost;
//    }
}
