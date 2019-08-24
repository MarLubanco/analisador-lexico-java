package model;

public class Token {

  private String key;

  private String value;

  public Token(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public Token() {
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return "Token - " +
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
