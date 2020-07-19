## Star Wars API
![All branches](https://github.com/Patrolfr/apisw/workflows/All%20branches/badge.svg?branch=apisw%2Fdevelopment)

Simple REST service which returns details of Star Wars characters.

Service works as a transient API forwarding to swapi.dev.  
Implementation may produce n+1 alike problem since Star Wars characters tends to have many starships  
and swapi.dev search query does not support searching by any ranges (especially id range),  
so HATEOAS resources may be fetched only in 'request per single resource' mode.

## Swagger (OpenApi 3.0)
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

### Exercise:

Zadanie polega na przygotowaniu usługi REST która zwróci:
- stronicowaną listę bohaterów Gwiezdnych Wojen
- szczegóły poszczególnych bohaterów.
API powinno wystawiać dwie końcówki:

GET /characters?page=x
```
{
  "count": 82,
  "pages": 9,
  "elements": [
    {
      "id": 1,
      "name": "Luke Skywalker",
      "height": "172",
      "mass": "77",
      "hairColor": "blond",
      "skinColor": "fair",
      "eyeColor": "blue",
      "birthYear": "19BBY",
      "gender": "male",
      "homeworld": {
        "name": "Tatooine",
        "rotationPeriod": "23",
        "orbitalPeriod": "304",
        "diameter": "10465",
        "climate": "arid",
        "gravity": "1 standard",
        "terrain": "desert",
        "surfaceWater": "1",
        "population": "200000"
      },
      "starships": [
        {
          "name": "X-wing",
          "model": "T-65 X-wing",
          "manufacturer": "Incom Corporation",
          "costInCredits": "149999",
          "length": "12.5",
          "maxAtmosphericSpeed": "1050",
          "crew": "1",
          "passengers": "0",
          "cargoCapacity": "110",
          "consumables": "1 week",
          "hyperdriveRating": "1.0",
          "mglt": "100",
          "starshipClass": "Starfighter"
        },
        {
          "name": "Imperial shuttle",
          "model": "Lambda-class T-4a shuttle",
          "manufacturer": "Sienar Fleet Systems",
          "costInCredits": "240000",
          "length": "20",
          "maxAtmosphericSpeed": "850",
          "crew": "6",
          "passengers": "20",
          "cargoCapacity": "80000",
          "consumables": "2 months",
          "hyperdriveRating": "1.0",
          "mglt": "50",
          "starshipClass": "Armed government transport"
        }
      ]
    }
  ]
}
```
GET /characters/{id}
```
{
  "id": 1,
  "name": "Luke Skywalker",
  "height": "172",
  "mass": "77",
  "hairColor": "blond",
  "skinColor": "fair",
  "eyeColor": "blue",
  "birthYear": "19BBY",
  "gender": "male",
  "homeworld": {
    "name": "Tatooine",
    "rotationPeriod": "23",
    "orbitalPeriod": "304",
    "diameter": "10465",
    "climate": "arid",
    "gravity": "1 standard",
    "terrain": "desert",
    "surfaceWater": "1",
    "population": "200000"
  },
  "starships": [
    {
      "name": "X-wing",
      "model": "T-65 X-wing",
      "manufacturer": "Incom Corporation",
      "costInCredits": "149999",
      "length": "12.5",
      "maxAtmosphericSpeed": "1050",
      "crew": "1",
      "passengers": "0",
      "cargoCapacity": "110",
      "consumables": "1 week",
      "hyperdriveRating": "1.0",
      "mglt": "100",
      "starshipClass": "Starfighter"
    },
    {
      "name": "Imperial shuttle",
      "model": "Lambda-class T-4a shuttle",
      "manufacturer": "Sienar Fleet Systems",
      "costInCredits": "240000",
      "length": "20",
      "maxAtmosphericSpeed": "850",
      "crew": "6",
      "passengers": "20",
      "cargoCapacity": "80000",
      "consumables": "2 months",
      "hyperdriveRating": "1.0",
      "mglt": "50",
      "starshipClass": "Armed government transport"
    }
  ]
}
```
### Wymagania
#### Wymagania poza funkcjonalne
- powinna być w stanie obsłużyć 20 zapytań na sekundę (nie powinna zawierać oczywistych wąskich gardeł)
- pełny zestaw testów uruchamiany wraz z narzędziem budującym (Maven lub Gradle)
- dobry projekt i jakość kodu
#### Dodatkowe wymagania- obsługa i logowanie błędów
- konfiguracja Swagger UI
- dokeryzacja aplikacji
- przygotowanie do monitorowania przy pomocy Prometheus
### Technologie
#### Wymagane technologie
- Java 11

#### Zalecane technologie:
- Spring
- Spock
