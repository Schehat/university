package de.fhhannover.inform.persistence;
/**
*
* Copyright:    Copyright (c) <p>
* Company:      FBI<p>
* @author JŸrgen Dunkel
* @version 1.1
 * dient um die Eigenschaften einer Beziehungstabelle zurueckgeben zu koennen
 */

public class AssociationTable {
  private String tableName;
  private String objectColumn;
  private String vectorColumn;

  public AssociationTable(String tableName, String objectColumn, String vectorColumn) {
      this.tableName = tableName;
      this.objectColumn = objectColumn;
      this.vectorColumn = vectorColumn;
  }

  public String getTableName(){
      return this.tableName;
  }
  public String getObjectColumn(){
      return this.objectColumn;
  }

  public String getVectorColumn(){
      return this.vectorColumn;
  }

}