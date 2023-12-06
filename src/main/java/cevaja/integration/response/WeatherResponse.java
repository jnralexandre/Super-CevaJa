package cevaja.integration.response;

import lombok.Data;

@Data
public class WeatherResponse {

    private LocationResponse location;

    private CurrentResponse current;

}
