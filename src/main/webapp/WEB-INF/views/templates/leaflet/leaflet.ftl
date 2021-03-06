<!DOCTYPE html>
<html>
<head>
    <title>Streaming Demo</title>
    <meta charset="utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<div class="container">
    <div id="auto" style="position:absolute; height:50%; width:25%; top:0px; left:3px; overflow: scroll;"><h3>Transaction Streaming</h3><div id="autotxt"></div></div>
    <div id="twilio" style="position:absolute; height:50%; width:25%; bottom:0px; left:3px; overflow: scroll;"><h3>User Streaming</h3><div id="twiliotxt"></div></div>

    <div id="mapid" style="position:absolute; height: 1200px; width: 1000px; right:0px; top:0px"></div>

    <script src="http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.js"></script>
    <script>
        $(document).ready(function() {
            setInterval("query_new_auto()", 1000);
            setInterval("query_new_twilio()", 1000);
        });


        function query_new_auto() {
            $.ajax({
                url: '${auto_trnx}',
                type: 'GET',
                success: function(data_string) {
                    console.debug(data_string)
                    var data =data_string;// JSON.parse(data_string);

                    if (data.output) {
                        var values = data.output;

                        var lat_value = values.geocode.lat;
                        var lng_value = values.geocode.lng;
                        var cordinates = {lat: lat_value, lng: lng_value};
                        var location = values.name;
                        var auto_div = document.getElementById('autotxt');
                        auto_div.innerHTML = "<b>Location</b>: " + location +
                                " | <b>Geocode</b>: [" + lat_value + ", " + lng_value + "]<br>"
                                + auto_div.innerHTML;
                        L.marker(cordinates).addTo(mymap)
                                .bindPopup(location, {autoPan: false}).openPopup();
                    }
                }
            });
        }



        function query_new_twilio() {
            $.ajax({
                url: '${twilio_trnx}',
                type: 'GET',
                success: function(data_string) {

                    var data = data_string;//JSON.parse(data_string);

                    if (data.output) {
                        var values = data.output;

                    //    var values = JSON.parse(data.output);
                        var phone = values.from;

                        var text_time = values.date;

                        var lat_value = values.body.geocode.lat;

                        var lng_value = values.body.geocode.lng;


                        var cordinates = {lat: lat_value, lng: lng_value};
                        var twilio_div = document.getElementById('twiliotxt');
                        twilio_div.innerHTML =  "<b>Date</b>: " + text_time +
                                " | <b>Geocode</b>: [" + lat_value + ", " + lng_value + "]<br>"
                                + twilio_div.innerHTML;

                        L.circle(cordinates, 200000, {
                            color: 'red',
                            fillColor: '#f03',
                            fillOpacity: 0.5
                        }).addTo(mymap).bindPopup("phone#: " + phone + "<br>date: " + text_time, {autoPan: false}).openPopup();
                    }
                }
            });
        }
        var mymap = L.map('mapid').setView([39.3343, -97.207], 5);
        L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1Ijoia2VpcmFxeiIsImEiOiJjaW12YmhveHYwMm9ldXdtNGczZ2l4cHoyIn0.RevL3gjWca4wYBP3YdRmNg', {
            maxZoom: 18,
            attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
            '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
            'Imagery © <a href="http://mapbox.com">Mapbox</a>',
            id: 'mapbox.streets'
        }).addTo(mymap);
        var popup = L.popup();
        function onMapClick(e) {
            popup
                    .setLatLng(e.latlng)
                    .setContent("You clicked the map at " + e.latlng.toString())
                    .openOn(mymap);
        }
        mymap.on('click', onMapClick);
    </script>
</div><!-- /.container -->
</body>
</html>