# Push Notification Server 
A simple command line applicaiton that sends push notifications using Java APNS.
## Setup
1. Clone and build the application

2. Run the application (single execution)

```
 mvn spring-boot:run -Dcertificate.path=xyz -Dcertificate.password=xyz -Ddevice.token=xyz -Dmessage=abcd
```

The above arguments must be provided to the application:
 * certificate.path - The path to the .p12 server certificate
 * certificate.password - The password of the .p12 server certificate
 * device.token - The unique device registration id
 * message (optional) - The message to send to the device, defaults to the value from 'application.properties'

