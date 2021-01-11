package com.example.healthylife.models;

import com.example.healthylife.models.IObserver;

public interface IObservable {
    public void add(IObserver observer);
    public void remove(IObserver observer);
    public void notify_observers();
}
