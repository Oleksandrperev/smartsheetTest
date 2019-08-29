package com.smartsheet;

import com.smartsheet.page.SheetPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddDeleteColumnTest extends BaseTest {


    @Test
    public void testDeleteColumn() {

        loginPage.inputEmail(user.getEmail());
        Reporter.log("User inpur email " + user.getEmail());

        loginPage.clickContinueButton();
        Reporter.log("User clicked button \"Continue\"");

        loginPage.inputPassword(user.getPassword());
        Reporter.log("User inpur password " + user.getPassword());

        sheetPage = loginPage.clickLoginButton();
        Reporter.log("User clicked button \"Login\"");

        /**
         Verify that an amount of column before deleting is equel 6 (six)
         */

        int amountOfColumnsBefore = sheetPage.getAmountOfColumn();
        Reporter.log("Amount of column " + amountOfColumnsBefore);

        Assert.assertEquals(amountOfColumnsBefore, 6);
        Reporter.log("Amount of column is verified");

        String nameFirstColumn = sheetPage.getNameFirstColumn();
        Reporter.log("First column name is " + nameFirstColumn);

        Assert.assertEquals(nameFirstColumn, "Primary Column");
        Reporter.log("First column name is verified");

        /**
         Verify that name of the last column - "Column6"
         */

        String nameLastColumnBefore = sheetPage.getNameLastColumn();
        Reporter.log("Last column name is " + nameLastColumnBefore);

        Assert.assertEquals(nameLastColumnBefore, "Column6");
        Reporter.log("Last column name is verified");

        /**
         delete Column6
         */

        sheetPage.deleteColumn(SheetPage.ColumnsName.COLUMN6);
        Reporter.log("User deleted last column");

        /**
         Verify that an amount of column after deleting is equel 5 (five)
         */

        int amountOfColumnsAfter = sheetPage.getAmountOfColumn();
        Reporter.log("Amount of column " + amountOfColumnsAfter);

        Assert.assertEquals(amountOfColumnsAfter, 5);
        Reporter.log("Amount of column is verified");

        /**
         Verify that name of the last column after deleting - "Column5"
         */

        String nameLastColumnAfter = sheetPage.getNameLastColumn();
        Reporter.log("Last column name is " + nameLastColumnAfter);

        Assert.assertEquals(nameLastColumnAfter, "Column5");
        Reporter.log("Last column name is verified");

        /**
         add Column6
         */

        sheetPage.addColumn(SheetPage.ColumnsName.COLUMN5);
        Reporter.log("User added column 6");

        /**
         Verify that an amount of column after adding is equel 6 (six)
         */

        int amountOfColumnsAfterAdding = sheetPage.getAmountOfColumn();
        Reporter.log("Amount of column " + amountOfColumnsAfterAdding);

        Assert.assertEquals(amountOfColumnsAfterAdding, 6);
        Reporter.log("Amount of column is verified");

        /**
         Verify that name of the last column - "Column6"
         */

        String nameLastColumnAfterAdding = sheetPage.getNameLastColumn();
        Reporter.log("Last column name is " + nameLastColumnAfterAdding);

        Assert.assertEquals(nameLastColumnAfterAdding, "Column6");
        Reporter.log("Last column name is verified");

        sheetPage.saveChanges();
        Reporter.log("User saved changes");
    }
}
