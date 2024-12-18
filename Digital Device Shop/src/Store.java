
public class Store {

    private Device[] devices;
    private int total = 0;  //dual purpose. 1) number of items stored in array, 2) next available index location

    public Store(int numberItems) {
        devices = new Device[numberItems];
    }

    private boolean isFull() {
        return total == devices.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }


    public boolean add(Device device) {
        if (isFull()) {
            return false;
        } else {
            devices[total] = device;
            total++;
            return true;
        }
    }


    public String listDevice() {
        if (isEmpty()) {
            return "No products in the store";
        } else {
            String listOfDevice = "";
            for (int i = 0; i < total; i++) {
                listOfDevice += i + ": " + devices[i] + "\n";
                //Find the devices one by one.
            }
            return listOfDevice;
        }
    }

    public Device find(String name) {
        Device foundDevice = null;
        if (isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < total; i++) {
                boolean result;
                result = devices[i].getProductName().contains(name);
                if (result) {
                    foundDevice = devices[i];
                    System.out.print("name:" + foundDevice.getProductName() + " price:" + foundDevice.getPrice() + " number:" + foundDevice.getProductType() + "\n");
                }
                //print the information of the device you find.
            }
        }
        return foundDevice;
    }


    public void deleteADevice(String name){
        for (int i = 0; i < devices.length; i++) {
            if((devices[i]!=null)&&devices[i].getProductName().equals(name)) {
                //Ensure the device you want to delete.
                devices[i] = null;
                if (i < devices.length - 1) {
                    for (int j = i+1; j <devices.length; j++) {
                        devices[j] =devices[j+1];
                    }
                }
                devices[devices.length - 1] = null;
                System.out.println("nothing is deleted!");
                break;
            }//Delete the device successfully
            if(!changeDeviceName(name)){
                System.out.println("Successfully deleted!");
                break;
            }
        }


    }
    public boolean changeDeviceName(String name){
        for (int i = 0; i < devices.length; i++) {
            if(devices[i]!=null){
                if(devices[i].getProductName().equals(name)){
                    return true;
                }
            }
        }
        return false;
    }

}








