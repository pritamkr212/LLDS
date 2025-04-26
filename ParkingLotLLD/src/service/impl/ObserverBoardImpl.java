package service.impl;

import entity.DisplayBoard;
import service.Observer;

public class ObserverBoardImpl implements Observer {
    @Override
    public void updateObserverBoard(String parkingSlotName) {
        DisplayBoard.getInstance(parkingSlotName);
    }
}
