package model;



import parser.ParserException;
import parser.XmlJsonParser;

import java.io.*;

public class SaverClass
{
  private String employeePathBinary, projectPathBinary;
  private String employeePathXML, projectPathXML;
  private File foldbin, fnewbin;
  private File foldxml, fnewxml;

  public SaverClass()
  {
    employeePathBinary = "./src/SavedEmployees.bin";
    employeePathXML = "./src/SavedEmployees.XML";
    projectPathBinary =  "./src/SavedProjects.bin";
    projectPathXML = "./src/SavedProjects.XML";

  }

  public void write(Object obj)
  {
    String pathbin = "";
    String pathxml = "";
    if(obj instanceof ProjectList){
      pathbin = projectPathBinary;
      pathxml = projectPathXML;}
    if(obj instanceof Team){
      pathbin = employeePathBinary;
      pathxml = employeePathXML;}
    this.foldbin = new File(pathbin);
    this.foldxml = new File(pathxml);
    foldbin.delete();
    foldxml.delete();
    this.fnewbin = new File(pathbin);
    this.fnewxml = new File(pathxml);

    //-------WRITING BINARY FILES-------
    ObjectOutputStream out = null;
    try
    {
      FileOutputStream fos = new FileOutputStream(fnewbin);
      out = new ObjectOutputStream(fos);
      out.writeObject(obj);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }catch (IOException e){
        e.printStackTrace();
      }
    }
    //-------WRITING XML FILES-------
    XmlJsonParser parser = new XmlJsonParser();
    try
    {
      parser.toXml(obj, pathxml);
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }

  }

  public Team getTeamFromBinary(){

    ObjectInputStream in = null;
    try
    {
      File file = new File(employeePathBinary);
      FileInputStream fis = new FileInputStream(file);
      in = new ObjectInputStream(fis);

      return (Team)in.readObject();

    }catch (IOException | ClassNotFoundException e){
      e.printStackTrace();
    }finally
    {
      try{
        in.close();
      }catch (IOException e){
        e.printStackTrace();
      }
    }
    return null;
  }
  public ProjectList getProjectListFromBinary(){

    ObjectInputStream in = null;
    try
    {
      File file = new File(projectPathBinary);
      FileInputStream fis = new FileInputStream(file);
      in = new ObjectInputStream(fis);

      return (ProjectList) in.readObject();

    }catch (IOException | ClassNotFoundException e){
      e.printStackTrace();
    }finally
    {
      try{
        in.close();
      }catch (IOException e){
        e.printStackTrace();
      }
    }
    return null;
  }

}
