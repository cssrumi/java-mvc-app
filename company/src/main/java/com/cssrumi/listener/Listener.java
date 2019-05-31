package com.cssrumi.listener;

import java.beans.PropertyChangeListener;

public interface Listener {

    void notifyListeners(Object object, String property, Object oldValue, Object newValue);

    void addChangeListener(PropertyChangeListener newListener);
}
