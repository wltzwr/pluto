package org.freemason.pluto.pluto.common.model;

import java.io.Serializable;

public interface InvokeRequest extends Serializable{
    String getId();

    String getClassName();

    String getMethodName();

    Object[] getParameters();

    String[] getParameterTypeNames();
}