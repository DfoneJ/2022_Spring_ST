package TransactionFeature;

import Util.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class TranscationDTO {
    private String amount;
    private String description;
    private CategoryType categoryType;
    private String categoryName;
    private String note;
    private String accountName;
    private Boolean comfirm;
    private Boolean showInTotalWallet;
    private Date date;

    private DateBlockType dateBlockType;
    private String eventName;
    private String placeName;
    private String placeAddress;

    public TranscationDTO() {
        dateBlockType = DateBlockType.CURRENT;
        categoryType = CategoryType.EXPENSES;
        comfirm = true;
        showInTotalWallet = true;
    }

    public void setPlace(String name, String address) {
        this.placeName = name;
        this.placeAddress = address;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public void setPeople(String[] people) {
        this.people = people;
    }

    private String[] people;

    public String getEventName() {
        return eventName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public String[] getPeople() {
        return people;
    }

    public void setComfirm(boolean comfirm) {
        this.comfirm = comfirm;
    }

    public void setShowInTotalWallet(boolean showInTotalWallet) {
        this.showInTotalWallet = showInTotalWallet;
    }

    public boolean getComfirm() {
        return comfirm;
    }

    public boolean getShowInTotalWallet() {
        return showInTotalWallet;
    }

    public Date getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getNote() {
        return note;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public void setDateBlockType(DateBlockType dateBlockType) {
        this.dateBlockType = dateBlockType;
        if (dateBlockType.equals(DateBlockType.CURRENT)){
            date = new Date();
        }
        else if (dateBlockType.equals(DateBlockType.BEFORE)){
            date = DateUtil.getSpecifyDate(2022, 6, 1);
        }
        else if (dateBlockType.equals(DateBlockType.AFTER)){
            date = DateUtil.getSpecifyDate(2022, 6, 30);
        }
    }

    public void setDate(int year, int month, int day) {
        date = DateUtil.getSpecifyDate(year, month, day);
    }

    public DateBlockType getDateBlockType() {
        return dateBlockType;
    }
}
