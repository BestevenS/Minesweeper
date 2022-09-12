package MineSweeperGame.Model;

import MineSweeperGame.Controller.Controller;

public class setVarValues {
    public setVarValues(Controller controller){
        if(controller.getDif() == "Beginner"){
            controller.setRows(9);
            controller.setColumns(9);
            controller.setNumberOfMines(10);
            controller.setLives(3);
        }
        else if(controller.getDif() == "Intermediate"){
            controller.setRows(16);
            controller.setColumns(16);
            controller.setNumberOfMines(30);
            controller.setLives(2);
        }
        else {  //  expert button option
            controller.setRows(16);
            controller.setColumns(30);
            controller.setNumberOfMines(50);
            controller.setLives(1);
        }

        controller.setAvailableMines(controller.getNumberOfMines());
    }
}
