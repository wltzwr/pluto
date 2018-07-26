package org.freemason.pluto.common.model;

import java.io.Serializable;

public interface InvokeRequest extends Serializable{
    String version();

    String getId();

    String getClassName();

    String getMethodName();

    Object[] getParameters();

    String[] getParameterTypeNames();
}
