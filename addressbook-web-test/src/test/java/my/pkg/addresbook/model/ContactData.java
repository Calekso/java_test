package my.pkg.addresbook.model;

public class ContactData {
  private int id;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String homePhone;
  private final String mobilePhone;
  private final String workPhone;
  private final String fax;
  private final String eMailOne;
  private final String eMailTwo;
  private final String eMailThree;
  private final String homePage;
  private final String birthDay;
  private final String birthMonth;
  private final String birthYear;
  private final String groupName;
  private final String addressTwo;
  private final String phoneTwo;
  private final String notes;

  public ContactData(String firstName, String middleName, String lastName, String nickName, String title, String comany, String address, String homePhone, String mobilePhone, String workPhone, String fax, String eMailOne, String eMailTwo, String eMailThree, String homePage, String birthDay, String birthMonth, String birthYear, String groupName, String addressTwo, String phoneTwo, String notes) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = comany;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.fax = fax;
    this.eMailOne = eMailOne;
    this.eMailTwo = eMailTwo;
    this.eMailThree = eMailThree;
    this.homePage = homePage;
    this.birthDay = birthDay;
    this.birthMonth = birthMonth;
    this.birthYear = birthYear;
    this.groupName = groupName;
    this.addressTwo = addressTwo;
    this.phoneTwo = phoneTwo;
    this.notes = notes;
  }
  public ContactData(int id, String firstName, String middleName, String lastName, String nickName, String title, String comany, String address, String homePhone, String mobilePhone, String workPhone, String fax, String eMailOne, String eMailTwo, String eMailThree, String homePage, String birthDay, String birthMonth, String birthYear, String groupName, String addressTwo, String phoneTwo, String notes) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = comany;
    this.address = address;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.fax = fax;
    this.eMailOne = eMailOne;
    this.eMailTwo = eMailTwo;
    this.eMailThree = eMailThree;
    this.homePage = homePage;
    this.birthDay = birthDay;
    this.birthMonth = birthMonth;
    this.birthYear = birthYear;
    this.groupName = groupName;
    this.addressTwo = addressTwo;
    this.phoneTwo = phoneTwo;
    this.notes = notes;
  }

  public int getId() { return id;  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFax() {
    return fax;
  }

  public String geteMailOne() {
    return eMailOne;
  }

  public String geteMailTwo() {
    return eMailTwo;
  }

  public String geteMailThree() {
    return eMailThree;
  }

  public String getHomePage() {
    return homePage;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public String getBirthMonth() {
    return birthMonth;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getAddressTwo() {
    return addressTwo;
  }

  public String getPhoneTwo() {
    return phoneTwo;
  }

  public String getNotes() {
    return notes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}
