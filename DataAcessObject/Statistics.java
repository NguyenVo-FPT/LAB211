package DataAcessObject;

import Core.Entities.Registration;
import Core.Interface.IStatistics;
import Core.Entities.StatisticalInfo;
import java.util.HashMap;
import java.util.List;

public class Statistics extends HashMap<String, StatisticalInfo> implements IStatistics {

    private final String HEADER_TABLE
            = "----------------------------------------------------\n"
            + "Peak Name    | Number of Participants  | Total Cost \n"
            + "---------------------------------------------------- ";

    private final String FOOTER_TABLE
            = "---------------------------------------------------- \n";

    public Statistics() {
        super();
    }

    public Statistics(List<Registration> list) {
        super();
        statisticalize(list);
    }

    @Override
    public void statisticalize(List<Registration> list) {
        for (Registration i : list) {
            if (this.containsKey(i.getMountain().getCode())) {
                StatisticalInfo x = this.get(i.getMountain().getCode());
                x.setNumOfStudent(x.getNumOfStudent() + 1);
                x.setTotalCost(x.getTotalCost() + i.getTutionFee());
            } else {
                StatisticalInfo y = new StatisticalInfo(i.getMountain().getCode(), 1, i.getTutionFee());
                this.put(i.getMountain().getCode(), y);
            }
        }
    }

    @Override
    public void show() {
        if (this.isEmpty()) {
            System.out.println("No students have registered yet.");
            return;
        }
        System.out.println(HEADER_TABLE);
        for (StatisticalInfo i : this.values()) {
            System.out.println(i.toString());
        }
        System.out.println(FOOTER_TABLE);
    }
}
