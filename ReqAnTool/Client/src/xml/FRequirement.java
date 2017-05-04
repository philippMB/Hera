package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;

public class FRequirement
{
  private String id;
  private String title;
  private String actor;
  private String description;
  private ArrayList<String> referenceIDs;

  public void setId(String id)
  {
    this.id = id;
  }

  public String getId()
  {
    return id;
  }

  public void setReferenceIDs(ArrayList<String> referenceIDs)
  {
    this.referenceIDs = referenceIDs;
  }

  public ArrayList<String> getReferenceIDs()
  {
    return referenceIDs;
  }

  public FRequirement(String title, String actor, String description)
  {
    this.title = title;
    this.actor = actor;
    this.description = description;
  }

  public String getTitle()
  {
    return title;
  }

  public String getActor()
  {
    return actor;
  }

  public String getDescription()
  {
    return description;
  }
  
  // für JavaBeans
  
  public FRequirement()
  {
    
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setActor(String actor)
  {
    this.actor = actor;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}
