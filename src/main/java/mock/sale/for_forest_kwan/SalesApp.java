package mock.sale.for_forest_kwan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SalesApp {

    public void generateSalesActivityReport(String salesId, int maxRow, boolean isNatTrade, boolean isSupervisor) {

        if (isIdNull(salesId)) return;

        Sales sales = getSales(salesId);

        if (isDateValid(sales)) return;

        List<SalesReportData> reportDataList = getSalesReportData(isSupervisor, sales);

        List<SalesReportData> tempList = getSalesReportData(maxRow, reportDataList);

        List<String> headers = getHeaders(isNatTrade);

        SalesActivityReport report = this.generateReport(headers, tempList);

        uploadDocument(report);

    }

    protected void uploadDocument(SalesActivityReport report) {
        getEcmService().uploadDocument(report.toXml());
    }

    protected EcmService getEcmService() {
        return new EcmService();
    }

    protected List<String> getHeaders(boolean isNatTrade) {
        List<String> headers = null;
        if (isNatTrade) {
            headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Time");
        } else {
            headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Local Time");
        }
        return headers;
    }

    protected List<SalesReportData> getSalesReportData(int maxRow, List<SalesReportData> reportDataList) {
        List<SalesReportData> tempList = new ArrayList<>();
        for (int i = 0; i < reportDataList.size() || i < maxRow; i++) {
            tempList.add(reportDataList.get(i));
        }
        return tempList;
    }

    protected List<SalesReportData> getSalesReportData(boolean isSupervisor, Sales sales) {
        List<SalesReportData> filteredReportDataList = new ArrayList<>();
        List<SalesReportData> reportDataList = getSalesReportDao().getReportData(sales);
        for (SalesReportData data : reportDataList) {
            if ("SalesActivity".equalsIgnoreCase(data.getType())) {
                if (data.isConfidential()) {
                    if (isSupervisor) {
                        filteredReportDataList.add(data);
                    }
                } else {
                    filteredReportDataList.add(data);
                }
            }
        }
        return filteredReportDataList;
    }

    protected SalesReportDao getSalesReportDao() {
        return new SalesReportDao();
    }

    protected boolean isDateValid(Sales sales) {
        Date today = new Date();
        if (today.after(sales.getEffectiveTo())
                || today.before(sales.getEffectiveFrom())) {
            return true;
        }
        return false;
    }

    protected Sales getSales(String salesId) {
        return getDao().getSalesBySalesId(salesId);
    }

    protected SalesDao getDao() {
        return new SalesDao();
    }

    protected boolean isIdNull(String salesId) {
        if (salesId == null) {
            return true;
        }
        return false;
    }

    protected static SalesActivityReport generateReport(List<String> headers, List<SalesReportData> reportDataList) {
        // TODO Auto-generated method stub
        return null;
    }

}
