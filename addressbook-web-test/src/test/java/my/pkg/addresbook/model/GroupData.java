package my.pkg.addresbook.model;

public class GroupData {
  private int id;
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;

  public GroupData(int id, String groupName, String groupHeader, String groupFooter) {
    this.id = id;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
  }

  public GroupData(String groupName, String groupHeader, String groupFooter) {
    this.id = Integer.MAX_VALUE;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", groupName='" + groupName + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
  }

  @Override
  public int hashCode() {
    return groupName != null ? groupName.hashCode() : 0;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }

  public String getGroupFooter() {
    return groupFooter;
  }
}
