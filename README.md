# geolocalization


**Endpoints construídos:**


Estado de la Api cuando esté arriba:<br>
GET
**localhost:8080/api/v1/geolocalization/health**


Cargar la base de datos desde el archivo .csv:
<br>
GET
**localhost:8080/api/v1/geolocalization/load**


Buscar registro por parámetro ip_from:
<br>
**localhost:8080/api/v1/geolocalization/getGeoByIpFrom/1.0.4.0**


Buscar registro por parámetro ip_to:
<br>
GET
**localhost:8080/api/v1/geolocalization/getGeoByIpTo/1.0.5.255**


**Gradle**

gradle clean
<br>
gradle bootRun