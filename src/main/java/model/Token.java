package model;

public class Token {

  private Integer id;

  private String key;

  private String value;

  public Token(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public Token() {
  }

  public Token(Integer id, String key, String value) {
    this.id = id;
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return " " + id + " - Token : " +
            "key='" + key + '\'' +
            ", value='" + value + '\'';
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
