package com.shonan.entity;

public class Condition {

  private String keyWord;
  private Long typeId;
/*  private String typeName;

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }*/

  public String getKeyWord() {
    return keyWord;
  }

  public void setKeyWord(String keyWord) {
    this.keyWord = keyWord;
  }

  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  public Condition() {
  }

  @Override
  public String toString() {
    return "Condition{" +
            "keyWord='" + keyWord + '\'' +
            ", typeId='" + typeId + '\'' +
            '}';
  }
}
