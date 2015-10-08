package tutorial.client.org;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import tutorial.org.br.Constants;
import tutorial.org.br.WeatherData;
import tutorial.org.br.WeatherService;
 
public class Client {
 
    // Host or IP of Server
    private static final String HOST = "localhost";
    private static final int PORT = 6666;
    private static Registry registry;
 
    public static void main(String[] args) throws Exception {
 
        // Search the registry in the specific Host, Port.
        registry = LocateRegistry.getRegistry(HOST, PORT);
 
        // Lookup WeatherService in the Registry.
        WeatherService service = (WeatherService) registry
                .lookup(WeatherService.class.getSimpleName());
 
        Date today = new Date();
 
        // Get Chicago weather info:
        WeatherData chicagoWeather = service.getWeather(today,
                Constants.LOCATION_CHICAGO);
 
        System.out.println("Chicago weather today: "
                + chicagoWeather.getWeather());
         
        // Get Hanoi weather info:
        WeatherData hanoiWeather = service.getWeather(today,
                Constants.LOCATION_HANOI);
 
        System.out.println("Hanoi weather today: " + hanoiWeather.getWeather());
 
    }
}