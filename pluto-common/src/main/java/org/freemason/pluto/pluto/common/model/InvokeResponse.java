package org.freemason.pluto.pluto.common.model;

import java.io.Serializable;

public interface InvokeResponse extends Serializable {

    String getId();

    Object getResult();

    boolean isSuccess();

    String exceptionMessage();
}
