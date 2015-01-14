

package com.pcms.model;
 
import org.springframework.dao.DataAccessException;

 
public class BizException extends DataAccessException {

 

    /**

     * @author Hoojo

     */

    private static final long serialVersionUID = 1L;

    

    public BizException(String msg) {

        super(msg);

    }

 

    public BizException(String msg, Throwable cause) {

        super(msg, cause);

    }

}