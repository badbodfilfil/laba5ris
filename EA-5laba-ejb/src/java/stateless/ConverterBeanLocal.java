/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import javax.ejb.Local;

/**
 *
 * @author Lenovo Z
 */
@Local
public interface ConverterBeanLocal {
    
    public BigDecimal dollarToYen(BigDecimal dollars)
            throws RemoteException;

    public BigDecimal yenToEuro(BigDecimal yen)
            throws RemoteException;
}
