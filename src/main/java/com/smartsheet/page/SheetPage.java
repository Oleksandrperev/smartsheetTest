package com.smartsheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SheetPage extends BasePage {

    SheetPage(WebDriver driver) {
        super(driver);
    }

    public enum ColumnsName {
        PRIMARY, COLUMN2, COLUMN3, COLUMN4, COLUMN5, COLUMN6;
    }

    @FindBy(css = "div[class$=Wrapper] .clsTableHeadingText")
    private List<WebElement> columns;

    /**
     [0]-[4] - empty
     [5] - Primary Column
     [6] - Column2
     [7] - Column3
     [8] - Column4
     [9] - Column5
     [10] - Column6
     [11] - Column7
     */

    @FindBy(css = "td[class^=clsStandardMenu")
    private List<WebElement> dropDownColumnMenu;

    /**
     [2] - delete button
     */

    @FindBy(css = "div[id=\"foid:47\"] span")
    private WebElement insertColumnOkButton;

    @FindBy(css = "button[data-client-type=\"men\"]")
    private WebElement fileButton;

    @FindBy(css = "tr[data-client-id=\"10629\"] .clsStandardMenuText")
    private WebElement saveButton;


    public int getAmountOfColumn() {
        wait.until(ExpectedConditions.visibilityOfAllElements(columns));
        int fullAmount = columns.size();
        int activColumnAmount = fullAmount - 5;
        return activColumnAmount;
    }

    public String getNameFirstColumn() {
        wait.until(ExpectedConditions.visibilityOfAllElements(columns));
        return columns.get(5).getText();
    }

    public String getNameLastColumn() {
        wait.until(ExpectedConditions.visibilityOfAllElements(columns));
        return columns.get(columns.size()-1).getText();
    }

    public void clickDeleteColumnButton() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownColumnMenu.get(2)));
        dropDownColumnMenu.get(2).click();
    }

    public void clickInsertColumnRightButton() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownColumnMenu.get(1)));
        dropDownColumnMenu.get(1).click();
    }

    public void clickInsertColumnOkButton() {
        wait.until(ExpectedConditions.elementToBeClickable(insertColumnOkButton));
        insertColumnOkButton.click();
    }



    public void deleteColumn(ColumnsName name) {

        WebElement element;

        switch (name) {
            case PRIMARY:
                element = columns.get(5);
                break;
            case COLUMN2:
                element = columns.get(6);
                break;
            case COLUMN3:
                element = columns.get(7);
                break;
            case COLUMN4:
                element = columns.get(8);
                break;
            case COLUMN5:
                element = columns.get(9);
                break;
            case COLUMN6:
                element = columns.get(10);
                break;

            default: element = null;
        }


        wait.until(ExpectedConditions.elementToBeClickable(element));

        /**
         right click on the column
         */
        Actions action = new Actions(driver);
        action.contextClick(element).perform();

        /**
         delete column
         */
        clickDeleteColumnButton();

    }

    public void addColumn(ColumnsName name) {

        WebElement element;

        switch (name) {
            case PRIMARY:
                element = columns.get(5);
                break;
            case COLUMN2:
                element = columns.get(6);
                break;
            case COLUMN3:
                element = columns.get(7);
                break;
            case COLUMN4:
                element = columns.get(8);
                break;
            case COLUMN5:
                element = columns.get(9);
                break;
            case COLUMN6:
                element = columns.get(10);
                break;

            default: element = null;
        }


        wait.until(ExpectedConditions.elementToBeClickable(element));

        /**
         right click on the column
         */
        Actions action = new Actions(driver);
        action.contextClick(element).perform();


        /**
         add column (insert right)
         */

        clickInsertColumnRightButton();

        clickInsertColumnOkButton();

    }

    public void saveChanges() {
        wait.until(ExpectedConditions.elementToBeClickable(fileButton));
        fileButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }






}
