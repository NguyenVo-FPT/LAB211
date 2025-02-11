/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Interface;

import Core.Entities.Registration;
import Core.Entities.StatisticalInfo;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface IStatistics {
    public void statisticalize(List<Registration> list);
    public void show();
}
