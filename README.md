iCloud4j is a Java port of the PyiCloud library. It provides a means for Java applications to use iCloud web services.
It is licenced under the Apache 2.0 licence.

# Authentication

When the account isn't protected using two-factor authentication, authentication can be down by supplying a simple
username/password pair:

    iCloud = new ICloudService("client-id");
    iCloud.authenticate("user@example.com", "password".toCharArray());


#Devices

A list of devices linked to the iCloud account can be retrieved via the 'FindMyIPhoneService':

    FindMyIPhoneService findMyIPhoneService = new FindMyIPhoneService(iCloudService);
    List<AppleDevice> devices = findMyIPhoneService.getDevices();


#Ubiquity (File Storage)

The iCloud Ubiquity file storage can be browsed by creating a new instance of the 'UbiquityService', and then calling
methods on each node from there:

    UbiquityService ubiquityService = new UbiquityService(iCloudService);
    UbiquityNode rootNode = ubiquityService.getRoot();
    List<UbiquityNode> childrenNode = root.getChildren();

File data can be streamed into an output stream:

    OutputStream outputStream;
    UbiquityNode child = folder.getChildren().get(0);
    if ("file".equals(child.getType()) {
        child.downloadFileData(outputStream);
    }

