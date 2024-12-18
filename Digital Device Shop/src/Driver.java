import java.util.Scanner;

public class Driver{

    private Device[] devices;
    private Scanner input = new Scanner(System.in);
    private Store store;
//Define store
    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        processOrder();
        runMenu();
    }
//Prepare for the menu.
    private int mainMenu(){
        System.out.print("""
              \033[32;57;255m
                Shop Menu
                  1) List the Device
                  2) Add Device
                  3) Delete Device
                  4）Find Devices
                  0) Exit
                  ==>>\033[0m""");
//Output the menu and selections.
        int option = input.nextInt();
        return option;
    }

    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> printDevice();
                case 2 -> addDevice();
                case 3 -> deleteADevice();
                case 4 ->findDevice();
                default -> System.out.println("Invalid option entered: " + option);
            }

//Options for users
            System.out.println("\nPress enter to continue(^o^)");
            input.nextLine();
            input.nextLine();
//Select again

            option = mainMenu();
        }


        System.out.println("Exiting......Service over.Bye!");
        System.exit(0);
    }


    private void processOrder(){

        System.out.print("How many Devices would you like to have in your Store?  :)");
        int numberDevice = input.nextInt();

        store = new Store(numberDevice+1);


        for (int i = 0; i < numberDevice; i++){
            addDevice();
        }
    }
//Add devices for the first time.

    private void addDevice(){
        input.nextLine();

        System.out.print("Enter the Device type:  ");
        String productType = input.nextLine();
        System.out.print("Enter the Device name:  ");
        String productName = input.nextLine();
        System.out.print("Enter the price:  ");
        double price = input.nextDouble();

        Device newDevice=new Device();
        newDevice.setProductType(productType);
        newDevice.setProductName(productName);
        newDevice.setPrice(price) ;

        boolean isAdded = store.add(newDevice);
        if (isAdded){
            System.out.println("Added Successfully");
        }
        else{
            System.out.println("Nothing is added");
        }
    }
//Add additional devices.

    private void printDevice(){
        System.out.println("List of Device are:");
        System.out.println(store.listDevice());
    }//list the devices input.
    public void deleteADevice(){
        System.out.println("Enter the name you want to delete");
        String name=input.next();
        store.deleteADevice(name);
    }
    public void deleteADevice(String name){
        for (int i = 0; i < devices.length; i++) {
            if((devices[i]!=null)&&devices[i].getProductName().equals(name)) {
                devices[i] = null;
                if (i < devices.length - 1) {
                    for (int j = i+1; j <devices.length; j++) {
                        devices[j] =devices[j+1];
                    }
                }
                devices[devices.length - 1] = null;
                System.out.println("Successfully delete!");
                break;
            }
            if(!changeDeviceName(name)){
                System.out.println("Nothing is deleted!");
                break;
            }
        }
//Delete a device you want to.

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

    private void findDevice(){
        input.nextLine();
        System.out.println("Enter a device name");
        String name=input.nextLine();
        Device foundDevice = store.find(name);
        if(foundDevice ==null){
            System.out.println("There are no devices with the name [" + name + "] in the store.");
        }
    }//Find the device and display the name ,type,price.


}