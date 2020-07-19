package go.fraczek.apisw.character

import org.json.JSONObject

class CharacterModels {

    static def getLuke() {
        return new JSONObject("{\n" +
                "  \"name\": \"Luke Skywalker\",\n" +
                "  \"height\": \"172\",\n" +
                "  \"mass\": \"77\",\n" +
                "  \"hair_color\": \"blond\",\n" +
                "  \"skin_color\": \"fair\",\n" +
                "  \"eye_color\": \"blue\",\n" +
                "  \"birth_year\": \"19BBY\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"homeworld\": \"http://swapi.dev/api/planets/1/\",\n" +
                "  \"films\": [\n" +
                "    \"http://swapi.dev/api/films/1/\",\n" +
                "    \"http://swapi.dev/api/films/2/\",\n" +
                "    \"http://swapi.dev/api/films/3/\",\n" +
                "    \"http://swapi.dev/api/films/6/\"\n" +
                "  ],\n" +
                "  \"species\": [],\n" +
                "  \"vehicles\": [\n" +
                "    \"http://swapi.dev/api/vehicles/14/\",\n" +
                "    \"http://swapi.dev/api/vehicles/30/\"\n" +
                "  ],\n" +
                "  \"starships\": [\n" +
                "    \"http://swapi.dev/api/starships/12/\",\n" +
                "    \"http://swapi.dev/api/starships/22/\"\n" +
                "  ],\n" +
                "  \"created\": \"2014-12-09T13:50:51.644000Z\",\n" +
                "  \"edited\": \"2014-12-20T21:17:56.891000Z\",\n" +
                "  \"url\": \"http://swapi.dev/api/people/1/\"\n" +
                "}")
    }

    static def getTatooine() {
        return new JSONObject('{\n' +
                '    "name": "Tatooine", \n' +
                '    "rotation_period": "23", \n' +
                '    "orbital_period": "304", \n' +
                '    "diameter": "10465", \n' +
                '    "climate": "arid", \n' +
                '    "gravity": "1 standard", \n' +
                '    "terrain": "desert", \n' +
                '    "surface_water": "1", \n' +
                '    "population": "200000", \n' +
                '    "residents": [\n' +
                '        "http://swapi.dev/api/people/1/", \n' +
                '        "http://swapi.dev/api/people/2/", \n' +
                '        "http://swapi.dev/api/people/4/", \n' +
                '        "http://swapi.dev/api/people/6/", \n' +
                '        "http://swapi.dev/api/people/7/", \n' +
                '        "http://swapi.dev/api/people/8/", \n' +
                '        "http://swapi.dev/api/people/9/", \n' +
                '        "http://swapi.dev/api/people/11/", \n' +
                '        "http://swapi.dev/api/people/43/", \n' +
                '        "http://swapi.dev/api/people/62/"\n' +
                '    ], \n' +
                '    "films": [\n' +
                '        "http://swapi.dev/api/films/1/", \n' +
                '        "http://swapi.dev/api/films/3/", \n' +
                '        "http://swapi.dev/api/films/4/", \n' +
                '        "http://swapi.dev/api/films/5/", \n' +
                '        "http://swapi.dev/api/films/6/"\n' +
                '    ], \n' +
                '    "created": "2014-12-09T13:50:49.641000Z", \n' +
                '    "edited": "2014-12-20T20:58:18.411000Z", \n' +
                '    "url": "http://swapi.dev/api/planets/1/"\n' +
                '}')
    }

    static def getXWing() {
        return new JSONObject('{\n' +
                '    "name": "X-wing", \n' +
                '    "model": "T-65 X-wing", \n' +
                '    "manufacturer": "Incom Corporation", \n' +
                '    "cost_in_credits": "149999", \n' +
                '    "length": "12.5", \n' +
                '    "max_atmosphering_speed": "1050", \n' +
                '    "crew": "1", \n' +
                '    "passengers": "0", \n' +
                '    "cargo_capacity": "110", \n' +
                '    "consumables": "1 week", \n' +
                '    "hyperdrive_rating": "1.0", \n' +
                '    "MGLT": "100", \n' +
                '    "starship_class": "Starfighter", \n' +
                '    "pilots": [\n' +
                '        "http://swapi.dev/api/people/1/", \n' +
                '        "http://swapi.dev/api/people/9/", \n' +
                '        "http://swapi.dev/api/people/18/", \n' +
                '        "http://swapi.dev/api/people/19/"\n' +
                '    ], \n' +
                '    "films": [\n' +
                '        "http://swapi.dev/api/films/1/", \n' +
                '        "http://swapi.dev/api/films/2/", \n' +
                '        "http://swapi.dev/api/films/3/"\n' +
                '    ], \n' +
                '    "created": "2014-12-12T11:19:05.340000Z", \n' +
                '    "edited": "2014-12-20T21:23:49.886000Z", \n' +
                '    "url": "http://swapi.dev/api/starships/12/"\n' +
                '}')
    }

    static def getLukeAndC3POPage() {
        return "{\n" +
                "    \"count\": 2, \n" +
                "    \"next\": \"http://swapi.dev/api/people/?page=2\", \n" +
                "    \"previous\": null, \n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"name\": \"Luke Skywalker\", \n" +
                "            \"height\": \"172\", \n" +
                "            \"mass\": \"77\", \n" +
                "            \"hair_color\": \"blond\", \n" +
                "            \"skin_color\": \"fair\", \n" +
                "            \"eye_color\": \"blue\", \n" +
                "            \"birth_year\": \"19BBY\", \n" +
                "            \"gender\": \"male\", \n" +
                "            \"homeworld\": \"http://swapi.dev/api/planets/1/\", \n" +
                "            \"films\": [\n" +
                "                \"http://swapi.dev/api/films/1/\", \n" +
                "                \"http://swapi.dev/api/films/2/\", \n" +
                "                \"http://swapi.dev/api/films/3/\", \n" +
                "                \"http://swapi.dev/api/films/6/\"\n" +
                "            ], \n" +
                "            \"species\": [], \n" +
                "            \"vehicles\": [\n" +
                "                \"http://swapi.dev/api/vehicles/14/\", \n" +
                "                \"http://swapi.dev/api/vehicles/30/\"\n" +
                "            ], \n" +
                "            \"starships\": [\n" +
                "                \"http://swapi.dev/api/starships/12/\", \n" +
                "                \"http://swapi.dev/api/starships/22/\"\n" +
                "            ], \n" +
                "            \"created\": \"2014-12-09T13:50:51.644000Z\", \n" +
                "            \"edited\": \"2014-12-20T21:17:56.891000Z\", \n" +
                "            \"url\": \"http://swapi.dev/api/people/1/\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\": \"C-3PO\", \n" +
                "            \"height\": \"167\", \n" +
                "            \"mass\": \"75\", \n" +
                "            \"hair_color\": \"n/a\", \n" +
                "            \"skin_color\": \"gold\", \n" +
                "            \"eye_color\": \"yellow\", \n" +
                "            \"birth_year\": \"112BBY\", \n" +
                "            \"gender\": \"n/a\", \n" +
                "            \"homeworld\": \"http://swapi.dev/api/planets/1/\", \n" +
                "            \"films\": [\n" +
                "                \"http://swapi.dev/api/films/1/\", \n" +
                "                \"http://swapi.dev/api/films/2/\", \n" +
                "                \"http://swapi.dev/api/films/3/\", \n" +
                "                \"http://swapi.dev/api/films/4/\", \n" +
                "                \"http://swapi.dev/api/films/5/\", \n" +
                "                \"http://swapi.dev/api/films/6/\"\n" +
                "            ], \n" +
                "            \"species\": [\n" +
                "                \"http://swapi.dev/api/species/2/\"\n" +
                "            ], \n" +
                "            \"vehicles\": [], \n" +
                "            \"starships\": [], \n" +
                "            \"created\": \"2014-12-10T15:10:51.357000Z\", \n" +
                "            \"edited\": \"2014-12-20T21:17:50.309000Z\", \n" +
                "            \"url\": \"http://swapi.dev/api/people/2/\"\n" +
                "        }\n" +
                "    ]\n" +
                "}"
    }

}
