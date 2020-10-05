public
package gridsim.example06;

import java.util.*;
import gridsim.*;

class Example6 extends GridSim {
    private Integer ID_;
    private String name_;
    private GridletList list_;
    private GridletList receiveList_;
    private int totalResource_;

    Example6(String name, double baud_rate, int total_resource) throws Exception {
        super(name, baud_rate);
        this.name_ = name;
        this.totalResource_ = total_resource;
        this.receiveList_ = new GridletList();
        this.ID_ = new Integer(getEntityId(name));
        System.out.println("Creating a grid user entity with name = " + name + ", and id = " + this.ID_);
        this.list_ = createGridlet(this.ID_.intValue());
        System.out.println(name + ":Creating " + this.list_.size() + " Gridlets");
    }

    public void body() {
        int resourceID[] = new int[this.totalResource_];
        double resourceCost[] = new double[this.totalResource_];
        String resourceName[] = new String[this.totalResource_];
        LinkedList resList;
        ResourceCharacteristics resChar;
        while (true) {
            super.gridSimHold(1.0); // hold by 1 second
            resList = super.getGridResourceList();
            if (resList.size() == this.totalResource_)
                break;
            else {
                System.out.println(this.name_ + ":Waiting to get list of resources ...");
            }
        }
        int i = 0;
        for (i = 0; i < this.totalResource_; i++) {
            resourceID[i] = ((Integer) resList.get(i)).intValue();
            super.send(resourceID[i], GridSimTags.SCHEDULE_NOW, GridSimTags.RESOURCE_CHARACTERISTICS, this.ID_);
            resChar = (ResourceCharacteristics) super.receiveEventObject();
            resourceName[i] = resChar.getResourceName();
            resourceCost[i] = resChar.getCostPerSec();
            System.out.println(this.name_ + ":Received ResourceCharacteristics from " + resourceName[i] + ", with id = "
                    + resourceID[i]);
            super.recordStatistics("\"Received ResourceCharacteristics " + "from " + resourceName[i] + "\"", "");
        }
        Gridlet gridlet;
        String info;
        int id = 0;
        for (i = 0; i < this.list_.size(); i++) {
            gridlet = (Gridlet) this.list_.get(i);
            info = "Gridlet_" + gridlet.getGridletID();
            id = GridSimRandom.intSample(this.totalResource_);
            System.out.println(
                    this.name_ + ":Sending " + info + " to " + resourceName[id] + " with id = " + resourceID[id]);
            super.gridletSubmit(gridlet, resourceID[id]);
            super.recordStatistics("\"Submit " + info + " to " + resourceName[id] + "\"", "");
            gridlet = super.gridletReceive();
            System.out.println(this.name_ + ":Receiving Gridlet " + gridlet.getGridletID());
            super.recordStatistics("\"Received " + info + " from " + resourceName[id] + "\"",
                    gridlet.getProcessingCost());
            this.receiveList_.add(gridlet);
        }
        super.shutdownGridStatisticsEntity();
        super.shutdownUserEntity();
        super.terminateIOEntities();
        System.out.println(this.name_ + ":%%%% Exiting body()");
    }

    public GridletList getGridletList() {
        return this.receiveList_;
    }

    private GridletList createGridlet(int userID) {
        GridletList list = new GridletList();
        int id = 0;
        double length = 3500.0;
        long file_size = 300;
        long output_size = 300;
        Gridlet gridlet1 = new Gridlet(id, length, file_size, output_size);
        id++;
        Gridlet gridlet2 = new Gridlet(id, 5000, 500, 500);
        id++;
        Gridlet gridlet3 = new Gridlet(id, 9000, 900, 900);
        gridlet1.setUserID(userID);
        gridlet2.setUserID(userID);
        gridlet3.setUserID(userID);
        list.add(gridlet1);
        list.add(gridlet2);
        list.add(gridlet3);
        GridSimStandardPE.setRating(100);
        int max = 5;
        int count = GridSimRandom.intSample(max);
        for (int i = 1; i < count + 1; i++) {
            length = GridSimStandardPE.toMIs(GridSimRandom.doubleSample() * 50);
            file_size = (long) GridSimRandom.real(100, 0.10, 0.40, GridSimRandom.doubleSample());
            output_size = (long) GridSimRandom.real(250, 0.10, 0.50, GridSimRandom.doubleSample());
            Gridlet gridlet = new Gridlet(id + i, length, file_size, output_size);
            gridlet.setUserID(userID);
            list.add(gridlet);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("Starting Example6");
        try {
            int num_user = 3; // number of grid users
            Calendar calendar = Calendar.getInstance();
            boolean trace_flag = false; // mean don't trace GridSim events
            String[] exclude_from_file = { "" };
            String[] exclude_from_processing = { "" };
            String report_name = null;
            GridSim.init(num_user, calendar, trace_flag, exclude_from_file, exclude_from_processing, report_name);
            GridResource resource0 = createGridResource("Resource_0");
            GridResource resource1 = createGridResource("Resource_1");
            GridResource resource2 = createGridResource("Resource_2");
            int total_resource = 3;
            Example6 user0 = new Example6("User_0", 560.00, total_resource);
            Example6 user1 = new Example6("User_1", 250.00, total_resource);
            Example6 user2 = new Example6("User_2", 150.00, total_resource);
            GridSim.startGridSimulation();
            GridletList newList = null;
            newList = user0.getGridletList();
            printGridletList(newList, "User_0");
            newList = user1.getGridletList();
            printGridletList(newList, "User_1");
            newList = user2.getGridletList();
            printGridletList(newList, "User_2");
            System.out.println("Finish Example6");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unwanted errors happen");
        }
    }

    private static GridResource createGridResource(String name) {
        MachineList mList = new MachineList();
        int mipsRating = 377;
        mList.add(new Machine(0, 4, mipsRating));
        mList.add(new Machine(1, 4, mipsRating)); // Second Machine
        mList.add(new Machine(2, 2, mipsRating)); // Third Machine
        String arch = "Sun Ultra"; // system architecture
        String os = "Solaris"; // operating system
        double time_zone = 9.0; // time zone this resource located
        double cost = 3.0; // the cost of using this resource
        ResourceCharacteristics resConfig = new ResourceCharacteristics(arch, os, mList,
                ResourceCharacteristics.TIME_SHARED, time_zone, cost);
        double baud_rate = 100.0; // communication speed
        long seed = 11L * 13 * 17 * 19 * 23 + 1;
        double peakLoad = 0.0; // the resource load during peak hour
        double offPeakLoad = 0.0; // the resource load during off-peak hr
        double holidayLoad = 0.0; // the resource load during holiday
        LinkedList Weekends = new LinkedList();
        Weekends.add(new Integer(Calendar.SATURDAY));
        Weekends.add(new Integer(Calendar.SUNDAY));
        LinkedList Holidays = new LinkedList();
        GridResource gridRes = null;
        try {
            gridRes = new GridResource(name, baud_rate, seed, resConfig, peakLoad, offPeakLoad, holidayLoad, Weekends,
                    Holidays);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Creates one Grid resource with name = " + name);
        return gridRes;
    }

    private static void printGridletList(GridletList list, String name) {
        int size = list.size();
        Gridlet gridlet;
        String indent = "    ";
        System.out.println();
        System.out.println("========== OUTPUT for " + name + " ==========");
        System.out.println("Gridlet ID" + indent + "STATUS" + indent + "Resource ID" + indent + "Cost");
        for (int i = 0; i < size; i++) {
            gridlet = (Gridlet) list.get(i);
            System.out.print(indent + gridlet.getGridletID() + indent + indent);
            if (gridlet.getGridletStatus() == Gridlet.SUCCESS)
                System.out.print("SUCCESS");
            System.out
                    .println(indent + indent + gridlet.getResourceID() + indent + indent + gridlet.getProcessingCost());
        }
    }
}

class GridUserResource {

}
