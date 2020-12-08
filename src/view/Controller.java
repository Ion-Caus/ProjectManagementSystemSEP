package view;

import javafx.scene.layout.Region;
import model.PMSModel;


public abstract class Controller
{
  abstract void init(ViewHandler viewHandler, PMSModel pmsModel, Region root);
  abstract void reset();
  abstract Region getRoot();
}
