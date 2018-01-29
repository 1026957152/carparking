package com.coalvalue.service;



import com.coalvalue.configuration.Constants;
import com.coalvalue.configuration.MqttPublishSample;
import com.coalvalue.configuration.MqttReceiver;

import com.service.BaseServiceImpl;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Service("mqttService")
public class MqttServiceImpl extends BaseServiceImpl implements MqttService {
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);



    @Autowired
    private MqttAsyncClient mqttClient;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    MqttReceiver mqttReceiver;
    private boolean login = false;





    @Override

    public void access() {

        sendNetworkStatus("OK");



     /*   System.out.println("----------------- finally");
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                  //  TimeUnit.SECONDS.sleep(20);
                    System.out.println("----------------- finally");
                    int timeout = 2000;
                    InetAddress[] addresses = InetAddress.getAllByName("baidu.com");
                    for (InetAddress address : addresses) {
                     if (address.isReachable(timeout))
                            sendNetworkStatus("OK");

                        else
                            sendNetworkStatus("BAD");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });*/
    }

    @Override
   // @Retryable
    public void sendNetworkStatus(String status) {
        System.out.println("----------------- GET TOPIC ");

        if(status.equals("OK") && !login){
        //    String url = "http://localhost:8085/app/register";
            String url = "http://yulinmei.cn/app/register";
            Map<String, Object> uriParams = new HashMap<String, Object>();
            // uriParams.put("companyId", stationId);

            String appId = "";

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                    // Add query parameter
                    .queryParam("APP_ID", Constants.APP_ID)
                    .queryParam("APP_SECRET", Constants.APP_SECRET);


  /*          String result = restTemplate.getForObject(builder.buildAndExpand(uriParams).toUri(), String.class);
            Map<String,String> map = new HashMap<String,String>();
            ObjectMapper mapper = new ObjectMapper();

            try {
                //convert JSON string to Map
                map = mapper.readValue(result, new TypeReference<HashMap<String,String>>(){});
            } catch (Exception e) {
                logger.info("Exception converting {} to map", result, e);
            }*/

         //   System.out.println(result);

           // Resource<Truck> resource  = restTemplate.getForObject(newProductLocation, Resource.class);
            ResponseEntity<Map> responseEntity_truck = restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, null, Map.class);
            System.out.println("truck {}, content is :{} " + responseEntity_truck.getBody().toString());
           // System.out.println("----------------- GET TOPIC ");
            if(responseEntity_truck.getStatusCode().equals(HttpStatus.OK)){
                login = true;
                Map map = responseEntity_truck.getBody();

                //  String in_camera = (String)map.get("in_camera_topic");

                logger.debug("============= mqtt topic {}", map.toString());
                String topic = (String)map.get("topic");
            //    DemoCallback demoCallback = new DemoCallback();




         //       MqttConnectOptions connOpt = new MqttConnectOptions();
       //         connOpt.setCleanSession(false);
       //         connOpt.setKeepAliveInterval(5);
      //          connOpt.setConnectionTimeout(10);
     //           connOpt.setAutomaticReconnect(true);

  /*              try {

                //brokerList[1] = BROKER_URL2;
                //connOpt.setServerURIs(brokerList);
       //         mqttAsyncClient.connect(connOpt);


                    //mqttAsyncClient.subscribe(topic,2);
           //     mqttAsyncClient.setCallback(mqttReceiver);
                    String topic_ =  "mqtt."+topic;
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mqttClient.subscribe(topic_, MqttPublishSample.qos);
                    System.out.println(" mqttAsyncClient.subscribe(topic, 0) "+ topic_);
                } catch (MqttException e) {
                    e.printStackTrace();
                }*/
            }


        }



    }

    @Override
    public void publishToHost(String license) {
        MqttMessage message = new MqttMessage();
        message.setPayload(license
                .getBytes());
        try {
            mqttClient.publish("topic_plate", message);
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
/*

    private class DemoCallback implements MqttCallback {

        public void connectionLost(Throwable cause) {
            System.out.println("Connection lost - attempting reconnect.");
            // mqttClient =  connect();

        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken arg0) {
            // Not needed in this simple demo
        }

        @Override
        public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
            System.out.println("");
            System.out.println("messageArrived "+ arg0 + "  " + arg1.toString());
            mqttReceiver.messageArrived(arg0,arg1);


            // Not needed in this simple demo
        }



        public void connectComplete(boolean reconnect, String serverURI) {
            if (reconnect) {
                System.out.println("Connection Reconnected! To: " + serverURI);
            } else {
                System.out.println("Initial Connection! To: " + serverURI);
                //  sync.doNotify();
            }
            //addSubscriptions();
        }
    }

*/

}
