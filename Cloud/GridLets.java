package gridsim.example04;
import java.util.*;
import gridsim.*;
class Example4 extends GridSim
{
private
    Integer ID_;
private
    String name_;
private
    GridletList list_;
private
    GridletList receiveList_;
    Example4(String name, double baud_rate) throws Exception
    {
        super(name, baud_rate);
        this.name_ = name;
        this.receiveList_ = new GridletList();
        this.ID_ = new Integer(getEntityId(name));
        System.out.println("Creating a grid user entity with name = " +
                           name + ", and id = " + this.ID_);
        this.list_ = createGridlet(this.ID_.intValue());
        System.out.println("Creating " + this.list_.size() + " Gridlets");
    }
public
    void body()
    {
        int resourceID = 0;
        String resourceName;
        LinkedList resList;
        ResourceCharacteristics resChar;
        while (true)
        {
            super.gridSimHold(1.0); // hold by 1 second
            resList = super.getGridResourceList();
            if (resList.size() > 0)
            {
                Integer num = (Integer)resList.get(0);
                resourceID = num.intValue();
                super.send(resourceID, GridSimTags.SCHEDULE_NOW,
                           GridSimTags.RESOURCE_CHARACTERISTICS, this.ID_);
                resChar = (ResourceCharacteristics)super.receiveEventObject();
                resourceName = resChar.getResourceName();
                System.out.println("Received ResourceCharacteristics from " +
                                   resourceName + ", with id = " + resourceID);
                super.recordStatistics("\"Received ResourceCharacteristics " +
                                           "from " + resourceName + "\"",
                                       "");
                break;
            }
            else
                System.out.println("Waiting to get list of resources ...");
        }
        Gridlet gridlet;
        String info;
        for (int i = 0; i < this.list_.size(); i++)
        {
            gridlet = (Gridlet)this.list_.get(i);
            info = "Gridlet_" + gridlet.getGridletID();
            System.out.println("Sending " + info + " to " + resourceName +
                               " with id = " + resourceID);
            super.gridletSubmit(gridlet, resourceID);
            super.recordStatistics("\"Submit " + info + " to " + resourceName +
                                       "\"",
                                   "");
            gridlet = super.gridletReceive();
            System.out.println("Receiving Gridlet " + gridlet.getGridletID());
            super.recordStatistics("\"Received " + info + " from " +
                                       resourceName + "\"",
                                   gridlet.getProcessingCost());
            this.receiveList_.add(gridlet);
        }
        super.shutdownGridStatisticsEntity();
        super.shutdownUserEntity();
        super.terminateIOEntities();
    }
public
    GridletList getGridletList() { return this.receiveList_; }
private
    GridletList createGridlet(int userID)
    {
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
        long seed = 11L * 13 * 17 * 19 * 23 + 1;
        Random random = new Random(seed);
        GridSimStandardPE.setRating(100);
        int count = 5;
        for (int i = 1; i < count + 1; i++)
        {
            length = GridSimStandardPE.toMIs(random.nextDouble() * 50);
            file_size = (long)GridSimRandom.real(100, 0.10, 0.40,
                                                 random.nextDouble());

            output_size = (long)GridSimRandom.real(250, 0.10, 0.50,
                                                   random.nextDouble());
            Gridlet gridlet = new Gridlet(id + i, length, file_size,
                                          output_size);
            list.add(gridlet);
        }
        return list;
    }
public
    static void main(String[] args)
    {
        System.out.println("Starting Example4");
        try
        {
            int num_user = 1; // number of grid users
            Calendar calendar = Calendar.getInstance();
            boolean trace_flag = true; // mean trace GridSim events
            String[] exclude_from_file = {""};
            String[] exclude_from_processing = {""};
            String report_name = null;
            System.out.println("Initializing GridSim package");
            GridSim.init(num_user, calendar, trace_flag, exclude_from_file,
                         exclude_from_processing, report_name);
            String name = "Resource_0";
            GridResource resource = createGridResource(name);
            Example4 obj = new Example4("Example4", 560.00);
            GridSim.startGridSimulation();
            GridletList newList = obj.getGridletList();
            printGridletList(newList);
            System.out.println("Finish Example4");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Unwanted errors happen");
        }
    }
private
    static GridResource createGridResource(String name)
    {
        System.out.println();
        System.out.println("Starting to create one Grid resource with " +
                           "3 Machines");
        MachineList mList = new MachineList();
        System.out.println("Creates a Machine list");
        int mipsRating = 377;
        mList.add(new Machine(0, 4, mipsRating)); // First Machine
        System.out.println("Creates the 1st Machine that has 4 PEs and " +
                           "stores it into the Machine list");
        mList.add(new Machine(1, 4, mipsRating)); // Second Machine
        System.out.println("Creates the 2nd Machine that has 4 PEs and " +
                           "stores it into the Machine list");
        mList.add(new Machine(2, 2, mipsRating)); // Third Machine
        System.out.println("Creates the 3rd Machine that has 2 PEs and " +
                           "stores it into the Machine list");
        String arch = "Sun Ultra"; // system architecture
        String os = "Solaris";     // operating system
        double time_zone = 9.0;    // time zone this resource located
        double cost = 3.0;         // the cost of using this resource
        ResourceCharacteristics resConfig = new ResourceCharacteristics(
            arch, os, mList, ResourceCharacteristics.TIME_SHARED,
            time_zone, cost);
        System.out.println("Creates the properties of a Grid resource and " +
                           "stores the Machine list");
        double baud_rate = 100.0; // communication speed
        long seed = 11L * 13 * 17 * 19 * 23 + 1;
        double peakLoad = 0.0;    // the resource load during peak hour
        double offPeakLoad = 0.0; // the resource load during off-peak hr
        double holidayLoad = 0.0; // the resource load during holiday
        LinkedList Weekends = new LinkedList();
        Weekends.add(new Integer(Calendar.SATURDAY));
        Weekends.add(new Integer(Calendar.SUNDAY));
        LinkedList Holidays = new LinkedList();
        GridResource gridRes = null;
        try
        {
            gridRes = new GridResource(name, baud_rate, seed,
                                       resConfig, peakLoad, offPeakLoad, holidayLoad, Weekends,
                                       Holidays);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Finally, creates one Grid resource and stores " +
                           "the properties of a Grid resource");
        System.out.println();
        return gridRes;
    private
        static void printGridletList(GridletList list)
        {
            int size = list.size();
            Gridlet gridlet;
            String indent = "    ";
            System.out.println();
            System.out.println("========== OUTPUT ==========");
            System.out.println("Gridlet ID" + indent + "STATUS" + indent +
                               "Resource ID" + indent + "Cost");
            for (int i = 0; i < size; i++)
            {
                gridlet = (Gridlet)list.get(i);
                System.out.print(indent + gridlet.getGridletID() + indent + indent);
                if (gridlet.getGridletStatus() == Gridlet.SUCCESS)
                    System.out.print("SUCCESS");
                System.out.println(indent + indent + gridlet.getResourceID() +
                                   indent + indent + gridlet.getProcessingCost());
            }
        }
    }
