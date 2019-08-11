package mock.sale.for_forest_kwan;

import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(JMockit.class)
public class SalesAppTest {
    @Test
    public void should_return_1_when_call_generateSalesActivityReport_given_null_id() {
        //given
        SalesApp salesApp = spy(new SalesApp());
        //when
        salesApp.generateSalesActivityReport(null, 1000, false, false);
        //then
        verify(salesApp, times(1)).isIdNull(null);
    }

    @Test
    public void should_return_1_when_call_getSales_given_id() {
        //given
        SalesApp salesApp = spy(new SalesApp());
        SalesDao salesDao = mock(SalesDao.class);
        //when
        doReturn(salesDao).when(salesApp).getDao();
        salesApp.getSales("1");
        //then
        verify(salesApp, times(1)).getDao();
    }

    @Test
    public void should_return_1_when_call_isDateValid_given_sale() {
        //given
        SalesApp salesApp = spy(new SalesApp());
        Sales sales = mock(Sales.class);
        //when
        when(sales.getEffectiveTo()).thenReturn(new Date());
        salesApp.isDateValid(sales);
        //then
        verify(sales, times(1)).getEffectiveTo();
    }

    @Test
    public void should_return_1_when_call_getSalesReportData_given_params() {
        //given
        SalesApp salesApp = spy(new SalesApp());
        SalesReportDao salesReportDao = mock(SalesReportDao.class);
        //when
        doReturn(salesReportDao).when(salesApp).getSalesReportDao();
        when(salesReportDao.getReportData(any())).thenReturn(new ArrayList<>());
        salesApp.getSalesReportData(false, null);
        //then
        verify(salesApp, times(1)).getSalesReportDao();
    }

    @Test
    public void should_return_1_when_call_generateSalesActivityReport_given_all_datas() throws ParseException {
        //given
        SalesApp salesApp = spy(new SalesApp());
        Sales sales = mock(Sales.class);
        SalesDao salesDao = mock(SalesDao.class);
        SalesReportDao salesReportDao = mock(SalesReportDao.class);
        SalesActivityReport salesActivityReport = mock(SalesActivityReport.class);
        new MockUp<SalesApp>() {
            @Mock
            protected SalesActivityReport generateReport(List<String> headers, List<SalesReportData> reportDataList) {
                // TODO Auto-generated method stub
                return salesActivityReport;
            }
        };
        EcmService ecmService = mock(EcmService.class);
        //when
        when(sales.getEffectiveTo()).thenReturn(new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").parse("2020-01-01 10:10:10"));
        when(sales.getEffectiveFrom()).thenReturn(new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").parse("2010-01-01 10:10:10"));
        when(salesDao.getSalesBySalesId(any())).thenReturn(sales);
        when(salesReportDao.getReportData(sales)).thenReturn(new ArrayList<>());
        when(salesActivityReport.toXml()).thenReturn("");
        doReturn(salesDao).when(salesApp).getDao();
        doReturn(salesReportDao).when(salesApp).getSalesReportDao();
        doReturn(ecmService).when(salesApp).getEcmService();
        salesApp.generateSalesActivityReport("1", 0, true, true);
        //then
        verify(salesApp, times(1)).getSales("1");
        verify(salesApp, times(1)).getSalesReportData(true, sales);
        verify(salesApp, times(1)).uploadDocument(salesActivityReport);
        assertEquals(false, salesApp.isIdNull("1"));
        assertEquals(false, salesApp.isDateValid(sales));
    }
}